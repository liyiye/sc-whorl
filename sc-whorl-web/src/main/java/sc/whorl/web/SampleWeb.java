package sc.whorl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sc.whorl.logic.domain.model.orders.Orderinfo;
import sc.whorl.logic.pojo.order.OrderInfoVo;
import sc.whorl.logic.service.order.OrderInfoService;
import sc.whorl.system.commons.MsgResponseBody;
import sc.whorl.system.commons.limitrate.Limit;
import sc.whorl.system.commons.preventresubmit.PreventParam;
import sc.whorl.system.commons.preventresubmit.PreventResubmitLock;
import sc.whorl.system.commons.webhandler.wapper.ResponseJsonParam;
import sc.whorl.system.config.jwt.JWTUserDetail;
import sc.whorl.system.config.springsecurity.utils.UserAuthInfoUtils;
import sc.whorl.system.utils.mapper.JsonMapper;

/**
 * <一句话功能简述>
 * <功能详细描述>
 */
@RestController
@Api(value = "SampleWeb", description="获取订单相关接口")
public class SampleWeb {
    @Autowired
    private OrderInfoService orderInfoService;


    @RequestMapping("/")
    @ApiOperation(value = "查询所有订单", httpMethod="POST")
    public List<Orderinfo> sampleRequest(@Valid @RequestBody OrderInfoVo orderinfo) {
        System.out.println("-->" + JsonMapper.nonDefaultMapper().toJson(orderinfo));

        orderInfoService.jdbcTemplateSample();
        orderInfoService.redisTesmpleSample();
        return orderInfoService.sample();
    }


    /**
     * 限流注解,即100秒内最多访问10次
     * @param unitid
     */
    @Limit(key = "test-limitrate", period = 100, count = 10)
    @ApiOperation(value = "根据unitid查询订单信息", httpMethod="POST")
    @RequestMapping("/units")
    public void sampleUnits(@PathVariable("unitid") Long unitid) {
        System.out.println("-->" +unitid);

    }

    /**
     * 防止重复提交 关键key为传入的unitId
     *
     * @param unitid
     */
    @PreventResubmitLock(prefix = "sc-unit",expire = 10)
    @RequestMapping("/units/{unitid}")
    public void sampleUnitsById(@PathVariable("unitid") @PreventParam(name = "unitId") Long unitid) {
        System.out.println("-->" + unitid);

    }


    /**
     * 权限验证
     *
     * @param unitid
     */
    @PreAuthorize("hasRole('teach')")
    @RequestMapping("/unitList/{unitid}")
    public MsgResponseBody jwtUserDetail(@PathVariable("unitid") Long unitid) {
        System.out.println(unitid + "-->" + UserAuthInfoUtils.getLoginName() + "json:" + UserAuthInfoUtils.getUser().toJson());
        return MsgResponseBody.success().setResult(UserAuthInfoUtils.getUser());

    }


    /**
     * 过滤返回字段,性能较低
     */
    @RequestMapping("/jsonUser/{unitid}")
    //一旦有include则只返回包含再include内的数据,且只能解析到第一层
    @ResponseJsonParam(filter = {"jwtToken"})
    public JWTUserDetail jsonUserDetail(@PathVariable("unitid") Long unitid) {
        System.out.println(unitid + "-->" + UserAuthInfoUtils.getLoginName() + "json:" + UserAuthInfoUtils.getUser().toJson());
        return UserAuthInfoUtils.getUser();
    }
}

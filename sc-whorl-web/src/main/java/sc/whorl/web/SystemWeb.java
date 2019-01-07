package sc.whorl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sc.whorl.logic.service.system.MenuService;
import sc.whorl.system.commons.MsgResponseBody;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping(value = "/sc/user/system")
@Api(value = "SystemWeb", description = "系统相关接口,包括菜单缓存字典等")
public class SystemWeb {
    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "获取菜单", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getMenu", method = RequestMethod.POST, produces = {"application/json"})
    public MsgResponseBody getMenu() {
        return MsgResponseBody.success().setResult(menuService.getMenu());
    }


}

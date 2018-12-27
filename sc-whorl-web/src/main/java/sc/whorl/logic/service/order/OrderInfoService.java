package sc.whorl.logic.service.order;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sc.whorl.logic.domain.dao.orders.OrderinfoMapper;
import sc.whorl.logic.domain.model.orders.Orderinfo;
import sc.whorl.system.commons.base.BaseService;
import sc.whorl.system.commons.spring.SpringUtil;
import sc.whorl.system.utils.mapper.JsonMapper;
import sc.whorl.system.utils.redis.RedisUtil;


/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
//@Primary
//@Conditional()
//@Qualifier
@Service
public class OrderInfoService extends BaseService<OrderinfoMapper, Orderinfo> {
    private static final Logger logger = LoggerFactory.getLogger(OrderInfoService.class);
    @Autowired
    private OrderinfoMapper orderinfoMapper;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private RedisUtil redisUtil;


    @Autowired
    private JavaMailSender mailSender;


    @Transactional
    //缓存返回结果,10s内将不会再调用此方法
    @Cacheable(value = "orderCache", keyGenerator = "wiselyKeyGenerator")
    public List<Orderinfo> sample() {
        PageHelper.startPage(2, 3);
        List<Orderinfo> ls = this.selectListAll();
        PageInfo<Orderinfo> pageInfo = new PageInfo<Orderinfo>(ls);
        logger.info("页码打印------------{}", JsonMapper.nonEmptyMapper().toJson(pageInfo));
        String string = SpringUtil.getProperty("druid.url");
        //获取spring上下文
        WebApplicationContext wac = (WebApplicationContext) SpringUtil.getApplicationContext();

        //获取请求上下文
        HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        ServletContext sc = httpRequest.getServletContext();
        //获取响应上下文
        HttpServletResponse httpResponse = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
        return ls;
    }

    public void jdbcTemplateSample() {
        String sql = "select * from orderInfo";
        List<Orderinfo> ls = jdbcTemplate.query(sql, new RowMapper() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                Orderinfo orderinfo = new Orderinfo();
                orderinfo.setPid(resultSet.getInt("pid"));
                orderinfo.setOrdertitle(resultSet.getString("ordertitle"));
                return orderinfo;
            }
        });
        logger.info("jdbctemple:{}", JsonMapper.nonEmptyMapper().toJson(ls));
    }

    public void redisTesmpleSample() {
        redisUtil.set("aa", "aa");
        logger.info(redisUtil.get("aaa"));
    }


}

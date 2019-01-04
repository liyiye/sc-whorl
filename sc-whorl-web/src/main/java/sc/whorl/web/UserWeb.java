package sc.whorl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sc.whorl.logic.service.user.UserService;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/sc/user/user")
@Api(value = "UserLoginWeb", description = "用户相关接口")
public class UserWeb {
    @Autowired
    private UserService userService;
    /**
     * 登陆接口
     */
    @ApiOperation(value = "用户登出", httpMethod = "POST")
    @RequestMapping("/logout")
    public void logout() {
        userService.logout();
    }
}

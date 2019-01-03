package sc.whorl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sc.whorl.logic.pojo.auth.UserVo;
import sc.whorl.logic.service.user.UserService;
import sc.whorl.system.commons.MsgResponseBody;
import sc.whorl.system.commons.webhandler.RequestJsonParam;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/sc/user/auth")
@Api(value = "UserLoginWeb", description = "用户权限登陆相关接口")
public class UserLoginWeb {


    @Autowired
    private UserService userService;


    /**
     * 登陆接口
     * 1.判断用户名密码是否正确
     * 2.生成令牌和用户信息返回到前端
     */
    @ApiOperation(value = "用户登陆接口", httpMethod = "POST")
    @RequestMapping("/login")
    public MsgResponseBody login(@RequestJsonParam("userName") String userName, @RequestJsonParam("passWord") String passWord) {
        UserVo userVo = new UserVo();
        userVo.setAccountname(userName);
        userVo.setPassword(passWord);
        return userService.login(userVo);
    }

    /**
     * 忘记密码
     */
    @ApiOperation(value = "忘记密码", httpMethod = "POST")
    @RequestMapping("/forgetPwd")
    public void forgetPwd() {
        System.out.println("-->");

    }

    /**
     * 登陆接口
     */
    @ApiOperation(value = "用户登出", httpMethod = "POST")
    @RequestMapping("/logout")
    public void logout() {
        System.out.println("-->");

    }

    /**
     * 注册接口
     */
    @ApiOperation(value = "用户注册", httpMethod = "POST")
    @RequestMapping("/register")
    public MsgResponseBody register(@RequestBody UserVo userVo) {
        userService.register(userVo);
        return MsgResponseBody.success().setResult("注册成功");
    }


}

package sc.whorl.logic.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import sc.whorl.logic.domain.dao.orders.UsersMapper;
import sc.whorl.logic.domain.model.orders.Users;
import sc.whorl.logic.pojo.order.UserVo;
import sc.whorl.system.commons.MsgResponseBody;
import sc.whorl.system.commons.base.BaseService;
import sc.whorl.system.config.jwt.JWTUserDetail;
import sc.whorl.system.config.jwt.JwtTokenUtil;
import sc.whorl.system.config.springsecurity.utils.ErrorCodeEnum;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
@Slf4j
public class UserService extends BaseService<UsersMapper, Users> {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    AuthenticationManager authenticationManager;


    public void register(UserVo userVo) {
        Users users = new Users();
        users.setAccountname(userVo.getAccountname());
        users.setPassword(bCryptPasswordEncoder.encode(userVo.getPassword()));
        users.setUserPhone(userVo.getUserPhone());
        users.setStatus("EBL");
        this.insert(users);
    }


    /**
     * 用户登陆相关,主要验证用户用户密码以及设置jwt和用户缓存相关,并返回jwt的凭证
     *
     * @param userVo
     * @return
     */
    public MsgResponseBody login(UserVo userVo) {
        Users user = new Users();
        user.setAccountname(userVo.getAccountname());
        Users userOne = selectOne(user);
        if (ObjectUtils.isEmpty(userOne)) {
            log.info("用户不存在!");
            return MsgResponseBody.error(ErrorCodeEnum.LOGIN_INCORRECT.getCode()).setResult(ErrorCodeEnum.LOGIN_INCORRECT.getMessage());
        }
        if (!bCryptPasswordEncoder.matches(userVo.getPassword(), userOne.getPassword())) {
            log.info("用户登陆密码错误!");
            return MsgResponseBody.error(ErrorCodeEnum.LOGIN_INCORRECT.getCode()).setResult(ErrorCodeEnum.LOGIN_INCORRECT.getMessage());
        }

        /**
         * todo spring security验证账户名和密码,可以考虑去除上面的用户和登陆密码校验
         */
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userVo.getAccountname(),
                        userVo.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        //使用jwt生成token 用于权限效验
        JWTUserDetail jwtUserDetail = new JWTUserDetail();
        jwtUserDetail.setLoginName(userOne.getAccountname());
        jwtUserDetail.setLoginTime(new Date());
        jwtUserDetail.setUserId(userOne.getAccountId());
        jwtUserDetail.setUserType(JWTUserDetail.UserType.User);
        String token = jwtTokenUtil.generateToken(jwtUserDetail);
        jwtUserDetail.setJwtToken(token);
        return MsgResponseBody.success().setResult(jwtUserDetail);
    }
}

package sc.whorl.system.config.springsecurity.conf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import sc.whorl.logic.domain.dao.orders.UsersMapper;
import sc.whorl.logic.domain.model.orders.Users;

/***
 *
 * @FileName: CustomUserDetailsService

 * @remark: 配置用户权限认证
 * @explain 当用户登录时会进入此类的loadUserByUsername方法对用户进行验证，验证成功后会被保存在当前回话的principal对象中
 *             系统获取当前登录对象信息方法 WebUserDetails webUserDetails = (WebUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 *
 *              异常信息：
 *              UsernameNotFoundException     用户找不到
 *              BadCredentialsException       坏的凭据
 *              AccountExpiredException       账户过期
 *              LockedException               账户锁定
 *              DisabledException             账户不可用
 *              CredentialsExpiredException   证书过期
 *
 *
 */
@Slf4j
@Service("myUserDetailService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("登录用户：" + username);
        //用户用户信息和用户角色
        Users user = new Users();
        user.setAccountname(username);
        Users userOne = usersMapper.selectOne(user);
        if (ObjectUtils.isEmpty(userOne)) {
            //后台抛出的异常是：org.springframework.security.authentication.BadCredentialsException: Bad credentials  坏的凭证 如果要抛出UsernameNotFoundException 用户找不到异常则需要自定义重新它的异常
            log.info("登录用户：" + username + " 不存在.");
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }
        Set<GrantedAuthority> grantedAuths = new HashSet<GrantedAuthority>();
        //todo 具体业务查询用户对应的角色
       /* if (roleList.size() > 0) {
            roleList.stream().forEach(role -> {
                grantedAuths.add(new SimpleGrantedAuthority(role.getAuthorizedSigns()));
            });
        }*/
        grantedAuths.add(new SimpleGrantedAuthority("admin"));
        grantedAuths.add(new SimpleGrantedAuthority("teach"));
        User baseUser = new User(userOne.getAccountname(),userOne.getPassword(),
                grantedAuths);
        return baseUser;
    }

    @Cacheable(key = "#userId", value = "SC-USERDETAIL")
    public UserDetails loadUserById(Long userId) {
        Users user = new Users();
        user.setAccountId(userId);
        Users userOne = usersMapper.selectOne(user);
        if (ObjectUtils.isEmpty(userOne)) {
            //后台抛出的异常是：org.springframework.security.authentication.BadCredentialsException: Bad credentials  坏的凭证 如果要抛出UsernameNotFoundException 用户找不到异常则需要自定义重新它的异常
            log.info("登录用户编号：" + userId + " 不存在.");
            throw new UsernameNotFoundException("登录用户编号：" + userId + " 不存在");
        }
        Set<GrantedAuthority> grantedAuths = new HashSet<GrantedAuthority>();
        //todo 具体业务查询用户对应的角色,注意SecurityExpressionRoot在判断的时候默认会为hasRole('USER')加上前缀
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_admin"));
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_teach"));
        User baseUser = new User(userOne.getAccountname(), userOne.getPassword(),
                grantedAuths);
        return baseUser;
    }

}

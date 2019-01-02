package sc.whorl.logic.domain.model.auth;

import java.util.Date;
import javax.persistence.*;

public class User {
    /**
     * 记录标识,自增
     */
    @Id
    private Long tid;

    /**
     * 登陆账号,不为空
     */
    @Column(name = "loginName")
    private String loginname;

    /**
     * 用户密码
     */
    @Column(name = "passWord")
    private String password;

    /**
     * 用户姓名
     */
    @Column(name = "userName")
    private String username;

    /**
     * 用户手机号
     */
    private String mobile;

    /**
     * 用户时间
     */
    private String email;

    @Column(name = "createAt")
    private Date createat;

    @Column(name = "createBy")
    private String createby;

    @Column(name = "modifyAt")
    private Date modifyat;

    @Column(name = "modifyBy")
    private String modifyby;

    /**
     * EBL-可用,DBL-不可用
     */
    private String status;

    /**
     * 获取记录标识,自增
     *
     * @return tid - 记录标识,自增
     */
    public Long getTid() {
        return tid;
    }

    /**
     * 设置记录标识,自增
     *
     * @param tid 记录标识,自增
     */
    public void setTid(Long tid) {
        this.tid = tid;
    }

    /**
     * 获取登陆账号,不为空
     *
     * @return loginName - 登陆账号,不为空
     */
    public String getLoginname() {
        return loginname;
    }

    /**
     * 设置登陆账号,不为空
     *
     * @param loginname 登陆账号,不为空
     */
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    /**
     * 获取用户密码
     *
     * @return passWord - 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码
     *
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户姓名
     *
     * @return userName - 用户姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户姓名
     *
     * @param username 用户姓名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取用户手机号
     *
     * @return mobile - 用户手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置用户手机号
     *
     * @param mobile 用户手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取用户时间
     *
     * @return email - 用户时间
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置用户时间
     *
     * @param email 用户时间
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return createAt
     */
    public Date getCreateat() {
        return createat;
    }

    /**
     * @param createat
     */
    public void setCreateat(Date createat) {
        this.createat = createat;
    }

    /**
     * @return createBy
     */
    public String getCreateby() {
        return createby;
    }

    /**
     * @param createby
     */
    public void setCreateby(String createby) {
        this.createby = createby;
    }

    /**
     * @return modifyAt
     */
    public Date getModifyat() {
        return modifyat;
    }

    /**
     * @param modifyat
     */
    public void setModifyat(Date modifyat) {
        this.modifyat = modifyat;
    }

    /**
     * @return modifyBy
     */
    public String getModifyby() {
        return modifyby;
    }

    /**
     * @param modifyby
     */
    public void setModifyby(String modifyby) {
        this.modifyby = modifyby;
    }

    /**
     * 获取EBL-可用,DBL-不可用
     *
     * @return status - EBL-可用,DBL-不可用
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置EBL-可用,DBL-不可用
     *
     * @param status EBL-可用,DBL-不可用
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
package sc.whorl.logic.domain.model.orders;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Alias("users")
@Table(name = "users")
public class Users implements Serializable {
    /**
     * 物理主键，自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
    private Long accountId;

    /**
     * 账户名称
     */
    @Column(name = "accountName")
    private String accountname;

    /**
     * 用户账号，应用层产生，不能重复
     */
    @Column(name = "userName")
    private String username;

    /**
     * 密码，只保存校验值，例如MD5的校验结果
     */
    @Column(name = "password")
    private String password;

    /**
     * 状态，正常或者冻结，这个状态只能手动设置
     * DBL 不可用
     * EBL 正常
     * CKD 已验证， 则不允许删除、修改
     * DEL 已删除
     */
    @Column(name = "status")
    private String status;

    @Column(name = "userEmail")
    private String useremail;
    @Column(name = "userPhone")
    private String userPhone;

    /**
     * 来源，用户的来源渠道
     */
    @Column(name = "token")
    private String token;

    /**
     * 创建人
     */
    @Column(name = "createBy")
    private String createby;

    @Column(name = "createAt")
    private Date createat;

    /**
     * 最后修改人
     */
    @Column(name = "modifyBy")
    private String modifyby;

    /**
     * 最后修改时间
     */
    @Column(name = "modifyAt")
    private Date modifyat;


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取账户名称
     *
     * @return accountName - 账户名称
     */
    public String getAccountname() {
        return accountname;
    }

    /**
     * 设置账户名称
     *
     * @param accountname
     *         账户名称
     */
    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    /**
     * 获取用户账号，应用层产生，不能重复
     *
     * @return userName - 用户账号，应用层产生，不能重复
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户账号，应用层产生，不能重复
     *
     * @param username
     *         用户账号，应用层产生，不能重复
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码，只保存校验值，例如MD5的校验结果
     *
     * @return password - 密码，只保存校验值，例如MD5的校验结果
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码，只保存校验值，例如MD5的校验结果
     *
     * @param password
     *         密码，只保存校验值，例如MD5的校验结果
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取状态，正常或者冻结，这个状态只能手动设置
     * DBL 不可用
     * EBL 正常
     * CKD 已验证， 则不允许删除、修改
     * DEL 已删除
     *
     * @return status - 状态，正常或者冻结，这个状态只能手动设置 DBL 不可用 EBL 正常 CKD 已验证， 则不允许删除、修改 DEL 已删除
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态，正常或者冻结，这个状态只能手动设置
     * DBL 不可用
     * EBL 正常
     * CKD 已验证， 则不允许删除、修改
     * DEL 已删除
     *
     * @param status
     *         状态，正常或者冻结，这个状态只能手动设置 DBL 不可用 EBL 正常 CKD 已验证， 则不允许删除、修改 DEL 已删除
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return userEmail
     */
    public String getUseremail() {
        return useremail;
    }

    /**
     * @param useremail
     */
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }


    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取来源，用户的来源渠道
     *
     * @return token - 来源，用户的来源渠道
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置来源，用户的来源渠道
     *
     * @param token
     *         来源，用户的来源渠道
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取创建人
     *
     * @return createBy - 创建人
     */
    public String getCreateby() {
        return createby;
    }

    /**
     * 设置创建人
     *
     * @param createby
     *         创建人
     */
    public void setCreateby(String createby) {
        this.createby = createby;
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
     * 获取最后修改人
     *
     * @return modifyBy - 最后修改人
     */
    public String getModifyby() {
        return modifyby;
    }

    /**
     * 设置最后修改人
     *
     * @param modifyby
     *         最后修改人
     */
    public void setModifyby(String modifyby) {
        this.modifyby = modifyby;
    }

    /**
     * 获取最后修改时间
     *
     * @return modifyAt - 最后修改时间
     */
    public Date getModifyat() {
        return modifyat;
    }

    /**
     * 设置最后修改时间
     *
     * @param modifyat
     *         最后修改时间
     */
    public void setModifyat(Date modifyat) {
        this.modifyat = modifyat;
    }


}
package sc.whorl.logic.domain.model.auth;

import java.util.Date;
import javax.persistence.*;

public class Userrole {
    /**
     * 用户校色主编号,自增
     */
    @Id
    private Long tid;

    /**
     * 用户编号
     */
    @Column(name = "userId")
    private Long userid;

    /**
     * 角色编号
     */
    @Column(name = "roleId")
    private Long roleid;

    /**
     * 状态EBL-可用,DBL-不可用
     */
    private String status;

    @Column(name = "createAt")
    private Date createat;

    @Column(name = "createBy")
    private String createby;

    @Column(name = "modifyAt")
    private Date modifyat;

    @Column(name = "modifyBy")
    private String modifyby;

    /**
     * 获取用户校色主编号,自增
     *
     * @return tid - 用户校色主编号,自增
     */
    public Long getTid() {
        return tid;
    }

    /**
     * 设置用户校色主编号,自增
     *
     * @param tid 用户校色主编号,自增
     */
    public void setTid(Long tid) {
        this.tid = tid;
    }

    /**
     * 获取用户编号
     *
     * @return userId - 用户编号
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置用户编号
     *
     * @param userid 用户编号
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取角色编号
     *
     * @return roleId - 角色编号
     */
    public Long getRoleid() {
        return roleid;
    }

    /**
     * 设置角色编号
     *
     * @param roleid 角色编号
     */
    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    /**
     * 获取状态EBL-可用,DBL-不可用
     *
     * @return status - 状态EBL-可用,DBL-不可用
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态EBL-可用,DBL-不可用
     *
     * @param status 状态EBL-可用,DBL-不可用
     */
    public void setStatus(String status) {
        this.status = status;
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
}
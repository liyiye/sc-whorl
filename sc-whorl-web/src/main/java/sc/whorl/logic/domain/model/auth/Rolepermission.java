package sc.whorl.logic.domain.model.auth;

import java.util.Date;
import javax.persistence.*;

public class Rolepermission {
    @Id
    private Long tid;

    /**
     * 角色编号
     */
    @Column(name = "roleId")
    private Long roleid;

    /**
     * 权限Id
     */
    @Column(name = "permissionId")
    private Long permissionid;

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
     * @return tid
     */
    public Long getTid() {
        return tid;
    }

    /**
     * @param tid
     */
    public void setTid(Long tid) {
        this.tid = tid;
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
     * 获取权限Id
     *
     * @return permissionId - 权限Id
     */
    public Long getPermissionid() {
        return permissionid;
    }

    /**
     * 设置权限Id
     *
     * @param permissionid 权限Id
     */
    public void setPermissionid(Long permissionid) {
        this.permissionid = permissionid;
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
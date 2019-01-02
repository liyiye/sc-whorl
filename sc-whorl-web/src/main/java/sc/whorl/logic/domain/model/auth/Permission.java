package sc.whorl.logic.domain.model.auth;

import java.util.Date;
import javax.persistence.*;

public class Permission {
    /**
     * 记录编号,自增
     */
    @Id
    private Long tid;

    /**
     * 权限名称
     */
    @Column(name = "permissionName")
    private String permissionname;

    /**
     * 权限描述
     */
    private String description;

    /**
     * 权限代码
     */
    @Column(name = "functionNumber")
    private String functionnumber;

    @Column(name = "createAt")
    private Date createat;

    @Column(name = "createBy")
    private String createby;

    @Column(name = "modifyAt")
    private Date modifyat;

    @Column(name = "modifyBy")
    private String modifyby;

    /**
     * 获取记录编号,自增
     *
     * @return tid - 记录编号,自增
     */
    public Long getTid() {
        return tid;
    }

    /**
     * 设置记录编号,自增
     *
     * @param tid 记录编号,自增
     */
    public void setTid(Long tid) {
        this.tid = tid;
    }

    /**
     * 获取权限名称
     *
     * @return permissionName - 权限名称
     */
    public String getPermissionname() {
        return permissionname;
    }

    /**
     * 设置权限名称
     *
     * @param permissionname 权限名称
     */
    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }

    /**
     * 获取权限描述
     *
     * @return description - 权限描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置权限描述
     *
     * @param description 权限描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取权限代码
     *
     * @return functionNumber - 权限代码
     */
    public String getFunctionnumber() {
        return functionnumber;
    }

    /**
     * 设置权限代码
     *
     * @param functionnumber 权限代码
     */
    public void setFunctionnumber(String functionnumber) {
        this.functionnumber = functionnumber;
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
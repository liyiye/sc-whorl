package sc.whorl.logic.domain.model.auth;

import java.util.Date;
import javax.persistence.*;

public class Role {
    /**
     * 记录编号,自增
     */
    @Id
    private Long tid;

    /**
     * 父级角色编号
     */
    @Column(name = "parentId")
    private Long parentid;

    /**
     * 角色名称
     */
    @Column(name = "roleName")
    private String rolename;
    /**
     * 使用状态
     * EBL-可用
     * DBL-不可用
     */
    @Column(name = "status")
    private String status;


    /**
     * 角色描述
     */
    private String description;

    @Column(name = "createAt")
    private Date createat;

    @Column(name = "createBy")
    private String createby;

    @Column(name = "modifyAt")
    private Date modifyat;

    @Column(name = "modifyBy")
    private String modifyby;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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
     * 获取父级角色编号
     *
     * @return parentId - 父级角色编号
     */
    public Long getParentid() {
        return parentid;
    }

    /**
     * 设置父级角色编号
     *
     * @param parentid 父级角色编号
     */
    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    /**
     * 获取角色名称
     *
     * @return roleName - 角色名称
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * 设置角色名称
     *
     * @param rolename 角色名称
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * 获取角色描述
     *
     * @return description - 角色描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置角色描述
     *
     * @param description 角色描述
     */
    public void setDescription(String description) {
        this.description = description;
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
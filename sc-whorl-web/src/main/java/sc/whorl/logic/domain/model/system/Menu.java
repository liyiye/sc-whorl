package sc.whorl.logic.domain.model.system;

import java.util.Date;
import javax.persistence.*;

public class Menu {
    /**
     * 菜单表主键,标记唯一列自增
     */
    @Id
    private Long tid;

    /**
     * 父级菜单编号.如果没有父级则父级为0
     */
    @Column(name = "parentId")
    private Long parentid;

    /**
     * 菜单Url
     */
    @Column(name = "menuUrl")
    private String menuurl;

    /**
     * 菜单名称
     */
    @Column(name = "menuName")
    private String menuname;

    /**
     * 关联权限表
     */
    @Column(name = "permissionId")
    private Long permissionid;

    /**
     * 状态EBL-可用,DBL-不可用
     */
    private String status;

    /**
     * 不同应用菜单的区分
     */
    @Column(name = "applicationCode")
    private String applicationcode;

    @Column(name = "createAt")
    private Date createat;

    @Column(name = "createBy")
    private String createby;

    @Column(name = "modifyAt")
    private Date modifyat;

    @Column(name = "modifyBy")
    private String modifyby;

    private Integer order;

    /**
     * 获取菜单表主键,标记唯一列自增
     *
     * @return tid - 菜单表主键,标记唯一列自增
     */
    public Long getTid() {
        return tid;
    }

    /**
     * 设置菜单表主键,标记唯一列自增
     *
     * @param tid 菜单表主键,标记唯一列自增
     */
    public void setTid(Long tid) {
        this.tid = tid;
    }

    /**
     * 获取父级菜单编号.如果没有父级则父级为0
     *
     * @return parentId - 父级菜单编号.如果没有父级则父级为0
     */
    public Long getParentid() {
        return parentid;
    }

    /**
     * 设置父级菜单编号.如果没有父级则父级为0
     *
     * @param parentid 父级菜单编号.如果没有父级则父级为0
     */
    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    /**
     * 获取菜单Url
     *
     * @return menuUrl - 菜单Url
     */
    public String getMenuurl() {
        return menuurl;
    }

    /**
     * 设置菜单Url
     *
     * @param menuurl 菜单Url
     */
    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl;
    }

    /**
     * 获取菜单名称
     *
     * @return menuName - 菜单名称
     */
    public String getMenuname() {
        return menuname;
    }

    /**
     * 设置菜单名称
     *
     * @param menuname 菜单名称
     */
    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    /**
     * 获取关联权限表
     *
     * @return permissionId - 关联权限表
     */
    public Long getPermissionid() {
        return permissionid;
    }

    /**
     * 设置关联权限表
     *
     * @param permissionid 关联权限表
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
     * 获取不同应用菜单的区分
     *
     * @return applicationCode - 不同应用菜单的区分
     */
    public String getApplicationcode() {
        return applicationcode;
    }

    /**
     * 设置不同应用菜单的区分
     *
     * @param applicationcode 不同应用菜单的区分
     */
    public void setApplicationcode(String applicationcode) {
        this.applicationcode = applicationcode;
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
     * @return order
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * @param order
     */
    public void setOrder(Integer order) {
        this.order = order;
    }
}
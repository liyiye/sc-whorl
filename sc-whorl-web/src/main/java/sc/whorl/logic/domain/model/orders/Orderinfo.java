package sc.whorl.logic.domain.model.orders;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Alias("orderinfo")
@Table(name = "orderinfo")
public class Orderinfo implements Serializable {
    /**
     * 自增主健
     */
    @Id
    @Column(name = "pid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    /**
     * 订单标题
     */
    @Column(name = "orderTitle")
    private String ordertitle;

    /**
     * 订单金额
     */
    @Column(name = "orderAmount")
    private String orderamount;

    /**
     * 创建时间
     */
    @Column(name = "createAt")
    private Date createat;

    /**
     * 创建人
     */
    @Column(name = "createBy")
    private String createby;

    /**
     * 获取自增主健
     *
     * @return pid - 自增主健
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置自增主健
     *
     * @param pid 自增主健
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取订单标题
     *
     * @return orderTitle - 订单标题
     */
    public String getOrdertitle() {
        return ordertitle;
    }

    /**
     * 设置订单标题
     *
     * @param ordertitle 订单标题
     */
    public void setOrdertitle(String ordertitle) {
        this.ordertitle = ordertitle;
    }

    /**
     * 获取订单金额
     *
     * @return orderAmount - 订单金额
     */
    public String getOrderamount() {
        return orderamount;
    }

    /**
     * 设置订单金额
     *
     * @param orderamount 订单金额
     */
    public void setOrderamount(String orderamount) {
        this.orderamount = orderamount;
    }

    /**
     * 获取创建时间
     *
     * @return createAt - 创建时间
     */
    public Date getCreateat() {
        return createat;
    }

    /**
     * 设置创建时间
     *
     * @param createat 创建时间
     */
    public void setCreateat(Date createat) {
        this.createat = createat;
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
     * @param createby 创建人
     */
    public void setCreateby(String createby) {
        this.createby = createby;
    }
}
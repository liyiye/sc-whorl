package sc.whorl.logic.pojo.order;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import sc.whorl.system.commons.validate.Mobile;
import sc.whorl.system.commons.validate.UserName;


/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OrderInfoVo implements Serializable {
    @UserName
    @NotNull
    private String userName;
    @Mobile
    private String mobilePhone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}

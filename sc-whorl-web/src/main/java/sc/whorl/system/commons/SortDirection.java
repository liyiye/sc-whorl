/*
 * Copyright (C),2015-2015. 城家酒店管理有限公司
 * FileName: SortDirection.java
 * Author:   wangpeng
 * Date:     2015-11-23 14:46:50
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <wangpeng>  <2015-11-23 14:46:50> <1.0.0> <创建> <PMS1.0>
 */

package sc.whorl.system.commons;

import java.io.Serializable;

/**
 * 排序规则枚举类定义。<br/>
 *
 * @auth: wangpeng
 * @since cjia-commons-base-api-1.0.0
 */
public enum SortDirection implements Serializable {

    /**
     * 目前支持排序规则有ASC，DESC
     */
    ASC("ASC"), DESC("DESC");

    /**
     * 排序规则
     */
    private String code;

    /**
     * 获取排序规则代码
     *
     * @return 排序规则代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 默认构造函数
     *
     * @param code 排序规则代码
     */
    SortDirection(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "[" + this.name() + " = " + this.getCode() + "]";
    }

}

/*
 * Copyright (C),2015-2015. 城家酒店管理有限公司
 * FileName: PageResponse.java
 * Author:   wangpeng
 * Date:     2015-12-01 15:40:30
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <wangpeng>  <2015-12-01 15:40:30> <1.0.0> <创建> <PMS1.0>
 */

package sc.whorl.system.commons;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;

/**
 * 分页响应对象基类，定义了所有有关分页的信息。<br/>
 * 所有的分页响应对象都需要继承该类。
 */
public class PageResponse implements Serializable {

    public PageResponse(PageInfo pageInfo) {
        this.pageIndex = pageInfo.getPageNum();
        this.pages = pageInfo.getPages();
        this.count = pageInfo.getTotal();
        this.pageSize = pageInfo.getPageSize();
    }

    /**
     * 当前页码
     */
    private int pageIndex;

    /**
     * 当前页的真实记录数
     */
    private int pageSize;

    /**
     * 总页数
     */
    private int pages;

    /**
     * 总记录数
     */
    private long count;

    /**
     * 获取当前页码
     *
     * @return 当前页码
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     * 设置当前页码
     *
     * @param pageIndex
     *         当前页面
     */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * 获取当前页的真实记录数
     *
     * @return 当前页的真实记录数
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置当前页的真实记录数
     *
     * @param pageSize
     *         当前页的真实记录数
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取总页数
     *
     * @return 总页数
     */
    public int getPages() {
        return pages;
    }

    /**
     * 设置总页数
     *
     * @param pages
     *         总页数
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}

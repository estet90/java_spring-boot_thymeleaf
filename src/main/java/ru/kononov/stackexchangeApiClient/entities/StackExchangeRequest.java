package ru.kononov.stackexchangeApiClient.entities;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Поисковый запрос
 */
public class StackExchangeRequest {

    private Long page;
    private Long pageSize;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private DateTime toDate;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private DateTime fromDate;
    private Order order = Order.ASC;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private DateTime min;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private DateTime max;
    private Sort sort = Sort.ACTIVITY;
    private String tagged;
    private String notTagged;
    private String inTitle;
    private String site;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public DateTime getToDate() {
        return toDate;
    }

    public void setToDate(DateTime toDate) {
        this.toDate = toDate;
    }

    public DateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(DateTime fromDate) {
        this.fromDate = fromDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public DateTime getMin() {
        return min;
    }

    public void setMin(DateTime min) {
        this.min = min;
    }

    public DateTime getMax() {
        return max;
    }

    public void setMax(DateTime max) {
        this.max = max;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public String getTagged() {
        return tagged;
    }

    public void setTagged(String tagged) {
        this.tagged = tagged;
    }

    public String getNotTagged() {
        return notTagged;
    }

    public void setNotTagged(String notTagged) {
        this.notTagged = notTagged;
    }

    public String getInTitle() {
        return inTitle;
    }

    public void setInTitle(String inTitle) {
        this.inTitle = inTitle;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}

package com.zbjk.creditfactory.mock.dto;

import java.util.Date;

/**
 * @author wys
 * @date 2018/3/21/021
 */
public class MockDto {

    /**自增ID**/
    private Long id;

    /**请求接口路径**/
    private String url;

    /**返回参数**/
    private String data;

    /**创建时间**/
    private Date createdAt;

    private Integer page = 1;
    private Integer size = 10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "MockDto{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", data='" + data + '\'' +
                ", createdAt=" + createdAt +
                ", page=" + page +
                ", size=" + size +
                '}';
    }
}

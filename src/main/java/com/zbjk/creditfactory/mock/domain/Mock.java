package com.zbjk.creditfactory.mock.domain;
import java.io.Serializable;
import java.util.Date;

/**
 *@author wys
 *@date 2018/03/21
 *@description Mock实体类
 */
@SuppressWarnings("serial")
public class Mock implements Serializable {

	/**自增ID**/
	private Long id;

	/**请求接口路径**/
	private String url;

	/**返回参数**/
	private String data;

	/**创建时间**/
	private Date createdAt;

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
		return "Mock{" +
				"id=" + id +
				", url='" + url + '\'' +
				", data='" + data + '\'' +
				", createdAt=" + createdAt +
				'}';
	}
}

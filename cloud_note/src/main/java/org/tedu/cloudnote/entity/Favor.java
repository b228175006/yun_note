package org.tedu.cloudnote.entity;

import java.io.Serializable;

public class Favor implements Serializable {

	/**
	 * 初始版本
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 用户Id
	 */
	private String cn_user_id;
	/**
	 * 分享笔记Id
	 */
	private String cn_share_id;
	
	public String getCn_user_id() {
		return cn_user_id;
	}
	public void setCn_user_id(String cn_user_id) {
		this.cn_user_id = cn_user_id;
	}
	public String getCn_share_id() {
		return cn_share_id;
	}
	public void setCn_share_id(String cn_share_id) {
		this.cn_share_id = cn_share_id;
	}
	@Override
	public String toString() {
		return "Favor [cn_user_id=" + cn_user_id + ", cn_share_id=" + cn_share_id + "]";
	}
	
}

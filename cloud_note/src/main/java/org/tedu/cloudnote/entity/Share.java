package org.tedu.cloudnote.entity;

import java.io.Serializable;

public class Share implements Serializable{

	/**
	 * 初始Version
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 共享Id
	 */
	private String cn_share_id;
	/**
	 * 共享标题
	 */
	private String cn_share_title;
	/**
	 * 共享内容
	 */
	private String cn_share_body;
	/**
	 * 笔记Id
	 */
	private String cn_note_id;
	public String getCn_share_id() {
		return cn_share_id;
	}
	public void setCn_share_id(String cn_share_id) {
		this.cn_share_id = cn_share_id;
	}
	public String getCn_share_title() {
		return cn_share_title;
	}
	public void setCn_share_title(String cn_share_title) {
		this.cn_share_title = cn_share_title;
	}
	public String getCn_share_body() {
		return cn_share_body;
	}
	public void setCn_share_body(String cn_share_body) {
		this.cn_share_body = cn_share_body;
	}
	public String getCn_note_id() {
		return cn_note_id;
	}
	public void setCn_note_id(String cn_note_id) {
		this.cn_note_id = cn_note_id;
	}
	@Override
	public String toString() {
		return "Share [cn_share_id=" + cn_share_id + ", cn_share_title=" + cn_share_title + ", cn_share_body="
				+ cn_share_body + ", cn_note_id=" + cn_note_id + "]";
	}
	
	
}

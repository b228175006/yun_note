package org.tedu.cloudnote.util;

import java.io.Serializable;

/**
 * 所有请求的响应对象
 * @author Java
 *
 */
public class NoteResult implements Serializable{
	/**
	 * 默认UID
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int status;//状态
	private String msg;//消息
	private Object data;//返回的数据
	
	
	
	public NoteResult(int status, String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	
	
	public NoteResult() {
		
	}


	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "NoteResult [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
	
}

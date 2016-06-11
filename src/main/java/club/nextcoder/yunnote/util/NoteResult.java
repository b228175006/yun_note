package club.nextcoder.yunnote.util;

import java.io.Serializable;
/**
 * 返回数据封装类
 * @author Java
 *
 */
public class NoteResult implements Serializable{

	/**
	 * 默认
	 */
	private static final long serialVersionUID = 1L;
	
	private String status;//状态码
	private String msg;//返回信息
	private Object data;//返回数据
	
	/**
	 * 无参构造
	 */
	public NoteResult() {
		
	}
	/**
	 * 有参构造
	 * @param status
	 * @param msg
	 * @param data
	 */
	public NoteResult(String status, String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
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

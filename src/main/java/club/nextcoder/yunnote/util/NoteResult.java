package club.nextcoder.yunnote.util;

import java.io.Serializable;
/**
 * �������ݷ�װ��
 * @author Java
 *
 */
public class NoteResult implements Serializable{

	/**
	 * Ĭ��
	 */
	private static final long serialVersionUID = 1L;
	
	private String status;//״̬��
	private String msg;//������Ϣ
	private Object data;//��������
	
	/**
	 * �޲ι���
	 */
	public NoteResult() {
		
	}
	/**
	 * �вι���
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

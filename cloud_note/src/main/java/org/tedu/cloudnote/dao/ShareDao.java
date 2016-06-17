package org.tedu.cloudnote.dao;

import java.util.List;

import org.tedu.cloudnote.entity.Share;

public interface ShareDao {
	/**
	 * ��������
	 * @param share ����ʵ�������
	 * @return
	 */
	public int saveShare(Share share);
	/**
	 * ���ݱʼ�Id���в�ѯ
	 * @param noteId �ʼ�Id
	 * @return
	 */
	public Share findByNoteId(String noteId);
	/**
	 * ���ݱʼ����ƽ���ģ������
	 * @param title
	 * @return
	 */
	public List<Share> search(String title);
	/**
	 * ���ݷ���Id��ѯ
	 * @param shareId �����Id
	 * @return
	 */
	public Share findByShareId(String shareId);
	/**
	 * �޸����ݣ����ݱʼ�Id����
	 * @param share ʵ�����
	 * @return
	 */
	public int updateShare(Share share);
}

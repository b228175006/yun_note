package org.tedu.cloudnote.dao;

import java.util.List;

import org.tedu.cloudnote.entity.Share;

public interface ShareDao {
	/**
	 * 新增分享
	 * @param share 分享实体类参数
	 * @return
	 */
	public int saveShare(Share share);
	/**
	 * 根据笔记Id进行查询
	 * @param noteId 笔记Id
	 * @return
	 */
	public Share findByNoteId(String noteId);
	/**
	 * 根据笔记名称进行模糊搜索
	 * @param title
	 * @return
	 */
	public List<Share> search(String title);
	/**
	 * 根据分享Id查询
	 * @param shareId 分享的Id
	 * @return
	 */
	public Share findByShareId(String shareId);
	/**
	 * 修改内容，根据笔记Id查找
	 * @param share 实体对象
	 * @return
	 */
	public int updateShare(Share share);
}

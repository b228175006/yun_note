package org.tedu.cloudnote.service;

import org.tedu.cloudnote.util.NoteResult;

public interface ShareService {
	/**
	 * 新增分享
	 * @param noteId 笔记Id
	 * @return
	 */
	public NoteResult shareNote(String noteId);
	/**
	 * 根据笔记标题模糊搜索
	 * @param title 笔记标题
	 * @return
	 */
	public NoteResult searchShare(String title);
	/**
	 * 根据分享Id进行查询，预览笔记
	 * @param shareId 分享Id
	 * @return
	 */
	public NoteResult loadShare(String shareId);
	/**
	 * 收藏笔记
	 * @param shareId 分享笔记Id
	 * @return
	 */
	public NoteResult favorShare(String shareId,String userId);
}

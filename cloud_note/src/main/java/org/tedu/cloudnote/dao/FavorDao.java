package org.tedu.cloudnote.dao;

import org.tedu.cloudnote.entity.Favor;

public interface FavorDao {
	/**
	 * 新增数据
	 * @param favor
	 * @return
	 */
	public int save(Favor favor);
	
	/**
	 * 通过favor对象进行查询数据数量
	 * @param favor
	 * @return 查询到几条记录
	 */
	public int findFavor(Favor favor);
}

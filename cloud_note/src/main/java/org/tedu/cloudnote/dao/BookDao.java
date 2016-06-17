package org.tedu.cloudnote.dao;

import java.util.List;
import java.util.Map;

import org.tedu.cloudnote.entity.Book;

public interface BookDao {
	/**
	 * ����UserId ��ȡ�����ʼǱ�
	 * @param userId
	 * @return
	 */
	public List<Book> findByUserId(String userId);
	/**
	 * ���ݱʼǱ����Ʋ���
	 * @param bookName �ʼǱ����ƣ�userId �û�Id
	 * @return
	 */
	public Book findByBookName(Map<String,Object> map);
	/**
	 * ���ݱʼǱ�Id����
	 * @param bookId �ʼǱ�Id
	 * @return
	 */
	public Book findByBookId(String bookId);
	/**
	 * �½��ʼǱ�
	 * @param book
	 * @return
	 */
	public int saveBook(Book book);
	/**
	 * �������ʼǱ�
	 * @param book
	 * @return
	 */
	public int rename(Book book);
	
}
package org.tedu.cloudnote.service;

import org.tedu.cloudnote.util.NoteResult;

public interface BookService {
	/**
	 * �����û�Id��ѯ�ʼǱ�
	 * @param userId �û�Id
	 * @return
	 */
	public NoteResult loadUserBooks(String userId);
	/**
	 * �½��ʼǱ�
	 * @param bookName �ʼǱ�����
	 * @param userId �û�Id
	 * @return
	 */
	public NoteResult saveBook(String bookName,String userId);
	/**
	 * �������ʼǱ�
	 * @param rename �ʼǱ�����
	 * @param bookId �ʼǱ�Id
	 * @param userId �û�Id
	 * @return
	 */
	public NoteResult rename (String rename,String bookId,String userId);
}

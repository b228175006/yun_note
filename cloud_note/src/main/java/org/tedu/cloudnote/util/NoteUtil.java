package org.tedu.cloudnote.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;



public class NoteUtil {
	
	/** 
	 * ����UUID�㷨����һ��Ψһ�Ե��ַ���
	 * @return
	 */
	public static String createId(){
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		return id;
	}
	
	/**
	 * ��msg����MD5�㷨��������һ��String���
	 * @param msg ����
 	 * @return ����
	 */
	public static String md5(String msg){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			//Ԫ����Ϣinput
			byte[] input = msg.getBytes();
			//������Ϣoutput
			byte[] output = md.digest(input);//���ܴ���
			//����Base64����������outputת��String�ַ���
			String s = Base64.encodeBase64String(output);
			return s;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println("md5����ʧ��");
			return null;
		}
		
	}
	
	public static void main(String[] args) {
//		System.out.println(md5("123456"));
//		System.out.println(md5("qwertyuiop"));
		System.out.println(createId());
		System.out.println(createId());
		System.out.println(createId());
		System.out.println(createId());
		System.out.println(createId());
		System.out.println(createId());
	}
}

package com.qian.encoded;

import org.apache.commons.codec.binary.Base64;

public class Base64Coded {
	public static void main(String[] args) {
		String string = "qianyang123";
		//����
		String encode = encode(string.getBytes());
		System.out.println(string + "\t�������ַ���Ϊ��" + encode);
		//����
		String decode = decode(encode.getBytes());
		System.out.println(encode + "\t�ַ��������Ϊ��" + decode);
	}
	//base64 ����
    public static String decode(byte[] bytes) {  
        return new String(Base64.decodeBase64(bytes));  
    }  
  
    //base64 ����
    public static String encode(byte[] bytes) {  
        return new String(Base64.encodeBase64(bytes));  
    }  
}

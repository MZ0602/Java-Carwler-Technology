package com.qian.test;

public class StringTest {
	public static void main(String[] args) {
		String url = " https://www.baidu.com/ ";
		String urlTrim = url.trim(); //ȥ���ո��ַ�
		System.out.println(urlTrim + "\t" + urlTrim.length());   //��ȡ�ַ�������
		System.out.println("toUpperCase:" + urlTrim.toUpperCase()); //ת���ɴ�д
		boolean bEqual = urlTrim.equals("www"); //�ж��ַ����Ƿ���ͬ
		boolean bContain = urlTrim.contains("www"); //�ж��Ƿ����
		System.out.println("bEqual:" + bEqual + "\t" + "bContain:" + bContain);
		String urlConcat = urlTrim.toLowerCase().concat("crawler");  //Ҳ�ɲ���+����ʽ
		System.out.println("urlConcat:" + urlConcat);
		String urlSubstring = urlTrim.substring(2, urlTrim.length()); //�ӵڶ����ַ�����ȡ�����
		System.out.println("urlSubstring:" + urlSubstring);
		int urlIndexOf = urlTrim.indexOf("t"); //Ѱ��ĳ�ַ���λ��
		System.out.println("urlIndexOf:" + urlIndexOf);
		boolean urlStartsWith = urlTrim.startsWith("https"); //�Ƿ���ĳ�ַ�Ϊǰ׺
		boolean urlEndsWith = urlTrim.endsWith("com/"); //�Ƿ���ĳ�ַ�Ϊ��׺
		System.out.println("urlStartsWith:" + urlStartsWith + "\t" + "urlEndsWith:" + urlEndsWith);
	}
}

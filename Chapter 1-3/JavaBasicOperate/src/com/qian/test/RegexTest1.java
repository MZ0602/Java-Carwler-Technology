package com.qian.test;

public class RegexTest1 {

	public static void main(String[] args) {
		String str1 = "a1b2c3dAZ4";
		String strReplace1 = str1.replaceAll("[abc]", "");
		System.out.println("ʹ��Ԫ�ַ�[abc]ƥ��Ľ��Ϊ:" + strReplace1);
		String strReplace2 = str1.replaceAll("[^abc]", "");
		System.out.println("ʹ��Ԫ�ַ�[^abc]ƥ��Ľ��Ϊ:" + strReplace2);
		String strReplace3 = str1.replaceAll("[a-zA-Z]", "");
		System.out.println("ʹ��Ԫ�ַ�[a-zA-Z]ƥ��Ľ��Ϊ:" + strReplace3);
		String strReplace4 = str1.replaceAll("[1-9]", "");
		System.out.println("ʹ��Ԫ�ַ�[1-9]ƥ��Ľ��Ϊ:" + strReplace4);
		String strReplace5 = str1.replaceAll("[1-3]", "");
		System.out.println("ʹ��Ԫ�ַ�[1-3]ƥ��Ľ��Ϊ:" + strReplace5);
		String strReplace6 = str1.replaceAll("[a-d1-3]", "");
		System.out.println("ʹ��Ԫ�ַ�[a-d1-3]ƥ��Ľ��Ϊ:" + strReplace6);
	}
}

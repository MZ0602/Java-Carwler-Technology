package com.qian.test;

public class RegexTest {

	public static void main(String[] args) {
		String url = "//i.autohome.com.cn/75975500";   //ʹ��Jsoup�����õ���urlƬ��
		String user_id = url.replaceAll("\\D", "");  //ȡ�����еķ������ַ�
		System.out.println(user_id);  //����Ľ����Ϊ75975500
		String content = "������ʽ-CSDN����";
		String[] contentRegex = content.split("\\p{Punct}"); //�Ա����Ž����и�
		System.out.println(contentRegex[0]); //������Ϊ"������ʽ"
		
	}
}

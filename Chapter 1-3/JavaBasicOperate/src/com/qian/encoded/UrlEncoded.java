package com.qian.encoded;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
public class UrlEncoded {
	public static void main(String[] args) {
		String keyword = "����";  //��Ҫ����Ĺؼ���
		try {
			//������뷽ʽgbk��utf-8
			String keywordEncoded = URLEncoder.encode(keyword, "gbk");
			System.out.println(keywordEncoded);  //������
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}

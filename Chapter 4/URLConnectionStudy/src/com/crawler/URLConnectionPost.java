package com.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLConnectionPost {

	public static void main(String[] args) throws IOException {
		//Post����Ҫ�ύ�Ĳ���
		String wen = "EH629625211CS";
		String action = "ajax";
		//��ʼ��URL
		URL url = new URL("http://www.kd185.com/ems.php");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
		//����Output
		conn.setDoOutput(true); 
		conn.setRequestMethod("POST"); //Post�ύ����
		StringBuffer params = new StringBuffer();  
		// ������ƴ��
		params.append("wen").append("=").append(wen).append("&")
		.append("action").append("=").append(action);
		byte[] bypes = params.toString().getBytes();
		conn.getOutputStream().write(bypes);// ����������Ӳ���
		// ����BufferedReader����������ȡURL����Ӧ ,�������ñ��� 
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(conn.getInputStream(), "utf-8"));  
		String line; 
		String html = "";
		while ((line = bufferedReader.readLine()) != null) {  
			html +=  line;  
		}  
		System.out.println(html);
		bufferedReader.close();
	}
}

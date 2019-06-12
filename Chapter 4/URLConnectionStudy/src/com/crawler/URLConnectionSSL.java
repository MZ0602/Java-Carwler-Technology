package com.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
public class URLConnectionSSL {
	public static void main(String[] args) throws IOException {
		initUnSecureTSL();
		//ʹ��URLConnection��������
		URL url = new URL("https://www.creditchina.gov.cn/xinyongfuwu/?navPage=5");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				int statusCode = conn.getResponseCode(); //��ȡ��Ӧ״̬��
		String responseBody = null;
		//�����Ӧ״̬��Ϊ200
		if (HttpURLConnection.HTTP_OK == statusCode) {  
			// ����BufferedReader����������ȡURL����Ӧ ,�������ñ���
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(conn.getInputStream(), "utf-8"));  
			//��ȡ����
			String readLine = null;
			StringBuffer response = new StringBuffer();
			while (null != (readLine = bufferedReader.readLine())) {
				response.append(readLine);
			}

			bufferedReader.close();
			responseBody = response.toString();
		}
		System.out.println(responseBody);
	}
	private static void initUnSecureTSL()  {
		// �������ι�����(����֤֤��)
		final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
			//���ͻ���֤��
			public void checkClientTrusted(final X509Certificate[] chain, final String authType) {
				//do nothing ��������ͻ���֤��
			}
			//����������֤��  
			public void checkServerTrusted(final X509Certificate[] chain, final String authType) {
				//do nothing  ������������֤��
			}
			//���������ε�X509֤��
			public X509Certificate[] getAcceptedIssuers() {
				return null; //����return new X509Certificate[0];
			}
		}};
		try {
			// ����SSLContext����,��ʹ��ָ�������ι�������ʼ��
			SSLContext sslContext = SSLContext.getInstance("SSL");
			sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
			////�������ι������������׽��ֹ��� (ssl socket factory)
			SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
			//��HttpsURLConnection����SSLSocketFactory
			HttpsURLConnection.setDefaultSSLSocketFactory(sslSocketFactory);
			//��������HttpsЭ����վ
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

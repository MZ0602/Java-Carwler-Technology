package com.qian.test;

public class StringTypeConversion {
	public static void main(String[] args) {
		String sumPage = "30"; //���磬ĳ��̳��������ҳ��Ϊ30
		int sumPageParse = Integer.parseInt(sumPage);
		String price = "1299.8";  //���磬ĳ��Ʒ�ļ۸�Ϊ1299.8
		double priceParse = Double.parseDouble(price);
		System.out.println(sumPageParse + "\t" + priceParse);
	}
}

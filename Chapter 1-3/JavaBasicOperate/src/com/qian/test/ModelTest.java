package com.qian.test;
import java.util.ArrayList;
import java.util.List;
public class ModelTest {
	public static void main(String[] args) {
		JdInfoModel product1 = new JdInfoModel();  //��������
		//����ֵ������
		product1.setId(1);  
		product1.setProduct_name("��Ϊp20");
		product1.setPrice(4800.50);
		JdInfoModel product2 = new JdInfoModel(); //����Ĵ���
		//����ֵ������
		product2.setId(2);
		product2.setProduct_name("��Ϊnova2s");
		product2.setPrice(2300.60);
		//�����������ݰ�����������Է�װ�������д洢
		List<JdInfoModel> productList = new ArrayList<JdInfoModel>(); 
		productList.add(product1);
		productList.add(product2);
		//��ȡһ������Ĳ�Ʒ����
		System.out.println(productList.get(0).getProduct_name());
	}
}

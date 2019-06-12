package com.qian.test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	/**
	 * ���в���
	 */
	public static void main(String[] args) {
		/*���в���
		*add()��remove()������ʧ�ܵ�ʱ����׳��쳣(���Ƽ�)
		*/
		Queue<String> urlQueue = new LinkedList<String>();
		//���Ԫ��
		urlQueue.offer("https://www.douban.com/people/46077896/likes/topic/");
		urlQueue.offer("https://www.douban.com/people/1475408/likes/topic");
		urlQueue.offer("https://www.douban.com/people/3853295/likes/topic/");
		for(String url : urlQueue){
			System.out.println(url);
		}
		System.out.println("=====================");
		System.out.println("��һ��urlΪ:" + urlQueue.poll()); //���صڶ�ͷԪ�أ����ڶ�����ɾ��
		for(String url : urlQueue){
			System.out.println(url);
		}
		System.out.println("=====================");
		System.out.println("��һ��urlΪ:" + urlQueue.element()); //��ȡ��ͷԪ�ص����Ƴ���ͷԪ��
		for(String url : urlQueue){
			System.out.println(url);
		}
		System.out.println("=====================");
		System.out.println("��һ��urlΪ:" + urlQueue.peek()); //��ȡ��ͷԪ�ص����Ƴ���ͷԪ��
		for(String url : urlQueue){
			System.out.println(url);
		}
		if( urlQueue.isEmpty() ){  //�ж������Ƿ�Ϊ��
			System.out.println("����Ϊ�գ�");
		}else {
			System.out.println("���в�Ϊ��,������Ԫ�ظ���Ϊ:" + urlQueue.size());
		}
	}
}

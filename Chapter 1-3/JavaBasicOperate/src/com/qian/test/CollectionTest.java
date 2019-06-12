package com.qian.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public class CollectionTest {
	public static void main(String[] args)  {
		//List���ϵĴ���
		List<String> urllist = new ArrayList<String>();
		//����Ԫ�ص����
		urllist.add("https://movie.douban.com/subject/27608425");
		urllist.add("https://movie.douban.com/subject/26968024");
		//��һ�ַ�ʽ��������
		for( String url : urllist ){
		    System.out.println(url);
		}
		//�ڶ��ַ�ʽ��������
		for( int i=0; i<urllist.size(); i++ ){
		    System.out.println(i+":"+urllist.get(i));
		}
		//�����ַ�ʽ��������
		Iterator<String> it = urllist.iterator();
		while ( it.hasNext() ){
		    System.out.println(it.next());
		}

		//Set���ϵĳ�ʼ��
		Set<String> set = new HashSet<String>();
	    set.add("https://movie.douban.com/subject/27608425");
	    set.add("https://movie.douban.com/subject/27608425");
	    set.add("https://movie.douban.com/subject/26968024");
	    //Set���ϵı���
	    Iterator<String> setIt = set.iterator();
	    while ( setIt.hasNext() ){
	      System.out.println(setIt.next());
	    }

	    //Map���ϵĳ�ʼ��
	    Map<String,Integer> map = new HashMap<String,Integer>();
	    //ֵ����ӣ���������������еĲ�Ʒid�Լ�ÿ����Ʒid��Ӧ��������
	    map.put("jd1515", 100);
	    map.put("jd1516", 300);
	    map.put("jd1515", 100);
	    map.put("jd1517", 200);
	    map.put("jd1518", 100);
	    //��һ�ַ�������map����
	    for (String key : map.keySet()) {  
	        Integer value = map.get(key);  
	        System.out.println("Key = " + key + ", Value = " + value);  
	    }  
	    //�ڶ��ַ�������map���
	    Iterator<Entry<String, Integer>> entries = map.entrySet().iterator();  
	    while (entries.hasNext()) {  
	        Entry<String, Integer> entry = entries.next();  
	        System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
	    }  
	    //�����ַ�������map����
	    for (Entry<String, Integer> entry : map.entrySet()) {  
	        System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());  
	    }  
		
	}
}

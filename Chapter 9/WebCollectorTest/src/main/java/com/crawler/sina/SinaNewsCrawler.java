package com.crawler.sina;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;
public class SinaNewsCrawler extends BreadthCrawler {
	private static StringBuilder sb = new StringBuilder();
	private static String fileName;
	private static String code;
	public SinaNewsCrawler(String crawlPath, boolean autoParse,String filename,String cod) {
		super(crawlPath, autoParse);
		/**
		 * 添加种子URL
		 */
		this.addSeed("https://news.sina.com.cn/");
		this.addSeed("https://news.sina.com.cn/china/");
		/**
		 * URL访问规则添加 
		 * 
		 * 以https://news.sina.com.cn/c/为前缀
		 * 以.shtml为后缀
		 * 不匹配以.(jpg|png|gif)结尾的URL
		 */
		this.addRegex("^(https://news.sina.com.cn/c/).*(\\.shtml)$");
		this.addRegex("-.*\\.(jpg|png|gif|css|js|mid|mp4|wav|avi|mov|mpeg|ram|m4v|pdf)$");
		/**
		 * 输出文件配置
		 * 
		 * 文件名以及文件编码
		 */
		fileName = filename;
		code = cod;
	}

	public void visit(Page page, CrawlDatums next) {
		String url = page.url();
		//种子URL,不符合条件,这里过滤掉
		if (page.matchUrl("^(https://news.sina.com.cn/c/).*(\\.shtml)$")){
			/**
			 * Jsoup解析数据
			 */
			String title = page.select("h1[class=main-title]").text();
			String content = page.select("div[class=article]").text();
			sb.append("URL:\t" + url  + "\n" + "title:\t" + title
					+ "\ncontent:\t" + content + "\n\n");
		}
		try {
			writeFile(fileName, sb.toString(), code);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 数据写入指定文档
	 * 
	 * @param file(文件名)
	 * @param content(需要写入的内容)
	 * @param code(文件编码)
	 */
	public static void writeFile(String file, String content, String code) 
			throws IOException {
		File result = new File(file);
		OutputStream out = new FileOutputStream(result, false);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, code));
		bw.write(content);
		bw.close();
		out.close();
	}

	public static void main(String[] args) throws Exception {
		SinaNewsCrawler crawler = new SinaNewsCrawler("sinaNewsCrawler", true,
				"data/sinaNews.txt","utf-8");
		//设置线程数目
		crawler.setThreads(3);
		//设置每一层最多采集的页面数
		crawler.getConf().setTopN(400);
		crawler.setResumable(true);
		//执行间隔
		crawler.getConf().setExecuteInterval(1000);
		crawler.getConf().setConnectTimeout(10000); //连接超时
		crawler.getConf().setReadTimeout(10000);//读取数据超时
		crawler.getConf().setMaxRedirect(5);//设置最大重定向次数
        crawler.setMaxExecuteCount(2); //设置最大执行次数
		crawler.getConf().setDefaultUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
        		+ "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.108 Safari/537.36");//设置UserAgent
		//开始数据采集，设置采集的深度
		crawler.start(4);
	}
}
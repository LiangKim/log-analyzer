package com.zjipst.log.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * 测试txt文本索引生成与查询
 * @author liangkim
 */
public class DemoIndexService {

	private String indexPath;  //索引文件存放路径
	private String filePath;    //原始文件存放路径
	private Analyzer analyzer = new SmartChineseAnalyzer();
	private IndexWriter iwriter;  //索引笔头
	
	public DemoIndexService(String indexPath, String filePath){
		try {
			this.indexPath = indexPath;
			this.filePath = filePath;
			Directory dir = FSDirectory.open(Paths.get(indexPath));
			IndexWriterConfig config = new IndexWriterConfig(analyzer);
			iwriter = new IndexWriter(dir, config);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成索引文件
	 * @throws FileNotFoundException 
	 */
	private void indexDoc(File file) throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		int lnum = 0;
		String lstr = "";
		while((lstr=reader.readLine())!=null){
			Document doc = getDocument(file, ++lnum, lstr);
			iwriter.addDocument(doc);
		}
		reader.close();
	}
	
	/**
	 * 获取文档对象
	 * @param sor 原始文件
	 * @param lnum 行数
	 * @param lstr 该行文本
	 * @return 文档对象
	 */
	private Document getDocument(File sor, long lnum, String lstr){
		Document doc = new Document();
		doc.add(new TextField("line", String.valueOf(lnum), Field.Store.YES));
		doc.add(new TextField("content", lstr, Field.Store.YES));
		doc.add(new TextField("filename", sor.getName(), Field.Store.YES));
		return doc;
	}
	
	/**
	 * 开始建立索引
	 * @throws Exception 
	 */
	public void start() throws Exception{
		File dir = new File(filePath);
		if(dir.isDirectory()){
			for(File log:dir.listFiles()){
				System.out.println("开始为"+log.getName()+"建立索引。。。");
				indexDoc(log);
			}
		}
		System.out.println("全部索引建立完毕，共生成"+iwriter.numDocs()+"条索引");
	}
	
	public void close(){
		try {
			iwriter.commit();
			iwriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 搜索
	 * @throws IOException 
	 */
	public void search() throws Exception{
		IndexSearcher searcher = 
				new IndexSearcher(DirectoryReader.open(FSDirectory.open(Paths.get(indexPath))));
		QueryParser parser = new QueryParser("content", analyzer);
		Query query = parser.parse("3301001610260000000003");
		TopDocs docs = searcher.search(query, 10);
		System.out.println("共查询到："+docs.totalHits);
		
		for(ScoreDoc sd:docs.scoreDocs){
			Document doc = searcher.doc(sd.doc);
			System.out.println(doc.get("content"));
		}
	}
	
	
	public static void main(String[] args) throws Exception{
//		
		DemoIndexService dis = new DemoIndexService("E:\\lucene\\index", "E:\\lucene\\sor");
//		dis.start();
//		dis.close();
		dis.search();
	}
}

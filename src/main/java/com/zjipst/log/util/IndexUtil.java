package com.zjipst.log.util;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * 索引生成、查询工具类
 * @author kim
 */
public class IndexUtil {

	/**
	 * 根据索引路径和分析器获取索引笔头，缺点是需要手动关闭
	 * @param indexPath 要写入的索引路径
	 * @param analyzer 词法分析器
	 * @return 索引笔头
	 */
	public IndexWriter getIndexWriter(String indexPath, Analyzer analyzer){
		IndexWriter iwriter = null;
		try {
			Directory dir = FSDirectory.open(Paths.get(indexPath));
			IndexWriterConfig config = new IndexWriterConfig(analyzer);
			iwriter = new IndexWriter(dir, config);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return iwriter;
	}
	
	/**
	 * 根据索引路径获取查询器
	 * @param indexPath
	 * @param analyzer
	 * @return
	 */
	public IndexSearcher getIndexSeacher(String indexPath, Analyzer analyzer){
		IndexSearcher searcher = null;
		try {
			searcher = new IndexSearcher(DirectoryReader.open(FSDirectory.open(Paths.get(indexPath))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return searcher;
	}
}

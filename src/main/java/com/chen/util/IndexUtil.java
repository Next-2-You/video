package com.chen.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.TextFragment;
import org.apache.lucene.search.highlight.TokenSources;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.Version;

import com.chen.constant.Constant;
import com.chen.dao.impl.FilmDaoImpl;
import com.chen.entities.Film;
import com.chen.entities.PageInfo;
public class IndexUtil {
	
	private Analyzer ikAnalyzer;  
	
	private IndexWriter indexWriter;
	
	private FilmDaoImpl filmDao;
	
	private Directory directory;
	
	/**
	 * 创建索引文件夹
	 * 
	 */
	public void createDirectory() {
		File file = new File(Constant.INDEXFILEPATH);
		if(file.exists()) {
			if(file.isDirectory()) {
				File[] listFiles = file.listFiles();
				if(listFiles!=null) {
					for (File f : listFiles) {
						f.delete();
					}
				}
				file.delete();
			}else {
				file.delete();
			}
		}
		file.mkdirs();
	}
	
	
	
	//创建电影索引文件
	public void createIndexFile() throws IOException{

			createDirectory();
			
			//从数据库中采集数据
			String hql = "from Film";
			List<Film> queryFilmList = filmDao.findEntityByHQL(hql, null);
			
			//Document对象集合
			List<Document> documents = new ArrayList<>();
			
			//将采集到的数据存放成Document对象
			for (Film film : queryFilmList) {
				Document document = new Document();
				//不分词，不索引,要存储 
				Field id = new Field("id", film.getId().toString(), Field.Store.YES, Field.Index.NOT_ANALYZED);
				//要分词，要索引，要存储
				Field filmName = new TextField("filmName",film.getFilmName(),Store.YES);
				//不分词，不索引，要存储
				Field introduction = new StoredField("introduction",film.getIntroduction());
				//不分词，不索引，要存储
				Field filmImage = new StoredField("filmImage",film.getFilmImage());
				document.add(id);
				document.add(filmName);
				document.add(introduction);
				document.add(filmImage);
				indexWriter.addDocument(document);
			}

			indexWriter.commit();
	}
	
	//运用索引查询电影
	public List<Film> doSearch(PageInfo<Film> pageInfo,String filmName) throws IOException, ParseException, InvalidTokenOffsetsException {
		QueryParser queryParser = new QueryParser(Version.LUCENE_46,"filmName", ikAnalyzer);
		Query query = queryParser.parse(filmName);
		SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<font color=red>","</font>");
		Highlighter highlighter = new Highlighter(simpleHTMLFormatter, new QueryScorer(query));
		IndexReader indexReader = DirectoryReader.open(directory);
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		
		
		// 查询数据， 结束页面自前的数据都会查询到，但是只取本页的数据
        TopDocs topDocs = indexSearcher.search(query, pageInfo.getPageSize());
        
        int count=topDocs.totalHits;
        pageInfo.setCount(count);
        if(pageInfo.getPageIndex()>count) {
        	return null;
        }
        
        //获取到上一页最后一条
        //如果是获取第一页，则为null
        ScoreDoc preScore = null;
        if(pageInfo.getPageIndex()!=0) {
        	preScore=topDocs.scoreDocs[pageInfo.getPageIndex()-1];
        }
       
        //查询最后一条后的数据的一页数据
        topDocs = indexSearcher.searchAfter(preScore, query,pageInfo.getPageSize());
		
        
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		
		List<Film> filmList=new ArrayList<>();
		Film film;
		for (ScoreDoc scoreDoc : scoreDocs) {
			int doc = scoreDoc.doc;
			Document document = indexSearcher.doc(doc);
			film=new Film();
			Long id = Long.valueOf(document.get("id"));
			film.setId(id);
			film.setFilmImage(document.get("filmImage"));
			film.setIntroduction(document.get("introduction"));
			String getFilmName = document.get("filmName");
			TokenStream tokenStream = TokenSources.getAnyTokenStream(indexReader, doc,"filmName", ikAnalyzer);
			TextFragment[] frag = highlighter.getBestTextFragments(tokenStream, getFilmName, false, 200);
			String filmNameHigh="";
			for(int i=0;i<frag.length;i++) {
				if((frag[i]!=null&&(frag[i].getScore()>0))) {
					filmNameHigh=((frag[i].toString()));
				}
			}
			film.setFilmName(filmNameHigh);		
			filmList.add(film);		
		}
		
		return filmList;
	}
	
	
	/**
	 * 	添加或更新指定索引
	 * 
	 * 	
	 * 
	 * @param name
	 * @param value
	 * @return
	 */
	public boolean addOrUpdateFilmIndex(Film film) {
		Document document = new Document();
		Field id = new Field("id", film.getId().toString(), Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field filmName = new TextField("filmName",film.getFilmName(),Store.YES);
		Field introduction = new StoredField("introduction",film.getIntroduction());
		Field filmImage = new StoredField("filmImage",film.getFilmImage());
		
		document.add(id);
		document.add(filmName);
		document.add(introduction);
		document.add(filmImage);
		
		Term term = new Term("id",film.getId().toString());
		try {
			indexWriter.updateDocument(term, document);
			indexWriter.commit();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * 添加索引
	 * 
	 * @param film
	 * @return
	 */
//	public boolean addFilmIndex(Film film) {
//		Document document = new Document();
//		Field id = new Field("id", film.getId().toString(), Field.Store.YES, Field.Index.NOT_ANALYZED);
//		Field filmName = new TextField("filmName",film.getFilmName(),Store.YES);
//		Field introduction = new StoredField("introduction",film.getIntroduction());
//		Field filmImage = new StoredField("filmImage",film.getFilmImage());
//		
//		document.add(id);
//		document.add(filmName);
//		document.add(introduction);
//		document.add(filmImage);
//		try {
//			indexWriter.addDocument(document);
//		} catch (IOException e) {
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}
	
	
	/*
	 * 
	 * 删除指定索引
	 * 
	 */
	public boolean deleteFilmIndex(Long id) {
		Term term = new Term("id",id.toString());
		try {
			indexWriter.deleteDocuments(term);
			indexWriter.commit();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	public Analyzer getIkAnalyzer() {
		return ikAnalyzer;
	}

	public void setIkAnalyzer(Analyzer ikAnalyzer) {
		this.ikAnalyzer = ikAnalyzer;
	}

	public IndexWriter getIndexWriter() {
		return indexWriter;
	}

	public void setIndexWriter(IndexWriter indexWriter) {
		this.indexWriter = indexWriter;
	}

	public FilmDaoImpl getFilmDao() {
		return filmDao;
	}

	public void setFilmDao(FilmDaoImpl filmDao) {
		this.filmDao = filmDao;
	}

	public Directory getDirectory() {
		return directory;
	}

	public void setDirectory(Directory directory) {
		this.directory = directory;
	}


	
	

}

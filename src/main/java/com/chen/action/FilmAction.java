package com.chen.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.search.IndexSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chen.constant.Constant;
import com.chen.constant.StyleEnum;
import com.chen.entities.Film;
import com.chen.entities.PageInfo;
import com.chen.service.FilmService;
import com.chen.util.IndexUtil;
import com.chen.util.ValidateUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class FilmAction extends ActionSupport {
	
	private Map<String,List<Film>> filmMap;
	
	private String leftMore;
	
	private String rightMore;
	
	private String searchName;
	
	private PageInfo<Film> pageInfo=new PageInfo<>();
	
	@Autowired
	private IndexUtil indexUtil;

	public PageInfo<Film> getPageInfo() {
		return pageInfo;
	}


	public void setPageInfo(PageInfo<Film> pageInfo) {
		this.pageInfo = pageInfo;
	}


	public String getSearchName() {
		return searchName;
	}


	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	


	public String getLeftMore() {
		return leftMore;
	}


	public void setLeftMore(String leftMore) {
		this.leftMore = leftMore;
	}


	public String getRightMore() {
		return rightMore;
	}


	public void setRightMore(String rightMore) {
		this.rightMore = rightMore;
	}




	@Autowired
	private FilmService filmService;
	

	public Map<String, List<Film>> getFilmMap() {
		return filmMap;
	}


	public void setFilmList(Map<String, List<Film>> filmMap) {
		this.filmMap = filmMap;
	}
	


	/**
	 * 初始化首页
	 * @return
	 */
	public String toIndexPage() {
		
		filmMap=new HashMap<>();
		pageInfo.setPageSize(Constant.LEFTSIZE);
		List<Film> broadcastFilm = filmService.initBroadcastFilm();
		List<Film> leftFilm = filmService.getLeftFilm(StyleEnum.FILM.getId(),pageInfo,false);
		List<Film> leftTvPlay = filmService.getLeftFilm(StyleEnum.TV_PLAY.getId(),pageInfo,false);
		List<Film> leftComic = filmService.getLeftFilm(StyleEnum.COMIC.getId(),pageInfo,false);
		pageInfo.setPageSize(Constant.RIGHTSIZE);
		List<Film> rightFilm = filmService.getRightFilm(StyleEnum.FILM.getId(),pageInfo,false);	
		List<Film> rightComic = filmService.getRightFilm(StyleEnum.COMIC.getId(),pageInfo,false);		
		List<Film> rightTvPlay = filmService.getRightFilm(StyleEnum.TV_PLAY.getId(),pageInfo,false);
		filmMap.put("broadcastFilm", broadcastFilm);
		filmMap.put("leftFilm", leftFilm);
		filmMap.put("rightFilm", rightFilm);
		filmMap.put("leftComic", leftComic);
		filmMap.put("rightComic", rightComic);
		filmMap.put("leftTvPlay", leftTvPlay);
		filmMap.put("rightTvPlay", rightTvPlay);
		return "indexPage";
	}
	

	
	/**
	 * 首页的更多和搜索页面
	 * 
	 * 通用
	 * 
	 * @return
	 */
	public String toSearchPage() {
		System.out.println("leftMore:"+leftMore);
		System.out.println("rightMore:"+rightMore);
		System.out.println("searchName:"+searchName);
		System.out.println("pageIndex:"+pageInfo.getPageIndex());
		System.out.println("pageSize:"+pageInfo.getPageSize());
		
		List<Film> filmList=null;
		if(!ValidateUtil.isValid(leftMore)) {
			filmList = filmService.getLeftFilm(Integer.valueOf(leftMore),pageInfo,true);
			filmService.supplementPageInfo(pageInfo, Integer.valueOf(leftMore));
		}else if(!ValidateUtil.isValid(rightMore)) {
			filmList=filmService.getRightFilm(Integer.valueOf(rightMore),pageInfo,true);
			filmService.supplementPageInfo(pageInfo, Integer.valueOf(rightMore));
		}else if(!ValidateUtil.isValid(searchName)) {
			filmList = filmService.getPageInfoByIndex(pageInfo, searchName);
			filmService.supplementPageInfo(pageInfo);	
		}
		pageInfo.setPageList(filmList);
		return "searchPage";
	}


	

	
	
	
}

package com.chen.service;

import java.util.List;
import java.util.Map;

import com.chen.entities.Episode;
import com.chen.entities.Film;
import com.chen.entities.Manager;
import com.chen.entities.PageInfo;

public interface FilmService{
	
	public Film loadEntity(Long id);

	public Film getEntity(Long id);
	
	public List<Film> initBroadcastFilm();
	
	public List<Film> getLeftFilm(int styleId,PageInfo<Film> pageInfo,boolean isMorePage);

	public List<Film> getRightFilm(int styleId,PageInfo<Film> pageInfo,boolean isMorePage);
	
	public List<Film> getPageInfoByIndex(PageInfo<Film> pageInfo,String filmName);
	
	public List<Film> getFilm(PageInfo<Film> pageInfo);
	
	public PageInfo<Film> supplementFilmListPageInfo(PageInfo<Film> pageInfo);
	
	//初始化索引文件
	public boolean initIndexFile();
	//添加或更新索引文件
	public boolean addOrUpdateFilmIndex(Film film);
	//删除索引文件
	public boolean deleteFilmIndex(Long id);
	//添加索引
//	public boolean addFilmIndex(Film film);
	
	
	public List<Film> getClassifyFilm(PageInfo<Film> pageInfo,Map<String,Object> map);
	
	//把分页信息补充完整
	public PageInfo<Film> supplementPageInfo(PageInfo<Film> pageInfo,Integer styleId);
	//把分页信息补充完整
	public PageInfo<Film> supplementPageInfo(PageInfo<Film> pageInfo);
	
	public void saveOrUpdateEntity(Film film);
	
	public void updateStatusId(Long id,int statusId);
	
	
	public List<Film> getAllFilm();
	//获得多集数影视的全部影片
	public List<Episode> getItsEpisode(Long filmid);
	
	
}

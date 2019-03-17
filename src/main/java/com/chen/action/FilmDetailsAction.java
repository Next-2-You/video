package com.chen.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chen.constant.Constant;
import com.chen.entities.Episode;
import com.chen.entities.Film;
import com.chen.entities.Resource;
import com.chen.service.EpisodeService;
import com.chen.service.FilmService;
import com.chen.service.ResourceService;
import com.chen.util.ValidateUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.tools.internal.xjc.model.SymbolSpace;

@Controller("filmDetailsAction")
@Scope("prototype")
public class FilmDetailsAction extends ActionSupport implements SessionAware{
	private Film film;

	private List<Episode> filmEpisodeList;
	
	private List<Resource> watchResourceList;//观看的资源   有分辨率
	
	private List<Resource> downLoadResourceList;//下载的资源 有分辨率
	
	
	private Map<String,Object> session;
	
	private String id;
	
	private String episodeId;
	
	private boolean filmIsVIP=false;



	public boolean isFilmIsVIP() {
		return filmIsVIP;
	}

	public void setFilmIsVIP(boolean filmIsVIP) {
		this.filmIsVIP = filmIsVIP;
	}

	public List<Resource> getWatchResourceList() {
		return watchResourceList;
	}

	public void setWatchResourceList(List<Resource> watchResourceList) {
		this.watchResourceList = watchResourceList;
	}

	public List<Resource> getDownLoadResourceList() {
		return downLoadResourceList;
	}

	public void setDownLoadResourceList(List<Resource> downLoadResourceList) {
		this.downLoadResourceList = downLoadResourceList;
	}

	public String getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(String episodeId) {
		this.episodeId = episodeId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	public List<Episode> getFilmEpisodeList() {
		return filmEpisodeList;
	}

	public void setFilmEpisodeList(List<Episode> filmEpisodeList) {
		this.filmEpisodeList = filmEpisodeList;
	}



	@Autowired
	private FilmService filmService;
	
	@Autowired
	private EpisodeService episodeService;
	
	@Autowired
	private ResourceService resourceService;
	
	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public String toFilmDetailsPage() {	
		if(!ValidateUtil.isValid(id)) {
			film = filmService.getEntity(Long.valueOf(id));
		}
		if(film!=null&&film.getStatusId()==Constant.AVAILABLE) {
			filmEpisodeList = episodeService.getFilmEpisodeUserfulList(film.getId());
		}
		return "filmDetailsPage";
	}
	
	public String toOnlinePage() {
		if(!ValidateUtil.isValid(episodeId)) {
			Episode entity = episodeService.getEntity(Long.valueOf(episodeId));
			if(entity!=null) {
				Long filmId = entity.getFilm().getId();
				Film film = filmService.getEntity(filmId);
				if(film!=null) {
					int isVIP = film.getIsVIP();
					if(isVIP==Constant.isVIP) {
						//查看用户是否有登陆并且是否是会员
						//VIP视频不能下载,只能观看
						if(true) {  //........。。。。。。。。这里要判断是否登陆并且是否是会员  需要补充
							watchResourceList = resourceService.getResourceList(Long.valueOf(episodeId), Constant.WATCHLINKTYPE);
							filmIsVIP=true;
						}
					}else {
						watchResourceList = resourceService.getResourceList(Long.valueOf(episodeId), Constant.WATCHLINKTYPE);//免费视频不管有没有登录都可以观看
						//查看用户是否有登陆
						if(true) {//........。。。。。。。。这里要判断是否登陆		   //如果没有登陆就只能观看视频，没办法下载			  需要补充	
							downLoadResourceList = resourceService.getResourceList(Long.valueOf(episodeId), Constant.DOWNLOADLINKTYPE);						
						}
					}
				}
			}
		}
		return "online";
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;	
	}
	

}

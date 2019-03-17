package com.chen.action.admin;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chen.constant.Constant;
import com.chen.entities.Episode;
import com.chen.entities.Film;
import com.chen.entities.PageInfo;
import com.chen.entities.Region;
import com.chen.entities.Resolution;
import com.chen.entities.Resource;
import com.chen.entities.Status;
import com.chen.entities.Style;
import com.chen.entities.Time;
import com.chen.entities.Type;
import com.chen.service.EpisodeService;
import com.chen.service.FilmService;
import com.chen.service.RegionService;
import com.chen.service.ResolutionService;
import com.chen.service.ResourceService;
import com.chen.service.StatusService;
import com.chen.service.StyleService;
import com.chen.service.TimeService;
import com.chen.service.TypeService;
import com.chen.util.ChangeDataType;
import com.chen.util.FileUtil;
import com.chen.util.IndexUtil;
import com.chen.util.ValidateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.tools.internal.xjc.model.SymbolSpace;

@Controller("adminFilmAction")
@Scope("prototype")
public class AdminFilmAction extends ActionSupport {

	private Map<String, List<Film>> filmMap;
	
	private Map<String, List> classifyMap;
	
	private Map<String, Object> dataMap;
	
	
	private Resource resource=new Resource();


	private Film film=new Film();
	
	private String searchName;

	private PageInfo<Film> pageInfo = new PageInfo<>();

	@Autowired
	private IndexUtil indexUtil;

	@Autowired
	private FilmService filmService;

	
	@Autowired
	private StatusService statusService;

	@Autowired
	private TimeService timeService;

	@Autowired
	private StyleService styleService;

	@Autowired
	private TypeService typeService;

	@Autowired
	private RegionService regionService;
	
	@Autowired
	private EpisodeService episodeService;
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private ResolutionService resolutionService;
	
	private String temp;
	
	private File file;
	

	private String id;
	
	private Map<String,List<Episode>> episodeMap;
	
	private Long filmid;
	private Long episodeid;
	private String episodeName;
	
	private Episode episode=new Episode();
	
	private List<Resolution> resolutionList;
	

	public List<Resolution> getResolutionList() {
		return resolutionList;
	}

	public void setResolutionList(List<Resolution> resolutionList) {
		this.resolutionList = resolutionList;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public ResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public ResolutionService getResolutionService() {
		return resolutionService;
	}

	public void setResolutionService(ResolutionService resolutionService) {
		this.resolutionService = resolutionService;
	}

	

	public EpisodeService getEpisodeService() {
		return episodeService;
	}

	public void setEpisodeService(EpisodeService episodeService) {
		this.episodeService = episodeService;
	}

	public Episode getEpisode() {
		return episode;
	}

	public void setEpisode(Episode episode) {
		this.episode = episode;
	}

	public Long getFilmid() {
		return filmid;
	}

	public void setFilmid(Long filmid) {
		this.filmid = filmid;
	}

	public Long getEpisodeid() {
		return episodeid;
	}

	public void setEpisodeid(Long episodeid) {
		this.episodeid = episodeid;
	}

	public String getEpisodeName() {
		return episodeName;
	}

	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}

	public Map<String, List<Episode>> getEpisodeMap() {
		return episodeMap;
	}

	public void setEpisodeMap(Map<String, List<Episode>> episodeMap) {
		this.episodeMap = episodeMap;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	
	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Map<String, List> getClassifyMap() {
		return classifyMap;
	}

	public void setClassifyMap(Map<String, List> classifyMap) {
		this.classifyMap = classifyMap;
	}

	public StatusService getStatusService() {
		return statusService;
	}

	public void setStatusService(StatusService statusService) {
		this.statusService = statusService;
	}

	public TimeService getTimeService() {
		return timeService;
	}

	public void setTimeService(TimeService timeService) {
		this.timeService = timeService;
	}

	public StyleService getStyleService() {
		return styleService;
	}

	public void setStyleService(StyleService styleService) {
		this.styleService = styleService;
	}

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	public RegionService getRegionService() {
		return regionService;
	}

	public void setRegionService(RegionService regionService) {
		this.regionService = regionService;
	}

	public PageInfo<Film> getPageInfo() {
		return pageInfo;
	}

	public Map<String, List<Film>> getFilmMap() {
		return filmMap;
	}

	public void setFilmMap(Map<String, List<Film>> filmMap) {
		this.filmMap = filmMap;
	}



	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public IndexUtil getIndexUtil() {
		return indexUtil;
	}

	public void setIndexUtil(IndexUtil indexUtil) {
		this.indexUtil = indexUtil;
	}

	public FilmService getFilmService() {
		return filmService;
	}

	public void setFilmService(FilmService filmService) {
		this.filmService = filmService;
	}

	public void setPageInfo(PageInfo<Film> pageInfo) {
		this.pageInfo = pageInfo;
	}

	/**
	 * 
	 * 
	 * 后台影片列表
	 * @return
	 */
	public String toManageFilmPage() {
		System.out.println("searchName:" + searchName);
		System.out.println("pageIndex:" + pageInfo.getPageIndex());
		System.out.println("pageSize:" + pageInfo.getPageSize());

		List<Film> filmList = null;
		if (!ValidateUtil.isValid(searchName)) {
			filmList = filmService.getPageInfoByIndex(pageInfo, searchName);
			filmService.supplementPageInfo(pageInfo);
		}else {
			filmList = filmService.getFilm(pageInfo);
			filmService.supplementFilmListPageInfo(pageInfo);
		}
		pageInfo.setPageList(filmList);
		
		toFilmDetailsPage();
		
		return "filmPage";
	}
	
	
	
	public void toFilmDetailsPage() {
		classifyMap = new HashMap<>();
		List<Status> statusList = statusService.getStatusList();
		List<Time> timeList = timeService.getTimeList();
		List<Style> styleList = styleService.getStyleList();
		List<Type> typeList = typeService.getTypeList();
		List<Region> regionList = regionService.getRegionList();

		classifyMap.put("timeList", timeList);
		classifyMap.put("styleList", styleList);
		classifyMap.put("typeList", typeList);
		classifyMap.put("regionList", regionList);
		classifyMap.put("statusList", statusList);
		System.out.println("abc");
	}
	
	
	/**
	 * 添加影片
	 * 
	 * @return
	 */
	public String addOrUpdateFilm() {	
		Set<Type> typeList = ChangeDataType.String2Set(temp);
		film.setTypeList(typeList);
		String filmImage = FileUtil.Upload(file,Constant.PICTUREPATH);
		System.out.println(Constant.PICTUREPATHcache);
		if(!ValidateUtil.isValid(filmImage)) {
			film.setFilmImage(filmImage);
			FileUtil.UploadCache(file, filmImage, Constant.PICTUREPATHcache);
		}
		filmService.saveOrUpdateEntity(film);
		filmService.addOrUpdateFilmIndex(film);
		return "success";
	}
	
	
	public String filmById() throws IOException {
		Film film=null;
		if(!ValidateUtil.isValid(id)) {
			film = filmService.getEntity(Long.valueOf(id));
		}
			
		//数据量太大，会出现堆栈溢出，得剔除一些数据
		
		dataMap=new HashMap<>();
		
		dataMap.put("id",film.getId());
		dataMap.put("filmName",film.getFilmName());
		dataMap.put("filmImage",film.getFilmImage());
		dataMap.put("actor", film.getActor());
		dataMap.put("director", film.getDirector());
		dataMap.put("introduction", film.getIntroduction());
		dataMap.put("statrs",film.getStatrs());
		dataMap.put("releaseTime", film.getReleaseTime());
		dataMap.put("isVIP", film.getIsVIP());
		dataMap.put("beanlink", film.getBeanlink());
		dataMap.put("statusId", film.getStatusId());
		dataMap.put("region",film.getRegion().getId());
		dataMap.put("time", film.getTime().getId());
		dataMap.put("style", film.getStyle().getId());
		List typeList=new ArrayList();
		Set<Type> typeSet = film.getTypeList();
		for (Type type : typeSet) {
			typeList.add(type.getId());
			
		}
		dataMap.put("typeList", typeList);
		
		return "filmDetails";

	}
	
	/**
	 * 上下架
	 * @return
	 */
	public String changeFilmStatus() {
		dataMap=new HashMap<>();
		dataMap.put("isSuccess", false);
		int statusId=film.getStatusId();
		if(!ValidateUtil.isValid(id)&&statusId!=0) {
			filmService.updateStatusId(Long.valueOf(id), statusId);
			dataMap.put("isSuccess", true);
		}
		return "filmDetails";
	}
	
	/**
	 * 
	 * 得到某部影片的影集
	 * 
	 * @return
	 */
	public String toParticularFilm(){	
		episodeMap=new HashMap<>();		
		List<Episode> Episodes=episodeService.getFilmEpisodeList(filmid);
		episodeMap.put("allEpisodes", Episodes);
		return "particularPage";
	}
	
	/**
	 * 添加或修改影集
	 * 
	 * @return
	 */
	public String addOrUpdateEpisode() {
		episode.setStatusId(Constant.AVAILABLE);
		episodeService.saveOrUpdateEntity(episode);	
		return "success";
	}
	
	/**
	 * 改变影集的状态
	 * 
	 * @return
	 */
	public String changeEpisodeStatus() {
		dataMap=new HashMap<>();
		dataMap.put("isSuccess", false);
		int statusId=episode.getStatusId();
		if(!ValidateUtil.isValid(String.valueOf(episode.getId()))&&statusId!=0) {
			episodeService.updateStatusId(episode.getId(), statusId);
			dataMap.put("isSuccess", true);
		}
		return "filmDetails";
	}
	
	
	public String findEpisodeById() {
		dataMap=new HashMap<>();
		dataMap.put("isSuccess",false);
		if(!ValidateUtil.isValid(id)) {
			Episode entity = episodeService.getEntity(Long.valueOf(id));
			if(entity!=null) {
				dataMap.put("episodeName", entity.getEpisodeName());	
				dataMap.put("episodeNumber", entity.getEpisodeNumber());	
				dataMap.put("isSuccess",true);
			}
		}	
		return "filmDetails";
	}
	
	/**
	 * 影集资源
	 * @return
	 */
	public String toresourceFilm(){	
		
		
		List<Resource> resources=resourceService.getFilmResourceList(episodeid);
		ActionContext.getContext().put("allreSources", resources);	
		ActionContext.getContext().put("episodeName", episodeName);
		
		resolutionList = resolutionService.getRegionList();
		
		return "resourcerPage";
	}
	
	
	public String addOrUpdateResource() {
		
		resourceService.saveOrUpdateEntity(resource);	
		return "success";
	}

	public String findResolutionById() {
		dataMap=new HashMap<>();
		dataMap.put("isSuccess",false);
		if(!ValidateUtil.isValid(id)) {
			Resource entity = resourceService.getEntity(Long.valueOf(id));
			if(entity!=null) {
				dataMap.put("linkType", entity.getLinkType());	
				dataMap.put("link", entity.getLink());	
				dataMap.put("resolutionId", entity.getResolution().getId());	
				dataMap.put("isSuccess",true);
			}
		}	
		return "filmDetails";
	}
	
	
	public String deleteResource() {
		dataMap=new HashMap<>();
		dataMap.put("isSuccess", false);
		if(!ValidateUtil.isValid(String.valueOf(resource.getId()))) {
		Resource entity = resourceService.getEntity(resource.getId());
			if(entity!=null) {
				resourceService.deleteEntity(entity);
				dataMap.put("isSuccess", true);
			}
		}
		return "filmDetails";
	}
	
}

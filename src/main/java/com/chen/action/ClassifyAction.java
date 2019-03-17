package com.chen.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chen.entities.Film;
import com.chen.entities.PageInfo;
import com.chen.entities.Region;
import com.chen.entities.Status;
import com.chen.entities.Style;
import com.chen.entities.Time;
import com.chen.entities.Type;
import com.chen.service.FilmService;
import com.chen.service.RegionService;
import com.chen.service.StatusService;
import com.chen.service.StyleService;
import com.chen.service.TimeService;
import com.chen.service.TypeService;
import com.chen.util.ValidateUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 分类页面
 * 
 * @author Next 2 You
 * @2018年11月24日 下午1:12:18
 */
@Controller("classifyAction")
@Scope("prototype")
public class ClassifyAction extends ActionSupport {

	private Map<String, List> classifyMap = new HashMap<>();

	private PageInfo<Film> pageInfo = new PageInfo<>();

	private String timeId = "0";
	private String styleId = "0";
	private String typeId = "0";
	private String regionId = "0";
	private String statusId = "0";
	private String isVIP = "0";// 全部：0、免费：1、vip：2

	private String ClassifyForm = "Classify_toClassifyPage";// 分页共用判断条件

	public ClassifyAction() {
		classifyMap.put("timeList", new ArrayList());
		classifyMap.put("styleList", new ArrayList());
		classifyMap.put("typeList", new ArrayList());
		classifyMap.put("regionList", new ArrayList());
		classifyMap.put("statusList", new ArrayList());
	}

	public Map<String, List> getClassifyMap() {
		return classifyMap;
	}

	public void setClassifyMap(Map<String, List> classifyMap) {
		this.classifyMap = classifyMap;
	}

	public String getTimeId() {
		return timeId;
	}

	public void setTimeId(String timeId) {
		this.timeId = timeId;
	}

	public String getStyleId() {
		return styleId;
	}

	public void setStyleId(String styleId) {
		this.styleId = styleId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getRegionId() {
		return regionId;
	}
 
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getIsVIP() {
		return isVIP;
	}

	public void setIsVIP(String isVIP) {
		this.isVIP = isVIP;
	}
	

	public PageInfo<Film> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<Film> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getClassifyForm() {
		return ClassifyForm;
	}

	public void setClassifyForm(String classifyForm) {
		ClassifyForm = classifyForm;
	}

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
	private FilmService filmService;

	public String toClassifyPage() {

		getAllClassify();
		Map<String, Object> hqlMap = getHqlMap();
		List<Film> classifyFilm = filmService.getClassifyFilm(pageInfo, hqlMap);
		pageInfo.setPageList(classifyFilm);
		return "classifyPage";
	}

	public String Classify() {
		getAllClassify();

		return "classifyPage";
	}

	public void getAllClassify() {
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
	}

	/**
	 * private String timeId = "0"; private String styleId = "0"; private String
	 * typeId = "0"; private String regionId = "0"; private String statusId = "0";
	 * private String isVIP = "0";// 全部：0、免费：1、vip：2 String hql="select f from Film
	 * f,Type t where f.statusId=? and f.region.id=? and f.time.id=? and
	 * f.style.id=? and t.id=? and f in elements(t.filmList)";
	 * 
	 * 
	 * @return
	 */
	public Map<String, Object> getHqlMap() {
		Map<String, Object> map = new HashMap<>();
		if (!ValidateUtil.isNoZeroValid(statusId)) {
			map.put("f.statusId", Integer.valueOf(statusId));
		}
		if (!ValidateUtil.isNoZeroValid(timeId)) {
			map.put("f.time.id", Integer.valueOf(timeId));
		}
		if (!ValidateUtil.isNoZeroValid(regionId)) {
			map.put("f.region.id", Integer.valueOf(regionId));
		}
		if (!ValidateUtil.isNoZeroValid(styleId)) {
			map.put("f.style.id", Integer.valueOf(styleId));
		}
		if (!ValidateUtil.isNoZeroValid(typeId)) {
			map.put("typeId", Integer.valueOf(typeId));
		}
		if (!ValidateUtil.isNoZeroValid(isVIP)) {
			map.put("f.isVIP", Integer.valueOf(isVIP));
		}
		return map;
	}

}

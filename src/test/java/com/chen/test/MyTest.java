package com.chen.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chen.constant.StyleEnum;
import com.chen.dao.impl.FilmDaoImpl;
import com.chen.entities.Episode;
import com.chen.entities.Film;
import com.chen.entities.Manager;
import com.chen.entities.PageInfo;
import com.chen.entities.Region;
import com.chen.entities.Resource;
import com.chen.entities.Status;
import com.chen.entities.Style;
import com.chen.entities.Time;
import com.chen.entities.Type;
import com.chen.service.EpisodeService;
import com.chen.service.FilmService;
import com.chen.service.ManagerService;
import com.chen.service.RegionService;
import com.chen.service.ResourceService;
import com.chen.service.StatusService;
import com.chen.service.StyleService;
import com.chen.service.TimeService;
import com.chen.service.TypeService;
import com.chen.service.impl.FilmServiceImpl;
import com.chen.util.DataUtil;
import com.chen.util.IndexUtil;

public class MyTest {

	private ApplicationContext app;

	{
		app = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	
	
	@Test
	public void testDataSource() throws Exception {
		
		DataSource dataSource = (DataSource) app.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}
	
	
	@Test
	public void testSessionFactory() throws Exception {
		SessionFactory sf=(SessionFactory) app.getBean("sessionFactory");
		System.out.println(sf.toString());
		
	}
	
	
	@Test
	public void testBean() throws Exception {
		app.getBean("filmAction");
		
	}
	
	
	@Test
	public void testService() throws Exception {
		ManagerService managerService = (ManagerService) app.getBean("managerService");
		Manager manager = new Manager();
		manager.setManagerName("laowang");
		manager.setManagerPasswd(DataUtil.MD5("123456"));
		managerService.saveEntity(manager);
		System.out.println("ok");
	}
	
	@Test
	public void testHql() throws Exception {
		FilmService filmService = (FilmService) app.getBean("filmService");
		List<Film> initBroadcastFilm = filmService.initBroadcastFilm();
		for (Film film : initBroadcastFilm) {
			System.out.println(film.getFilmName());
		}

	}
	
	@Test
	public void testHql2() throws Exception {
		FilmService filmService = (FilmService) app.getBean("filmService");
		List<Film> initBroadcastFilm = filmService.initBroadcastFilm();
		for (Film film : initBroadcastFilm) {
			System.out.println(film.getFilmName());
		}
		
		
	}
	
	@Test
	public void testLeft() throws Exception {
		FilmService filmService = (FilmService) app.getBean("filmService");
		List<Film> leftFilm = filmService.getLeftFilm(1, new PageInfo<Film>(), false);
		for (Film film : leftFilm) {
			System.out.println(film.getFilmName());
		}
	}
	
	@Test
	public void testRight() throws Exception {
		FilmService filmService = (FilmService) app.getBean("filmService");
		List<Film> rightFilm = filmService.getRightFilm(StyleEnum.FILM.getId(), new PageInfo<Film>(), false);
		for (Film film : rightFilm) {
			System.out.println(film.getFilmName());
		}
	}
	
	@Test
	public void testCount() throws Exception {
		FilmService filmService = (FilmService) app.getBean("filmService");
		PageInfo<Film> pageInfo = new PageInfo<Film>();
		pageInfo.setPageIndex(0);
		pageInfo.setPageSize(8);
		PageInfo<Film> pageInfo2 = filmService.supplementPageInfo(pageInfo, 1);
		System.out.println(pageInfo2.getCount());
		System.out.println(pageInfo2.getTotalPages());
		System.out.println(pageInfo2.getCurrentPage());
	}
	
	
	@Test
	public void createIndexFilm() throws Exception {
		IndexUtil indexUtil = (IndexUtil) app.getBean("indexUtil");
		FilmDaoImpl filmDao = (FilmDaoImpl) app.getBean("filmDao");
		indexUtil.setFilmDao(filmDao);
		indexUtil.createIndexFile();
		
	}
	
//	
//	@Test
//	public void createIndexFilmInService() throws Exception {
//		myTestServiceImpl test = (myTestServiceImpl) app.getBean("myTestService");
//		test.createFileIndex();
//	}
//	
//	@Test
//	public void find() throws Exception {
//		myTestServiceImpl test = (myTestServiceImpl) app.getBean("myTestService");
//		List<Film> list = test.findName("自杀小队");
//	}
//	
	
	@Test
	public void testClassify() throws Exception {
		StatusService statusService = (StatusService) app.getBean("statusService");
		List<Status> statusList = statusService.getStatusList();
		for (Status status : statusList) {
			System.out.println(status.getStatus());
		}
		
		TypeService typeService = (TypeService) app.getBean("typeService");
		List<Type> tyleList = typeService.getTypeList();
		for (Type type : tyleList) {
			System.out.println(type.getTypeName());
		}
		
		TimeService timeService = (TimeService) app.getBean("timeService");
		List<Time> timeList = timeService.getTimeList();
		for (Time time : timeList) {
			System.out.println(time.getYear());
			
		}
		
		RegionService regionService = (RegionService) app.getBean("regionService");
		List<Region> regionList = regionService.getRegionList();
		for (Region region : regionList) {
			System.out.println(region.getRegionName());
			
		}
		
		StyleService styleService = (StyleService) app.getBean("styleService");
		List<Style> styleList = styleService.getStyleList();
		for (Style style : styleList) {
			System.out.println(style.getStyleName());
			
		}
	}
	
	
//	@Test
//	public void testGLHql() throws Exception {
//		FilmService filmService = (FilmService) app.getBean("filmService");
//		List<Film> test = filmService.test();
//		for (Film film : test) {
//			System.out.println(film.getFilmName());
//		}
//	
//	}
	
	@Test
	public void testDeleteIndex() throws Exception {
		FilmService filmService = (FilmService) app.getBean("filmService");
		boolean deleteFilmIndex = filmService.deleteFilmIndex(Long.valueOf(2));
		System.out.println(deleteFilmIndex);
	}
	
	
	@Test
	public void testUpdateIndex() throws Exception {
		FilmService filmService = (FilmService) app.getBean("filmService");
		Film f =new Film();
		f.setId(Long.valueOf(3));
		f.setFilmName("美人鱼自杀2");
		f.setFilmImage("1476253019826.jpg");
		f.setIntroduction("试试索引更新文件如何");
		boolean updateFilmIndex = filmService.addOrUpdateFilmIndex(f);
		System.out.println(updateFilmIndex);
	}
	
	@Test
	public void testInitIndex() {
		FilmService filmService = (FilmService) app.getBean("filmService");
		boolean initIndexFile = filmService.initIndexFile();
		System.out.println(initIndexFile);
		
	}
	
	
//	@Test
//	public void testAddIndex() throws Exception {
//		FilmService filmService = (FilmService) app.getBean("filmService");
//		f.setId(Long.valueOf(3));
//		f.setFilmName("美人鱼自杀333");
//		f.setFilmImage("1476253019826.jpg");
//		f.setIntroduction("试试添加");
//		filmService.addFilmIndex(film);
//	}
	
	
	@Test
	public void testFilmDetails() throws Exception {
		FilmService filmService = (FilmService) app.getBean("filmService");
		Film film = filmService.getEntity(3l);
		System.out.println(film.getFilmName());
		String name = film.getRegion().getRegionName();
		Set<Type> typeList = film.getTypeList();
		
		for (Type type : typeList) {
			System.out.println(type.getTypeName());
		}
		

	}
	
	
	@Test
	public void testEpisode() throws Exception {
		EpisodeService episodeService = (EpisodeService) app.getBean("episodeService");
		List<Episode> filmEpisodeList = episodeService.getFilmEpisodeList(3l);
		for (Episode episode : filmEpisodeList) {
			System.out.println(episode.getEpisodeName());
			System.out.println(episode.getEpisodeNumber());
			
		}
		
	}
	
	
	@Test
	public void testResource() throws Exception {
		ResourceService bean = (ResourceService) app.getBean("resourceService");
		List<Resource> resourceList = bean.getResourceList(1l, 1);
		
		for (Resource resource : resourceList) {
			System.out.println(resource.getId());
			System.out.println(resource.getResolution().getResolution());
			
		}
		
		
	}
	
	
	@Test
	public void testGetOne() throws Exception {
		EpisodeService bean = (EpisodeService) app.getBean("episodeService");
		Episode entity = bean.getEntity(3l);
		System.out.println(entity.getFilm().getId());
	}
	
	@Test
	public void initIndex() {
		FilmService filmService = (FilmService) app.getBean("filmService");
		filmService.initIndexFile();
	}
	

}

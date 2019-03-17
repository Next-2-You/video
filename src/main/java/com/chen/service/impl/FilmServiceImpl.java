package com.chen.service.impl;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.constant.Constant;
import com.chen.dao.impl.FilmDaoImpl;
import com.chen.entities.Episode;
import com.chen.entities.Film;
import com.chen.entities.PageInfo;
import com.chen.service.FilmService;
import com.chen.util.IndexUtil;
import com.chen.util.ValidateUtil;

@Service("filmService")
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmDaoImpl filmDao;

	@Autowired
	private IndexUtil indexUtil;

	@Override
	public List<Film> initBroadcastFilm() {
		String hql = "from Film order by release_time DESC ,statrs DESC";
		return filmDao.findEntityByHQL(hql, 0, 3, null);
	}

	@Override
	public List<Film> getLeftFilm(int styleId, PageInfo<Film> pageInfo, boolean isMorePage) {
		String hql = "from Film where status_id=2 and style.id=? order by release_time DESC";
		if (pageInfo.getPageIndex() == null) {
			pageInfo.setPageIndex(Constant.INITSTART);
		}
		if (pageInfo.getPageSize() == null) {
			if (isMorePage) {
				pageInfo.setPageSize(Constant.PAGESIZE);
			} else {
				pageInfo.setPageSize(Constant.LEFTSIZE);
			}
		}

		return filmDao.findEntityByHQL(hql, pageInfo.getPageIndex(), pageInfo.getPageSize(), new Object[] { styleId });
	}

	@Override
	public List<Film> getRightFilm(int styleId, PageInfo<Film> pageInfo, boolean isMorePage) {
		String hql = "from Film where status_id=2 and style.id=? order by statrs DESC";

		if (pageInfo.getPageIndex() == null) {
			pageInfo.setPageIndex(Constant.INITSTART);
		}
		if (pageInfo.getPageSize() == null) {
			if (isMorePage) {
				pageInfo.setPageSize(Constant.PAGESIZE);
			} else {
				pageInfo.setPageSize(Constant.RIGHTSIZE);
			}
		}
		return filmDao.findEntityByHQL(hql, pageInfo.getPageIndex(), pageInfo.getPageSize(), new Object[] { styleId });
	}

	@Override
	public PageInfo<Film> supplementPageInfo(PageInfo<Film> pageInfo, Integer styleId) {
		String hql = "select count(*) from Film where style.id=? and status_id=2";
		int count = filmDao.getPageCount(hql, styleId);
		pageInfo.setCount(count);
		int totalPages = count % pageInfo.getPageSize() != 0 ? (count / pageInfo.getPageSize()) + 1
				: count / pageInfo.getPageSize();
		pageInfo.setTotalPages(totalPages);
		int currentPage = (pageInfo.getPageIndex() / pageInfo.getPageSize()) + 1;
		pageInfo.setCurrentPage(currentPage);
		return pageInfo;
	}

	@Override
	public PageInfo<Film> supplementPageInfo(PageInfo<Film> pageInfo) {
		int totalPages = pageInfo.getCount() % pageInfo.getPageSize() != 0
				? (pageInfo.getCount() / pageInfo.getPageSize()) + 1
				: pageInfo.getCount() / pageInfo.getPageSize();
		pageInfo.setTotalPages(totalPages);
		int currentPage = (pageInfo.getPageIndex() / pageInfo.getPageSize()) + 1;
		pageInfo.setCurrentPage(currentPage);
		return pageInfo;
	}

	@Override
	public List<Film> getPageInfoByIndex(PageInfo<Film> pageInfo, String filmName) {
		indexUtil.setFilmDao(filmDao);
		List<Film> filmList = null;
		if (pageInfo.getPageIndex() == null) {
			pageInfo.setPageIndex(Constant.INITSTART);
		}
		pageInfo.setPageSize(Constant.PAGESIZE);
		try {
			filmList = indexUtil.doSearch(pageInfo, filmName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return filmList;
	}

	@Override
	public List<Film> getClassifyFilm(PageInfo<Film> pageInfo, Map<String, Object> map) {
		StringBuffer sb = new StringBuffer("select f from Film f");
		Object[] obj = null;
		boolean isHaveType = false;
		if (!ValidateUtil.isValid(map)) {
			int size = map.size();
			obj = new Object[size];
			int i = 0;
			if (map.get("typeId") != null) {
				sb.append(",Type t where t.id=? and f in elements(t.filmList)");
				isHaveType = true;
				obj[i] = map.get("typeId");
				i++;
			}

			Set<Entry<String, Object>> entrySet = map.entrySet();
			if (!isHaveType) {
				sb.append(" where 1=1");
			}
			for (Entry<String, Object> entry : entrySet) {
				if (entry.getKey() != "typeId") {
					sb.append(" and " + entry.getKey() + "=?");
					obj[i] = entry.getValue();
					i++;
				}
			}
		}

		if (pageInfo.getPageIndex() == null) {
			pageInfo.setPageIndex(Constant.INITSTART);
		}
		pageInfo.setPageSize(Constant.PAGESIZE);

		String countStr = sb.toString().replace("select f ", "select count(*) ");
		int count = filmDao.getPageCount(countStr, obj);
		pageInfo.setCount(count);
		PageInfo<Film> supplementPageInfo = supplementPageInfo(pageInfo);
		return filmDao.findEntityByHQL(sb.toString(), pageInfo.getPageIndex(), pageInfo.getPageSize(), obj);
	}


	@Override
	public boolean initIndexFile() {
		try {
			indexUtil.setFilmDao(filmDao);
			indexUtil.createIndexFile();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean addOrUpdateFilmIndex(Film film) {
		return indexUtil.addOrUpdateFilmIndex(film);
	}

	@Override
	public boolean deleteFilmIndex(Long id) {
		return indexUtil.deleteFilmIndex(id);
	}

	@Override
	public Film loadEntity(Long id) {
		return filmDao.loadEntity(id);
	}

	@Override
	public Film getEntity(Long id) {
		return filmDao.getEntity(id);
	}
	
	
	@Override
	public List<Film> getFilm(PageInfo<Film> pageInfo){
		String hql = "from Film order by id";
		if (pageInfo.getPageIndex() == null) {
			pageInfo.setPageIndex(Constant.INITSTART);
		}
		if (pageInfo.getPageSize() == null) {
			pageInfo.setPageSize(Constant.PAGESIZE);
		}

		return filmDao.findEntityByHQL(hql, pageInfo.getPageIndex(), pageInfo.getPageSize(),null);
	}
	
	@Override
	public PageInfo<Film> supplementFilmListPageInfo(PageInfo<Film> pageInfo) {
		String hql = "select count(*) from Film";
		int count = filmDao.getPageCount(hql);
		pageInfo.setCount(count);
		int totalPages = count % pageInfo.getPageSize() != 0 ? (count / pageInfo.getPageSize()) + 1
				: count / pageInfo.getPageSize();
		pageInfo.setTotalPages(totalPages);
		int currentPage = (pageInfo.getPageIndex() / pageInfo.getPageSize()) + 1;
		pageInfo.setCurrentPage(currentPage);
	
		return pageInfo;
	}
	
	
	@Override
	public void saveOrUpdateEntity(Film film) {
		filmDao.saveOrUpdateEntity(film);
	}

	@Override
	public void updateStatusId(Long id, int statusId) {
		String hql="update Film set status_id=? where id=?";
		filmDao.updateAttributes(hql, statusId,id);
		
	}


	
	@Override
	public List<Film> getAllFilm() {
		return filmDao.getAllFilm();
	}

	
	
	
	//获得多集数影视的全部影片
	@Override
	public List<Episode> getItsEpisode(Long filmid) {
		
		return filmDao.getItsEpisode(filmid);
		
	}


}

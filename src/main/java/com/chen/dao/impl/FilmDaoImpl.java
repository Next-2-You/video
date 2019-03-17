package com.chen.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.chen.entities.Episode;
import com.chen.entities.Film;
import com.chen.util.ValidateUtil;

@Repository("filmDao")
public class FilmDaoImpl extends BaseDaoImpl<Film> {
	
	public List<Film> findEntityByHQL(String hql,int start,int size,Object... objects) {
		Query q = sf.getCurrentSession().createQuery(hql);
		if(!ValidateUtil.isValid(objects)) {
			for(int i=0;i<objects.length;i++){
				q.setParameter(i, objects[i]);
			}
		}
		q.setFirstResult(start);
		q.setMaxResults(size);
		return q.list();
	}
	

	public int getPageCount(String hql,Integer styleId) {
		Query q = sf.getCurrentSession().createQuery(hql);
		if(styleId!=null) {
			q.setParameter(0,styleId);
		}
		return ((Number)q.uniqueResult()).intValue();   
	}
	
	public int getPageCount(String hql,Object...objects) {
		Query q = sf.getCurrentSession().createQuery(hql);
		if(!ValidateUtil.isValid(objects)) {
			for(int i=0;i<objects.length;i++){
				q.setParameter(i, objects[i]);
			}
		}
		return ((Number)q.uniqueResult()).intValue();   
	}
	
	
	
	public List<Film> findFilmByIn(String hql,String name,List list){
		Query q = sf.getCurrentSession().createQuery(hql);
		q.setParameterList(name, list);
		return q.list();
	}
	
	

	public Film loadEntity(Long id) {
		return (Film) sf.getCurrentSession().load(clazz, id);
		
	}

	public Film getEntity(Long id) {
		return (Film) sf.getCurrentSession().get(clazz, id);
	}
	
	public void saveOrUpdateEntity(Film film) {
		sf.getCurrentSession().saveOrUpdate(film);
	}
	

	
	public void updateAttributes(String hql,Object...objects) {
		Query q = sf.getCurrentSession().createQuery(hql);
		if(!ValidateUtil.isValid(objects)) {
			for(int i=0;i<objects.length;i++){
				q.setParameter(i, objects[i]);
			}
		}
		q.executeUpdate();
	}
	
	public List<Film> getAllFilm() {
		String hql="from Film";
		Query q=sf.getCurrentSession().createQuery(hql);
		return q.list();
		
	}


	public List<Episode> getItsEpisode(Long filmid) {
		String hql="from Episode where film_id=?";
		Query q=sf.getCurrentSession().createQuery(hql);
		q.setParameter(1,filmid);
		return q.list();
	}
	
	
}

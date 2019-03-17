package com.chen.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.chen.entities.Episode;
import com.chen.util.ValidateUtil;

@Repository("episodeDao")
public class EpisodeDaoImpl extends BaseDaoImpl<Episode> {
	
	
	public Episode getEntity(Long id) {
		return  (Episode) sf.getCurrentSession().get(clazz, id);
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
}

package com.gt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gt.dao.comm.HibernateDaoSupport;
import com.gt.entity.PchargeWithdrawStatistics;

/**
 * 
 * @author raoshijing
 * @email 742434841@qq.com
 * @date 2018-10-31 15:30:02
 */
@Repository
public class PchargeWithdrawStatisticsDAO extends HibernateDaoSupport {

	private static final Logger log = LoggerFactory.getLogger(PchargeWithdrawStatisticsDAO.class);

	public void save(PchargeWithdrawStatistics instance) {
		log.debug("saving PchargeWithdrawStatistics instance");
		try {
			getSession().save(instance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public PchargeWithdrawStatistics findById(java.lang.Integer id) {
		log.debug("getting PchargeWithdrawStatistics instance with id: " + id);
		try {
			PchargeWithdrawStatistics instance = (PchargeWithdrawStatistics) getSession().get(
					"com.gt.entity.PchargeWithdrawStatistics", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	
	public void attachDirty(PchargeWithdrawStatistics instance) {
		log.debug("attaching dirty PchargeWithdrawStatistics instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List<PchargeWithdrawStatistics> list(int firstResult, int maxResults, String filter,boolean isFY) {
		List<PchargeWithdrawStatistics> list = null;
		log.debug("finding PchargeWithdrawStatistics instance with filter");
		try {
			String queryString = "from PchargeWithdrawStatistics "+filter;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setCacheable(true);
			if(isFY){
				queryObject.setFirstResult(firstResult);
				queryObject.setMaxResults(maxResults);
			}
			list = queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by PchargeWithdrawStatistics name failed", re);
			throw re;
		}
		return list;
	}
	public Map<Integer, Object> getChargeWithdrawSQLValue1(String sqlfilter) {
		Map<Integer,Object> map = new HashMap<Integer,Object>();
		Query queryObject = getSession().createSQLQuery(sqlfilter);
		List list = queryObject.list();
		if(list != null && list.size() >0 && list.get(0) != null){
			for(int i=0;i<list.size();i++){
				Object[] o = (Object[])list.get(i);
				map.put(Integer.parseInt(o[0].toString()),o[1]);
			}
		}
		return map;
	}

	public double getChargeWithdrawSQLValue2(String filter) {
		double total =0d;
		Query queryObject = getSession().createSQLQuery(filter);
		List list = queryObject.list();
		if(list != null && list.size() >0 && list.get(0) != null){
			total = Double.valueOf(list.get(0).toString());
		}
		return total;
	}
}

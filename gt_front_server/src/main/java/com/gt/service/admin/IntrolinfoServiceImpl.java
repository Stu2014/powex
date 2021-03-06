package com.gt.service.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.dao.FintrolinfoDAO;
import com.gt.entity.Fintrolinfo;

@Service("introlinfoService")
public class IntrolinfoServiceImpl implements IntrolinfoService{
	@Autowired
	private FintrolinfoDAO introlinfoDAO;

	public Fintrolinfo findById(int id) {
		return this.introlinfoDAO.findById(id);
	}

	public void saveObj(Fintrolinfo obj) {
		this.introlinfoDAO.save(obj);
	}

	public void deleteObj(int id) {
		Fintrolinfo obj = this.introlinfoDAO.findById(id);
		this.introlinfoDAO.delete(obj);
	}

	public void updateObj(Fintrolinfo obj) {
		this.introlinfoDAO.attachDirty(obj);
	}

	public List<Fintrolinfo> findByProperty(String name, Object value) {
		return this.introlinfoDAO.findByProperty(name, value);
	}

	public List<Fintrolinfo> findAll() {
		return this.introlinfoDAO.findAll();
	}

	public List<Fintrolinfo> list(int firstResult, int maxResults,
			String filter,boolean isFY) {
		List<Fintrolinfo> list = this.introlinfoDAO.list(firstResult, maxResults, filter,isFY);
		for (Fintrolinfo fintrolinfo : list) {
			if(fintrolinfo.getFuser() != null) fintrolinfo.getFuser().getFnickName();
		}
		return list;
	}
	
	public List<Map> getAllIntrol(int firstResult, int maxResults, String filter,boolean isFY) {
		return this.introlinfoDAO.getAllIntrol(firstResult, maxResults, filter, isFY);
	}
}
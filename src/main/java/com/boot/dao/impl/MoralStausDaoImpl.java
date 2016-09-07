package com.boot.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.dao.contract.MoralStatusDao;
import com.boot.entity.MoralStatusEntity;

@Repository("MoralStatusDao")
public class MoralStausDaoImpl implements MoralStatusDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public MoralStatusEntity getMoralStatusByDate(Date date) {
		return this.sessionFactory.getCurrentSession().get(MoralStatusEntity.class,
				new SimpleDateFormat("yyyy-MM-dd").format(date));
	}

	@Override
	public void saveMoralStatus(MoralStatusEntity entityObject) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(entityObject);
	}
}

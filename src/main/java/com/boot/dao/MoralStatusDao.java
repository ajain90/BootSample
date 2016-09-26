package com.boot.dao;

import java.util.Date;

import com.boot.entity.MoralStatusEntity;

public interface MoralStatusDao {

	MoralStatusEntity getMoralStatusByDate(Date date);

	void saveMoralStatus(MoralStatusEntity entityObject);
}

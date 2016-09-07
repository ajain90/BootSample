package com.boot.dao.contract;

import java.util.Date;

import com.boot.entity.MoralStatusEntity;

public interface MoralStatusDao {

	MoralStatusEntity getMoralStatusByDate(Date date);

	void saveMoralStatus(MoralStatusEntity entityObject);
}

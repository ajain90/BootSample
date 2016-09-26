package com.boot.service;

import java.util.Date;

import com.boot.models.AggregatMoralStatusVO;

public interface MoralStatusService {

	AggregatMoralStatusVO getMoralStatusByDate(Date date);

	void populateMoralStatus(String moralType);
}

package com.boot.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.dao.MoralStatusDao;
import com.boot.entity.MoralStatusEntity;
import com.boot.models.AggregatMoralStatusVO;

@Service
@Transactional
public class MoralSatusServiceImpl implements MoralStatusService {

	@Autowired
	private MoralStatusDao moralStatusDao;

	@Override
	public AggregatMoralStatusVO getMoralStatusByDate(Date date) {
		// set default values to object
		AggregatMoralStatusVO moralAggStatus = new AggregatMoralStatusVO("0.0", "0.0", "0.0");
		MoralStatusEntity moralData = moralStatusDao.getMoralStatusByDate(date);
		if (null != moralData && moralData.getTotal() != 0) {
			int total = moralData.getTotal();
			moralAggStatus.setHigh(computePercentage(moralData.getHigh(), total));
			moralAggStatus.setLow(computePercentage(moralData.getLow(), total));
			moralAggStatus.setAverage(computePercentage(moralData.getAverage(), total));
		}
		return moralAggStatus;
	}

	@Override
	public void populateMoralStatus(String moralType) {
		MoralStatusEntity currentMoralData = moralStatusDao.getMoralStatusByDate(Calendar.getInstance().getTime());
		if (null == currentMoralData) {
			// set default values
			currentMoralData = new MoralStatusEntity(0, 0, 0, 0);
		}
		moralStatusDao.saveMoralStatus(createStatusEntity(moralType, currentMoralData));
	}

	private MoralStatusEntity createStatusEntity(String moralType, MoralStatusEntity currentMoralData) {
		currentMoralData.setDate(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
		if (moralType.equalsIgnoreCase("high")) {
			currentMoralData.setHigh(currentMoralData.getHigh() + 1);
			currentMoralData.setLow(currentMoralData.getLow());
			currentMoralData.setLow(currentMoralData.getAverage());
			currentMoralData.setTotal(currentMoralData.getTotal() + 1);
			return currentMoralData;
		} else if (moralType.equalsIgnoreCase("low")) {
			currentMoralData.setHigh(currentMoralData.getHigh());
			currentMoralData.setLow(currentMoralData.getLow() + 1);
			currentMoralData.setAverage(currentMoralData.getAverage());
			currentMoralData.setTotal(currentMoralData.getTotal() + 1);
			return currentMoralData;
		} else if (moralType.equalsIgnoreCase("avg")) {
			currentMoralData.setHigh(currentMoralData.getHigh());
			currentMoralData.setLow(currentMoralData.getLow());
			currentMoralData.setAverage(currentMoralData.getAverage() + 1);
			currentMoralData.setTotal(currentMoralData.getTotal() + 1);
			return currentMoralData;
		}
		return currentMoralData;
	}

	private String computePercentage(int num, int denom) {
		if (denom == 0) {
			return "0";
		}
		return String.valueOf((float) num / (float) denom * 100);
	}
}

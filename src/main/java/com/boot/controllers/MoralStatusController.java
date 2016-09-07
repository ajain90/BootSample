package com.boot.controllers;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.beans.MoralSatusService;
import com.boot.models.AggregatMoralStatusVO;

@RestController
public class MoralStatusController {

	@Autowired
	MoralSatusService moralAggStatusBean;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public AggregatMoralStatusVO fetchMoralStatus() {

		return moralAggStatusBean.getMoralStatusByDate(Calendar.getInstance().getTime());
	}

	@RequestMapping(path = "/captureResponse/{moralType}")
	public void execute(@PathVariable("moralType") String moralType) {
		if (isValidType(moralType)) {
			moralAggStatusBean.populateMoralStatus(moralType);
		}
	}

	private boolean isValidType(String moralType) {
		if (moralType.equalsIgnoreCase("high") || moralType.equalsIgnoreCase("low")
				|| moralType.equalsIgnoreCase("avg")) {
			return true;
		}
		return false;
	}
}

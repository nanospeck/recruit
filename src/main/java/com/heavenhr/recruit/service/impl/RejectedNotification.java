package com.heavenhr.recruit.service.impl;

import com.heavenhr.recruit.service.NotificationService;

public class RejectedNotification implements NotificationService {

	@Override
	public void printNotification() {
		System.out.println("Status Changed to Rejected");

	}

}

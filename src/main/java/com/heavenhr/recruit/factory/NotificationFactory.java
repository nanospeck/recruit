package com.heavenhr.recruit.factory;

import org.springframework.stereotype.Component;

import com.heavenhr.recruit.enumeration.ApplicationStatus;
import com.heavenhr.recruit.service.NotificationService;
import com.heavenhr.recruit.service.impl.AppliedNotification;
import com.heavenhr.recruit.service.impl.HiredNotification;
import com.heavenhr.recruit.service.impl.InvitedNotification;
import com.heavenhr.recruit.service.impl.RejectedNotification;

@Component
public class NotificationFactory {
	public NotificationService getNotificationService(String status) {
		if (status == null) {
			return null;
		} else if (status.equalsIgnoreCase(ApplicationStatus.APPLIED.toString())) {
			return new AppliedNotification();
		} else if (status.equalsIgnoreCase(ApplicationStatus.HIRED.toString())) {
			return new HiredNotification();
		} else if (status.equalsIgnoreCase(ApplicationStatus.INVITED.toString())) {
			return new InvitedNotification();
		} else if (status.equalsIgnoreCase(ApplicationStatus.REJECTED.toString())) {
			return new RejectedNotification();
		}

		return null;
	}
}

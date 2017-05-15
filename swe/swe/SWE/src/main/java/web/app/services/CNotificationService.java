package web.app.services;

import java.util.ArrayList;

import web.app.entities.CNotification;

public interface CNotificationService {

	String Save(CNotification notify);

	ArrayList<CNotification> all(String name);

}

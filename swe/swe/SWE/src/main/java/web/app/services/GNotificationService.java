package web.app.services;

import java.util.ArrayList;

import web.app.entities.GNotification;

public interface GNotificationService {

	public void save(GNotification n);
	public void delete(GNotification n);
	public ArrayList<String> findNotification(String Sname);
	public ArrayList<String> findCourse(String Sname);
}

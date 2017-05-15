package web.app.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import web.app.entities.CNotification;
import web.app.repositories.NotifyRepository;

@Service
public class CNotificationServer implements CNotificationService{
     NotifyRepository NR;
     @Autowired
 		public void SeTNotifyRepository(NotifyRepository nr)
 		{
 			NR=nr;
 			
 		}
	@Override
	public String Save(CNotification notify)
	{
		if(NR.save(notify)!=null)
		{
			return "savee is done";
		}
     return"nooo";
	}
	@Override
	 public ArrayList<CNotification> all(String name)
	  {
		ArrayList<CNotification> N = new ArrayList<CNotification>();
		ArrayList<CNotification> N1 = new ArrayList<CNotification>();

		N=(ArrayList<CNotification>) ( NR).findAll();
		for(int i=0;i<N.size();i++)
		{
			if(N.get(i).getTname().equals(name))
			{
				N1.add(N.get(i));
			}
		}
		return N1;
	  }
}

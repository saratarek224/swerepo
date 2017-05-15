package web.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.app.entities.CNotification;

@Repository
public interface NotifyRepository extends CrudRepository<CNotification,Integer> {

}


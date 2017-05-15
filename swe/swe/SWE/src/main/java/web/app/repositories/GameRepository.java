package web.app.repositories;

import org.springframework.data.repository.CrudRepository;

import web.app.entities.Game;

public interface GameRepository extends CrudRepository<Game,Integer> {

}

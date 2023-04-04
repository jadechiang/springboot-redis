package github.io.dao;

import github.io.model.People;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<People, Integer> {

    People findByName(String name);
}

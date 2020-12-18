package biz.nable.sampath.oc.db.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import biz.nable.sampath.oc.db.entity.User;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Integer>{
}

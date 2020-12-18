package biz.nable.sampath.oc.services;


import biz.nable.sampath.oc.db.entity.User;

public interface UserService {
	
    Iterable<User> listAllUsers();

    User getUserById(Integer id);

    User saveUser(User user);

    void deleteUser(Integer id);
}

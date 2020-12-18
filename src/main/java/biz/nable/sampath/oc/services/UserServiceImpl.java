package biz.nable.sampath.oc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.nable.sampath.oc.db.entity.User;
import biz.nable.sampath.oc.db.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> listAllUsers() {
        logger.debug("listAllProducts called");
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        logger.debug("getUserById called");
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        logger.debug("saveProduct called");
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        logger.debug("deleteUser called");
        userRepository.deleteById(id);
    }
}

package com.dmiit3iy.quizespringboot.service;

import com.dmiit3iy.quizespringboot.model.User;
import com.dmiit3iy.quizespringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) {
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Пользователь уже добавлен!");
        }

    }

    @Override
    public User get(long id) {

        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Такого пользователя нет!"));
    }

    @Override
    public List<User> get() {
        return userRepository.findAll();
    }

    @Override
    public User delete(long id) {
        User user = get(id);
        userRepository.deleteById(id);
        return user;
    }

    @Override
    public User update(User user) {
        User baseUser = get(user.getId());
        baseUser.setLogin(user.getLogin());
        baseUser.setSurname(user.getSurname());
        baseUser.setFirstName(user.getFirstName());
        baseUser.setPassword(user.getPassword());
        return baseUser;
    }
}

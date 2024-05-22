package com.dmiit3iy.quizespringboot.service;

import com.dmiit3iy.quizespringboot.model.Gamer;
import com.dmiit3iy.quizespringboot.repository.GamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class GamerServiceImpl implements GamerService {
    private GamerRepository gamerRepository;

    @Autowired
    public void setGamerRepository(GamerRepository gamerRepository) {
        this.gamerRepository = gamerRepository;
    }

    @Override
    public void add(Gamer gamer) {
        try {
            gamerRepository.save(gamer);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Такой игрок уже добавлен!");
        }
    }

    @Override
    public Gamer get(long id) {

        return gamerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Игрок с таким Id нет"));
    }

    @Override
    public List<Gamer> get() {
        return gamerRepository.findAll();
    }

    @Override
    public Gamer update(Gamer gamer) {
        Gamer baseGamer = get(gamer.getId());
        baseGamer.setLogin(gamer.getLogin());
        baseGamer.setSurname(gamer.getSurname());
        baseGamer.setFirstName(gamer.getFirstName());
        baseGamer.setPassword(gamer.getPassword());
        return baseGamer;
    }

    @Override
    public Gamer delete(long id) {
        Gamer gamer = get(id);
        gamerRepository.deleteById(id);
        return gamer;
    }
}

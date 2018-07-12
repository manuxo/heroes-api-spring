package com.heroes.apiheroes.services.impl;

import com.heroes.apiheroes.model.dao.IHeroDAO;
import com.heroes.apiheroes.model.entities.Hero;
import com.heroes.apiheroes.services.IHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService implements IHeroService {
    @Autowired
    private IHeroDAO repo;

    @Override
    public List<Hero> findAll() {
        return repo.findAll();
    }

    @Override
    public Hero findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Hero entity) {
        repo.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void save(Hero entity) {
        repo.save(entity);
    }

    @Override
    public void update(Hero entity) {
        repo.save(entity);
    }

    @Override
    public List<Hero> findByNameContaining(String name) {
        return repo.findByNameContaining(name);
    }
}

package com.heroes.apiheroes.services;

import com.heroes.apiheroes.model.entities.Hero;

import java.util.List;

public interface IHeroService extends IService<Hero,Long>{
    List<Hero> findByNameContaining(String name);
}

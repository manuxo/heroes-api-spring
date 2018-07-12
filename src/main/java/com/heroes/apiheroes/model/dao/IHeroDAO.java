package com.heroes.apiheroes.model.dao;

import com.heroes.apiheroes.model.entities.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IHeroDAO extends JpaRepository<Hero,Long>{
    List<Hero> findByNameContaining(String name);
}

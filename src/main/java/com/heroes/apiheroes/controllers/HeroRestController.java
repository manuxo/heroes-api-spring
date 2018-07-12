package com.heroes.apiheroes.controllers;

import com.heroes.apiheroes.model.entities.Hero;
import com.heroes.apiheroes.services.IHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(value = "/api")
@CrossOrigin
@RestController
public class HeroRestController {

    @Autowired
    private IHeroService heroService;

    //GET
    @GetMapping(value="/heroes")
    public ResponseEntity<List<Hero>> getHeroes(@RequestParam(name = "name",required = false) String term){
        if(term != null){
            List<Hero> heroes = heroService.findByNameContaining(term);
            return new ResponseEntity<>(heroes,HttpStatus.OK);
        }
        List<Hero> heroes = heroService.findAll();
        return new ResponseEntity<>(heroes,HttpStatus.OK);
    }

    @GetMapping(value = "/hero/{id}")
    public ResponseEntity<Hero> getHero(@PathVariable("id") Long id){
        Hero hero = heroService.findById(id);
        return new ResponseEntity<>(hero,HttpStatus.OK);
    }

    @PutMapping(value="/hero/{id}")
    public ResponseEntity<?> updateHero(@PathVariable("id") Long id, @RequestBody Hero hero){
        Hero currentHero = heroService.findById(id);
        currentHero.setName(hero.getName());
        heroService.update(currentHero);
        return new ResponseEntity<>(currentHero,HttpStatus.OK);
    }

    @PostMapping(value="/heroes/add")
    public ResponseEntity<?> addHero(@RequestBody Hero hero){
        heroService.save(hero);
        return new ResponseEntity<>(hero,HttpStatus.OK);
    }

    @DeleteMapping(value="/hero/{id}")
    public ResponseEntity<?> deleteHero(@PathVariable("id") Long id){
        heroService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

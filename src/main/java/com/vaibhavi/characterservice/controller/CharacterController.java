package com.vaibhavi.characterservice.controller;


import com.vaibhavi.characterservice.Entity.CharacterForBattle;
import com.vaibhavi.characterservice.Repository.CharacterRepository;
import com.vaibhavi.characterservice.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @Autowired
    CharacterRepository characterRepository;

    @PostMapping(value = "/gen/{characterName}/{characterClass}")
    public CharacterForBattle generateCharacter(@PathVariable String characterName, @PathVariable String characterClass) {
        return characterService.generateCharacter(characterName, characterClass);
        //return (List<CharacterForBattle>) characterRepository.findAll();
    }

}

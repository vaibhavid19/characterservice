package com.vaibhavi.characterservice.controller;


import com.vaibhavi.characterservice.Entity.CharacterForBattle;
import com.vaibhavi.characterservice.Repository.CharacterRepository;
import com.vaibhavi.characterservice.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @Autowired
    CharacterRepository characterRepository;

    @PostMapping(value = "/gen/{characterName}/{characterClass}")
    public CharacterForBattle generateCharacter(@PathVariable String characterName, @PathVariable String characterClass) throws Exception {
        return characterService.generateCharacter(characterName, characterClass);
    }
}

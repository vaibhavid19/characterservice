package com.vaibhavi.characterservice.service;

import com.vaibhavi.characterservice.Entity.CharacterForBattle;
import com.vaibhavi.characterservice.Repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    public CharacterForBattle generateCharacter(String characterName, String characterClass) {
        CharacterForBattle theCharacter = new CharacterForBattle();
        return characterRepository.save(new CharacterForBattle(0,characterName, characterClass,9,9,9,9,9,9,9,9));
    }

    public List<CharacterForBattle> getAll() {
        return (List<CharacterForBattle>) this.characterRepository.findAll();
    }

    public int genRandomNumBetween(int num1, int num2) {
        int range = (num2 - num1) + 1;
        return (int)(Math.random() * range) + num1;
    }
}

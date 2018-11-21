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

    public CharacterForBattle generateCharacter(String characterName, String characterClass) throws Exception {
        CharacterForBattle theCharacter = new CharacterForBattle();
        theCharacter = this.getCharacterObjectValues(characterClass);
        theCharacter.setCharacterClass(characterClass);
        theCharacter.setCharacterName(characterName);
        //return characterRepository.save(new CharacterForBattle(0,characterName, characterClass,9,9,9,9,9,9,9,9));
        return characterRepository.save(theCharacter);
    }

    public CharacterForBattle getCharacterObjectValues(String characterClass) throws Exception {
        CharacterForBattle theCharacter = new CharacterForBattle();
        theCharacter.setIntelligence(genRandomNumBetween(8,18));
        theCharacter.setWisdom(genRandomNumBetween(8,18));
        theCharacter.setCharacterPoints(genRandomNumBetween(8,18));
        theCharacter.setStrength(genRandomNumBetween(8,18));
        theCharacter.setDexterity(genRandomNumBetween(8,18));
        theCharacter.setCon(genRandomNumBetween(8,18));
        theCharacter.setLocation(genRandomNumBetween(8,18));
        if (characterClass.equals("Warrior")) {
            theCharacter.setStrength(18);
            theCharacter.setIntelligence(8);
        } else if (characterClass.equals("Archer")) {
            theCharacter.setDexterity(18);
            theCharacter.setCharacterPoints(8);
        } else if (characterClass.equals("Wizard")) {
            theCharacter.setIntelligence(18);
            theCharacter.setStrength(8);
        } else if (characterClass.equals("Rogue")) {
            theCharacter.setCharacterPoints(18);
            theCharacter.setStrength(8);
        } else {
            throw new Exception("The classname provided is not valid. Please provide from available list and try again.");
        }
        theCharacter.setHitPoints(theCharacter.getCon()*2);
        return theCharacter;
    }

    public List<CharacterForBattle> getAll() {
        return (List<CharacterForBattle>) this.characterRepository.findAll();
    }

    public int genRandomNumBetween(int num1, int num2) {
        int range = (num2 - num1) + 1;
        return (int)(Math.random() * range) + num1;
    }
}

package com.vaibhavi.characterservice.service;

import com.vaibhavi.characterservice.Entity.CharacterForBattle;
import com.vaibhavi.characterservice.Repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

        int[] numbers = genRandomNumBetween(8, 18);
        Arrays.sort(numbers);
        CharacterForBattle theCharacter = new CharacterForBattle();

        if (characterClass.equals("Warrior")) {
            theCharacter.setStrength(numbers[6]);
            theCharacter.setIntelligence(numbers[0]);
            theCharacter.setWisdom(numbers[1]);
            theCharacter.setCharacterPoints(numbers[2]);
            theCharacter.setDexterity(numbers[3]);
            theCharacter.setCon(numbers[4]);
            theCharacter.setLocation(numbers[5]);

        } else if (characterClass.equals("Archer")) {
            theCharacter.setDexterity(numbers[6]);
            theCharacter.setCharacterPoints(numbers[0]);
            theCharacter.setWisdom(numbers[1]);
            theCharacter.setStrength(numbers[2]);
            theCharacter.setIntelligence(numbers[3]);
            theCharacter.setCon(numbers[4]);
            theCharacter.setLocation(numbers[5]);

        } else if (characterClass.equals("Wizard")) {
            theCharacter.setIntelligence(numbers[6]);
            theCharacter.setStrength(numbers[0]);
            theCharacter.setWisdom(numbers[1]);
            theCharacter.setCharacterPoints(numbers[2]);
            theCharacter.setDexterity(numbers[3]);
            theCharacter.setCon(numbers[4]);
            theCharacter.setLocation(numbers[5]);

        } else if (characterClass.equals("Rogue")) {
            theCharacter.setCharacterPoints(numbers[6]);
            theCharacter.setStrength(numbers[0]);
            theCharacter.setWisdom(numbers[1]);
            theCharacter.setIntelligence(numbers[2]);
            theCharacter.setDexterity(numbers[3]);
            theCharacter.setCon(numbers[4]);
            theCharacter.setLocation(numbers[5]);
        } else {
            throw new Exception("The classname provided is not valid. Please provide from available list and try again.");
        }
        theCharacter.setHitPoints(theCharacter.getCon()*2);
        return theCharacter;
    }

    public List<CharacterForBattle> getAll() {
        return (List<CharacterForBattle>) this.characterRepository.findAll();
    }

    public int[] genRandomNumBetween(int num1, int num2) {
        int[] numbers = new int[7];
        int range = (num2 - num1) + 1;

        for(int i = 0; i < 7; i++) {
            numbers[i] = (int)(Math.random()*20 + 1);
        }  
                
        return numbers;
    }
}

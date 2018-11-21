package com.vaibhavi.characterservice.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.text.AttributeSet;
import java.util.List;

@Entity
public class CharacterForBattle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String characterName;
    private String characterClass;
    private int intelligence;
    private int wisdom;
    private int character;
    private int strength;
    private int dexterity;
    private int con;
    private int location;
    //private List<String> inventory;
    private int hitPoints;

    public CharacterForBattle(int id, String characterName, String characterClass, int intelligence, int wisdom, int character, int strength, int dexterity, int con, int location, int hitPoints) {
        this.id = id;
        this.characterName = characterName;
        this.characterClass = characterClass;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.character = character;
        this.strength = strength;
        this.dexterity = dexterity;
        this.con = con;
        this.location = location;
        this.hitPoints = hitPoints;
    }

    public CharacterForBattle() {

    }
}
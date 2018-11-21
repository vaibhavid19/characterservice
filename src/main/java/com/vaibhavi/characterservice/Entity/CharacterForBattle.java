package com.vaibhavi.characterservice.Entity;

import org.hibernate.annotations.AttributeAccessor;

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
    private int characterPoints;
    private int strength;
    private int dexterity;
    private int con;
    private int location;
    //private List<String> inventory;
    private int hitPoints;

    public CharacterForBattle(int id, String characterName, String characterClass, int intelligence, int wisdom, int characterPoints, int strength, int dexterity, int con, int location, int hitPoints) {
        this.id = id;
        this.characterName = characterName;
        this.characterClass = characterClass;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.characterPoints = characterPoints;
        this.strength = strength;
        this.dexterity = dexterity;
        this.con = con;
        this.location = location;
        this.hitPoints = hitPoints;
    }

    public CharacterForBattle() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharacterPoints() {
        return characterPoints;
    }

    public void setCharacterPoints(int characterPoints) {
        this.characterPoints = characterPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    /*public List<String> getInventory() {
        return inventory;
    }

    public void setInventory(List<String> inventory) {
        this.inventory = inventory;
    }*/
}
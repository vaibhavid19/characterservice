package com.vaibhavi.characterservice.Repository;

import com.vaibhavi.characterservice.Entity.CharacterForBattle;
import org.springframework.data.repository.CrudRepository;

public interface CharacterRepository extends CrudRepository<CharacterForBattle, Integer> {

    //@Query("from Item i where i.id=:id AND i.name=:name")
    //public Optional<Item> findByItemNameAndId(@Param("id") int id, @Param("name") String name);
}
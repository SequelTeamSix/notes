package spring2.repository;
/*
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring2.model.Digimon;

import java.util.List;

public interface DigimonRepository extends JpaRepository<Digimon, Integer> {


    @Query("from Digimon")
    List<Digimon> getAllDigimon();

    @Query("from Digimon where name = :name")
    List<Digimon> findAllDigimonByName(String name);

}*/


import org.springframework.stereotype.Component;
import spring2.model.Digimon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DigimonRepository {
    List<Digimon> digimons;
    public DigimonRepository(){
        digimons = new ArrayList<Digimon>();
        digimons.add(new Digimon(0, "abc", 10));
        digimons.add(new Digimon(1, "def", 20));
        digimons.add(new Digimon(2, "hij", 30));
    }
    public List<Digimon> getAllDigimon(){
        return digimons;
    }
    public List<Digimon> findAllDigimonByName(String name){
        return digimons.stream().filter(digimon -> digimon.getName().equals(name)).collect(Collectors.toList());

    }
}
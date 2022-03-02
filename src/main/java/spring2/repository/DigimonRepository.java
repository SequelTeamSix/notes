package spring2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring2.model.Digimon;

import java.util.List;

public interface DigimonRepository extends JpaRepository<Digimon, Integer> {
    /*
    Not HQL - this is a subset of HQL
    JPQL
    Java Persistence Query Language
    All JPQL statements are valid HQL statements,
    the inverse is not always true
     */
    @Query("from Digimon")
    List<Digimon> getAllDigimon();
}

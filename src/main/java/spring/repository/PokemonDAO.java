package spring.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import spring.model.Pokemon;

import java.util.ArrayList;
import java.util.List;
//@Component
@Repository
public class PokemonDAO {

    List<Pokemon> pokemonList;
    /*fake database: just using a list for proof of concept

     */
    public PokemonDAO() {
        pokemonList = new ArrayList<Pokemon>();
        pokemonList.add(new Pokemon("Pikachu"));
        pokemonList.add(new Pokemon("Bulbasaur"));
        pokemonList.add(new Pokemon("MewToo"));
    }
    public List<Pokemon> getAllPokemon(){
        return pokemonList;
    }

    public Pokemon getPokemon(Integer id) {
        return pokemonList.get(id);
    }

    public void addPokemon(Pokemon p){
        pokemonList.add(p);
    }
}

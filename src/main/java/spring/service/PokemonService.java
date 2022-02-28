package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring.model.Pokemon;
import spring.repository.Nonsense;
import spring.repository.PokemonDAO;

import java.util.List;
//@Component
@Service
public class PokemonService {
    /*field injection:
    (basically this is advised against, because spring
    then needs to do extra reflection in order to get this to work)
    @Autowired
     */
    PokemonDAO pokemonDAO;

    /*we could potentially have something like a PokemonDAO interface
    in the same way that we can declare a List object (which is also an interface)
    but now we never have to even define which specific implementation we use:
    this means that spring can swap out implementations for whatever impl are currently available
    for instance:
    we could be migrating from a JDBC based dao to a hibernate based dao
    and we would *never* have to modify classes other than the dao
    because spring is instantiation our objects (beans) for us
     */
    @Autowired
    public PokemonService(PokemonDAO pokemonDAO){
        System.out.println("Making a new pokeServ!");
        this.pokemonDAO = pokemonDAO;
    }
    /*
    Setter injection:
    @Autowired
    public void setPokemonDAO(PokemonDAO pokemonDAO){
        this.pokemonDAO = pokemonDAO;
    }*/
    public List<Pokemon> getAllPokemon(){
        return pokemonDAO.getAllPokemon();
    }

    public Pokemon getPokemon(Integer id) {
        return pokemonDAO.getPokemon(id);
    }

    public void addPokemon(Pokemon p){
        pokemonDAO.addPokemon(p);
    }

}

package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.model.Pokemon;
import spring.service.PokemonService;

import java.util.List;

@RestController
public class PokemonController {

    private PokemonService pokemonService;
    /*@RequestMapping
    put this on a method to specify the route as well as the http verb (meaning get, post, etc)
    @ResponseBody
    put this on a method to return a json string in the http response (uses jackson)
    @RequestBody
    get the request body and conver the json string to an object (uses jackson)
    @Restcontroller
    should be utilized if all methods use json as response body (ie this helps to conform
        to restful)
    @RequestParam
    utilized to get form and query parameters (like servlets)

    CRUD:
    @GetMapping
    @PostMapping
    @PutMapping
    @DeleteMapping
     */


    @Autowired
    public PokemonController(PokemonService pokemonService){
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> getAllPokemon(){
        return pokemonService.getAllPokemon();
    }
    @GetMapping(value = "{id}")
    public Pokemon getPokemon(@PathVariable Integer id){
        return pokemonService.getPokemon(id);
    }
    @PostMapping(value = "addPokemon")
    public void addPokemon(@RequestBody Pokemon pokemon){
        pokemonService.addPokemon(pokemon);
    }

    /*
    Spring web MVC:
    it's the first module we look at apart from Spring core
    it's the http request driven module for web services
    in particular, REST
     */



}

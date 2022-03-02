package spring2.service;

import org.springframework.beans.factory.annotation.Autowired;
import spring2.model.Digimon;
import spring2.repository.DigimonRepository;

import java.util.List;

public class DigimonService {
    DigimonRepository digimonRepository;

    @Autowired
    public DigimonService(DigimonRepository digimonRepository){
        this.digimonRepository = digimonRepository;
    }

    public List<Digimon> getAllDigimon() {
        return digimonRepository.getAllDigimon();
    }
}

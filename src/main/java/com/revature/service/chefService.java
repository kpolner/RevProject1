package com.revature.service;
import com.revature.model.chef;
import com.revature.model.recipe;
import com.revature.repository.chefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.lang.annotation.*;
import java.util.List;

@Component
public class chefService {
    chefRepository chefRepository;
    public chefService(chefRepository chefRepository) {
        this.chefRepository = chefRepository;
    }
    public List<chef> findAllChefs() {
        return chefRepository.findAll();
    }

    public chef findChefByName(String name) {
        return chefRepository.findByName(name);
    }

    public chef saveChef(chef chef) {
        return chefRepository.save(chef);
    }
    public List<chef> findAllChefsBySpecialty(String specialty){
        return chefRepository.findAllBySpecialty(specialty);
    }
    public List<chef> findAllChefsByTag(String tag){
        return chefRepository.findAllByTag(tag);
    }
    public chef findChefById(int id) { return chefRepository.findById(id); }
    public void deleteChef(int id) {
        chefRepository.deleteById(id);
    }
}

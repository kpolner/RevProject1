package com.revature.controller;

import com.revature.service.chefService;
import com.revature.model.chef;
import com.revature.service.recipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("chef")
public class chefController {
    chefService chefService;

    @Autowired
    public chefController(chefService chefService) {
        this.chefService = chefService;
    }


    @GetMapping
    public List<chef> getChefs() {
        return chefService.findAllChefs();
    }

    @GetMapping("name/{name}")
    public chef getChefByName(@PathVariable String name) {
        return chefService.findChefByName(name);
    }

    @PostMapping()
    public chef postChef(@RequestBody chef chef) {
        return chefService.saveChef(chef);
    }

    @GetMapping("specialty/{specialty}")
    public List<chef> getChefBySpecialty(@PathVariable String specialty) {
        return chefService.findAllChefsBySpecialty(specialty);
    }
    @GetMapping("tag/{tag}")
    public List<chef> getChefByTag(@PathVariable String tag) {
        return chefService.findAllChefsByTag(tag);
    }
    @DeleteMapping("chef/{chef}")
    public chef deleteChef(@PathVariable chef chef) {
        return chefService.deleteChef(chef);
    }
}
    /*you're likely to also need
    a delete mapping
    @DeleteMapping
    a patch mapping
    @PatchMapping
     */

package com.revature.controller;

import com.revature.service.chefService;
import com.revature.model.chef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PatchMapping("updateName/{id}/{chefName}")
    public void updateName(@PathVariable int id, @PathVariable String chefName) {
        chef chef = chefService.findChefById(id);
        chef.setChefName(chefName);
        chefService.saveChef(chef);
    }
    @PatchMapping("updateSpecialty/{id}/{specialty}")
    public void updateSpecialty(@PathVariable int id, @PathVariable String specialty) {
        chef chef = chefService.findChefById(id);
        chef.setSpecialty(specialty);
        chefService.saveChef(chef);
    }
    @PatchMapping("updateTag/{id}/{tag}")
    public void updateTag(@PathVariable int id, @PathVariable String tag) {
        chef chef = chefService.findChefById(id);
        chef.setTag(tag);
        chefService.saveChef(chef);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Long> deleteChef(@PathVariable int id) {
        chef chef = chefService.findChefById(id);
        if(chef == null)
        {
            System.out.println("No chef by this id");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            System.out.println(chefService.findChefById(id).getChefName() + " deleted!");
            chefService.deleteChef(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
    /*you're likely to also need
    a delete mapping
    @DeleteMapping
    a patch mapping
    @PatchMapping
     */

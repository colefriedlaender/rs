package com.application.backend.API;



import com.application.backend.model.RestaurantItems;
import com.application.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    ItemRepository restaurantItemRepo;

    @GetMapping("/api/all")
    public List<RestaurantItems> all( ) {
        return restaurantItemRepo.findAll().stream().toList();
    }

    @GetMapping("/api/")
    public RestaurantItems findName(@RequestParam(value = "name") String name ) {
        return restaurantItemRepo.findItemByName(name);
    }
}
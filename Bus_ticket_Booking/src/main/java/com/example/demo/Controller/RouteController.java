package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Route;
import com.example.demo.Repo.RouteRepo;

@RestController

public class RouteController {
	
	@Autowired
	RouteRepo routeRepo;
	
	 @PostMapping("/add")
	    public String addRoute(@RequestBody Route route) {
		    route.setVisibility(1);
		    routeRepo.save(route); 
	        return "Route added successfully!";
	    }


    @GetMapping
    public List<Route> getAllRoutes() {
    	List<Route> allRoutes = routeRepo.getAllRoutes();
        return allRoutes; 
    }
}


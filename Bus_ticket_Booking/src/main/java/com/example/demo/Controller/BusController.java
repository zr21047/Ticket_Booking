package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Bus;
import com.example.demo.Service.BusService;

@RestController
public class BusController {
	
	
	 @Autowired
	  private BusService busService;
	 
	 
	    @PostMapping
	    public ResponseEntity<Bus> addBus(@RequestBody Bus bus) {
	        Bus newBus = busService.addBus(bus);
	        return ResponseEntity.ok(newBus);
	    }

	    @GetMapping
	    public List<Bus> getAllBuses() {
	        return busService.getAllBuses();
	    }

	    
	    @GetMapping("/{id}")
	    public ResponseEntity<Bus> getBusById(@PathVariable Long id) {
	        Bus bus = busService.getBusById(id);
	        return ResponseEntity.ok(bus);
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Bus> updateBus(@PathVariable Long id, @RequestBody Bus busDetails) {
	        Bus updatedBus = busService.updateBus(id, busDetails);
	        return ResponseEntity.ok(updatedBus);
	    }

	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteBus(@PathVariable Long id) {
	        busService.deleteBus(id);
	        return ResponseEntity.noContent().build();
	    }
	}



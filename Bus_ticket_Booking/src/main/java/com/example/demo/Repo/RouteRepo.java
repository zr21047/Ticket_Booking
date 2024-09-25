package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Route;

public interface RouteRepo extends JpaRepository<Route, Long> {
	
	@Query(value = "select * from route where visibility=1",nativeQuery = true)
	public List<Route> getAllRoutes();

}

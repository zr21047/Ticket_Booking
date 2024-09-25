package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Bus;

public interface BusRepo extends JpaRepository<Bus, Long> {
	
	@Query(value = "select * from bus where visibility=1",nativeQuery = true)
	public Bus getAllBuses();

}

package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Bus;

public interface BusService {
	Bus addBus(Bus bus);
	List<Bus> getAllBuses();
    Bus getBusById(Long id);
    Bus updateBus(Long id, Bus busDetails);
    void deleteBus(Long id);

}

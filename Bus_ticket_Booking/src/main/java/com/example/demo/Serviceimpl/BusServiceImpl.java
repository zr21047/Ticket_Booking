package com.example.demo.Serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Entity.Bus;
import com.example.demo.Exception.NoRecordFoundException;
import com.example.demo.Repo.BusRepo;
import com.example.demo.Service.BusService;

public class BusServiceImpl implements BusService{
	
	@Autowired
    private BusRepo busRepository;

    @Override
    public List<Bus> getAllBuses() {
        return (List<Bus>) busRepository.getAllBuses();
    }

    @Override
    public Bus getBusById(Long id) {
        Optional<Bus> bus = busRepository.findById(id);
        if(bus.isPresent()) {
        return bus.orElseThrow(() -> new RuntimeException("Bus not found with id: " + id));
        }
        
        throw new NoRecordFoundException("No Buses found");
    }

    

	@Override
    public Bus addBus(Bus bus) {
    	bus.setVisibility(1);
        return busRepository.save(bus);
    }

    @Override
    public Bus updateBus(Long id, Bus busDetails) {
        Bus bus = getBusById(id);  

        bus.setBusName(busDetails.getBusName());
        bus.setBusNumber(busDetails.getBusNumber());
        bus.setRoute(busDetails.getRoute());
        bus.setTotalSeats(busDetails.getTotalSeats());
        bus.setAvailableSeats(busDetails.getAvailableSeats());
        bus.setDepartureTime(busDetails.getDepartureTime());
        bus.setArrivalTime(busDetails.getArrivalTime());

        return busRepository.save(bus);
    }

    @Override
    public void deleteBus(Long id) {
        Bus bus = getBusById(id);
        bus.setVisibility(0);
        busRepository.save(bus);
    }


}

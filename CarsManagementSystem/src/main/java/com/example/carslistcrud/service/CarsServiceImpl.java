package com.example.carslistcrud.service;

import com.example.carslistcrud.entity.Cars;
import com.example.carslistcrud.repository.CarsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {


    private CarsRepository carsRepository;

    public CarsServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public List<Cars> getAllCars() {
        return carsRepository.findAll();
    }

    @Override
    public Cars saveCars(Cars cars) {
        return carsRepository.save(cars);
    }

    @Override
    public Cars getCarById(Long id) {
        return carsRepository.findById(id).get();
    }

    @Override
    public Cars updateCar(Cars cars) {
        return carsRepository.save(cars);
    }


    @Override
    public void deleteCarById(Long id) {
        carsRepository.deleteById(id);
    }






}

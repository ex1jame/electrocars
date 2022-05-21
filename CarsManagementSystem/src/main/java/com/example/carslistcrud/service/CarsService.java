package com.example.carslistcrud.service;

import com.example.carslistcrud.entity.Cars;

import java.util.List;

public interface CarsService {

    List<Cars> getAllCars();

    Cars saveCars(Cars cars);

    Cars getCarById(Long id);

    Cars updateCar(Cars cars);

    void deleteCarById(Long id);




}

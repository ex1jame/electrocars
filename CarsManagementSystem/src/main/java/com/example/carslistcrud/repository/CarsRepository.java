package com.example.carslistcrud.repository;

import com.example.carslistcrud.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Cars,Long> {

}

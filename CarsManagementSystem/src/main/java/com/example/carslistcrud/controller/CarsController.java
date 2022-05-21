package com.example.carslistcrud.controller;

import com.example.carslistcrud.entity.Cars;
import com.example.carslistcrud.service.CarsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarsController {

    private CarsService carsService;

    public CarsController(CarsService carsService) {
        super();
        this.carsService = carsService;
    }
    @GetMapping("/cars")
    public String listCars(Model model) {
        model.addAttribute("cars", carsService.getAllCars());
        return "cars";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/cars/new")
    public String createCarForm(Model model) {
        Cars cars = new Cars();
        model.addAttribute("car", cars);
        return "create_car";

    }

    @PostMapping("/cars")
    public String saveCarForm(@ModelAttribute("car") Cars cars) {
        carsService.saveCars(cars);
        return "redirect:/cars";
    }

    @GetMapping("/cars/edit/{id}")
    public String editCarForm(@PathVariable Long id, Model model) {
        model.addAttribute("car", carsService.getCarById(id));
        return "edit_car";
    }

    @PostMapping("/cars/{id}")
    public String updateCar(@PathVariable Long id,
                            @ModelAttribute("car") Cars cars,
                            Model model) {

        Cars existingCars = carsService.getCarById(id);
        existingCars.setId(id);
        existingCars.setModel(cars.getModel());
        existingCars.setTransmission(cars.getTransmission());
        existingCars.setProductionYear(cars.getProductionYear());
        existingCars.setHorsepower(cars.getHorsepower());
        existingCars.setDriveUnit(cars.getDriveUnit());

        carsService.updateCar(cars);
        return "redirect:/cars";
    }


    @GetMapping("/cars/{id}")
    public String deleteCarById(@PathVariable Long id) {
        carsService.deleteCarById(id);
        return "redirect:/cars";
    }
}

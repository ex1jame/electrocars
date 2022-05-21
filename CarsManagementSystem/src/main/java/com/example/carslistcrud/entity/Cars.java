package com.example.carslistcrud.entity;

import javax.persistence.*;

@Entity
@Table(name="cars")
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;//марка

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "production_year")
    private int productionYear;

    @Column(name = "horsepower")
    private int horsepower;

    @Column(name = "drive_unit")
    private String driveUnit; //привод


    public Cars() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String getDriveUnit() {
        return driveUnit;
    }

    public void setDriveUnit(String driveUnit) {
        this.driveUnit = driveUnit;
    }

    public Cars(Long id, String model, String transmission, int productionYear, int horsepower, String driveUnit) {
        this.id = id;
        this.model = model;
        this.transmission = transmission;
        this.productionYear = productionYear;
        this.horsepower = horsepower;
        this.driveUnit = driveUnit;
    }
}

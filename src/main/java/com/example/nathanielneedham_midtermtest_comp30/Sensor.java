package com.example.nathanielneedham_midtermtest_comp30;

import jakarta.persistence.*;

@Entity
@Table(name = "Sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensorid")  // matches the database column
    private Long sensorID;

    @Column(name = "sensor_name", nullable = false)  // matches database column
    private String sensorName;

    @Column(name = "sensor_type", nullable = false)  // matches database column
    private String sensorType;

    @Column(name = "sensor_pin", nullable = false)  // matches database column
    private int sensorPin;

    @Column(name = "sensor_location")  // matches database column
    private String sensorLocation;

    @Enumerated(EnumType.STRING)
    @Column(name = "sensor_status", nullable = false)  // matches database column
    private SensorStatus sensorStatus;

    // Default constructor
    public Sensor() {}

    // Parameterized constructor
    public Sensor(String sensorName, String sensorType, int sensorPin, String sensorLocation, SensorStatus sensorStatus) {
        this.sensorName = sensorName;
        this.sensorType = sensorType;
        this.sensorPin = sensorPin;
        this.sensorLocation = sensorLocation;
        this.sensorStatus = sensorStatus;
    }

    // Getters and Setters
    public Long getSensorID() {
        return sensorID;
    }

    public void setSensorID(Long sensorID) {
        this.sensorID = sensorID;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public int getSensorPin() {
        return sensorPin;
    }

    public void setSensorPin(int sensorPin) {
        this.sensorPin = sensorPin;
    }

    public String getSensorLocation() {
        return sensorLocation;
    }

    public void setSensorLocation(String sensorLocation) {
        this.sensorLocation = sensorLocation;
    }

    public SensorStatus getSensorStatus() {
        return sensorStatus;
    }

    public void setSensorStatus(SensorStatus sensorStatus) {
        this.sensorStatus = sensorStatus;
    }

    @Override
    public String toString() {
        return "Sensor [sensorID=" + sensorID + ", sensorName=" + sensorName + ", sensorType=" + sensorType +
                ", sensorPin=" + sensorPin + ", sensorLocation=" + sensorLocation + ", sensorStatus=" + sensorStatus + "]";
    }
}

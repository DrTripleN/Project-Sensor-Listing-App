package com.example.nathanielneedham_midtermtest_comp30;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sensors")
public class SensorController {

    @Autowired
    private SensorRepository sensorRepository;

    @GetMapping
    public String listSensors(Model model) {
        List<Sensor> sensors = (List<Sensor>) sensorRepository.findAll();
        model.addAttribute("sensors", sensors);
        return "sensorList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("sensor", new Sensor());
        return "addSensor";
    }

    @PostMapping("/add")
    public String addSensor(@ModelAttribute Sensor sensor) {
        sensorRepository.save(sensor);
        return "redirect:/sensors";
    }

    // Show the edit form for a specific sensor
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid sensor Id:" + id));
        model.addAttribute("sensor", sensor);
        return "editSensor";  // Corresponding Thymeleaf template: editSensor.html
    }

    // Process the submitted edit form
    @PostMapping("/edit/{id}")
    public String updateSensor(@PathVariable Long id, @ModelAttribute Sensor sensor) {
        // Set the sensorID to ensure the sensor is updated, not created as new
        sensor.setSensorID(id);
        sensorRepository.save(sensor);
        return "redirect:/sensors";
    }

    // Delete a sensor record
    @GetMapping("/delete/{id}")
    public String deleteSensor(@PathVariable Long id) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid sensor Id:" + id));
        sensorRepository.delete(sensor);
        return "redirect:/sensors";
    }

    @GetMapping("/exists/{id}")
    @ResponseBody
    public boolean sensorExists(@PathVariable Long id) {
        return sensorRepository.existsById(id);
    }
}

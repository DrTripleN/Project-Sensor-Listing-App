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
        List<Sensor> sensors = (List<Sensor>) sensorRepository.findAll(); // Explicit cast to List
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

    @GetMapping("/exists/{id}")
    @ResponseBody
    public boolean sensorExists(@PathVariable Long id) {
        return sensorRepository.existsById(id);
    }
}

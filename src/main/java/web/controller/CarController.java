package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller

public class CarController {
    @Autowired
    private CarServiceImpl carServiceImpl;
    @GetMapping( "/cars")
    public String printWelcome(@RequestParam(defaultValue="5") Integer count, ModelMap model) {
        if (count < 0) {
            count = 0;
        }
        List<Car> cars = carServiceImpl.carList(count);
        model.addAttribute("message", cars);

        return "cars";
    }
}

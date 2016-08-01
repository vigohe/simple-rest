package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vigohe on 31-07-16.
 */
@RestController
public class SimpleController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String simpleHello(){
        return "Hello, World!";
    }

    @RequestMapping(value = "/car")
    public ResponseEntity<Car> getCar() {
        Car car = new Car();
        car.setColor("Blue");
        car.setMiles(100);
        car.setVIN("1234");

        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        if (car != null) {
            car.setMiles(car.getMiles()+100);
        }

        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }

}

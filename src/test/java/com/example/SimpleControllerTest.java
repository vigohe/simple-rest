package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by vigohe on 31-07-16.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(SimpleController.class)
public class SimpleControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void getCar() throws Exception {
        this.mvc.perform(get("/car")).andExpect(status().isOk());
    }

    @Test
    public void updateCar() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Car car = new Car();
        car.setMiles(300);
        car.setColor("Green");
        car.setVIN("11111");
        String jsonCar = mapper.writeValueAsString(car);

        this.mvc.perform(post("/car")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonCar))
                .andExpect(status().isOk());

    }

}
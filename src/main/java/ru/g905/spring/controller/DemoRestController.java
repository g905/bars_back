/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.g905.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.g905.spring.model.TestModel;
import ru.g905.spring.service.TestModelService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author g905
 */
@RestController
public class DemoRestController {
    private TestModelService tmSvc;

    @Autowired
    public void setTestModelService(TestModelService tmSvc) {
        this.tmSvc = tmSvc;
    }
    
    @GetMapping("/getAll")
    public String m() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String js = om.writeValueAsString(tmSvc.allModels());
        return js;
    }
}

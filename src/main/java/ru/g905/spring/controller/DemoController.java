/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.g905.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.g905.spring.model.TestModel;
import ru.g905.spring.service.TestModelService;

/**
 *
 * @author zharnikov
 */
@Controller
public class DemoController {

    private TestModelService tmSvc;

    @Autowired
    public void setTestModelService(TestModelService tmSvc) {
        this.tmSvc = tmSvc;
    }

    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public void db() {
        ru.g905.spring.Main.main(null);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allModels(@RequestParam(defaultValue = "1") int page) {
        List<TestModel> tms = tmSvc.allModelsByPage(page);
        int count = tmSvc.getModelsCount();
        int pagesCount = (count + 9) / 10;
        ModelAndView mav = new ModelAndView();
        mav.setViewName("models");
        mav.addObject("page", page);
        mav.addObject("modelsCount", count);
        mav.addObject("pagesCount", pagesCount);
        mav.addObject("modelsList", tms);
        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        TestModel tm = tmSvc.getById(id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("editPage");
        mav.addObject("testModel", tm);
        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editModel(@ModelAttribute("testModel") TestModel tm) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/");
        tmSvc.edit(tm);
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("editPage");
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addModel(@ModelAttribute("testModel") TestModel tm) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/");
        tmSvc.add(tm);
        return mav;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView addModel(@PathVariable("id") int id) {
        TestModel tm = tmSvc.getById(id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/");
        tmSvc.delete(tm);
        return mav;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView test() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("test");
        return mav;
    }
}

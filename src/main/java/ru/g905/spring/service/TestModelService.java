/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.g905.spring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.g905.spring.model.TestModel;

/**
 *
 * @author zharnikov
 */
@Service
public interface TestModelService {

    List<TestModel> allModelsByPage(int page);
    List<TestModel> allModels();

    public int getModelsCount();

    void add(TestModel tm);

    void delete(TestModel tm);

    void edit(TestModel tm);

    TestModel getById(int id);
}

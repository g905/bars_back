/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.g905.spring.dao;

import java.util.List;
import ru.g905.spring.model.TestModel;

/**
 *
 * @author zharnikov
 */
public interface TestModelDAO {

    List<TestModel> allModels(int page);
    List<TestModel> allModelsNoPagination();

    public int getModelsCount();

    void add(TestModel tm);

    void delete(TestModel tm);

    void edit(TestModel tm);

    TestModel getById(int id);
}

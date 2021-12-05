/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.g905.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.g905.spring.dao.TestModelDAO;
import ru.g905.spring.model.TestModel;

/**
 *
 * @author zharnikov
 */
@Service
public class TestModelServiceImpl implements TestModelService {

    private TestModelDAO mDAO;

    @Autowired
    public void setTestModelDAO(TestModelDAO mDAO) {
        this.mDAO = mDAO;
    }

    @Override
    @Transactional
    public int getModelsCount() {
        return mDAO.getModelsCount();
    }

    @Override
    @Transactional
    public List<TestModel> allModelsByPage(int page) {
        return mDAO.allModels(page);
    }
    
    @Override
    @Transactional
    public List<TestModel> allModels() {
        return mDAO.allModelsNoPagination();
    }

    @Override
    @Transactional
    public void add(TestModel tm) {
        mDAO.add(tm);
    }

    @Override
    @Transactional
    public void delete(TestModel tm) {
        mDAO.delete(tm);
    }

    @Override
    @Transactional
    public void edit(TestModel tm) {
        mDAO.edit(tm);
    }

    @Override
    @Transactional
    public TestModel getById(int id) {
        return mDAO.getById(id);
    }

}

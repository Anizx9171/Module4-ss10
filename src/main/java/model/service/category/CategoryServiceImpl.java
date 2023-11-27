package model.service.category;

import model.dao.category.CategoryDao;
import model.dao.category.CategoryDaoImpl;
import model.entity.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService{
    private final CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public boolean saveOrUpdate(Category category, Integer integer) {
        return categoryDao.saveOrUpdate(category, integer);
    }

    @Override
    public Category findById(Integer integer) {
        return categoryDao.findById(integer);
    }

    @Override
    public void delete(Integer integer) {
        categoryDao.delete(integer);
    }

    @Override
    public List<Category> findByName(String name) {
        return categoryDao.findByName(name);
    }

    @Override
    public List<Category> sortAZ() {
        return null;
    }
}

package model.dao.category;

import model.dao.IGenericDao;
import model.entity.Category;

import java.util.List;

public interface CategoryDao extends IGenericDao<Category,Integer> {
    List<Category> sortAZ();
}

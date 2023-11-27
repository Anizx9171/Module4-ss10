package model.service.category;

import model.entity.Category;
import model.service.IGenericService;

import java.util.List;

public interface CategoryService extends IGenericService<Category,Integer> {
    List<Category> sortAZ();
}

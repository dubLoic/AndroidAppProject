package fr.epsi.service;

import java.util.ArrayList;

import fr.epsi.entity.Category;

public interface CategoryService {
    Category getCategory(String path, String id);
    ArrayList<Category> getCategories(String path);
}

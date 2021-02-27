package fr.epsi.service;

import java.util.ArrayList;

import fr.epsi.entity.Product;

public interface ProductService {
    Product getProduct(String path, String name);
    ArrayList<Product> getProducts(String path);
}

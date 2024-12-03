package com.Synctric.ProductResource.service;

import com.Synctric.ProductResource.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> getAllProducts();

    Optional getProductById(Integer id);

    Product updateProduct(Integer id, Product product);

    void deleteProduct(Integer id);

    List<Product> filterByStatus(Product.Status status);

    List<Product> searchProducts(String keyword);
}

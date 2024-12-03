package com.Synctric.ProductResource.service;

import com.Synctric.ProductResource.model.Product;
import com.Synctric.ProductResource.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImp implements ProductService{
    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product)
    {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(Integer id,Product updatedProduct)
    {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(updatedProduct.getName());
                    product.setStatus(updatedProduct.getStatus());
                    product.setDescription(updatedProduct.getDescription());
                    return productRepository.save(product);
                }).orElseThrow(()-> new RuntimeException("Product not found"));
    }

    public void deleteProduct(Integer id)
    {
        productRepository.deleteById(id);
    }

    public List<Product> filterByStatus(Product.Status status)
    {
        return productRepository.findByStatus(status);
    }

    public List<Product> searchProducts(String keyword)
    {
        return productRepository.searchByKeyword(keyword);
    }
}

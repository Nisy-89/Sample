package com.Synctric.ProductResource.controller;

import com.Synctric.ProductResource.model.Product;
import com.Synctric.ProductResource.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class Cart {

    @Autowired
    private ProductService productService;


    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product)
    {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> getAllProducts()
    {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id)
    {
        return (ResponseEntity<Product>) productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id,@RequestBody Product product)
    {
        return ResponseEntity.ok(productService.updateProduct(id,product));
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id)
    {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Product>> filterByStatus(@RequestParam Product.Status status)
    {
        return ResponseEntity.ok(productService.filterByStatus(status));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword)
    {
        return ResponseEntity.ok(productService.searchProducts(keyword));
    }
}

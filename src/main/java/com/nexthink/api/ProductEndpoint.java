package com.nexthink.api;

import com.nexthink.model.Product;
import com.nexthink.model.Report;
import com.nexthink.service.ProductService;
import jakarta.inject.Singleton;

import java.util.Collections;
import java.util.List;

@Singleton
public class ProductEndpoint {

    private final ProductService productService;

    public ProductEndpoint(ProductService productService) {
        this.productService = productService;
    }

    public Product getByName(String name) {
        return productService.getByName(name);
    }

    public void addProduct(Product product) {
        productService.save(product);
    }

    public List<Product> getAll() {
        return productService.getAll();
    }

    public void removeProduct(Product product) {
        //TODO
    }

    public Integer totalPriceByType(String type) {
        //TODO
        return Integer.MAX_VALUE;
    }

    public List<Report> getReport() {
        //TODO
        return Collections.emptyList();
    }

}

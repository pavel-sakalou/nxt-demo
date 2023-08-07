package com.nexthink.repository;

import com.nexthink.model.Product;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Singleton
public class TomatoRepository {
    private final Map<String, Product> db = new HashMap<>();

    public void save(Product product) {
        db.put(product.getName(), product);
    }

    public Product get(String name) {
        return db.get(name);
    }

    public List<Product> getAll() {
        List<Product> result = new ArrayList<>();
        for (Entry<String, Product> productEntry: db.entrySet()) {
            result.add(productEntry.getValue());
        }

        return result;
    }

}

package com.nexthink.service;

import com.nexthink.model.Product;
import com.nexthink.repository.MilkRepository;
import com.nexthink.repository.PotatoRepository;
import com.nexthink.repository.TomatoRepository;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class ProductService {

    private final MilkRepository milkRepository;
    private final PotatoRepository potatoRepository;
    private final TomatoRepository tomatoRepository;

    public ProductService(MilkRepository milkRepository, PotatoRepository potatoRepository, TomatoRepository tomatoRepository) {
        this.milkRepository = milkRepository;
        this.potatoRepository = potatoRepository;
        this.tomatoRepository = tomatoRepository;
    }

    public Product getByName(String name) {
        List<Product> milk = milkRepository.getAll();
        List<Product> potato = potatoRepository.getAll();
        List<Product> tomato = tomatoRepository.getAll();

        boolean isFound = false;

        for (Product product: milk) {
            if(name.equals(product.getName())) {
                isFound = true;
            }
        }

        if (isFound) {
            return milkRepository.get(name);
        }

        for (Product product: potato) {
            if(name.equals(product.getName())) {
                isFound = true;
            }
        }

        if (isFound) {
            return potatoRepository.get(name);
        }

        for (Product product: tomato) {
            if(name.equals(product.getName())) {
                isFound = true;
            }
        }

        if (isFound) {
            return tomatoRepository.get(name);
        }

        return null;
    }

    public void save(Product product) {
        if(product.getType().equals("MILK")) {
            milkRepository.save(product);
        }

        if(product.getType().equals("POTATO")) {
            potatoRepository.save(product);
        }

        if(product.getType().equals("TOMATO")) {
            tomatoRepository.save(product);
        }
    }

    public List<Product> getAll() {
        List<Product> milk = milkRepository.getAll();
        List<Product> potato = potatoRepository.getAll();
        List<Product> tomato = tomatoRepository.getAll();
        List<Product> result = new ArrayList<>();

        result.addAll(milk);
        result.addAll(potato);
        result.addAll(tomato);
        return result;
    }

}

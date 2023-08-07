package com.nexthink;

import com.nexthink.api.ProductEndpoint;
import com.nexthink.model.Product;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import java.util.List;

@MicronautTest
class NxtDemoTest {

    @Inject
    EmbeddedApplication<?> application;
    @Inject
    ProductEndpoint productEndpoint;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testMainFlow() {
        Product milk = new Product();
        milk.setType("MILK");
        milk.setName("my milk");
        milk.setPrice(10);
        productEndpoint.addProduct(milk);

        List<Product> products = productEndpoint.getAll();
        Assertions.assertEquals(1, products.size());

        Product myMilk = productEndpoint.getByName("my milk");
        Assertions.assertEquals(milk, myMilk);
    }

    @Test
    void testFindProduct() {
        Product milk = new Product();
        milk.setType("MILK");
        milk.setName("my milk");
        milk.setPrice(10);
        productEndpoint.addProduct(milk);
        Product tomato = new Product();
        tomato.setType("Tomato");
        tomato.setName("my tomato");
        tomato.setPrice(15);
        productEndpoint.addProduct(tomato);

        List<Product> products = productEndpoint.getAll();
        Assertions.assertEquals(2, products.size());
    }

    @Test
    void testGetByName() {
        Product myMilk = new Product();
        myMilk.setType("MILK");
        myMilk.setName("my milk");
        myMilk.setPrice(10);
        Product newMilk = new Product();
        newMilk.setType("MILK");
        newMilk.setName("new milk");
        newMilk.setPrice(12);
        productEndpoint.addProduct(myMilk);
        productEndpoint.addProduct(newMilk);


        Product product = productEndpoint.getByName("my milk");
        Assertions.assertEquals(myMilk, product);
        product = productEndpoint.getByName("new milk ");
        Assertions.assertEquals(newMilk, product);
    }

}

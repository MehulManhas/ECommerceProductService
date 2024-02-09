package com.ecommerceproject.ECommProject.Service;

import com.ecommerceproject.ECommProject.Model.Category;
import com.ecommerceproject.ECommProject.Model.Price;
import com.ecommerceproject.ECommProject.Model.Product;
import com.ecommerceproject.ECommProject.Model.ProductOrder;
import com.ecommerceproject.ECommProject.Repository.CategoryRepository;
import com.ecommerceproject.ECommProject.Repository.OrderRepository;
import com.ecommerceproject.ECommProject.Repository.PriceRepository;
import com.ecommerceproject.ECommProject.Repository.ProductRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InitServiceImpl implements InitService{
    private ProductRepository productRepository;
    private PriceRepository priceRepository;
    private OrderRepository orderRepository;
    private CategoryRepository categoryRepository;


    public InitServiceImpl(ProductRepository productRepository, PriceRepository priceRepository, OrderRepository orderRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;

    }

    @Override
    public void initialise() {
        Category electronics = new Category();
        electronics.setCategoryName("Electronics");

        electronics = categoryRepository.save(electronics); // insert and update -> upsert

        Price priceIphone = new Price();
        priceIphone.setCurrency("INR");
        priceIphone.setAmount(100000);
        priceIphone.setDiscount(0);

        Price priceMacbook = new Price();
        priceMacbook.setCurrency("INR");
        priceMacbook.setAmount(200000);
        priceMacbook.setDiscount(0);

        Price priceWatch = new Price();
        priceWatch.setCurrency("INR");
        priceWatch.setAmount(40000);
        priceWatch.setDiscount(0);


        Price pricePS5 = new Price();
        priceWatch.setCurrency("INR");
        priceWatch.setAmount(50000);
        priceWatch.setDiscount(0);

        priceIphone = priceRepository.save(priceIphone);
        priceMacbook = priceRepository.save(priceMacbook);
        priceWatch = priceRepository.save(priceWatch);
        pricePS5 = priceRepository.save(pricePS5);

        Product iphone = new Product();
        iphone.setTitle("IPhone 15 Pro");
        iphone.setDescription("Best Iphone ever");
        iphone.setImage("http://someImageURl");
        iphone.setPrice(priceIphone);
        iphone.setCategory(electronics);
        iphone = productRepository.save(iphone);

        Product macbook = new Product();
        macbook.setTitle("Macbook Pro 16");
        macbook.setDescription("Best macbook ever");
        macbook.setImage("http://someImageURl");
        macbook.setPrice(priceMacbook);
        macbook.setCategory(electronics);
        macbook = productRepository.save(macbook);

        Product watch = new Product();
        watch.setTitle("Watch Series 10");
        watch.setDescription("Best watch ever");
        watch.setImage("http://someImageURl");
        watch.setPrice(priceWatch);
        watch.setCategory(electronics);
        watch = productRepository.save(watch);

        Product ps5 = new Product();
        ps5.setTitle("PlayStation5");
        ps5.setDescription("Best playstation ever");
        ps5.setImage("http://someImageURl");
        ps5.setPrice(pricePS5);
        ps5.setCategory(electronics);
        ps5 = productRepository.save(ps5);

        ProductOrder order = new ProductOrder();
        order.setProduct(List.of(iphone, macbook, watch));
        order = orderRepository.save(order);

    }
}

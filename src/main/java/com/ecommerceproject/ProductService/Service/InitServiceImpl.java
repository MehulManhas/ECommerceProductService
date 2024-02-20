package com.ecommerceproject.ProductService.Service;

import com.ecommerceproject.ProductService.Model.*;
import com.ecommerceproject.ProductService.Repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InitServiceImpl implements InitService{
    private ProductRepository productRepository;
    private PriceRepository priceRepository;
    private OrderRepository orderRepository;
    private CategoryRepository categoryRepository;
    private AuthorRepository authorRepository;


    public InitServiceImpl(ProductRepository productRepository, PriceRepository priceRepository, OrderRepository orderRepository, CategoryRepository categoryRepository,
                           AuthorRepository authorRepository) {
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;

        this.authorRepository = authorRepository;
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

        Author author = new Author("Ashok Kumar", null);

        Book book1 = new Book("Book1", author);
        Book book2 = new Book("Book2", author);
        Book book3 = new Book("Book3", author);
        author.setBooks(List.of(book1, book2, book3));

        authorRepository.save(author);

        Author savedAuthor = authorRepository.findById(1).get();
        List<Book> books = savedAuthor.getBooks();
        System.out.println(books);

    }
}

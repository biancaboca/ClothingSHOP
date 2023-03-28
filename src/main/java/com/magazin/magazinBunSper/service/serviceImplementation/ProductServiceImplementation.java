package com.magazin.magazinBunSper.service.serviceImplementation;

import com.magazin.magazinBunSper.model.Product;
import com.magazin.magazinBunSper.repository.ProductRepository;
import com.magazin.magazinBunSper.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @Override
//    public Product updateProduct(Product product,String ) {
//        Product updateProduct = productRepository.findById(product.getId()).get();
//        updateProduct.setUser(product.getUser());
//        productRepository.save(updateProduct);
//
//        return updateProduct;
//    }

}

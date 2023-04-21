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

    //metode pentru Product
    @Override
    public List<Product> findAllProducts()
    {
        return (List<Product>) productRepository.findAll();
    }
    @Override
    public Optional<Product> findProductById(Integer id)
    {
        return productRepository.findById(id);
    }
    @Override
    public Product addProduct(Product Product1)
    {
        return productRepository.save(Product1);
    }
    @Override
    public void deleteProduct(Product Product1)
    {
        productRepository.delete(Product1);
    }
    @Override
    public void deleteProductById(Integer id)
    {
        productRepository.deleteById(id);
    }
    @Override
    public Product updateProduct(Product product) {
        Product updateProduct = productRepository.findById(product.getId()).get();
        updateProduct.setUser(product.getUser());
        productRepository.save(updateProduct);

        return updateProduct;
    }

    @Override
    public Product updateProduct(Product product, String marca) {
        Product updateProduct = productRepository.findById(product.getId()).get();
        updateProduct.setMarca(marca);
        productRepository.save(updateProduct);

        return updateProduct;
    }
    @Override
    public Product updateProductByName(Product product, String numeProdus) {
        Product updateProduct = productRepository.findById(product.getId()).get();
        updateProduct.setMarca(numeProdus);
        productRepository.save(updateProduct);

        return updateProduct;
    }

    @Override
    public Product updateProduct(Product product, int cantitate) {
        Product updateProduct = productRepository.findById(product.getId()).get();
        updateProduct.setCantitateProdus(cantitate);
        productRepository.save(updateProduct);

        return updateProduct;
    }

    @Override
    public Product updateProductPret(Product product,int pret) {
        Product updateProduct = productRepository.findById(product.getId()).get();
        updateProduct.setCantitateProdus(pret);
        productRepository.save(updateProduct);

        return updateProduct;
    }



}

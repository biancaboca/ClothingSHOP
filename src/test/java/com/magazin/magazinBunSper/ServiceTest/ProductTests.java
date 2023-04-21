package com.magazin.magazinBunSper.ServiceTest;

import com.magazin.magazinBunSper.model.Admin;
import com.magazin.magazinBunSper.model.Orderer;
import com.magazin.magazinBunSper.model.Product;
import com.magazin.magazinBunSper.model.User;
import com.magazin.magazinBunSper.repository.ProductRepository;
import com.magazin.magazinBunSper.repository.UserRepository;
import com.magazin.magazinBunSper.service.ProductService;
import com.magazin.magazinBunSper.service.UserService;
import com.magazin.magazinBunSper.service.serviceImplementation.AdminServiceImplementation;
import com.magazin.magazinBunSper.service.serviceImplementation.ProductServiceImplementation;
import com.magazin.magazinBunSper.service.serviceImplementation.UserServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ProductTests {
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;


    private boolean verificaDelete=false;
    private User user;
    private String NameUser = "Boca";
    private int idToFind=2;
    private int idToFindNot=1;
    private String NameUser_NOT="Doesn't exist";
    private Product product;
    private int cantitate=20;
    private int pret=20;
    private String marca="Nikii";
    private int cod=444555;
    private String parola="alina0102030405";
    private String numeProdus="Cocotiera";



    @BeforeEach
    void init() {
        initMocks(this);
        user = new User();
        user.setId(idToFind);
        product= new Product();
        assertNotNull(product);
        product.setUser(user);
        product.setCantitateProdus(cantitate);
        product.setMarca(marca);
        product.setPretProdus(pret);
        product.setNumeProdus(numeProdus);
        assertNotNull(product);
    }

    @Test
    void whenUpdatingProductPret_thenProductIsUpdated() {
        productService=new ProductServiceImplementation(productRepository);
        Product originalProduct = new Product();
        originalProduct.setId(1);
        originalProduct.setPretProdus(20);
        when(productRepository.findById(originalProduct.getId())).thenReturn(Optional.of(originalProduct));
        Product updatedProduct = productService.updateProductPret(originalProduct, pret);
        assertEquals(pret, updatedProduct.getPretProdus());

    }

    @Test
    void whenUpdatingProductCantitate_thenProductIsUpdated() {
        productService=new ProductServiceImplementation(productRepository);
        Product originalProduct = new Product();
        originalProduct.setId(1);
        originalProduct.setCantitateProdus(30);
        when(productRepository.findById(originalProduct.getId())).thenReturn(Optional.of(originalProduct));
        Product updatedProduct = productService.updateProduct(originalProduct, cantitate);
        assertEquals(cantitate, updatedProduct.getCantitateProdus());

    }

    @Test
    void whenUpdatingProductMarca_thenProductIsUpdated() {
        productService=new ProductServiceImplementation(productRepository);
        Product originalProduct = new Product();
        originalProduct.setId(1);
        originalProduct.setMarca("Nikii");
        when(productRepository.findById(originalProduct.getId())).thenReturn(Optional.of(originalProduct));
        Product updatedProduct = productService.updateProduct(originalProduct, marca);
        assertEquals(marca, updatedProduct.getMarca());

    }

    @Test
    void whenUpdatingProductNume_thenProductIsUpdated() {
        productService=new ProductServiceImplementation(productRepository);
        Product originalProduct = new Product();
        originalProduct.setId(1);
        originalProduct.setNumeProdus("Cocotiera");
        when(productRepository.findById(originalProduct.getId())).thenReturn(Optional.of(originalProduct));
        Product updatedProduct = productService.updateProduct(originalProduct, numeProdus);
        assertEquals(numeProdus, updatedProduct.getNumeProdus());

    }



}

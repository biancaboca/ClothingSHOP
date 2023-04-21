package com.magazin.magazinBunSper.controller;

import com.magazin.magazinBunSper.model.Product;
import com.magazin.magazinBunSper.model.User;
import com.magazin.magazinBunSper.service.ProductService;
import jakarta.persistence.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService)
    {
        this.productService=productService;
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Optional<Product>> getProdId(@PathVariable Integer id)  {
        return new ResponseEntity<>(productService.findProductById(id), HttpStatus.OK);}

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts () {
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Product>> getProductById (@PathVariable("id") Integer id) {
        Optional<Product> product =productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct (@RequestBody Product product) {
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/update/name")
    public ResponseEntity<Product> updateProductName(@RequestBody Product product, @RequestParam String nume) {
        Product product1 = productService.updateProductByName(product,nume);
        return new ResponseEntity<>(product1, HttpStatus.OK);
    }
    @PutMapping("/update/marca")
    public ResponseEntity<Product> updateProductMarca(@RequestBody Product product, @RequestParam String marca) {
        Product product1 = productService.updateProduct(product,marca);
        return new ResponseEntity<>(product1, HttpStatus.OK);
    }

    @PutMapping("/update/cantitate")
    public ResponseEntity<Product> updateProductCantitate(@RequestBody Product product, @RequestParam int cantitate) {
        Product product1 = productService.updateProduct(product,cantitate);
        return new ResponseEntity<>(product1, HttpStatus.OK);
    }
    @PutMapping("/update/pret")
    public ResponseEntity<Product> updateProductPret(@RequestBody Product product, @RequestParam int pret) {
        Product product1 = productService.updateProductPret(product,pret);
        return new ResponseEntity<>(product1, HttpStatus.OK);
    }
    @PutMapping("/update/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product product1 = productService.updateProduct(product);
        return new ResponseEntity<>(product1, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") Integer id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/product")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

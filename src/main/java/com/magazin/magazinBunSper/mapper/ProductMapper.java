package com.magazin.magazinBunSper.mapper;

import com.magazin.magazinBunSper.DAO.ProductDTO;
import com.magazin.magazinBunSper.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public static ProductDTO mapProductToDTO(Product product)
    {
        ProductDTO productDTO=new ProductDTO();
        productDTO.setId((long) product.getId());
        productDTO.setMarca(product.getMarca());
        productDTO.setCantitateProdus(product.getCantitateProdus());
        productDTO.setPretProdus(product.getPretProdus());
        productDTO.setNumeProdus(product.getNumeProdus());
        return productDTO;
    }


    public static Product mapDTOToProduct(ProductDTO productDTO)
    {
        Product product=new Product();
        product.setId(Math.toIntExact(productDTO.getId()));
        product.setMarca(productDTO.getMarca());
        product.setCantitateProdus(productDTO.getCantitateProdus());
        product.setPretProdus(productDTO.getPretProdus());
        product.setNumeProdus(productDTO.getNumeProdus());
        return product;
    }

}

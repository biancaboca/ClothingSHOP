package com.magazin.magazinBunSper.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {


    private Long id;
    private String numeProdus;
    private int cantitateProdus;
    private int pretProdus;
    private String marca;


}

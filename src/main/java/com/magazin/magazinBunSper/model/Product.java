package com.magazin.magazinBunSper.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String numeProdus;
    private int cantitateProdus;
    private int pretProdus;
    private String marca;




    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Orderer ordering;



    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", numeProdus='" + numeProdus + '\'' +
                ", cantitateProdus='" + cantitateProdus + '\'' +
                ", pretProdus='" + pretProdus + '\'' +
                ", marca='" + marca + '\'' +
                '}'+"\n";
    }
}

package com.magazin.magazinBunSper.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String numeClient;
    private String adresaEmail;
    private String prenumeClient;
    private int varsta;
    private String dataLogare;
    private String parola;



    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "id")
    private List<Product> listaProduse;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "id")
    private List<Orderer> listaOrders;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + numeClient + '\'' +
                ", prenume='" + prenumeClient + '\'' +
                ", email='" + adresaEmail + '\'' +
                ", varsta='" + varsta + '\'' +
                ", datalogare='" + dataLogare + '\'' +
                '}'+"\n";
    }
}

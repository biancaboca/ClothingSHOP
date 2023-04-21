package com.magazin.magazinBunSper.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class AdminDTO {
    private int id;
    private String name;
    private String prenume;
    private String functie;
    private Integer codAdmin;
    private String parola;
}

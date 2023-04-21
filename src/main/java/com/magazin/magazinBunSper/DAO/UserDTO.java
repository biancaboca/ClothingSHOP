package com.magazin.magazinBunSper.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String numeClient;
    private String adresaEmail;
    private String prenumeClient;
    private int varsta;
    private String dataLogare;
    private String parola;
}

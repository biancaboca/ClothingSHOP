package com.magazin.magazinBunSper.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.net.PasswordAuthentication;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Admin {
    @Id
    private int id;
    private String name;
    private String prenume;
    private String functie;
    private Integer codAdmin;
    private String parola;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prenume='" + prenume + '\'' +
                ", functie='" + functie + '\'' +
                ", codAdmin='" + codAdmin + '\'' +
                ", parola='" + parola + '\'' +
                '}'+"\n";
    }






}

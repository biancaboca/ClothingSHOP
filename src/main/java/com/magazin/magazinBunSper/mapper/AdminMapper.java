package com.magazin.magazinBunSper.mapper;

import com.magazin.magazinBunSper.DAO.AdminDTO;
import com.magazin.magazinBunSper.controller.AdminController;
import com.magazin.magazinBunSper.model.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {

    public AdminDTO mapModelToDto(Admin user) {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(user.getId());
        adminDTO.setName(user.getName());
        adminDTO.setCodAdmin(user.getCodAdmin());
        adminDTO.setParola(user.getParola());
        adminDTO.setFunctie(user.getFunctie());
        adminDTO.setPrenume(user.getPrenume());
        return adminDTO;
    }

    public Admin mapModelToDto(AdminDTO user) {
        Admin adminDTO = new Admin();
        adminDTO.setId(user.getId());
        adminDTO.setName(user.getName());
        adminDTO.setCodAdmin(user.getCodAdmin());
        adminDTO.setParola(user.getParola());
        adminDTO.setFunctie(user.getFunctie());
        adminDTO.setPrenume(user.getPrenume());
        return adminDTO;
    }


}

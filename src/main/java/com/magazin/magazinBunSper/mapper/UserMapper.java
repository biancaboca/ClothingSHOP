package com.magazin.magazinBunSper.mapper;

import com.magazin.magazinBunSper.DAO.UserDTO;
import com.magazin.magazinBunSper.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDTO mapUserToDTO(User user)
    {
        UserDTO userDTO=new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setParola(user.getParola());
        userDTO.setVarsta(user.getVarsta());
        userDTO.setAdresaEmail(user.getAdresaEmail());
        userDTO.setPrenumeClient(user.getPrenumeClient());
        userDTO.setDataLogare(user.getDataLogare());
        userDTO.setNumeClient(user.getNumeClient());

        return userDTO;
    }


    public static User mapUserDTOToUser(UserDTO userDTO)
    {
        User user=new User();
        user.setNumeClient(userDTO.getNumeClient());

        user.setId(userDTO.getId());
        user.setVarsta(userDTO.getVarsta());
        user.setParola(userDTO.getParola());
        user.setAdresaEmail(userDTO.getAdresaEmail());
        user.setPrenumeClient(userDTO.getPrenumeClient());
        user.setDataLogare(userDTO.getDataLogare());
        user.setPrenumeClient(user.getPrenumeClient());
        return user;

    }

}

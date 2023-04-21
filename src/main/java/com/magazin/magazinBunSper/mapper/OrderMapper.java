package com.magazin.magazinBunSper.mapper;

import com.magazin.magazinBunSper.DAO.OrdererDTO;
import com.magazin.magazinBunSper.model.Orderer;
import jakarta.persistence.criteria.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public static OrdererDTO mapOrderToDto(Order order)
    {
        OrdererDTO ordererDTO=new OrdererDTO();
        ordererDTO.setId(ordererDTO.getId());
        return ordererDTO;
    }

    public static Orderer mapOrderDTOtoORDER(OrdererDTO ordererDTO)
    {
        Orderer order = new Orderer();
        order.setId(ordererDTO.getId());
        return order;
    }
}

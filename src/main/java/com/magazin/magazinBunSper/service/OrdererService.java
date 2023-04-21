package com.magazin.magazinBunSper.service;

import com.magazin.magazinBunSper.model.Orderer;
import com.magazin.magazinBunSper.model.User;
import com.magazin.magazinBunSper.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public interface OrdererService {

    List<Orderer> findAllOrders();
    Orderer addOrder(Orderer order1);
    void deleteOrder(Orderer order1);
    void deleteOrderById(Integer id);
    Optional<Orderer> findOrderById(Long id);
}

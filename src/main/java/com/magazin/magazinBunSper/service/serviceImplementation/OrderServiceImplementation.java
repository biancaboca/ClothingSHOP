package com.magazin.magazinBunSper.service.serviceImplementation;

import com.magazin.magazinBunSper.model.Orderer;
import com.magazin.magazinBunSper.repository.OrderRepository;
import com.magazin.magazinBunSper.service.OrdererService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImplementation implements OrdererService {
    @Autowired
    private  OrderRepository orderRepository;

    public OrderServiceImplementation(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Orderer> findAllOrders()
    {
        return (List<Orderer>) orderRepository.findAll();
    }
    @Override
    public Orderer addOrder(Orderer order1)
    {
        return orderRepository.save(order1);
    }
    @Override
    public void deleteOrder(Orderer order1)
    {
        orderRepository.delete(order1);
    }
    @Override
    public void deleteOrderById(Integer id)
    {
        orderRepository.deleteById(Long.valueOf(id));
    }
    @Override
    public Optional<Orderer> findOrderById(Long id)
    {
        return orderRepository.findById(id);
    }





}

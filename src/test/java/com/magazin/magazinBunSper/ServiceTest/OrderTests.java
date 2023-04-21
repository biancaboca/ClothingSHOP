package com.magazin.magazinBunSper.ServiceTest;

import com.magazin.magazinBunSper.model.Admin;
import com.magazin.magazinBunSper.model.Orderer;
import com.magazin.magazinBunSper.model.Product;
import com.magazin.magazinBunSper.model.User;
import com.magazin.magazinBunSper.repository.AdminRepository;
import com.magazin.magazinBunSper.repository.OrderRepository;
import com.magazin.magazinBunSper.service.AdminService;
import com.magazin.magazinBunSper.service.OrdererService;
import com.magazin.magazinBunSper.service.serviceImplementation.AdminServiceImplementation;
import com.magazin.magazinBunSper.service.serviceImplementation.OrderServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class OrderTests {

    private OrdererService ordererService;
    @Mock
    private OrderRepository orderRepository;
    private Orderer order;

    private String Nameadmin = "Pojar";


    private int idToFindNot=999;
    private int idToFind=1;
    private String Nameadmin_NOT="Doesn't exist";

    private List<Orderer> listaOrders;


    @BeforeEach
    void init() {
        initMocks(this);
        ordererService = new OrderServiceImplementation(orderRepository);
        // admin= adminService.findAdminById(idToFind);
        listaOrders=new ArrayList<Orderer>();
        order=new Orderer();
        order.setId((long) idToFind);


    }

    @Test
    void whenGivenAnOrder_whenTryingToDelete_thenReturnNull(){
        ordererService = new OrderServiceImplementation(orderRepository);
        ordererService.deleteOrder(order);
        assertNotNull(order);

    }
    @Test
    void whenGivenAnOrder_whenTryingToAdd_thenReturnOrder(){
        ordererService = new OrderServiceImplementation(orderRepository);
        ordererService.addOrder(order);
        assertNotNull(order);

    }

    @Test
    void whenGivenAnOrder_whenTryingToDelete_thenReturnNothing() {
        ordererService = new OrderServiceImplementation(orderRepository);
        ordererService.deleteOrderById(idToFind);
        assertNotNull(order);
        assertEquals(order.getId(), idToFind);
    }

    @Test
    void whenFindingOrders_thenReturnListOfOrders()
    {
        ordererService = new OrderServiceImplementation(orderRepository);
        when(ordererService.findAllOrders()).thenReturn(listaOrders);
        assertNotNull(listaOrders);
    }

}

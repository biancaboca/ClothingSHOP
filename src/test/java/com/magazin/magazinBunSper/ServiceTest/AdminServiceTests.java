package com.magazin.magazinBunSper.ServiceTest;

import com.magazin.magazinBunSper.model.Admin;
import com.magazin.magazinBunSper.model.Orderer;
import com.magazin.magazinBunSper.model.Product;
import com.magazin.magazinBunSper.model.User;
import com.magazin.magazinBunSper.repository.AdminRepository;
import com.magazin.magazinBunSper.repository.OrderRepository;
import com.magazin.magazinBunSper.repository.ProductRepository;
import com.magazin.magazinBunSper.repository.UserRepository;
import com.magazin.magazinBunSper.service.AdminService;
import com.magazin.magazinBunSper.service.serviceImplementation.AdminServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class AdminServiceTests {

    private AdminService adminService;
    @Mock
    private AdminRepository adminRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private OrderRepository orderRepository;


    private Admin admin;
    private String Nameadmin = "Pojar";
    private int idToFind=1;
    private int cod=444555;
    private String parola="alina0102030405";
    private List<Admin> listaAdmini;


    @BeforeEach
    void init() {
        initMocks(this);
        adminService = new AdminServiceImplementation(adminRepository, productRepository, userRepository,orderRepository);
       // admin= adminService.findAdminById(idToFind);
        admin=new Admin();
        listaAdmini=new ArrayList<Admin>();
        admin.setId(idToFind);
        admin.setName(Nameadmin);
        admin.setCodAdmin(cod);
        admin.setParola(parola);
        assertNotNull(admin);

    }

    @Test
    void givenFunction_whenFindingAll_thenListAdmins() {
        adminService = new AdminServiceImplementation(adminRepository, productRepository, userRepository,orderRepository);
        when(adminService.findAllAdmins()).thenReturn(listaAdmini);
        listaAdmini = adminService.findAllAdmins();
        assertNotNull(listaAdmini);

    }

    @Test
    void givenId_whenFindingAnAdmin_thenAdmin() {
        adminService = new AdminServiceImplementation(adminRepository, productRepository, userRepository,orderRepository);
        when(adminService.findAdminById(idToFind)).thenReturn(Optional.ofNullable(admin));
        Optional<Admin> admin=adminService.findAdminById(idToFind);
        assertNotNull(admin);
        assertEquals(idToFind, admin.get().getId());
    }

    @Test
    void givenAnAdmin_whenTryingToAdd_thenReturnAdmin()
    {
        adminService = new AdminServiceImplementation(adminRepository, productRepository, userRepository,orderRepository);
        when(adminService.addAdmin(admin)).thenReturn(admin);
        admin=adminService.addAdmin(admin);
        assertNotNull(admin);

    }






}

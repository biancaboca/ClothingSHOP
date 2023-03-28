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


    private Optional<Admin> adminOptional;
    private Admin admin;
    private Product product;
    private User user;
    private Orderer order;

    private String Nameadmin = "Pojar";
    private int cantitate=20;
    private int pret=20;
    private String marca="Nikii";
    private int idToFind=1;
    private int cod=444555;
    private String parola="alina0102030405";
    private String numeProdus="Cocotiera";

    private int idToFindNot=999;
    private String Nameadmin_NOT="Doesn't exist";

    private List<Admin> listaAdmini;
    private List<Orderer> listaOrders;
    private List<User> userList;


    @BeforeEach
    void init() {
        initMocks(this);
        adminService = new AdminServiceImplementation(adminRepository, productRepository, userRepository,orderRepository);
       // admin= adminService.findAdminById(idToFind);
        admin=new Admin();
        user=new User();
        product=new Product();
        adminOptional= Optional.of(new Admin());
        listaAdmini=new ArrayList<Admin>();
        listaOrders=new ArrayList<Orderer>();
        userList=new ArrayList<User>();
        order=new Orderer();

        order.setId((long) idToFind);
        user.setId(idToFind);
        admin.setId(idToFind);
        admin.setName(Nameadmin);
        admin.setCodAdmin(cod);
        admin.setParola(parola);
        assertNotNull(admin);
        product.setUser(user);
        product.setCantitateProdus(cantitate);
        product.setMarca(marca);
        product.setPretProdus(pret);
        product.setNumeProdus(numeProdus);


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

    @Test
    void whenGivenAnOrder_whenTryingToDelete_thenReturnNull(){
        adminService = new AdminServiceImplementation(adminRepository, productRepository, userRepository,orderRepository);
        adminService.deleteOrder(order);
        assertNotNull(order);

    }
    @Test
    void whenGivenAnOrder_whenTryingToAdd_thenReturnOrder(){
        adminService = new AdminServiceImplementation(adminRepository, productRepository, userRepository,orderRepository);
        adminService.addOrder(order);
        assertNotNull(order);

    }

    @Test
    void whenGivenAnOrder_whenTryingToDelete_thenReturnNothing() {
        adminService = new AdminServiceImplementation(adminRepository, productRepository, userRepository, orderRepository);
        adminService.deleteOrderById(idToFind);
        assertNotNull(order);
        assertEquals(order.getId(), idToFind);
    }

    @Test
    void whenFindingOrders_thenReturnListOfOrders()
    {
        adminService=new AdminServiceImplementation(adminRepository,productRepository,userRepository,orderRepository);
        when(adminService.findAllOrders()).thenReturn(listaOrders);
        assertNotNull(listaOrders);
    }


    @Test
    void whenGivenAnUser_whenTryingToDelete_thenReturnNull(){
        adminService = new AdminServiceImplementation(adminRepository, productRepository, userRepository,orderRepository);
        adminService.deleteUser(user);

    }

    @Test
    void whenGivenAnUser_whenTryingToAdd_thenReturnOrder(){
        adminService = new AdminServiceImplementation(adminRepository, productRepository, userRepository,orderRepository);
        adminService.addUser(user);

    }

    @Test
    void whenGivenAnUser_whenTryingToDelete_thenReturnNothing() {
        adminService = new AdminServiceImplementation(adminRepository, productRepository, userRepository, orderRepository);
        adminService.deleteUserById(idToFind);
        assertEquals(user.getId(), idToFind);
        assertNotNull(user);
    }
    @Test
    void whenFindingUser_thenReturnListOfUsers()
    {
        adminService=new AdminServiceImplementation(adminRepository,productRepository,userRepository,orderRepository);
        when(adminService.findAllUsers()).thenReturn(userList);
    //    assertNotNull(userList);
    }
//    @Test
//    void whenFindingProductAndName_thenReturnNewProduct(){
//        adminService = new AdminServiceImplementation(adminRepository, productRepository, userRepository, orderRepository);
//        Product updatedProduct = new Product(); // create an updated product object to use in the test
//        updatedProduct.setId(product.getId());
//        updatedProduct.setCantitateProdus(cantitate); // set the updated quantity value
//        when(adminService.updateProduct(updatedProduct, cantitate)).thenReturn(product);
//
//        Optional<Product> optionalProduct = Optional.of(adminService.updateProduct(product, cantitate));
//        assertNotNull(optionalProduct);
//
//        assertNotNull(product);
//        assertEquals(cantitate, optionalProduct.get().getCantitateProdus());
//    }

    @Test
    void whenUpdatingProductPret_thenProductIsUpdated() {
        adminService=new AdminServiceImplementation(adminRepository,productRepository,userRepository,orderRepository);
        Product originalProduct = new Product();
        originalProduct.setId(1);
        originalProduct.setPretProdus(20);
        when(productRepository.findById(originalProduct.getId())).thenReturn(Optional.of(originalProduct));
        Product updatedProduct = adminService.updateProductPret(originalProduct, pret);
        assertEquals(pret, updatedProduct.getPretProdus());

    }

    @Test
    void whenUpdatingProductCantitate_thenProductIsUpdated() {
        adminService=new AdminServiceImplementation(adminRepository,productRepository,userRepository,orderRepository);
        Product originalProduct = new Product();
        originalProduct.setId(1);
        originalProduct.setCantitateProdus(30);
        when(productRepository.findById(originalProduct.getId())).thenReturn(Optional.of(originalProduct));
        Product updatedProduct = adminService.updateProduct(originalProduct, cantitate);
        assertEquals(cantitate, updatedProduct.getCantitateProdus());

    }

    @Test
    void whenUpdatingProductMarca_thenProductIsUpdated() {
        adminService=new AdminServiceImplementation(adminRepository,productRepository,userRepository,orderRepository);
        Product originalProduct = new Product();
        originalProduct.setId(1);
        originalProduct.setMarca("Nikii");
        when(productRepository.findById(originalProduct.getId())).thenReturn(Optional.of(originalProduct));
        Product updatedProduct = adminService.updateProduct(originalProduct, marca);
        assertEquals(marca, updatedProduct.getMarca());

    }

    @Test
    void whenUpdatingProductNume_thenProductIsUpdated() {
        adminService=new AdminServiceImplementation(adminRepository,productRepository,userRepository,orderRepository);
        Product originalProduct = new Product();
        originalProduct.setId(1);
        originalProduct.setNumeProdus("Cocotiera");
        when(productRepository.findById(originalProduct.getId())).thenReturn(Optional.of(originalProduct));
        Product updatedProduct = adminService.updateProduct(originalProduct, numeProdus);
        assertEquals(numeProdus, updatedProduct.getNumeProdus());

    }





}

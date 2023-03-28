package com.magazin.magazinBunSper;

import com.magazin.magazinBunSper.model.*;
import com.magazin.magazinBunSper.repository.AdminRepository;
import com.magazin.magazinBunSper.repository.OrderRepository;
import com.magazin.magazinBunSper.repository.ProductRepository;
import com.magazin.magazinBunSper.repository.UserRepository;
import com.magazin.magazinBunSper.service.serviceImplementation.AdminServiceImplementation;
import com.magazin.magazinBunSper.service.serviceImplementation.UserServiceImplementation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//@EnableTransactionManagement
@SpringBootApplication
@EnableJpaRepositories
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan({"com.magazin.magazinBunSper.repository"})
public class MagazinBunSperApplication {


	public static void main(String[] args) {

		SpringApplication.run(MagazinBunSperApplication.class, args);
	}

	@Bean
		CommandLineRunner init (UserRepository userRepository, ProductRepository productRepository, OrderRepository orderRepository,AdminRepository adminRepository){
		return args -> {

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate = dateFormat.format(new Date());

			Admin adminPrincipal=new Admin();
			//UserService service=new UserService(userRepository);
			adminPrincipal.setCodAdmin(444555);
			adminPrincipal.setId(1);
			adminPrincipal.setName("Pojar");
			adminPrincipal.setPrenume("Alina");
			adminPrincipal.setParola("alina0102030405");
			adminPrincipal.setFunctie("Director General");
			adminRepository.save(adminPrincipal);

			Admin adminPrincipal1=new Admin();
			//UserService service=new UserService(userRepository);
			adminPrincipal1.setCodAdmin(0102030405);
			adminPrincipal1.setId(2);
			adminPrincipal1.setName("Mihaila");
			adminPrincipal1.setPrenume("Calina");
			adminPrincipal1.setParola("calinaDirectorProductie");
			adminPrincipal1.setFunctie("Director Productie");
			adminRepository.save(adminPrincipal1);

			User user1=new User();
			user1.setNumeClient("Boca");
			user1.setPrenumeClient("Bianca");
			user1.setAdresaEmail("bianca_boca25@yahoo.com");
			user1.setVarsta(21);
			user1.setParola("bianca");
			user1.setDataLogare(formattedDate);
			userRepository.save(user1);

			User user2=new User();
			user2.setNumeClient("Honan");
			user2.setPrenumeClient("Alina");
			user2.setAdresaEmail("alina_ho25@yahoo.com");
			user2.setVarsta(25);
			user2.setParola("alinaa@32");
			user2.setDataLogare(formattedDate);
			userRepository.save(user2);

			User user3=new User();
			user3.setNumeClient("Mitica");
			user3.setPrenumeClient("Larisa");
			user3.setAdresaEmail("miticalarisa24@yahoo.com");
			user3.setParola("mitica");
			user3.setVarsta(40);
			user3.setDataLogare(formattedDate);
			userRepository.save(user3);

			Product produs1=new Product();
			produs1.setNumeProdus("Rochie");
			produs1.setCantitateProdus(20);
			produs1.setPretProdus(40);
			produs1.setMarca("Adidas");
			//produs1.setUser(user1);
			productRepository.save(produs1);

			Product produs2=new Product();
			produs2.setNumeProdus("Jeans Mom-Fitt");
			produs2.setPretProdus(60);
			produs2.setCantitateProdus(60);
			produs2.setMarca("Nike");
			//produs2.setUser(user1);
			productRepository.save(produs2);

			Product produs3=new Product();
			produs3.setNumeProdus("Jeans");
			produs3.setPretProdus(40);
			produs3.setCantitateProdus(30);
			produs3.setMarca("Nike");
			productRepository.save(produs3);

			Product produs4=new Product();
			produs4.setId(3);
			produs4.setNumeProdus("Tshirt");
			produs4.setPretProdus(30);
			produs4.setCantitateProdus(50);
			produs4.setMarca("Nike");
			productRepository.save(produs4);




//			produs3.setUser(user3);
//			productRepository.save(produs3);



			Orderer order=new Orderer();
			List<Product> produse=new ArrayList<>();
			List<Orderer> orderList=new ArrayList<>();

			Orderer order1=new Orderer();
			List<Product> produse2=new ArrayList<>();
			List<Orderer> orderList2=new ArrayList<>();

			Orderer order2=new Orderer();
			List<Product> produse3=new ArrayList<>();
			List<Orderer> orderList3=new ArrayList<>();

			produse.add(produs1);
			produse.add(produs2);
			productRepository.saveAll(produse);
			user1.setListaProduse(produse);
			order.setComanda(produse);
			userRepository.save(user1);

			produse2.add(produs1);
			produse2.add(produs2);
			produse2.add(produs3);
			productRepository.saveAll(produse2);
			order1.setComanda(produse2);

			produse3.add(produs1);
			produse3.add(produs2);
			produse3.add(produs3);
			produse3.add(produs4);
			productRepository.saveAll(produse3);
			order2.setComanda(produse3);
		//	order2.setComanda(produse3);



//			orderList.add(order);
//			orderList2.add(order1);
//			orderList3.add(order2);


			System.out.println(orderList);
			System.out.println(orderList2);System.out.println(orderList3);



			produs1.setUser(user1);
			productRepository.save(produs1);

//			produs1.setOrdering(order);
//			produs1.setOrdering(order1);
//			produs1.setOrdering(order2);
//
//			productRepository.save(produs1);
//
//			produs2.setOrdering(order);
//			produs2.setOrdering(order1);
//			produs2.setOrdering(order2);
//			productRepository.save(produs2);
//
//			produs3.setOrdering(order1);
//			produs3.setOrdering(order2);
//			productRepository.save(produs3);
//
//			produs4.setOrdering(order2);
//			productRepository.save(produs4);
//			user1.setListaOrders(orderList);
//			userRepository.save(user1);

			produs2.setUser(user2);
			productRepository.save(produs2);



		//	System.out.println(orderList);
	//		System.out.println(order);
			AdminServiceImplementation adminServiceImplementation=new AdminServiceImplementation(adminRepository, productRepository, userRepository, orderRepository);
		//	System.out.println(adminServiceImplementation.logIn(adminPrincipal,"alina0102030405", 444555  ));
			UserServiceImplementation userService=new UserServiceImplementation(userRepository);
			//System.out.println(userService.findById2((long)3));
		//	System.out.println(userServiceImplementation.fetchAUserByName("Boca"));
//			userRepository.deleteUserById(1);
//			System.out.println(use);

			adminServiceImplementation.updateProduct(produs1,"KIWI");
			System.out.println(userService.logInClient(user1,"bianca", "bianca_boca25@yahoo.com"));

		};


	}

}
package com.lemos.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lemos.cursomc.domain.Address;
import com.lemos.cursomc.domain.Category;
import com.lemos.cursomc.domain.City;
import com.lemos.cursomc.domain.Client;
import com.lemos.cursomc.domain.Product;
import com.lemos.cursomc.domain.State;
import com.lemos.cursomc.domin.enums.TypeClient;
import com.lemos.cursomc.repository.AddressRepository;
import com.lemos.cursomc.repository.CategoryRepository;
import com.lemos.cursomc.repository.CityRepository;
import com.lemos.cursomc.repository.ClientRepository;
import com.lemos.cursomc.repository.ProductRepository;
import com.lemos.cursomc.repository.StateRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;	
	@Autowired
	private ProductRepository productRepository;	
	@Autowired 
	private StateRepository stateRepository;	
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		State est1 = new State(null, "Minas Gerais");
		State est2 = new State(null, "São paulo");
		
		City c1 = new City(null, "Uberlândia", est1);
		City c2 = new City(null, "São paulo", est2);
		City c3 = new City(null, "Campinas", est2);
		
		est1.getCities().addAll(Arrays.asList(c1));
		est2.getCities().addAll(Arrays.asList(c2,c3));
		
		stateRepository.saveAll(Arrays.asList(est1, est2));
		cityRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", TypeClient.PHYSICALPERSON);
		
		cli1.getPhones().addAll(Arrays.asList("27363323", "93838393"));
		
		Address e1 = new Address(null, "Rua Floeres", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Address e2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Jardim", "38777012", cli1, c2);
		
		cli1.getAdresses().addAll(Arrays.asList(e1, e2));
		
		clientRepository.save(cli1);
		addressRepository.saveAll(Arrays.asList(e1, e2));
		
		
	}

}

package model;

import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		List<Customer> costumers = CustomerFacade.retriveAllCostumers();
		for(Customer costumer : costumers) System.out.println(costumer.toString());
		System.out.println(ProductFacade.retriveAllProviders((long)1).toString());
		System.out.println(ProductFacade.retriveAllProviders((long)1).toString());
		System.out.println(ProductFacade.retriveAllProviders((long)2).toString());
	}
}

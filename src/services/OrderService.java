package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import entities.Cashier;
import entities.Order;
import entities.Table;
import entities.enums.Payment;
import entities.enums.Status;
import view.View;


public class OrderService {
	
	
	public static Map<Table,Order> orderMap = new HashMap<>();
	public static List<Cashier> cashier = new ArrayList<>();
		
			
	public static void addOrder(Table table, Order order) {
		orderMap.put(table, order);		
		System.out.println("Finished!");
		View.menu();
	}
	
	public static void viewOrders() {
		for (Map.Entry<Table, Order> orders : orderMap.entrySet()) {
			System.out.println(orders.getKey() + " " + orders.getValue());
		}
		View.menu();
	}
	
	public static void selectTable(Integer tableNumber) {
		Double soma = 0.0;
		for (Map.Entry<Table, Order> pedidos : orderMap.entrySet()) {
			if (pedidos.getKey().getNumber() == tableNumber) {
				soma += pedidos.getValue().getPrice();
			}
		}
		System.out.printf("The table " + tableNumber + ", has the total: "+" %.2f",soma);
		System.out.println("");
		View.menu();
	}
	
	public static void selectStatus(Status status) {
		Map<Table, Order> orderSelected = new HashMap<>();
		Double sum = 0.0;
		for (Map.Entry<Table, Order> orders : orderMap.entrySet()) {
			if (orders.getValue().getOrderStatus() == status) {
				orderSelected.put(orders.getKey(), orders.getValue());
				sum += orders.getValue().getPrice();
			}
		}		
		for (Map.Entry<Table, Order> put : orderSelected.entrySet()) {
			System.out.println(put.getKey() + " " + put.getValue());		
		}
		System.out.printf("Total orders with status: "+ status + ": "+" %.2f",sum);
		View.menu();			
	}
	
	public static void valuePerTable() {
	
		Set<Integer> tables = new HashSet<>();
		for (Map.Entry<Table, Order> orders : orderMap.entrySet()) {
			tables.add(orders.getKey().getNumber());
		}		
		for (Integer table : tables) {
			Double sum = 0.0;
			for (Map.Entry<Table, Order> orders : orderMap.entrySet()) {
				if (orders.getKey().getNumber() == table) {
					sum += orders.getValue().getPrice();
				}				
			}
			System.out.println("");
			System.out.printf("Table: " + table + ", Total orders: $" + "%.2f",sum);
			System.out.println("");
		}
		View.menu();
	}	
	
	public static void changingStatus(Integer number, Status status) {		
		for (Map.Entry<Table, Order> orders : orderMap.entrySet()) {
			if (orders.getValue().getOrderNumber() == number) {		
				orders.getValue().setOrderStatus(status);
			}
		}
		View.menu();
	}	
	
	public static void payingOrder(Integer number, Status status, Payment option) {
		for (Map.Entry<Table, Order> orders : orderMap.entrySet()) {
			if (orders.getValue().getOrderNumber() == number) {		
				orders.getValue().setOrderStatus(status);
				Cashier payment = new Cashier(option, number, orders.getValue().getPrice());
				cashier.add(payment);				
			}
		}	
		View.menu();
	}
	
	public static void checkCashier() {
		Double somaCash = 0.0;
		Double somaCreditcard = 0.0;		
		for(Cashier cash : cashier) {
			if (cash.getPayment() == Payment.CASH){
				somaCash += cash.getPrice();
			}
			if (cash.getPayment() == Payment.CREDITCARD){
				somaCreditcard += cash.getPrice();
			}			
		}
		System.out.println("Total in cash: " + somaCash);
		System.out.println("Total in Credit card: " + somaCreditcard);
		View.menu();
	}
}	
	
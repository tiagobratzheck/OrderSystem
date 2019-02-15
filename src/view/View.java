package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.Table;
import entities.enums.Payment;
import entities.enums.Status;
import services.OrderService;

public class View {

	public static void menu() {
		System.out.println("1 - Order: ");
		System.out.println("2 - Select orders by table: ");
		System.out.println("3 - Select by status: ");
		System.out.println("4 - Total orders: ");
		System.out.println("5 - Change status:");	
		System.out.println("6 - Pay order:");
		System.out.println("7 - Check results:");
		controller();
	}

	public static void controller() {
		Scanner input = new Scanner(System.in);
		System.out.print("Select one of the options above: ");
		try {
			int option = input.nextInt();
			choseOption(option);
		} catch (InputMismatchException e) {
			System.out.println("Exception gotten: " + e);
			controller();
		}
		input.close();
	}

	public static void choseOption(Integer option) {
		if (option == 1) {
			makeOrder();
		}
		if (option == 2) {
			selectTable();
		}
		if (option == 3) {
			selectStatus();
		}
		if (option == 4) {
			totalOrder();
		}
		if (option == 5) {
			selectOrder();
		}
		if (option == 6) {
			payingOrder();
		}
		if (option == 7) {
			checkResult();
		}else {
			System.out.println("Invalid Option...");
			controller();
		}
	}

	public static void makeOrder() {		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the table number: ");	
		Integer tableNumber = input.nextInt(); 
		
		System.out.print("Enter the name of order: ");	
		String orderName = input.next();
		
		System.out.print("Enter the name of the client: ");	
		String client = input.next();
		
		System.out.print("Enter the number: ");	
		Integer orderNumber = input.nextInt();
		
		System.out.print("Status: ");	
		String status = input.next();
		
		System.out.print("Order price: ");	
		Double price = input.nextDouble();
			
		Order order = new Order(orderName, new Client(client), orderNumber, Status.valueOf(status.toUpperCase()), price);
		Table table = new Table(tableNumber);
		OrderService.addOrder(table, order);
		
		input.close();		
	}

	public static void selectTable() {
		Scanner input = new Scanner(System.in);
		System.out.println("Select the table number: ");
		Integer table = input.nextInt();
		OrderService.selectTable(table);		
		input.close();
	}

	public static void selectStatus() {
		Scanner input = new Scanner(System.in);
		System.out.print("Status: ");	
		String status = input.next();
		
		OrderService.selectStatus(Status.valueOf(status.toUpperCase()));
		input.close();
	}

	public static void totalOrder() {
		OrderService.viewOrders();		
	}
	
	public static void selectOrder() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the order number: ");	
		Integer number = input.nextInt();	
		
		changingStatus(number);		
		input.close();
	}

	public static void changingStatus(Integer number) {
		Scanner input = new Scanner(System.in);
		System.out.print("Status: ");	
		String status = input.next();
		OrderService.changingStatus(number, Status.valueOf(status.toUpperCase()));
		input.close();
	}
	
	public static void payingOrder() {	
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the order number: ");	
		Integer number = input.nextInt();	
		System.out.print("cash or credircard: ");	
		String option = input.next();
		OrderService.payingOrder(number, Status.PAYED, Payment.valueOf(option.toUpperCase()));
								
		input.close();		
	}
	
	public static void checkResult() {
		OrderService.checkCashier();
	}	
}

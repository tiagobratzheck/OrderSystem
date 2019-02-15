package entities;

import entities.enums.Payment;

public class Cashier {

	private Payment payment;
	private Integer number;
	private Double price;
	
	
	public Cashier(Payment payment, Integer number, Double price) {		
		this.payment = payment;
		this.number = number;
		this.price = price;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Payment = " + payment + ", number = " + number + ", price = " + price;
	}	
	
}

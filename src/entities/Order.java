package entities;

import entities.enums.Status;

public class Order {

	private String orderName;
	private Client client;
	private Integer orderNumber;
	private Status orderStatus;
	private Double price;
	
	
	public Order() {
		
	}

	public Order(String orderName, Client client, Integer orderNumber, Status orderStatus, Double price) {		
		this.orderName = orderName;
		this.client = client;
		this.orderNumber = orderNumber;
		this.orderStatus = orderStatus;
		this.price = price;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Status getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Status orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return " Order [" + orderName +  client +", Number = " + orderNumber + ", Status= " + orderStatus
				+ ", price= " + price + " ]";
	}	
}

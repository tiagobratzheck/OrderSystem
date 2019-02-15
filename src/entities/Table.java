package entities;

public class Table {
	
	private Integer number;	
	
	public Table() {
		
	}
	
	public Table(Integer number) {		
		this.number = number;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Table: " + number;
	}	
}

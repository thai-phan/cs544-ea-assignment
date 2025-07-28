package app.requiresnew.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class CustomerRN {
    @Id
    @GeneratedValue
    private long id;
	private String name;


    public CustomerRN(){
    	
    }

	public CustomerRN(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}

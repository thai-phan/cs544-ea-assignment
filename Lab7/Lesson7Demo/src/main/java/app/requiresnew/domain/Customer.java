package app.requiresnew.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Customer {
    @Id
    @GeneratedValue
    private long id;
	private String name;


    public Customer(){
    	
    }

	public Customer(String name) {
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

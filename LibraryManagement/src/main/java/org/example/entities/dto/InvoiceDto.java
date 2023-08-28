package org.example.entities.dto;


import lombok.Data;
import org.example.entities.Customer;

import java.time.LocalDateTime;

@Data
public class InvoiceDto {
    private int id;
    private LocalDateTime updatedDate;
    private Customer customer;
    private String bookNames;
    private Float amount;

    public InvoiceDto(int id, LocalDateTime updatedDate, Customer customer, String bookNames, Float amount) {
        this.id = id;
        this.updatedDate = updatedDate;
        this.customer = customer;
        this.bookNames = bookNames;
        this.amount = amount;
    }

    public InvoiceDto() {}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getBookNames() {
		return bookNames;
	}

	public void setBookNames(String bookNames) {
		this.bookNames = bookNames;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}
    
    
}

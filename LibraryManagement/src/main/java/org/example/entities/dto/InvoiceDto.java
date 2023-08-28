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
}

package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ISBN;

    private String name;

    @Column(name = "author_name")
    private String authorName;

    private String language;

    private String category;

    private Integer quantity;

    private Float price;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedDate;

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    private List<Invoice> invoices;
    public Book() {}
    
    public Book(Integer id, String ISBN, String name, String authorName, String language, String category, Integer quantity, Float price) {
        this.id = id;
        this.ISBN = ISBN;
        this.name = name;
        this.authorName = authorName;
        this.language = language;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public Book(String ISBN, String name, String language, String category, String authorName,  Integer quantity, Float price, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.ISBN = ISBN;
        this.name = name;
        this.authorName = authorName;
        this.language = language;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Book(Integer id, String ISBN, String name, String authorName, String language, String category, Integer quantity, Float price, LocalDateTime updatedDate) {
        this.id = id;
        this.ISBN = ISBN;
        this.name = name;
        this.authorName = authorName;
        this.language = language;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.updatedDate = updatedDate;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
    
    
}

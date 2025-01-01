package com.example.demo.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    @NotBlank(message = "Description is required")
    @Column(unique = true, nullable = false)
    private String description;

    public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	private String partNo;

    @Column(nullable = false)
    private Double unitPrice;
    
    @Column(nullable = false, length = 50)
    private String make;

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

    // Getters and Setters
}

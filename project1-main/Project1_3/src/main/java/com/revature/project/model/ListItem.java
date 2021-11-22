package com.revature.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "list_item")
public class ListItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="list_item_id")
	private int listItemId;
	@Column(name="product_id")
	private int productId; 
	@Column(name="quantity")
	private int quantity;
	@Column(name="extendedPrice")
	private double extendedPrice;
	
	public ListItem() {
		super();
	}

	public ListItem(int listItemId, int productId, int quantity, double extendedPrice) {
		super();
		this.listItemId = listItemId;
		this.productId = productId;
		this.quantity = quantity;
		this.extendedPrice = extendedPrice;
	}

	public int getListItemId() {
		return listItemId;
	}

	public void setListItemId(int listItemId) {
		this.listItemId = listItemId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getExtendedPrice() {
		return extendedPrice;
	}

	public void setExtendedPrice(double extendedPrice) {
		this.extendedPrice = extendedPrice;
	}

	@Override
	public String toString() {
		return "ListItem [listItemId=" + listItemId + ", productId=" + productId + ", quantity=" + quantity
				+ ", extendedPrice=" + extendedPrice + "]";
	}
	
	
	
}

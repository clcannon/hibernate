package b;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@Column(name = "id")
	protected int productID;
	
	
	public int getProductID() {
		return productID;
	}


	public void setProductID(int productID) {
		this.productID = productID;
	}


	@Column(name  = "name")
	protected String name;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany(cascade = {CascadeType.PERSIST})
	@JoinTable(name = "orders_products", joinColumns = @JoinColumn(name = "order_id"))
	private List<Order> orders;


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order order) {
		this.orders.add(order);
	}
}

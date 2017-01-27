package persistance;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long order_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<OrderLines> orderLines = new HashSet<>();
	
	@Transient
	private int totalCost;
	
	public Order()
	{
		
	}

	public Order(Long order_id, int customer_id, Set<OrderLines> orderLines,
			int totalCost) {
		super();
		this.order_id = order_id;
		this.customer = customer;
		this.orderLines = orderLines;
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", customer_id=" + customer
				+ ", orderLines=" + orderLines + ", totalCost=" + totalCost
				+ "]";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customer == null) ? 0 : customer.hashCode());
		result = prime * result
				+ ((orderLines == null) ? 0 : orderLines.hashCode());
		result = prime * result
				+ ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + totalCost;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (orderLines == null) {
			if (other.orderLines != null)
				return false;
		} else if (!orderLines.equals(other.orderLines))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (totalCost != other.totalCost)
			return false;
		return true;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Customer getCustomer_id() {
		return customer;
	}

	public void setCustomer_id(Customer customer) {
		this.customer = customer;
	}

	public Set<OrderLines> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(Set<OrderLines> orderLines) {
		this.orderLines = orderLines;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	
	
	
}

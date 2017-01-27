package persistance;
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
public class OrderLines {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long order_Lines_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Order order;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Book book;
	
	@Column(nullable = false)
	private int quantity;
	
	@Transient
	private int lineCost;

	public OrderLines()
	{
		
	}
	public OrderLines(Long order_Lines_id, Order order, Book book,
			int quantity, int lineCost) {
		super();
		this.order_Lines_id = order_Lines_id;
		this.order = order;
		this.book = book;
		this.quantity = quantity;
		this.lineCost = lineCost;
	}
	@Override
	public String toString() {
		return "OrderLines [order_Lines_id=" + order_Lines_id + ", order="
				+ order + ", book=" + book + ", quantity=" + quantity
				+ ", lineCost=" + lineCost + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + lineCost;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result
				+ ((order_Lines_id == null) ? 0 : order_Lines_id.hashCode());
		result = prime * result + quantity;
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
		OrderLines other = (OrderLines) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (lineCost != other.lineCost)
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (order_Lines_id == null) {
			if (other.order_Lines_id != null)
				return false;
		} else if (!order_Lines_id.equals(other.order_Lines_id))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	public Long getOrder_Lines_id() {
		return order_Lines_id;
	}
	public void setOrder_Lines_id(Long order_Lines_id) {
		this.order_Lines_id = order_Lines_id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getLineCost() {
		return lineCost;
	}
	public void setLineCost(int lineCost) {
		this.lineCost = lineCost;
	}
	
	
	
	
}

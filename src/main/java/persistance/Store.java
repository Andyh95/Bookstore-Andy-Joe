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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
public class Store {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long store_id;
	
	@Column(nullable = false)
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Book> books = new HashSet<>();
	
	@Column(nullable = false)
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Customer> customers = new HashSet<>();
	
	@Column(nullable = false, length = 100)
	@Size(max = 100)
	private String name;
	
	@Column(length = 150)
	@Size(max = 150)
	private String address;
	
	public Store()
	{
		
	}

	public Store(Long store_id, Set<Book> books, Set<Customer> customers,
			String name, String address) {
		super();
		this.store_id = store_id;
		this.books = books;
		this.customers = customers;
		this.name = name;
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result
				+ ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((store_id == null) ? 0 : store_id.hashCode());
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
		Store other = (Store) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (store_id == null) {
			if (other.store_id != null)
				return false;
		} else if (!store_id.equals(other.store_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Store [store_id=" + store_id + ", books=" + books
				+ ", customers=" + customers + ", name=" + name + ", address="
				+ address + "]";
	}

	public Long getStore_id() {
		return store_id;
	}

	public void setStore_id(Long store_id) {
		this.store_id = store_id;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

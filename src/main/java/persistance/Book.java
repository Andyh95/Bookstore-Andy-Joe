package persistance;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long book_id;
	
	@Column(nullable=false, length = 100)
	@Size(max = 100)
	private String title;
	
	@Column(length = 50)
	@Size(max = 50)
	private String genre;
	
	@Column(nullable=false, name="Authors")
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Author> authors = new HashSet<>();
	
	@Column(length = 500)
	@Size(max = 500)
	private String synopsis;
	
	@Column(nullable = false)
	private int quantity;
	
	private int cost;
	
	

	public Book(Long book_id, String title, String genre, Set<Author> authors,
			String synopsis, int quantity, int cost) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.genre = genre;
		this.authors = authors;
		this.synopsis = synopsis;
		this.quantity = quantity;
		this.cost = cost;
	}


	public Book()
	{
	
	}


	public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}


	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", title=" + title + ", genre="
				+ genre + ", authors=" + authors + ", synopsis=" + synopsis
				+ ", quantity=" + quantity + ", cost=" + cost + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((book_id == null) ? 0 : book_id.hashCode());
		result = prime * result + cost;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + quantity;
		result = prime * result
				+ ((synopsis == null) ? 0 : synopsis.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (book_id == null) {
			if (other.book_id != null)
				return false;
		} else if (!book_id.equals(other.book_id))
			return false;
		if (cost != other.cost)
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (quantity != other.quantity)
			return false;
		if (synopsis == null) {
			if (other.synopsis != null)
				return false;
		} else if (!synopsis.equals(other.synopsis))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	



	
}

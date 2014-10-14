package laogen.action;
public class Book {
	private String Title;
	private long ISBN;
	private long AuthorID;
	private String Publisher;
	private String PublishDate;
	private float Price;

	public void setTitle(String temp) {
		Title = temp;
	}

	public void setISBN(long temp) {
		ISBN = temp;
	}

	public void setAuthorID(long temp) {
		AuthorID = temp;
	}

	public void setPublisher(String temp) {
		Publisher = temp;
	}

	public void setPublishDate(String temp) {
		PublishDate = temp;
	}

	public void setPrice(float temp) {
		Price = temp;
	}

	public String getTitle() {
		return Title;
	}

	public long getISBN() {
		return ISBN;
	}

	public long getAuthorID() {
		return AuthorID;
	}

	public String getPublisher() {
		return Publisher;
	}

	public String getPublishDate() {
		return PublishDate;
	}

	public float getPrice() {
		return Price;
	}

}

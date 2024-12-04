package aug_24;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BookBean implements Serializable
{
	private String bookCode;
	private String bookName;
	private String bookAuthor;
	private Double bookPrice;
	private Long bookQty;
	
	 BookBean()
	{
		
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Long getBookQty() {
		return bookQty;
	}

	public void setBookQty(Long bookQty) {
		this.bookQty = bookQty;
	}

	@Override
	public String toString() {
		return "BookBean [bookCode=" + bookCode + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor
				+ ", bookPrice=" + bookPrice + ", bookQty=" + bookQty + "]";
	}

	
}

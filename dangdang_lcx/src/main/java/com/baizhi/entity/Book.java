package com.baizhi.entity;

import java.io.Serializable;
import java.sql.Date;

public class Book implements Serializable {
	private String id;
	private String dname;
	private String author;
	private String cover;
	private String press;
	private Date pressdate;
	private Integer edition;
	private Date printdate;
	private Integer impression;
	private String isbn;
	private Integer wordNum;
	private Integer pageNum;
	private String dsize;
	private String paper;
	private String pack;
	private Double price;
	private Double dprice;
	private Date createdate;
	private String editorRecommend;
	private String contentAbstract;
	private String authorAbstract;
	private String director;
	private String mediaCommentary;
	private Integer sale;
	private Integer stock;
	private String categoryId;
	public Book() {
		super();
	}
	public Book(String id, String dname, String author, String cover,
			String press, Date pressdate, Integer edition, Date printdate,
			Integer impression, String isbn, Integer wordNum, Integer pageNum,
			String dsize, String paper, String pack, Double price,
			Double dprice, Date createdate, String editorRecommend,
			String contentAbstract, String authorAbstract, String director,
			String mediaCommentary, Integer sale, Integer stock,
			String categoryId) {
		super();
		this.id = id;
		this.dname = dname;
		this.author = author;
		this.cover = cover;
		this.press = press;
		this.pressdate = pressdate;
		this.edition = edition;
		this.printdate = printdate;
		this.impression = impression;
		this.isbn = isbn;
		this.wordNum = wordNum;
		this.pageNum = pageNum;
		this.dsize = dsize;
		this.paper = paper;
		this.pack = pack;
		this.price = price;
		this.dprice = dprice;
		this.createdate = createdate;
		this.editorRecommend = editorRecommend;
		this.contentAbstract = contentAbstract;
		this.authorAbstract = authorAbstract;
		this.director = director;
		this.mediaCommentary = mediaCommentary;
		this.sale = sale;
		this.stock = stock;
		this.categoryId = categoryId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Date getPressdate() {
		return pressdate;
	}
	public void setPressdate(Date pressdate) {
		this.pressdate = pressdate;
	}
	public Integer getEdition() {
		return edition;
	}
	public void setEdition(Integer edition) {
		this.edition = edition;
	}
	public Date getPrintdate() {
		return printdate;
	}
	public void setPrintdate(Date printdate) {
		this.printdate = printdate;
	}
	public Integer getImpression() {
		return impression;
	}
	public void setImpression(Integer impression) {
		this.impression = impression;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getWordNum() {
		return wordNum;
	}
	public void setWordNum(Integer wordNum) {
		this.wordNum = wordNum;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public String getDsize() {
		return dsize;
	}
	public void setDsize(String dsize) {
		this.dsize = dsize;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDprice() {
		return dprice;
	}
	public void setDprice(Double dprice) {
		this.dprice = dprice;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getEditorRecommend() {
		return editorRecommend;
	}
	public void setEditorRecommend(String editorRecommend) {
		this.editorRecommend = editorRecommend;
	}
	public String getContentAbstract() {
		return contentAbstract;
	}
	public void setContentAbstract(String contentAbstract) {
		this.contentAbstract = contentAbstract;
	}
	public String getAuthorAbstract() {
		return authorAbstract;
	}
	public void setAuthorAbstract(String authorAbstract) {
		this.authorAbstract = authorAbstract;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getMediaCommentary() {
		return mediaCommentary;
	}
	public void setMediaCommentary(String mediaCommentary) {
		this.mediaCommentary = mediaCommentary;
	}
	public Integer getSale() {
		return sale;
	}
	public void setSale(Integer sale) {
		this.sale = sale;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", dname=" + dname + ", author=" + author
				+ ", cover=" + cover + ", press=" + press + ", pressdate="
				+ pressdate + ", edition=" + edition + ", printdate="
				+ printdate + ", impression=" + impression + ", isbn=" + isbn
				+ ", wordNum=" + wordNum + ", pageNum=" + pageNum + ", dsize="
				+ dsize + ", paper=" + paper + ", pack=" + pack + ", price="
				+ price + ", dprice=" + dprice + ", createdate=" + createdate
				+ ", editorRecommend=" + editorRecommend + ", contentAbstract="
				+ contentAbstract + ", authorAbstract=" + authorAbstract
				+ ", director=" + director + ", mediaCommentary="
				+ mediaCommentary + ", sale=" + sale + ", stock=" + stock
				+ ", categoryId=" + categoryId + "]";
	}
	
}

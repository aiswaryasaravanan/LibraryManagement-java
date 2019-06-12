public class Book {
	
	private String id;
	private String name;
	private String author;
	private int availableStock;
	
	Book(String id,String name,String author,int availableStock){
		this.id=id;
		this.name=name;
		this.author=author;
		this.availableStock=availableStock;
	}
	
	void updateStock(int count) {
		availableStock+=count;
	}
	String getId() {
		return id;
	}
	String getName() {
		return name;
	}
	String getAuthor() {
		return author;
	}
}

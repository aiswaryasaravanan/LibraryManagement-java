import java.util.*;
public class User {
	
	private String name;
	private String rollNo;
	private String password;
	private int fineAmount;
	HashSet<String> borrowedBooks=new HashSet<String>();
	
	User(String rollNo,String name,String  password){
		this.rollNo=rollNo;
		this.name=name;
		this.password=password;
		fineAmount=0;
	}
	
	void borrowBook(String bookId) {
		borrowedBooks.add(bookId);
	}
	void returnBook(String bookId) {
		borrowedBooks.remove(bookId);
	}
	void updateFine(int amount) {
		fineAmount+=amount;
	}
	boolean authenticate(String password) {
		if(password.equals(this.password)) {
			return true;
		}
		return false;
	}
	String getName() {
		return name;
	}
	int getFine() {
		return fineAmount;
	}
	String getRollNo() {
		return rollNo;
	}
	HashSet<String> getBorrowedBooks(){
		return borrowedBooks;
	}
	
}

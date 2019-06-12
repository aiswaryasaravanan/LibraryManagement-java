import java.util.*;
public class Library {
	
	static HashMap<String,User> user=new HashMap<String,User>();
	static HashMap<String,Book> book=new HashMap<String,Book>();

	{
		Book book1=new Book("b1","letusc","yaswanth",5);
		addBook("b1",book1);
		Book book2=new Book("b2","harrypotter","rowling",15);
		addBook("b2",book2);		
		Book book3=new Book("b3","aaa","bbb",3);
		addBook("b3",book3);
	}
	{
		User user1=new User("16c001","Aishu","Aishu");
		enrollUser("16c001",user1);
		User user2=new User("16c002","Abi","Abi");
		enrollUser("16c002",user2);
		User user3=new User("16c003","Arun","Arun");
		enrollUser("16c003",user3);
		
	}
	
	private static void borrowBook(String userId,String bookId) {
		User u=user.get(userId);
		u.borrowBook(bookId);
		Book b=book.get(bookId);
		b.updateStock(-1);
	}
	
	private static void returnBook(String userId,String bookId) {
		User u=user.get(userId);
		u.returnBook(bookId);
		Book b=book.get(bookId);
		b.updateStock(1);
	}
	
	private static void enrollUser(String userId,User u) {
		user.put(userId,u);
	}
	
	private User authenticateUser(String userId,String password) {
		User u=user.get(userId);
		if(u.authenticate(password)) {
			return u;
		}
		return null;
	}
	
	private static void addBook(String bookId,Book b) {
		book.put(bookId,b);
	}
	
	private static void removeBook(String bookId) {
		Book b=book.remove(bookId);
	}

	public static void main(String a[]) {
		
		Library library=new Library();
		
		System.out.println("Welcome To Library!!");
		System.out.println("Enter:");
		System.out.println("1)Login   2)Register");
		Scanner inp=new Scanner(System.in);
		int entryOption=inp.nextInt();
		if(entryOption==1) {
			User u=library.authenticateUser(inp.next(),inp.next());
			if(u==null) {
				System.out.println("Login failed...");
				//Goto welcomePage
			}else {
				//profile
				System.out.println("Welcome "+u.getName()+"...");
				System.out.println("You have the following books...");
				System.out.println(u.getBorrowedBooks());
				System.out.println("your fine is.."+u.getFine());
				
				//action
				System.out.println("Enter:");
				System.out.println("1)Borrow   2)Return   3)PayFine");
				int  action=inp.nextInt();
				if(action==1) {
				    for(Map.Entry m:book.entrySet()){    
				    	   Book b=(Book)m.getValue();
				           System.out.println("BookId:"+b.getId());
				           System.out.println("BookName:"+b.getName());
				           System.out.println("BookAuthor:"+b.getAuthor());
				           System.out.println("");
				    }  
					System.out.println("Enter required bookId :");
					String bookId=inp.next();
					library.borrowBook(u.getRollNo(),bookId);
					
					//action(u);
				}else if(action==2) {
					System.out.println("You have the following books...");
					System.out.println(u.getBorrowedBooks());
					System.out.println("Enter bookId:");
					String bookId=inp.next();
					library.returnBook(u.getRollNo(),bookId);
				}else if(action==3) {
					System.out.println("Enter amount to be paid..");
					int amount=inp.nextInt();
					//
					//
					//
				}
				
			}
		}
		else if(entryOption==2) {
			System.out.println("Enter Roll no,name,password");
			String rollNo=inp.next();
			String name=inp.next();
		}inp.close();
				
	}
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book{
    String bookName;
    String Author;
    Boolean isIssued;

    Book(String bookName, String Author){
        this.bookName = bookName;
        this.Author = Author;
        isIssued = false;
    }
public String getBookName(){
    return bookName;
}
   public void issueBook(){
    isIssued = true;
   }

   public void returnBook(){
    isIssued = false;
   }

    @Override
	public String toString() {
		return "Book [bookName=" + bookName + ", Author=" + Author + ", isIssued=" + isIssued + "]";
	}

}


class User {
    private String userName;
    private List <Book> borrowedBook ;
    
    User (String userName){
    this.userName = userName;
     this.borrowedBook = new ArrayList<>();
    }


public void borrowBook(Book book){
    borrowedBook.add(book);
    book.issueBook();
}

public void returnBook(Book book){
    borrowedBook.remove(book);
    book.returnBook();
}

    }

     class Library {
    private List<Book> books;

    Library(){
        this.books = new ArrayList<>();
    }

    public void addBooks(Book bookName){
        books.add(bookName);
    }    
    
    public Book findByTitle(String title){
        for (Book b : books) {
            if (b.getBookName().equalsIgnoreCase(title)) {
                return b;
            }
            }
            return null;
        }

        public Book findIssuedBook(String title){
            for (Book b : books) {
                if (b.getBookName().equalsIgnoreCase(title)) {
                    return b;
                }

            }
            return null;
        }

    }

    public class libraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        


    Library library = new Library();
	
	library.addBooks(new Book("Java Basic", "James Gosling"));
	library.addBooks(new Book("Clean Code", "Joshua Bloch"));
	
	User user = new User("RITIK");
	 
	int Choice;
	do {
		System.out.println("**** LIBRARY MANAGEMENT SYSTEM ****");
		System.out.println("0. for exist");
		System.out.println("1. borrow book");
		System.out.println("2. return book");
		Choice = scanner.nextInt();
		scanner.nextLine();
		
		switch(Choice) {
		
		case 1:
			System.out.println("Enter Book Name To Borrow");
			String borrowTitle = scanner.nextLine();
			Book bookToBorrow = library.findByTitle(borrowTitle);
			if(bookToBorrow != null) {
				user.borrowBook(bookToBorrow);
                System.out.println("you borrow the book" +bookToBorrow);
				}else {
					System.out.println("Book Not Available");
				}
		break;
		
		case 2 :
			System.out.println("enter book name to return");
			String returnTitle = scanner.nextLine();
			Book bookToReturn = library.findIssuedBook(returnTitle);
			if(bookToReturn != null) {
				user.returnBook(bookToReturn);
                System.out.println("Book returned" + bookToReturn);
			}else {
				System.out.println("Book already returned");
			}
				
		}
		
	}
	while(Choice != 0);
	
	
	
	scanner.close();
}
    }

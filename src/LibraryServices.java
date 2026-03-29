import java.awt.print.Book;

public interface LibraryServices {

    void addUser(String Name, String Email, String Password);
    void addBook(String ISBN, String title, String author, String publisher);
    void issueBook(Users u, Books b);
    void returnBook(Books b);
    void showAllBooks();
    void isAvailable(Books b);


}

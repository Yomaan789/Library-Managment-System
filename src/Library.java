import java.util.*;

public class Library implements LibraryServices {
     public  HashMap<Long,Users> members=new HashMap<>();
     public  HashMap<Users,Books> User_book=new HashMap<>();

    public  Map<String ,Books> book_record= new HashMap<>();
    public  Map<Books,Boolean> book_status= new HashMap<>();
    public  ArrayList<Books> Allbooks= new ArrayList<>();

    @Override
    public void addUser(String Name, String Email, String Password) {
             Users m = new Members(Name, Email, Password);
             long id = Users.getID_Member();
             Users.setID_Member(++id);
             members.put(id, m);

    }

    @Override
    public void addBook(String ISBN, String title, String author, String publisher) {
        Books b= new Books(ISBN,title,author,publisher);
        Allbooks.add(b);
        book_record.put(ISBN,b);
        book_status.put(b,true);
        System.out.println("Book with" +ISBN+ title+" added Successfully");

    }

    @Override
    public void showAllBooks() {
        for(Map.Entry<String,Books> x: book_record.entrySet()) {
            System.out.print(x.getKey() + " " + x.getValue().getTitle()+ " ");
            isAvailable(x.getValue());
        }
    }

    @Override
    public void returnBook(Books b) {
            setAvailability(b,true);
    }

    @Override
    public void issueBook(Users u, Books b) {
        User_book.put(u,b);
        System.out.println("Book Issued Successfully");

    }


    public void isAvailable(Books b) {
            if(book_status.containsKey(b))
                if(book_status.get(b)) System.out.println("is available");
    }

    public void setAvailability(Books b,boolean status) {
        if(book_status.containsKey(b))
             book_status.put(b,status);
    }


    public void ShowAllMembers(){
        for(Map.Entry<Long,Users> entry: members.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue().getName());
        }
    }
}

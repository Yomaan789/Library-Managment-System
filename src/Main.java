import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Library L=new Library();
        Users u; Books b;
        String ISBN;
        OUTER:
        while(true) {
            System.out.println("\t\t------Welcome to the Library Management System----");
            System.out.println("1.Create Users.");
            System.out.println("2.Show all Users.");
            System.out.println("3.Add Books.");
            System.out.println("4.Issue Books.");
            System.out.println("5.Return Books.");
            System.out.println("6.Show all available Books.");
            System.out.println("7.Exit.");
            System.out.println("Enter your choice: ");
            int choice = in.nextInt();
            switch(choice){

                case 1://ADD_USERS
                    System.out.println("Enter Name:");
                    String name=in.next();
                    System.out.println("Enter Email:");
                    String email=in.next();
                    System.out.println("Enter Password:");
                    String password=in.next();
                    L.addUser(name,email,password);
                    break;

                case 2://SHOW_ALL_USERS
                    System.out.println("All members:");
                    for(Map.Entry<Long, Users> x: L.members.entrySet())
                        System.out.println(x.getKey()+" "+ x.getValue().getName());
                    break;

                case 3://ADD_BOOK
                    System.out.println("Enter ISBN: ");
                    ISBN=in.nextLine();
                    System.out.println("Enter Title of Book: ");
                    String title=in.nextLine();
                    System.out.println("Enter Author of Book: ");
                    String author=in.nextLine();
                    System.out.println("Enter Publisher of Book: ");
                    String publisher=in.nextLine();
                    //input done
                    L.addBook(ISBN,title, author, publisher);
                    break;

                case 4:// ISSUE_BOOK
                    L.showAllBooks();
                    System.out.print("Enter ISBN of the book you want to Issue: ");
                    ISBN=in.nextLine();
                    b=L.book_record.get(ISBN);
                    System.out.println("Books Title: "+ L.book_record.get(ISBN).getTitle());
                    L.setAvailability(b,false);
                    L.ShowAllMembers();
                    System.out.println("\nSelect UserID: ");
                    long userID=in.nextLong();
                    u= L.members.get(userID);
                    L.issueBook(u,b);
                    break;

                case 5://RETURN_BOOK
                    System.out.print("\nEnter User ID: ");
                    long ID=in.nextLong();
                    u= L.members.get(ID);
                    System.out.print("\nEnter ISBN: ");
                    ISBN=in.nextLine();
                    b=L.book_record.get(ISBN);
                    L.returnBook(b);
                    break;

                case 6://EXIT_SYSYEM
                    System.out.println("All available books:");
                    L.showAllBooks();
                    break;

                case 7:
                    break OUTER;

            }
        }
    }
}

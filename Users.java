import java.util.*;

public abstract class Users {
    static private long ID_Member=312100012L;
    static private long ID_Staff=3121010120L;
    protected String name;
    protected String email;
    protected String password;

    //SET_ID_OF_MEMBER
    public static void setID_Member(long ID_Member) {
        Users.ID_Member = ID_Member;
    }
    //SET_ID_OF_STAFFS
    public static void setID_Staff(long ID_Staff) {
        Users.ID_Staff = ID_Staff;
    }
    //SET_NAME
    public void setName(String name) {
        this.name = name;
    }
    //SET_EMAIL
    public void setEmail(String email) {
        this.email = email;
    }

    //GET_ID_OF_MEMBERS
    public static long getID_Member() {
        return ID_Member;
    }
    //GET_ID_OF_Staffs
    public static long getID_Staff() {
        return ID_Staff;
    }
    //GET_Name_of_Users
    public String getName() {
        return name;
    }
    //GET_Email_of_Users
    public String getEmail() {
        return email;
    }
    //GET_Password_users
    public String getPassword() {
        return password;
    }

}

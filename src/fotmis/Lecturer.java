//management information system for university of ruhuna...
package fotmis;

/**
 *
 * @author Sujan
 */
public class Lecturer {
    private String Lec_id;
    private String name;
    private String department;
    private String subject;
    private String email;
    private String phone;
    private String address;
    private byte[] picture;

    public Lecturer(String Lec_id, String name, String department, String subject, String email, String phone, String address, byte[] picture) 
    {
        this.Lec_id = Lec_id;
        this.name = name;
        this.department = department;
        this.subject = subject;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.picture = picture;
    }
     Profile p1=new Profile();
   
     
    
}

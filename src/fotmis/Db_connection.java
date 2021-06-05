package fotmis;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Sujan
 */
public class Db_connection {
    public static Connection connect(){
        Connection conn = null;
        
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fot","root","");
            }
            catch(Exception e){
                System.out.println(e);
            }
        
        return conn;
    }
}

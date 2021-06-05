package fotmis;

import static fotmis.Login.txtUser;
import static fotmis.Login.txtpwd;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author Sujan
 */
public class SetProfile extends LecturerMain{
    PreparedStatement st;
    ResultSet rs1;

    //String password=jTextUserPwd.getText();
    public void SetUserProfile(){
    
           try{
            String sql ="SELECT * FROM `lecturers` where Lecturer_Id='"+txtUser.getText()+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            if(rs.next()){
                String Name=rs.getString("Lecturer_Name");
                String Dip=rs.getString("Department_name");
                String Sub=rs.getString("Subject");
                String Mail=rs.getString("Email");
                String Tel=rs.getString("Phone_Number");
                String Addr=rs.getString("Address");
                byte[] img=rs.getBytes("image");
                ImageIcon image=new ImageIcon(img);
                Image im=image.getImage();
                Image myImg=im.getScaledInstance(lbl_LecPic.getWidth(),lbl_LecPic.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newImage=new ImageIcon(myImg);
                lbl_LecPic.setIcon(newImage);
                lbl_LecName.setText(Name);
                lbl_LecDip.setText(Dip);
                lbl_LecSub.setText(Sub);
                lbl_LecEmail.setText(Mail);
                lbl_LecPhone.setText(Tel);
                lbl_LecAddress.setText(Addr);
               // rs=pst.executeQuery(sql);
                }
           }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
    }
    
    public void UserValidating(){
        // PreparedStatement st;
        //ResultSet rs;
        
        //get the user name & password
        String username=txtUser.getText();
        String password=txtpwd.getText();
        
        //create select query to check if the user name and password exits in the data base
        String query="SELECT * FROM `user` WHERE `user_id`=? AND `password`=?";
            try {
                st = conn.prepareStatement(query);
                st.setString(1,username);
                st.setString(2,password);
                rs=st.executeQuery();
                
                if(rs.next()){
                    //Show form
                    SetProfile LecProfile=new SetProfile();
                    LecturerMain Lform=new LecturerMain();
                    LecProfile.SetUserProfile();
                    Lform.setVisible(true);
                    Lform.pack();
                    Lform.setLocationRelativeTo(null);
                    
                    //close current form
                    this.dispose();
                }else{
                    //error message
                    JOptionPane.showMessageDialog(null,"Invalid User / Password","Login error",2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}

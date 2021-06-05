    package fotmis;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sujan
 */
public class Password extends LecturerMain{
       
    public void changeUserPassword(){
        String NewPwd=pwdNew.getText();
        String PwdCon=pwdConfirm.getText();
        //
        if(!"".equals(NewPwd) && !"".equals(PwdCon)&&(NewPwd.equals(PwdCon)) ){
             
                 try {
                   String UpdateQuery = "UPDATE user SET password =? WHERE user_id ='"+pwdUserId.getText()+"'";
                   pst =conn.prepareStatement(UpdateQuery);
                   pst.setString(1,PwdCon);
                   pst.executeUpdate();
                   JOptionPane.showMessageDialog(null, "Password Changed successfully...");
               } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null,ex.getMessage());
               } 
        pwdNew.setText("");
        pwdConfirm.setText("");
        jPanelChangePwd.setVisible(false);
        }
        else{
                JOptionPane.showMessageDialog(null,"check Inputs","Your Password not Matching! TryAgain!...",2);
        }
    }
    
}

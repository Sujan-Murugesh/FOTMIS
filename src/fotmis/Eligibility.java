package fotmis;

import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sujan
 */
public class Eligibility extends LecturerMain {
    public void showEligibility(){
        
        try{
           // String sql="SELECT * FROM `eligibility`";atten_eligibility
           String sql="SELECT * FROM `atten_eligibility`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            tbl_StuEligible.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}

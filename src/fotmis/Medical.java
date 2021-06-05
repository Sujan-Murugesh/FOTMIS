package fotmis;

import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sujan
 */
public class Medical extends LecturerMain{
     public void showMedical(){
        
            try{
            String sql ="SELECT * FROM `medical`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            jTableStu_Medical.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
}

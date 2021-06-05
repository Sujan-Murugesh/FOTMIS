package fotmis;

import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sujan
 */
public class Attendance extends LecturerMain{
 
        public void showAttendance(){
             String Attendance=(String)jComboAttendance.getSelectedItem();
             if("Select_Attendance".equals(Attendance)){
                AttenDisplay.removeAll();
                AttenDisplay.repaint();
                AttenDisplay.revalidate();
                 JOptionPane.showMessageDialog(null,"Please Select Attendance type");
             }
             else{
                 switch(Attendance){
                     case "Summary":
                AttenDisplay.removeAll();
                AttenDisplay.repaint();
                AttenDisplay.revalidate();

                AttenDisplay.add(Summary);
                AttenDisplay.repaint();
                AttenDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `attendence`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            tbl_summary.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
                         break;
                     case "Practical":
                AttenDisplay.removeAll();
                AttenDisplay.repaint();
                AttenDisplay.revalidate();

                AttenDisplay.add(practical);
                AttenDisplay.repaint();
                AttenDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `prac_attendence`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            tbl_practicalAtten.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
                         break;
                     case "Theory":
                AttenDisplay.removeAll();
                AttenDisplay.repaint();
                AttenDisplay.revalidate();

                AttenDisplay.add(Theory);
                AttenDisplay.repaint();
                AttenDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `theory_attendence`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            tbl_theoryAtten.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
                         break;
                 }
             }
         }
}

package fotmis;

import static fotmis.LecturerMain.c_code;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sujan
 */
public class Grade extends LecturerMain{
        
//=========================GET GRADES FROM MYSQL TABLES==================================================
       public void GradeDbms(){
           try{
            String sql ="SELECT Stu_id,FinalMarks,Grade FROM `final_result_dbms` where concat('Stu_id','FinalMarks','Grade')like '%Stu%'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            jTableGrade.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
       }
       
       public void GradeOoad(){
           try{
            String sql ="SELECT Stu_id,FinalMarks,Grade FROM `final_result_ooad` where concat('Stu_id','FinalMarks','Grade')like '%Stu%'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            jTableGrade.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
       }
       
       public void GradeCl(){
           try{
            String sql ="SELECT Stu_id,FinalMarks,Grade FROM `final_result_cl` where concat('Stu_id','FinalMarks','Grade')like '%Stu%'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            jTableGrade.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
       }
        
       public void GradeJava(){
           try{
            String sql ="SELECT Stu_id,FinalMarks,Grade FROM `final_result_java` where concat('Stu_id','FinalMarks','Grade')like '%Stu%'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            jTableGrade.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
       }
       
       public void GradeWebt(){
           try{
            String sql ="SELECT Stu_id,FinalMarks,Grade FROM `final_result_webt` where concat('Stu_id','FinalMarks','Grade')like '%Stu%'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            jTableGrade.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
       }
       
       public void GradeC(){
           try{
            String sql ="SELECT Stu_id,FinalMarks,Grade FROM `final_result_c` where concat('Stu_id','FinalMarks','Grade')like '%Stu%'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            jTableGrade.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
       }
//==========================================================================================================
        public void getFinalGrades(){
        String course=(String)c_code.getSelectedItem();
        if(("Select Subject Code".equals(course))){
            JOptionPane.showMessageDialog(null,"Please Select Course code");
        }
        else{
            switch(course){
                case "ICT1213":GradeDbms();       
                    break;
                case "ICT1223":GradeOoad();
                    break;
                case "ICT1232":GradeCl();
                    break;
                case "ICT1233":GradeJava();
                    break;
                case "ICT1242":GradeWebt();
                    break;
                case "ICT1243":GradeC();
                    break;
            }
        }
    }
//==========================================================================================================
}

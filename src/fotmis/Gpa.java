package fotmis;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Sujan
 */
public class Gpa extends LecturerMain{
    public static float dbmsGpa;
    public static float ooadGpa;
    public static float clGpa;
    public static float javaGpa;
    public static float webtGpa;
    public static float cGpa;
    public static float TotalGpa;
    public static String student;
    //=======================================================================================================
    public void getGpaDbms(){
        try{
            String sql ="SELECT Stu_id,GPA FROM `final_result_dbms` where Stu_id='"+jTextStu.getText()+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            if(rs.next()){
                        student=rs.getString("Stu_id");
                        dbmsGpa=rs.getFloat("GPA");
                    }
            }
           catch(SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    
    public void getGpaOoad(){
        try {
            String sql ="SELECT Stu_id,GPA FROM `final_result_ooad` where Stu_id='"+jTextStu.getText()+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            if(rs.next()){
            student=rs.getString("Stu_id");
            ooadGpa=rs.getFloat("GPA");
            }
        } catch(SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    
    public void getGpaCl(){
        try {
            String sql ="SELECT Stu_id,GPA FROM `final_result_cl` where Stu_id='"+jTextStu.getText()+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            if(rs.next()){
            student=rs.getString("Stu_id");
            clGpa=rs.getFloat("GPA");
            }
        }catch(SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    
    public void getGpaJava(){
        try {
            String sql ="SELECT Stu_id,GPA FROM `final_result_java` where Stu_id='"+jTextStu.getText()+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            if(rs.next()){
            student=rs.getString("Stu_id");
            javaGpa=rs.getFloat("GPA");
            }
        } catch(SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    
    public void getGpaWebt(){
        try {
            String sql ="SELECT Stu_id,GPA FROM `final_result_webt` where Stu_id='"+jTextStu.getText()+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            if(rs.next()){
            webtGpa=rs.getFloat("GPA");
            student=rs.getString("Stu_id");
            }
        } catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    
    public void getGpaC(){
        try {
            String sql ="SELECT Stu_id,GPA FROM `final_result_c` where Stu_id='"+jTextStu.getText()+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            if(rs.next()){
            student=rs.getString("Stu_id");
            cGpa=rs.getFloat("GPA");
            }
        } catch(SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    //=======================================================================================================
    public void getGpa(){
        getGpaDbms();
        getGpaOoad();
        getGpaCl();
        getGpaJava();
        getGpaWebt();
        getGpaC();
        TotalGpa=(float)((dbmsGpa+ooadGpa+clGpa+javaGpa+webtGpa+cGpa)/6);
        if("".equals(jTextStu.getText())){
            JOptionPane.showMessageDialog(null,"Please fillout the Student Id");
        }
        else{
        try {
            PreparedStatement ps=conn.prepareStatement("INSERT INTO `student_gpa`(Stu_id,ICT1213,ICT1223,ICT1232,ICT1233,ICT1242,ICT1243,TOTAL)values(?,?,?,?,?,?,?,?)");
                ps.setString(1,jTextStu.getText());
                ps.setFloat(2, dbmsGpa);
                ps.setFloat(3, ooadGpa);
                ps.setFloat(4, clGpa);
                ps.setFloat(5, javaGpa);
                ps.setFloat(6, webtGpa);
                ps.setFloat(7, cGpa);
                ps.setFloat(8, TotalGpa);
                ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "data is Inserted...");
                } 
            catch(SQLException ex) {
                  JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        
        
        //DefaultTableModel model=(DefaultTableModel)jTableGpa.getModel();
        //model.addRow(new Object[]{student,dbmsGpa,ooadGpa,clGpa,javaGpa,webtGpa,cGpa,TotalGpa}); 
        try{
            String sql ="SELECT * FROM `student_gpa` where concat('Stu_id')like '%Stu%'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            jTableGpa.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }
        

    public void show_Gpa(){
        try{
            String sql ="SELECT * FROM `student_gpa`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            jTableGpa.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
    }
  
    
}

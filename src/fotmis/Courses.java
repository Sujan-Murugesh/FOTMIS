package fotmis;

import java.awt.HeadlessException;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Sujan
 */
public class Courses extends LecturerMain{
    
    public static String res;
    public boolean courseInputCheck(){
        return !(jTextC_Lecture_Id==null ||
                jTextC_Lecture_name==null||
                jTextC_Lecture_hourse==null||
                jTextC_Practical_hours==null||
                res==null||
                jTextC_Lecture_weekno==null);
    }
    //=====================================================================================================
    public void chooiceResourse(){
        JFileChooser jfc= new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        JOptionPane.showMessageDialog(null,"You able to Select Multiple Files And Directories");
       
        jfc.setMultiSelectionEnabled(true);
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        int returnValue =jfc.showOpenDialog(null);
        if(returnValue == JFileChooser.APPROVE_OPTION){
            File[] files=jfc.getSelectedFiles();
           // JOptionPane.showMessageDialog(null,"Directories Selected");
            //System.out.println("Directories found");
            Arrays.asList(files).forEach(x->{
                if(x.isDirectory()){
                    res= x.getAbsolutePath();
                    //System.out.println(x.getName());
                    JOptionPane.showMessageDialog(null,x.getName());
                }
            });
           // JOptionPane.showMessageDialog(null,"Files Selected");
            //System.out.println("Files found");
            Arrays.asList(files).forEach(x->{
                if(x.isFile()){
                    //System.out.println(x.getName());
                    res= x.getAbsolutePath();
                    JOptionPane.showMessageDialog(null,x.getName());
                }
            });
            
        }
    }
    //=====================================================================================================
    public void insertCourse_Dbms(){
        try {
            PreparedStatement ps=conn.prepareStatement("INSERT INTO `course_dbms`(Lecture_id,Lecture_Name,Lecture_Hours,Practical_Hours,Resources,Week_Number)values(?,?,?,?,?,?)");
                ps.setInt(1,Integer.parseInt(jTextC_Lecture_Id.getText()));
                ps.setString(2,jTextC_Lecture_name.getText());
                ps.setInt(3,Integer.parseInt(jTextC_Lecture_hourse.getText()));
                ps.setInt(4,Integer.parseInt(jTextC_Practical_hours.getText()));
                byte[] bytes = res.getBytes();
                ps.setString(5,res);
                ps.setInt(6,Integer.parseInt(jTextC_Lecture_weekno.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "data is Inserted...");
        } catch (SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    //------------------
    public void insertCourse_Ooad(){
        try {
            PreparedStatement ps=conn.prepareStatement("INSERT INTO `course_ooad`(Lecture_id,Lecture_Name,Lecture_Hours,Practical_Hours,Resources,Week_Number)values(?,?,?,?,?,?)");
                ps.setInt(1,Integer.parseInt(jTextC_Lecture_Id.getText()));
                ps.setString(2,jTextC_Lecture_name.getText());
                ps.setInt(3,Integer.parseInt(jTextC_Lecture_hourse.getText()));
                ps.setInt(4,Integer.parseInt(jTextC_Practical_hours.getText()));
                byte[] bytes = res.getBytes();
                ps.setString(5,res);
                ps.setInt(6,Integer.parseInt(jTextC_Lecture_weekno.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "data is Inserted...");
        } catch (SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    //---------------------
    public void insertCourse_Cl(){
        try {
            PreparedStatement ps=conn.prepareStatement("INSERT INTO `course_cl`(Lecture_id,Lecture_Name,Lecture_Hours,Practical_Hours,Resources,Week_Number)values(?,?,?,?,?,?)");
                ps.setInt(1,Integer.parseInt(jTextC_Lecture_Id.getText()));
                ps.setString(2,jTextC_Lecture_name.getText());
                ps.setInt(3,Integer.parseInt(jTextC_Lecture_hourse.getText()));
                ps.setInt(4,Integer.parseInt(jTextC_Practical_hours.getText()));
                byte[] bytes = res.getBytes();
                ps.setString(5,res);
                ps.setInt(6,Integer.parseInt(jTextC_Lecture_weekno.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "data is Inserted...");
        } catch (SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    //---------------------
    public void insertCourse_Java(){
        try {
            PreparedStatement ps=conn.prepareStatement("INSERT INTO `course_java`(Lecture_id,Lecture_Name,Lecture_Hours,Practical_Hours,Resources,Week_Number)values(?,?,?,?,?,?)");
                ps.setInt(1,Integer.parseInt(jTextC_Lecture_Id.getText()));
                ps.setString(2,jTextC_Lecture_name.getText());
                ps.setInt(3,Integer.parseInt(jTextC_Lecture_hourse.getText()));
                ps.setInt(4,Integer.parseInt(jTextC_Practical_hours.getText()));
                byte[] bytes = res.getBytes();
                ps.setString(5,res);
                ps.setInt(6,Integer.parseInt(jTextC_Lecture_weekno.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "data is Inserted...");
        } catch (SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    //-----------------------
    public void insertCourse_Webt(){
        try {
            PreparedStatement ps=conn.prepareStatement("INSERT INTO `course_webt`(Lecture_id,Lecture_Name,Lecture_Hours,Practical_Hours,Resources,Week_Number)values(?,?,?,?,?,?)");
                ps.setInt(1,Integer.parseInt(jTextC_Lecture_Id.getText()));
                ps.setString(2,jTextC_Lecture_name.getText());
                ps.setInt(3,Integer.parseInt(jTextC_Lecture_hourse.getText()));
                ps.setInt(4,Integer.parseInt(jTextC_Practical_hours.getText()));
                byte[] bytes = res.getBytes();
                ps.setString(5,res);
                ps.setInt(6,Integer.parseInt(jTextC_Lecture_weekno.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "data is Inserted...");
        } catch (SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    //-------------------------
    public void insertCourse_C(){
        try {
            PreparedStatement ps=conn.prepareStatement("INSERT INTO `course_c`(Lecture_id,Lecture_Name,Lecture_Hours,Practical_Hours,Resources,Week_Number)values(?,?,?,?,?,?)");
                ps.setInt(1,Integer.parseInt(jTextC_Lecture_Id.getText()));
                ps.setString(2,jTextC_Lecture_name.getText());
                ps.setInt(3,Integer.parseInt(jTextC_Lecture_hourse.getText()));
                ps.setInt(4,Integer.parseInt(jTextC_Practical_hours.getText()));
                byte[] bytes = res.getBytes();
                ps.setString(5,res);
                ps.setInt(6,Integer.parseInt(jTextC_Lecture_weekno.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "data is Inserted...");
        } catch (SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    //=====================================================================================================
    public void inserting_Course(){
        String selectedCourse=(String)jComboBoxchCourse.getSelectedItem();
        if("Select Course Code".equals(selectedCourse)){
            JOptionPane.showMessageDialog(null,"Please Select A course Code...");
        }
        else if(!courseInputCheck()){
            JOptionPane.showMessageDialog(null,"Please Check Input feilds...");
        }
        else{
            switch(selectedCourse){
                case "ICT1213":insertCourse_Dbms();
                    break;
                case "ICT1223":insertCourse_Ooad();
                    break;
                case "ICT1232":insertCourse_Cl();
                    break;
                case "ICT1233":insertCourse_Java();
                    break;
                case "ICT1242":insertCourse_Webt();
                    break;
                case "ICT1243":insertCourse_C();
                    break;
            }
        }
    }
    //=====================================================================================================
    //UPDATING COURSE DATA
    public void updateCourse_Dbms(){
    String UpdateQuery =null;
    PreparedStatement ps =null;
        try {
          UpdateQuery="UPDATE `course_dbms` SET `Lecture_Name`=?,`Lecture_Hours`=?,`Practical_Hours`=?,`Resources`=?,`Week_Number`=? WHERE `Lecture_id`=?";
          ps =conn.prepareStatement(UpdateQuery);
            ps.setString(1,jTextC_Lecture_name.getText());
            ps.setString(2,jTextC_Lecture_hourse.getText());
            ps.setString(3,jTextC_Practical_hours.getText());
            byte[] bytes = res.getBytes();
            ps.setString(4,res);
            ps.setString(5,jTextC_Lecture_weekno.getText());
            ps.setString(6,jTextC_Lecture_Id.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "data is Updated...");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    //----------------------------
    public void updateCourse_Ooad(){
    String UpdateQuery =null;
    PreparedStatement ps =null;
        try {
          UpdateQuery="UPDATE `course_ooad` SET Lecture_Name=?,Lecture_Hours=?,Practical_Hours=?,Resources=?,Week_Number=? WHERE Lecture_id=?";
          ps =conn.prepareStatement(UpdateQuery);
            ps.setString(1,jTextC_Lecture_name.getText());
            ps.setString(2,jTextC_Lecture_hourse.getText());
            ps.setString(3,jTextC_Practical_hours.getText());
            byte[] bytes = res.getBytes();
            ps.setString(4,res);
            ps.setString(5,jTextC_Lecture_weekno.getText());
            ps.setString(6,jTextC_Lecture_Id.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "data is Updated...");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    //-----------------------------
    public void updateCourse_Cl(){
    String UpdateQuery =null;
    PreparedStatement ps =null;
        try {
          UpdateQuery="UPDATE `course_cl` SET `Lecture_Name`=?,`Lecture_Hours`=?,`Practical_Hours`=?,`Resources`=?,`Week_Number`=? WHERE `Lecture_id`=?";
          ps =conn.prepareStatement(UpdateQuery);
            ps.setString(1,jTextC_Lecture_name.getText());
            ps.setString(2,jTextC_Lecture_hourse.getText());
            ps.setString(3,jTextC_Practical_hours.getText());
            byte[] bytes = res.getBytes();
            ps.setString(4,res);
            ps.setString(5,jTextC_Lecture_weekno.getText());
            ps.setString(6,jTextC_Lecture_Id.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "data is Updated...");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    //------------------------
    public void updateCourse_Java(){
    String UpdateQuery =null;
    PreparedStatement ps =null;
        try {
          UpdateQuery="UPDATE `course_java` SET `Lecture_Name`=?,`Lecture_Hours`=?,`Practical_Hours`=?,`Resources`=?,`Week_Number`=? WHERE `Lecture_id`=?";
          ps =conn.prepareStatement(UpdateQuery);
            ps.setString(1,jTextC_Lecture_name.getText());
            ps.setString(2,jTextC_Lecture_hourse.getText());
            ps.setString(3,jTextC_Practical_hours.getText());
            byte[] bytes = res.getBytes();
            ps.setString(4,res);
            ps.setString(5,jTextC_Lecture_weekno.getText());
            ps.setString(6,jTextC_Lecture_Id.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "data is Updated...");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    //----------------------
    public void updateCourse_Webt(){
    String UpdateQuery =null;
    PreparedStatement ps =null;
        try {
          UpdateQuery="UPDATE `course_webt` SET `Lecture_Name`=?,`Lecture_Hours`=?,`Practical_Hours`=?,`Resources`=?,`Week_Number`=? WHERE `Lecture_id`=?";
          ps =conn.prepareStatement(UpdateQuery);
            ps.setString(1,jTextC_Lecture_name.getText());
            ps.setString(2,jTextC_Lecture_hourse.getText());
            ps.setString(3,jTextC_Practical_hours.getText());
            byte[] bytes = res.getBytes();
            ps.setString(4,res);
            ps.setString(5,jTextC_Lecture_weekno.getText());
            ps.setString(6,jTextC_Lecture_Id.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "data is Updated...");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    //--------------------------
    public void updateCourse_C(){
    String UpdateQuery =null;
    PreparedStatement ps =null;
        try {
          UpdateQuery="UPDATE `course_c` SET `Lecture_Name`=?,`Lecture_Hours`=?,`Practical_Hours`=?,`Resources`=?,`Week_Number`=? WHERE `Lecture_id`=?";
          ps =conn.prepareStatement(UpdateQuery);
            ps.setString(1,jTextC_Lecture_name.getText());
            ps.setString(2,jTextC_Lecture_hourse.getText());
            ps.setString(3,jTextC_Practical_hours.getText());
            byte[] bytes = res.getBytes();
            ps.setString(4,res);
            ps.setString(5,jTextC_Lecture_weekno.getText());
            ps.setString(6,jTextC_Lecture_Id.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "data is Updated...");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    //=====================================================================================================
    public void updating_Course(){
        String selectedCourse=(String)jComboBoxchCourse.getSelectedItem();
        if("Select Course Code".equals(selectedCourse)){
            JOptionPane.showMessageDialog(null,"Please Select A course Code...");
        }
        else{
            switch(selectedCourse){
                case "ICT1213":updateCourse_Dbms();
                    break;
                case "ICT1223":updateCourse_Ooad();
                    break;
                case "ICT1232":updateCourse_Cl();
                    break;
                case "ICT1233":updateCourse_Java();
                    break;
                case "ICT1242":updateCourse_Webt();
                    break;
                case "ICT1243":updateCourse_C();
                    break;
            }
        }
    }
    //=====================================================================================================
    public void deleteCourseRows(){
        String DeleteQuery =null;
        PreparedStatement ps =null;
        String selectedCourse=(String)jComboBoxchCourse.getSelectedItem();
     
        if("Select Course Code".equals(selectedCourse)){
            JOptionPane.showMessageDialog(null,"Please Select A course Code...");
        }
        else{
            int opt=JOptionPane.showConfirmDialog(null,"Are you sure to Delete?","Delete",JOptionPane.YES_NO_OPTION);
            if(opt==0){    
            switch(selectedCourse){
                case "ICT1213":
                    try {
                        DeleteQuery="DELETE FROM `course_dbms` WHERE Lecture_id='"+jTextC_Lecture_Id.getText()+"'";
                        ps =conn.prepareStatement(DeleteQuery);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Data Deteted Successfully...");
                    } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                     }
                    break;
                case "ICT1223":
                    try {
                        DeleteQuery="DELETE FROM `course_ooad` WHERE Lecture_id='"+jTextC_Lecture_Id.getText()+"'";
                        ps =conn.prepareStatement(DeleteQuery);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Data Deteted Successfully...");
                    } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                     }
                    break;
                case "ICT1232":
                    try {
                        DeleteQuery="DELETE FROM `course_cl` WHERE Lecture_id='"+jTextC_Lecture_Id.getText()+"'";
                        ps =conn.prepareStatement(DeleteQuery);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Data Deteted Successfully...");
                    } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                     }
                    break;
                case "ICT1233":
                    try {
                        DeleteQuery="DELETE FROM `course_java` WHERE Lecture_id='"+jTextC_Lecture_Id.getText()+"'";
                        ps =conn.prepareStatement(DeleteQuery);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Data Deteted...");
                    } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                     }
                    break;
                case "ICT1242":
                    try {
                        DeleteQuery="DELETE FROM `course_webt` WHERE Lecture_id='"+jTextC_Lecture_Id.getText()+"'";
                        ps =conn.prepareStatement(DeleteQuery);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Data Deteted Successfully...");
                    } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                     }
                    break;
                case "ICT1243":
                    try {
                        DeleteQuery="DELETE FROM `course_c` WHERE Lecture_id='"+jTextC_Lecture_Id.getText()+"'";
                        ps =conn.prepareStatement(DeleteQuery);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Data Deteted Successfully...");
                    } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                     }
                    break;
            }
        }
        }
    }
     //=====================================================================================================
}   

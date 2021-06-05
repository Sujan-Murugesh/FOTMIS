/*
 This System for Faculty of Technology ,University of ruhuna
 */
package fotmis;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sujan
 * 
 **/

public class LecturerMain extends javax.swing.JFrame {
    
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    static Attendance Obj1=new Attendance();
    static Eligibility E1=new Eligibility();
    static Marks AdQuiz=new Marks();
    static Marks UPQuiz=new Marks();
    static Marks AddAss=new Marks();
    static Marks UpAss=new Marks();
    static Marks AdMid=new Marks();
    static Marks UpMid=new Marks();
    static Marks AdFinal=new Marks();
    static Marks UpFinal=new Marks();
    static Medical medical=new Medical();
    static FinalResults finalresult=new FinalResults();
    static Grade grades=new Grade();
    static Gpa fgpa=new Gpa();
    static Gpa fgpa1=new Gpa();
    static Courses c=new Courses();
    static Courses insertcourse=new Courses();
    static Courses Upcourse=new Courses();
    static Courses Deletecourse=new Courses();
    static Password chpwd=new Password();
    static Notice ShNotice=new Notice();
    Clock Time=new Clock();
    //static SetProfile Pro=new SetProfile();
    

    /**
     * Creates new form LecturerMain
     */
    public LecturerMain() {
        initComponents();
         //connect to db
        conn=Db_connection.connect();
        QuizPanel.setVisible(false);
        FinalPanel.setVisible(false);
        AssessmentPanel.setVisible(false);
        MidPanel.setVisible(false);
        jPanelChangePwd.setVisible(false);
        WriteNoticePanel.setVisible(false);
        Set_Date_And_Time();
        //Pro.SetUserProfile();
        
    }
    
    

    
    
         String ImgPath = null;
    
    //check input feilds
        public boolean checkinput()
        {
            if(txt_name.getText() == null 
                    ||txt_lec_id.getText() == null
                    ||txt_email.getText() == null
                    ||txt_phone.getText() == null
                    ||txt_subject.getText() == null
                    ||Comp_Dep.getSelectedItem().toString() == null
               ){
                return false;
            }
            else{
                return true;
                } 
        }
        
         //Resize image
        public ImageIcon ResizeImage(String ImgPath,byte[] pic)
        {
            ImageIcon myImage= null;
            if(ImgPath != null)
            {
                myImage = new ImageIcon(ImgPath);
            }else
            {
                myImage =new ImageIcon(pic);
            }
            
            Image img= myImage.getImage();
            Image img2= img.getScaledInstance(lbl_image.getWidth(),lbl_image.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon image =new ImageIcon(img2);
            return image;
        }
        
        //display Student details in Jtable
        private void Update_table(){
        
            try{
            String sql ="SELECT * FROM `student`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            jTable_Student_details.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
        
        //Display DBMS Assessment Marks
         public void show_DBMS_AssMark(){
            marksDisplay.removeAll();
            marksDisplay.repaint();
            marksDisplay.revalidate();

            marksDisplay.add(showDbmsAssMarks);
            marksDisplay.repaint();
            marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `ass_marks_dbms`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_dbms_ass_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
         
         //Display DBMS QUIZ marks
         public void show_DBMS_QuizMark(){
                
                marksDisplay.removeAll();
                marksDisplay.repaint();
                marksDisplay.revalidate();

                marksDisplay.add(showDbmsQuizMarks);
                marksDisplay.repaint();
                marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `quiz_marks_dbms`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_dbms_Quiz_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
         
         //Display DBMS final marks
         public void show_DBMS_FinalMark(){
                
                marksDisplay.removeAll();
                marksDisplay.repaint();
                marksDisplay.revalidate();

                marksDisplay.add(showDbmsFinalMarks);
                marksDisplay.repaint();
                marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `final_marks_dbms`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_dbms_Final_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
        
         //display OOAD assessment marks
         public void show_OOAD_AssMark(){
         
                marksDisplay.removeAll();
                marksDisplay.repaint();
                marksDisplay.revalidate();

                marksDisplay.add(showOoadAssMarks);
                marksDisplay.repaint();
                marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `ass_marks_ooad`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_ooad_ass_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
         
         //Display ooad Quiz marks
         public void show_OOAD_QuizMark(){
             
            marksDisplay.removeAll();
            marksDisplay.repaint();
            marksDisplay.revalidate();

            marksDisplay.add(showOoadQuizMarks);
            marksDisplay.repaint();
            marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `quiz_marks_ooad`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_ooad_quiz_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
         }
         
         //Display ooad Mid marks 
         public void show_OOAD_MidMark(){
             
            marksDisplay.removeAll();
            marksDisplay.repaint();
            marksDisplay.revalidate();

            marksDisplay.add(showOoadMidMarks);
            marksDisplay.repaint();
            marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `mid_marks_ooad`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_ooad_mid_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
         }
         
         //Display ooad Final marks
         public void show_OOAD_FinalMark(){
         
            marksDisplay.removeAll();
            marksDisplay.repaint();
            marksDisplay.revalidate();

            marksDisplay.add(showOoadFinalMarks);
            marksDisplay.repaint();
            marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `final_marks_ooad`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_ooad_final_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            } 
         }
         
         //Display CL Assessment Marks
         public void show_CL_AssMark(){
            marksDisplay.removeAll();
            marksDisplay.repaint();
            marksDisplay.revalidate();

            marksDisplay.add(showClAssMarks);
            marksDisplay.repaint();
            marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `ass_marks_cl`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_cl_ass_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
         
         //Display CL QUIZ marks
         public void show_CL_QuizMark(){
                
                marksDisplay.removeAll();
                marksDisplay.repaint();
                marksDisplay.revalidate();

                marksDisplay.add(showClQuizMarks);
                marksDisplay.repaint();
                marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `quiz_marks_cl`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_Cl_Quiz_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
         
         //Display CL final marks
         public void show_CL_FinalMark(){
                
                marksDisplay.removeAll();
                marksDisplay.repaint();
                marksDisplay.revalidate();

                marksDisplay.add(showClFinalMarks);
                marksDisplay.repaint();
                marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `final_marks_cl`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_cl_Final_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
         
         //Display JAVA QUIZ marks
         public void show_JAVA_QuizMark(){
                
                marksDisplay.removeAll();
                marksDisplay.repaint();
                marksDisplay.revalidate();

                marksDisplay.add(showJavaQuizMarks);
                marksDisplay.repaint();
                marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `quiz_marks_java`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_Java_Quiz_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
         
         //Display JAVA final marks
         public void show_JAVA_FinalMark(){
                
                marksDisplay.removeAll();
                marksDisplay.repaint();
                marksDisplay.revalidate();

                marksDisplay.add(showJavaFinalMarks);
                marksDisplay.repaint();
                marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `final_marks_java`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_java_Final_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
         
         //Display JAVA Mid marks
         public void show_JAVA_MidMark(){
                
                marksDisplay.removeAll();
                marksDisplay.repaint();
                marksDisplay.revalidate();

                marksDisplay.add(showJavaMidMarks);
                marksDisplay.repaint();
                marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `mid_marks_java`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_java_mid_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
         
         //Display webt QUIZ marks
         public void show_WEBT_QuizMark(){
                
                marksDisplay.removeAll();
                marksDisplay.repaint();
                marksDisplay.revalidate();

                marksDisplay.add(showWebtQuizMarks);
                marksDisplay.repaint();
                marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `quiz_marks_webt`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_Webt_Quiz_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
         
         //Display WEBT Mid marks
         public void show_WEBT_MidMark(){
                
                marksDisplay.removeAll();
                marksDisplay.repaint();
                marksDisplay.revalidate();

                marksDisplay.add(showWebtMidMarks);
                marksDisplay.repaint();
                marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `mid_marks_webt`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_webt_mid_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
         
         //Display WEBT final marks
         public void show_WEBT_FinalMark(){
                
                marksDisplay.removeAll();
                marksDisplay.repaint();
                marksDisplay.revalidate();

                marksDisplay.add(showWebtFinalMarks);
                marksDisplay.repaint();
                marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `final_marks_webt`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_webt_Final_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
         
         //Display C final marks
         public void show_C_FinalMark(){
                
                marksDisplay.removeAll();
                marksDisplay.repaint();
                marksDisplay.revalidate();

                marksDisplay.add(showCFinalMarks);
                marksDisplay.repaint();
                marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `final_marks_c`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_c_Final_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
         
         //Display C Quiz marks
         public void show_C_QuizMark(){
                
                marksDisplay.removeAll();
                marksDisplay.repaint();
                marksDisplay.revalidate();

                marksDisplay.add(showCQuizMarks);
                marksDisplay.repaint();
                marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `quiz_marks_c`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_c_Quiz_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
         
         //display C assessment marks
         public void show_C_AssMark(){
         
                marksDisplay.removeAll();
                marksDisplay.repaint();
                marksDisplay.revalidate();

                marksDisplay.add(showCAssMarks);
                marksDisplay.repaint();
                marksDisplay.revalidate();
            try{
            String sql ="SELECT * FROM `ass_marks_c`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            Jtable_c_ass_marks.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
         
         //==============================
        public static void SwAtten(){
            Obj1.showAttendance();
        }
         //===============================
        
        //================================
            public void eligibility(){
                E1.showEligibility();
            }
        //================================
          public void AddQuiz_Marks(){
              AdQuiz.AddQuizMark();
          }
           
          public void Update_Quiz_Marks(){
              UPQuiz.updateQuizMarks();
          }
        //================================       
          public void Add_Ass_Marks(){
              AddAss.addAssessmentMarks();
          }
          
          public void Update_Ass_Marks(){
              UpAss.updateAssMarks();
          }
        //================================
          public void Add_Mid_Marks(){
              AdMid.addMidMarks();
          }
          public void Update_Mid_Marks(){
              UpMid.updatemidMarks();
          }
        //================================
          public void Add_Final_Marks(){
              AdFinal.AddFinalMarks();
          }
          
          public void Update_Final_Marks(){
              UpFinal.UpdateFinalMarks();
          }
        //================================
          public  void show_stu_medical(){
              medical.showMedical();
          }
        //================================
          public void set_final_results(){
              finalresult.setFinalResults();
          }
        //================================
          public void find_grade(){
              grades.getFinalGrades();
          }
        //================================
          public void find_gpa(){
              fgpa.getGpa();
          }
          
          public void showGpa(){
              fgpa1.show_Gpa();
          }
        //================================
          public void chFiles(){
              c.chooiceResourse();
          }
          
          public void insertCourses(){
              insertcourse.inserting_Course();
          }
          
          public void UpdateCourses(){
              Upcourse.updating_Course();
          }
          
          public void Delete_Course_Rows(){
              Deletecourse.deleteCourseRows();
          }
        //================================
          public void PwdChange(){
              chpwd.changeUserPassword();
          }
        //================================
          public void Show_Notice() throws SQLException, IOException{
              ShNotice.showNotice();
          }
          public void sh_notice_jtable(){
              ShNotice.setJtableNotice();
          }
          public void mouseClickNotice(){
              ShNotice.mouseClickAction();
          }
          
          public void ch_notice_dir(){
              ShNotice.chooiceNoticeDirectory();
          }
          
          public void Create_Notice() throws FileNotFoundException{
              ShNotice.createNotice();
          }
         
          public void Print_Notices(){
              ShNotice.printNotice();
          }
       //=================================
          private void Set_Date_And_Time(){
              Time.setTime();
          }
       //=================================
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        MainPanel = new javax.swing.JPanel();
        Ststic = new javax.swing.JPanel();
        btn_course = new javax.swing.JButton();
        btn_marks = new javax.swing.JButton();
        btn_student = new javax.swing.JButton();
        btn_notice = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_profile = new javax.swing.JButton();
        Title = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        DateLbl = new javax.swing.JLabel();
        TimeLbl1 = new javax.swing.JLabel();
        window = new javax.swing.JPanel();
        pWindow = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbl_LecName = new javax.swing.JLabel();
        lbl_LecDip = new javax.swing.JLabel();
        lbl_LecSub = new javax.swing.JLabel();
        lbl_LecEmail = new javax.swing.JLabel();
        lbl_LecPhone = new javax.swing.JLabel();
        lbl_LecAddress = new javax.swing.JLabel();
        lbl_LecPic = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanelChangePwd = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jButtonSavePwd = new javax.swing.JButton();
        jButtoncancelpwd = new javax.swing.JButton();
        pwdUserId = new javax.swing.JTextField();
        pwdOld = new javax.swing.JPasswordField();
        pwdNew = new javax.swing.JPasswordField();
        pwdConfirm = new javax.swing.JPasswordField();
        jLabel94 = new javax.swing.JLabel();
        jButton24 = new javax.swing.JButton();
        Profile_penal = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_subject = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_phone = new javax.swing.JTextField();
        Comp_Dep = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_address = new javax.swing.JTextArea();
        lbl_image = new javax.swing.JLabel();
        btn_image_choice = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_lec_id = new javax.swing.JTextField();
        jButton23 = new javax.swing.JButton();
        course_penal = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jTextC_Lecture_Id = new javax.swing.JTextField();
        jTextC_Lecture_name = new javax.swing.JTextField();
        jTextC_Lecture_hourse = new javax.swing.JTextField();
        jTextC_Practical_hours = new javax.swing.JTextField();
        jTextC_Lecture_weekno = new javax.swing.JTextField();
        jButtonChooseResourse = new javax.swing.JButton();
        jButtonAddCourse = new javax.swing.JButton();
        jButtonUpdateCourse = new javax.swing.JButton();
        jButtonDeleteCourse = new javax.swing.JButton();
        jComboBoxchCourse = new javax.swing.JComboBox<>();
        jLabel89 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        marks_penal = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        text_stu_id = new javax.swing.JTextField();
        combo_course = new javax.swing.JComboBox<>();
        btnAddQuiz = new javax.swing.JButton();
        btnAddAss = new javax.swing.JButton();
        btnAddMid = new javax.swing.JButton();
        btnAddFinal = new javax.swing.JButton();
        QuizPanel = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        txtQ1 = new javax.swing.JTextField();
        txtQ2 = new javax.swing.JTextField();
        txtQ3 = new javax.swing.JTextField();
        txtQ4 = new javax.swing.JTextField();
        btn_quiz_add = new javax.swing.JButton();
        btn_update_quiz = new javax.swing.JButton();
        btn_Q_clear = new javax.swing.JButton();
        AssessmentPanel = new javax.swing.JPanel();
        btn_update_ass = new javax.swing.JButton();
        btn_ass_add = new javax.swing.JButton();
        txtA3 = new javax.swing.JTextField();
        txtA2 = new javax.swing.JTextField();
        txtA1 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        btn_clear = new javax.swing.JButton();
        MidPanel = new javax.swing.JPanel();
        btn_Mid_add = new javax.swing.JButton();
        btn_update_mid = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        txtMid_t = new javax.swing.JTextField();
        txtMid_p = new javax.swing.JTextField();
        btn_mid_clear = new javax.swing.JButton();
        FinalPanel = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        txtFinal_t = new javax.swing.JTextField();
        txtFinal_p = new javax.swing.JTextField();
        btn_Final_add = new javax.swing.JButton();
        btn_update_final = new javax.swing.JButton();
        btn_final_clear = new javax.swing.JButton();
        student_penal = new javax.swing.JPanel();
        studentmain = new javax.swing.JPanel();
        btn_attendance = new javax.swing.JButton();
        btn_details = new javax.swing.JButton();
        btn_eligibility = new javax.swing.JButton();
        btn_marks1 = new javax.swing.JButton();
        btn_grade = new javax.swing.JButton();
        btn_gpa = new javax.swing.JButton();
        btn_medical = new javax.swing.JButton();
        StudentFormInro = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        Stu_Eligibility = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        tbl_StuEligible = new javax.swing.JTable();
        jButton18 = new javax.swing.JButton();
        Stu_Grade = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        btnSetFinalresults = new javax.swing.JButton();
        jtxt_stuid = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        c_code = new javax.swing.JComboBox<>();
        jScrollPane28 = new javax.swing.JScrollPane();
        jTableGrade = new javax.swing.JTable();
        jButtonfindGrade = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        Stu_marks = new javax.swing.JPanel();
        marksDisplay = new javax.swing.JPanel();
        SubjectForm = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        showOoadMidMarks = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        Jtable_ooad_mid_marks = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        showOoadFinalMarks = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Jtable_ooad_final_marks = new javax.swing.JTable();
        showDbmsAssMarks = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Jtable_dbms_ass_marks = new javax.swing.JTable();
        showDbmsFinalMarks = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Jtable_dbms_Final_marks = new javax.swing.JTable();
        showDbmsQuizMarks = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Jtable_dbms_Quiz_marks = new javax.swing.JTable();
        showOoadAssMarks = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Jtable_ooad_ass_marks = new javax.swing.JTable();
        showOoadQuizMarks = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Jtable_ooad_quiz_marks = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        showClAssMarks = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        Jtable_cl_ass_marks = new javax.swing.JTable();
        showClQuizMarks = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        Jtable_Cl_Quiz_marks = new javax.swing.JTable();
        showClFinalMarks = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        Jtable_cl_Final_marks = new javax.swing.JTable();
        showJavaQuizMarks = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        Jtable_Java_Quiz_marks = new javax.swing.JTable();
        showJavaFinalMarks = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        Jtable_java_Final_marks = new javax.swing.JTable();
        showJavaMidMarks = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        Jtable_java_mid_marks = new javax.swing.JTable();
        showWebtQuizMarks = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        Jtable_Webt_Quiz_marks = new javax.swing.JTable();
        showWebtFinalMarks = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        Jtable_webt_Final_marks = new javax.swing.JTable();
        showWebtMidMarks = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        Jtable_webt_mid_marks = new javax.swing.JTable();
        showCAssMarks = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        Jtable_c_ass_marks = new javax.swing.JTable();
        showCQuizMarks = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        Jtable_c_Quiz_marks = new javax.swing.JTable();
        showCFinalMarks = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        Jtable_c_Final_marks = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        com_select_course = new javax.swing.JComboBox<>();
        com_exam_type = new javax.swing.JComboBox<>();
        btn_search = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        Stu_medical = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jScrollPane27 = new javax.swing.JScrollPane();
        jTableStu_Medical = new javax.swing.JTable();
        btn_show_medical = new javax.swing.JButton();
        Stu_gpa = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane29 = new javax.swing.JScrollPane();
        jTableGpa = new javax.swing.JTable();
        jTextStu = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        StudentDetails = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_Student_details = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        Stu_Attendance = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jComboAttendance = new javax.swing.JComboBox<>();
        BtnAttendanceSearch = new javax.swing.JButton();
        AttenDisplay = new javax.swing.JPanel();
        AttendanceForm = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        Summary = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        tbl_summary = new javax.swing.JTable();
        Theory = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        tbl_theoryAtten = new javax.swing.JTable();
        practical = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        tbl_practicalAtten = new javax.swing.JTable();
        jButton17 = new javax.swing.JButton();
        notice_penal = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jTextNoticeId = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        NoticeArea = new javax.swing.JTextArea();
        WriteNoticePanel = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jTextnoticeTitle = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jComboFormat = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        add_date = new datechooser.beans.DateChooserCombo();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane30 = new javax.swing.JScrollPane();
        jTableNotice = new javax.swing.JTable();
        jButton22 = new javax.swing.JButton();
        WelCome = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 0, 255));
        jButton10.setText("Create Notice");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Ststic.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 255), null));

        btn_course.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/coursesicon.png"))); // NOI18N
        btn_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_courseActionPerformed(evt);
            }
        });

        btn_marks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/marksicon.png"))); // NOI18N
        btn_marks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_marksActionPerformed(evt);
            }
        });

        btn_student.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/studenticon.png"))); // NOI18N
        btn_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_studentActionPerformed(evt);
            }
        });

        btn_notice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/noticeicon.png"))); // NOI18N
        btn_notice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_noticeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Profile");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Course");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Marks");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Students");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Notice");

        btn_profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/profileicon.png"))); // NOI18N
        btn_profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_profileMouseClicked(evt);
            }
        });
        btn_profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_profileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StsticLayout = new javax.swing.GroupLayout(Ststic);
        Ststic.setLayout(StsticLayout);
        StsticLayout.setHorizontalGroup(
            StsticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StsticLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(StsticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StsticLayout.createSequentialGroup()
                        .addGroup(StsticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_course, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_marks, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_student, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_notice, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StsticLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StsticLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(78, 78, 78))))
            .addGroup(StsticLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StsticLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(StsticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StsticLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StsticLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(79, 79, 79))))
        );
        StsticLayout.setVerticalGroup(
            StsticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StsticLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btn_profile)
                .addGap(1, 1, 1)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_course, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_marks, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_student, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_notice, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Title.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 255), null));
        Title.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Engravers MT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("UNIVERSITY OF RUHUNA");
        Title.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("Faculty Of Technology Management Information System");
        Title.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, 40));

        jButton3.setBackground(new java.awt.Color(204, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/_logout.png"))); // NOI18N
        jButton3.setText("LogOut");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Title.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 50, -1, 40));

        jButton5.setBackground(new java.awt.Color(204, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 51, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_exit_sign_50px_1.png"))); // NOI18N
        jButton5.setText("Exit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        Title.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 109, 50));

        DateLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DateLbl.setForeground(new java.awt.Color(0, 0, 255));
        DateLbl.setText("1");
        Title.add(DateLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 110, 30));

        TimeLbl1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TimeLbl1.setForeground(new java.awt.Color(0, 0, 255));
        TimeLbl1.setText("1");
        Title.add(TimeLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 80, 30));

        window.setLayout(new java.awt.CardLayout());

        pWindow.setBackground(new java.awt.Color(153, 153, 255));
        pWindow.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                pWindowPropertyChange(evt);
            }
        });
        pWindow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Name ");
        pWindow.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 155, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("Department");
        pWindow.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 191, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Subject");
        pWindow.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 229, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Email");
        pWindow.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 265, 63, 28));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Phone_Number");
        pWindow.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 303, 119, 23));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Address");
        pWindow.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 346, -1, -1));

        lbl_LecName.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbl_LecName.setForeground(new java.awt.Color(51, 0, 255));
        pWindow.add(lbl_LecName, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 155, 260, 25));

        lbl_LecDip.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbl_LecDip.setForeground(new java.awt.Color(51, 0, 255));
        pWindow.add(lbl_LecDip, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 191, 260, 25));

        lbl_LecSub.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbl_LecSub.setForeground(new java.awt.Color(51, 0, 255));
        pWindow.add(lbl_LecSub, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 229, 260, 25));

        lbl_LecEmail.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbl_LecEmail.setForeground(new java.awt.Color(51, 0, 255));
        pWindow.add(lbl_LecEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 265, 260, 25));

        lbl_LecPhone.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbl_LecPhone.setForeground(new java.awt.Color(51, 0, 255));
        pWindow.add(lbl_LecPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 303, 260, 25));

        lbl_LecAddress.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbl_LecAddress.setForeground(new java.awt.Color(51, 0, 255));
        lbl_LecAddress.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_LecAddress.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pWindow.add(lbl_LecAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 346, 260, 52));
        pWindow.add(lbl_LecPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 11, 137, 126));

        jButton4.setBackground(new java.awt.Color(204, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/edit_profile.png"))); // NOI18N
        jButton4.setText("Edit Profile");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        pWindow.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, -1, 32));

        jPanelChangePwd.setBackground(new java.awt.Color(204, 204, 255));
        jPanelChangePwd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelChangePwd.setForeground(new java.awt.Color(255, 102, 255));

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setText("User Id");

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setText("Old Password");

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setText("New Password");

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setText("Conform New Password");

        jButtonSavePwd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonSavePwd.setForeground(new java.awt.Color(0, 0, 255));
        jButtonSavePwd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_save_as_30px.png"))); // NOI18N
        jButtonSavePwd.setText("Save Password");
        jButtonSavePwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSavePwdActionPerformed(evt);
            }
        });

        jButtoncancelpwd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtoncancelpwd.setForeground(new java.awt.Color(0, 0, 255));
        jButtoncancelpwd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_delete_sign_16px.png"))); // NOI18N
        jButtoncancelpwd.setText("Cancel");
        jButtoncancelpwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncancelpwdActionPerformed(evt);
            }
        });

        pwdUserId.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pwdUserId.setForeground(new java.awt.Color(51, 51, 255));
        pwdUserId.setEnabled(false);

        pwdOld.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pwdOld.setForeground(new java.awt.Color(0, 0, 255));
        pwdOld.setEnabled(false);

        pwdNew.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pwdNew.setForeground(new java.awt.Color(0, 0, 255));

        pwdConfirm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pwdConfirm.setForeground(new java.awt.Color(0, 0, 255));
        pwdConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdConfirmActionPerformed(evt);
            }
        });

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 0, 255));
        jLabel94.setText("You can Change Your Password here....");

        javax.swing.GroupLayout jPanelChangePwdLayout = new javax.swing.GroupLayout(jPanelChangePwd);
        jPanelChangePwd.setLayout(jPanelChangePwdLayout);
        jPanelChangePwdLayout.setHorizontalGroup(
            jPanelChangePwdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChangePwdLayout.createSequentialGroup()
                .addGroup(jPanelChangePwdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelChangePwdLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel90)
                        .addGap(153, 153, 153)
                        .addComponent(pwdUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelChangePwdLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel91)
                        .addGap(97, 97, 97)
                        .addComponent(pwdOld, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelChangePwdLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel92)
                        .addGap(86, 86, 86)
                        .addComponent(pwdNew, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelChangePwdLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel93)
                        .addGap(4, 4, 4)
                        .addComponent(pwdConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelChangePwdLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButtonSavePwd)
                        .addGap(19, 19, 19)
                        .addComponent(jButtoncancelpwd))
                    .addGroup(jPanelChangePwdLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel94)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanelChangePwdLayout.setVerticalGroup(
            jPanelChangePwdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChangePwdLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanelChangePwdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelChangePwdLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel90))
                    .addComponent(pwdUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanelChangePwdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel91)
                    .addComponent(pwdOld, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanelChangePwdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelChangePwdLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel92))
                    .addComponent(pwdNew, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanelChangePwdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelChangePwdLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel93))
                    .addComponent(pwdConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanelChangePwdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSavePwd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtoncancelpwd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pWindow.add(jPanelChangePwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, 355));

        jButton24.setBackground(new java.awt.Color(204, 255, 255));
        jButton24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton24.setForeground(new java.awt.Color(0, 0, 255));
        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/PwdCh.png"))); // NOI18N
        jButton24.setText("Change Password");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        pWindow.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, -1, 32));

        window.add(pWindow, "card3");

        Profile_penal.setBackground(new java.awt.Color(153, 153, 255));
        Profile_penal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Name");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Department");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Subject");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Email");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Phone_Number");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Address");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Image");

        txt_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_name.setEnabled(false);
        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        txt_subject.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txt_email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        txt_phone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_phoneActionPerformed(evt);
            }
        });

        Comp_Dep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Comp_Dep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Department", "BICT", "BST", "ENT" }));
        Comp_Dep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Comp_DepActionPerformed(evt);
            }
        });

        txt_address.setColumns(20);
        jScrollPane1.setViewportView(txt_address);

        lbl_image.setBackground(new java.awt.Color(0, 153, 153));
        lbl_image.setOpaque(true);

        btn_image_choice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_image_choice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/chooice.png"))); // NOI18N
        btn_image_choice.setText("chooice");
        btn_image_choice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_image_choiceActionPerformed(evt);
            }
        });

        btn_add.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/inserticon.png"))); // NOI18N
        btn_add.setText("Add Details");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("ID");

        txt_lec_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_lec_id.setEnabled(false);
        txt_lec_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lec_idActionPerformed(evt);
            }
        });

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_delete_sign_16px.png"))); // NOI18N
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel8))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(txt_phone)
                            .addComponent(txt_email)
                            .addComponent(txt_subject)
                            .addComponent(txt_name)
                            .addComponent(Comp_Dep, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_lec_id))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_image_choice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txt_lec_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Comp_Dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txt_subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel12)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel15))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_image_choice, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Profile_penal.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 450));

        window.add(Profile_penal, "card2");

        course_penal.setBackground(new java.awt.Color(153, 153, 255));
        course_penal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Course Details...");
        course_penal.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 7, -1, 43));
        jLabel48.getAccessibleContext().setAccessibleName("");

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 51, 255));
        jLabel20.setText("Lecture_id");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 255));
        jLabel21.setText("Lecture_Name");

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 51, 255));
        jLabel85.setText("Lecture_Hours");

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 51, 255));
        jLabel86.setText("Practical_Hours");

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 51, 255));
        jLabel87.setText("Resources");

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(0, 51, 255));
        jLabel88.setText("Week_Number  ");

        jTextC_Lecture_Id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextC_Lecture_Id.setForeground(new java.awt.Color(0, 0, 255));
        jTextC_Lecture_Id.setCaretColor(new java.awt.Color(204, 0, 204));
        jTextC_Lecture_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextC_Lecture_IdActionPerformed(evt);
            }
        });

        jTextC_Lecture_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextC_Lecture_name.setForeground(new java.awt.Color(0, 0, 255));
        jTextC_Lecture_name.setCaretColor(new java.awt.Color(204, 0, 204));

        jTextC_Lecture_hourse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextC_Lecture_hourse.setForeground(new java.awt.Color(0, 0, 255));
        jTextC_Lecture_hourse.setCaretColor(new java.awt.Color(204, 0, 204));

        jTextC_Practical_hours.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextC_Practical_hours.setForeground(new java.awt.Color(0, 0, 255));
        jTextC_Practical_hours.setCaretColor(new java.awt.Color(204, 0, 204));

        jTextC_Lecture_weekno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextC_Lecture_weekno.setForeground(new java.awt.Color(0, 0, 255));
        jTextC_Lecture_weekno.setCaretColor(new java.awt.Color(204, 0, 204));
        jTextC_Lecture_weekno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextC_Lecture_weeknoActionPerformed(evt);
            }
        });

        jButtonChooseResourse.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonChooseResourse.setForeground(new java.awt.Color(0, 0, 255));
        jButtonChooseResourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/Resourses_upload.png"))); // NOI18N
        jButtonChooseResourse.setText("Chooice");
        jButtonChooseResourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChooseResourseActionPerformed(evt);
            }
        });

        jButtonAddCourse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonAddCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/inserticon.png"))); // NOI18N
        jButtonAddCourse.setText("Add");
        jButtonAddCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCourseActionPerformed(evt);
            }
        });

        jButtonUpdateCourse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonUpdateCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_available_updates_16px.png"))); // NOI18N
        jButtonUpdateCourse.setText("Update");
        jButtonUpdateCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateCourseActionPerformed(evt);
            }
        });

        jButtonDeleteCourse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonDeleteCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_delete_sign_16px.png"))); // NOI18N
        jButtonDeleteCourse.setText("Delete");
        jButtonDeleteCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteCourseActionPerformed(evt);
            }
        });

        jComboBoxchCourse.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBoxchCourse.setForeground(new java.awt.Color(0, 51, 255));
        jComboBoxchCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course Code", "ICT1213", "ICT1223", "ICT1232", "ICT1233", "ICT1242", "ICT1243" }));

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(0, 51, 255));
        jLabel89.setText("Course");

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_erase_16px.png"))); // NOI18N
        jButton6.setText("Clear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel87)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel86, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel85))
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jButtonChooseResourse))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextC_Lecture_name)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextC_Lecture_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextC_Lecture_hourse, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                        .addComponent(jTextC_Practical_hours, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addComponent(jComboBoxchCourse, 0, 245, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel88)
                        .addGap(18, 18, 18)
                        .addComponent(jTextC_Lecture_weekno, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButtonAddCourse)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonUpdateCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDeleteCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)))
                .addGap(9, 9, 9))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxchCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel89))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextC_Lecture_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextC_Lecture_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextC_Lecture_hourse, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextC_Practical_hours, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel86))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(jTextC_Lecture_weekno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonChooseResourse, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddCourse)
                    .addComponent(jButtonUpdateCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeleteCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        course_penal.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 61, -1, -1));

        window.add(course_penal, "card2");

        marks_penal.setBackground(new java.awt.Color(153, 153, 255));
        marks_penal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setText("Student Marks Update");
        marks_penal.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel66.setText("Student ID");
        marks_penal.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 47, -1, -1));

        text_stu_id.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        text_stu_id.setCaretColor(new java.awt.Color(153, 204, 255));
        text_stu_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_stu_idActionPerformed(evt);
            }
        });
        marks_penal.add(text_stu_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 47, 122, -1));

        combo_course.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        combo_course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Subject Code", "ICT1213", "ICT1223", "ICT1232", "ICT1233", "ICT1242", "ICT1243" }));
        combo_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_courseActionPerformed(evt);
            }
        });
        marks_penal.add(combo_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 47, -1, 31));

        btnAddQuiz.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddQuiz.setText("Quiz");
        btnAddQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddQuizActionPerformed(evt);
            }
        });
        marks_penal.add(btnAddQuiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 47, -1, 31));

        btnAddAss.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddAss.setText("Assessment");
        btnAddAss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAssActionPerformed(evt);
            }
        });
        marks_penal.add(btnAddAss, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 47, -1, 31));

        btnAddMid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddMid.setText("Mid");
        btnAddMid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMidActionPerformed(evt);
            }
        });
        marks_penal.add(btnAddMid, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 47, -1, 31));

        btnAddFinal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddFinal.setText("Final");
        btnAddFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFinalActionPerformed(evt);
            }
        });
        marks_penal.add(btnAddFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(726, 47, -1, 31));

        QuizPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quiz", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel67.setText("Quiz 01");

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel68.setText("Quiz 02");

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel69.setText("Quiz 03");

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel70.setText("Quiz 04");

        txtQ1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtQ2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtQ3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtQ4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        btn_quiz_add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_quiz_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/inserticon.png"))); // NOI18N
        btn_quiz_add.setText("Add");
        btn_quiz_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quiz_addActionPerformed(evt);
            }
        });

        btn_update_quiz.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_update_quiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_available_updates_16px.png"))); // NOI18N
        btn_update_quiz.setText("Update");
        btn_update_quiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_quizActionPerformed(evt);
            }
        });

        btn_Q_clear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Q_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_erase_16px.png"))); // NOI18N
        btn_Q_clear.setText("Clear");
        btn_Q_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Q_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout QuizPanelLayout = new javax.swing.GroupLayout(QuizPanel);
        QuizPanel.setLayout(QuizPanelLayout);
        QuizPanelLayout.setHorizontalGroup(
            QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuizPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_quiz_add)
                    .addGroup(QuizPanelLayout.createSequentialGroup()
                        .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel67)
                            .addComponent(jLabel68)
                            .addComponent(jLabel69)
                            .addComponent(jLabel70))
                        .addGap(27, 27, 27)
                        .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQ4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQ3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQ2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQ1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btn_update_quiz)
                .addGap(18, 18, 18)
                .addComponent(btn_Q_clear)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        QuizPanelLayout.setVerticalGroup(
            QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuizPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel67)
                    .addComponent(txtQ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(txtQ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(txtQ3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(txtQ4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_quiz_add)
                    .addComponent(btn_update_quiz)
                    .addComponent(btn_Q_clear))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        marks_penal.add(QuizPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 89, -1, -1));

        AssessmentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Assessment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        AssessmentPanel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btn_update_ass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_update_ass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_available_updates_16px.png"))); // NOI18N
        btn_update_ass.setText("Update");
        btn_update_ass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_assActionPerformed(evt);
            }
        });

        btn_ass_add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_ass_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/inserticon.png"))); // NOI18N
        btn_ass_add.setText("Add");
        btn_ass_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ass_addActionPerformed(evt);
            }
        });

        txtA3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtA2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtA1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel72.setText("Assessment 03");

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel73.setText("Assessment 02");

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel74.setText("Assessment 01");

        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_erase_16px.png"))); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AssessmentPanelLayout = new javax.swing.GroupLayout(AssessmentPanel);
        AssessmentPanel.setLayout(AssessmentPanelLayout);
        AssessmentPanelLayout.setHorizontalGroup(
            AssessmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AssessmentPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(AssessmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel74)
                    .addComponent(jLabel73)
                    .addComponent(jLabel72))
                .addGap(27, 27, 27)
                .addGroup(AssessmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AssessmentPanelLayout.createSequentialGroup()
                        .addComponent(btn_ass_add)
                        .addGap(18, 18, 18)
                        .addComponent(btn_update_ass)
                        .addGap(18, 18, 18)
                        .addComponent(btn_clear))
                    .addComponent(txtA3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtA2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtA1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        AssessmentPanelLayout.setVerticalGroup(
            AssessmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AssessmentPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(AssessmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel74)
                    .addComponent(txtA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(AssessmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(txtA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AssessmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(txtA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(AssessmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ass_add)
                    .addComponent(btn_update_ass)
                    .addComponent(btn_clear))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        marks_penal.add(AssessmentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 91, -1, -1));

        MidPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mid", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        btn_Mid_add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Mid_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/inserticon.png"))); // NOI18N
        btn_Mid_add.setText("Add");
        btn_Mid_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Mid_addActionPerformed(evt);
            }
        });

        btn_update_mid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_update_mid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_available_updates_16px.png"))); // NOI18N
        btn_update_mid.setText("Update");
        btn_update_mid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_midActionPerformed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel75.setText("Mid Theory");

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel76.setText("Mid Practical");

        txtMid_t.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtMid_p.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        btn_mid_clear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_mid_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_erase_16px.png"))); // NOI18N
        btn_mid_clear.setText("Clear");
        btn_mid_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mid_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MidPanelLayout = new javax.swing.GroupLayout(MidPanel);
        MidPanel.setLayout(MidPanelLayout);
        MidPanelLayout.setHorizontalGroup(
            MidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MidPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(MidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel75)
                    .addComponent(jLabel76))
                .addGap(27, 27, 27)
                .addGroup(MidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MidPanelLayout.createSequentialGroup()
                        .addComponent(btn_Mid_add)
                        .addGap(18, 18, 18)
                        .addComponent(btn_update_mid)
                        .addGap(18, 18, 18)
                        .addComponent(btn_mid_clear))
                    .addComponent(txtMid_p, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMid_t, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        MidPanelLayout.setVerticalGroup(
            MidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MidPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(MidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel75)
                    .addComponent(txtMid_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(MidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(txtMid_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(MidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Mid_add)
                    .addComponent(btn_update_mid)
                    .addComponent(btn_mid_clear))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        marks_penal.add(MidPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 91, -1, -1));

        FinalPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Final", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel77.setText("Final Theory");

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel78.setText("Final Practical");

        txtFinal_t.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtFinal_p.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        btn_Final_add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Final_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/inserticon.png"))); // NOI18N
        btn_Final_add.setText("Add");
        btn_Final_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Final_addActionPerformed(evt);
            }
        });

        btn_update_final.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_update_final.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_available_updates_16px.png"))); // NOI18N
        btn_update_final.setText("Update");
        btn_update_final.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_finalActionPerformed(evt);
            }
        });

        btn_final_clear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_final_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_erase_16px.png"))); // NOI18N
        btn_final_clear.setText("Clear");
        btn_final_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_final_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FinalPanelLayout = new javax.swing.GroupLayout(FinalPanel);
        FinalPanel.setLayout(FinalPanelLayout);
        FinalPanelLayout.setHorizontalGroup(
            FinalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FinalPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(FinalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77)
                    .addComponent(jLabel78))
                .addGap(27, 27, 27)
                .addGroup(FinalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FinalPanelLayout.createSequentialGroup()
                        .addComponent(btn_Final_add)
                        .addGap(18, 18, 18)
                        .addComponent(btn_update_final)
                        .addGap(18, 18, 18)
                        .addComponent(btn_final_clear))
                    .addComponent(txtFinal_p, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFinal_t, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        FinalPanelLayout.setVerticalGroup(
            FinalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FinalPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(FinalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77)
                    .addComponent(txtFinal_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(FinalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(txtFinal_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(FinalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Final_add)
                    .addComponent(btn_update_final)
                    .addComponent(btn_final_clear))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        marks_penal.add(FinalPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 91, -1, -1));

        window.add(marks_penal, "card2");

        studentmain.setBackground(new java.awt.Color(153, 153, 255));
        studentmain.setMinimumSize(new java.awt.Dimension(827, 493));
        studentmain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_attendance.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_attendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/Attendence_icon.png"))); // NOI18N
        btn_attendance.setText("Attendence");
        btn_attendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_attendanceActionPerformed(evt);
            }
        });
        studentmain.add(btn_attendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 50));

        btn_details.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_details.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_content_16px.png"))); // NOI18N
        btn_details.setText("Details");
        btn_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_detailsActionPerformed(evt);
            }
        });
        studentmain.add(btn_details, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 120, 50));

        btn_eligibility.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_eligibility.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icon_eligible.png"))); // NOI18N
        btn_eligibility.setText("Eligibility");
        btn_eligibility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eligibilityActionPerformed(evt);
            }
        });
        studentmain.add(btn_eligibility, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 140, 50));

        btn_marks1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_marks1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons_marks.png"))); // NOI18N
        btn_marks1.setText("Marks");
        btn_marks1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_marks1ActionPerformed(evt);
            }
        });
        studentmain.add(btn_marks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 120, 50));

        btn_grade.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_grade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons_grade.png"))); // NOI18N
        btn_grade.setText("Grades");
        btn_grade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gradeActionPerformed(evt);
            }
        });
        studentmain.add(btn_grade, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 120, 50));

        btn_gpa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_gpa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons_gpa.png"))); // NOI18N
        btn_gpa.setText("GPA");
        btn_gpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gpaActionPerformed(evt);
            }
        });
        studentmain.add(btn_gpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 90, 50));

        btn_medical.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_medical.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons_medical.png"))); // NOI18N
        btn_medical.setText("Medical");
        btn_medical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_medicalActionPerformed(evt);
            }
        });
        studentmain.add(btn_medical, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 130, 50));

        StudentFormInro.setBackground(new java.awt.Color(153, 153, 255));
        StudentFormInro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText(",FACULTY OF TECHNOLOGY");
        StudentFormInro.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 290, -1, -1));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("You Can see All kind of Student Details ");
        StudentFormInro.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 49, -1, -1));

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/UORicon.png"))); // NOI18N
        StudentFormInro.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 129, -1, 150));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Just Click And Find it...");
        StudentFormInro.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 89, -1, -1));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("UNIVERSITY OF RUHUNA");
        StudentFormInro.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 290, -1, -1));

        studentmain.add(StudentFormInro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 790, 380));

        Stu_Eligibility.setBackground(new java.awt.Color(153, 153, 255));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Students  Eligibility");

        tbl_StuEligible.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stu_Id", "WebT_Eligibility", "Java_Eligibility", "Title 4", "C_Eligibility", "DBMS_Eligibility", "OOAD_Eligibility"
            }
        ));
        jScrollPane26.setViewportView(tbl_StuEligible);

        jButton18.setBackground(new java.awt.Color(102, 51, 255));
        jButton18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton18.setForeground(new java.awt.Color(51, 0, 255));
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/stu_back.png"))); // NOI18N
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Stu_EligibilityLayout = new javax.swing.GroupLayout(Stu_Eligibility);
        Stu_Eligibility.setLayout(Stu_EligibilityLayout);
        Stu_EligibilityLayout.setHorizontalGroup(
            Stu_EligibilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Stu_EligibilityLayout.createSequentialGroup()
                .addGroup(Stu_EligibilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Stu_EligibilityLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel22)
                        .addGap(465, 465, 465)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Stu_EligibilityLayout.setVerticalGroup(
            Stu_EligibilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stu_EligibilityLayout.createSequentialGroup()
                .addGroup(Stu_EligibilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        studentmain.add(Stu_Eligibility, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 523, 820, 410));

        Stu_Grade.setBackground(new java.awt.Color(153, 153, 255));
        Stu_Grade.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Student Grade");
        Stu_Grade.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jButton19.setBackground(new java.awt.Color(102, 51, 255));
        jButton19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton19.setForeground(new java.awt.Color(51, 0, 255));
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/stu_back.png"))); // NOI18N
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        Stu_Grade.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 51, 47));

        btnSetFinalresults.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSetFinalresults.setForeground(new java.awt.Color(0, 0, 255));
        btnSetFinalresults.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/inserticon.png"))); // NOI18N
        btnSetFinalresults.setText("AddFinalResults");
        btnSetFinalresults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetFinalresultsActionPerformed(evt);
            }
        });
        Stu_Grade.add(btnSetFinalresults, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 154, -1, 40));

        jtxt_stuid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_stuid.setForeground(new java.awt.Color(51, 51, 255));
        Stu_Grade.add(jtxt_stuid, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 55, 103, 28));

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(0, 0, 255));
        jLabel71.setText("Stu_id");
        Stu_Grade.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 53, 64, 29));

        c_code.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_code.setForeground(new java.awt.Color(0, 0, 255));
        c_code.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Subject Code", "ICT1213", "ICT1223", "ICT1232", "ICT1233", "ICT1242", "ICT1243" }));
        Stu_Grade.add(c_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 101, 171, 35));

        jTableGrade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stu_id", "Marks", "Grade"
            }
        ));
        jTableGrade.setColumnSelectionAllowed(true);
        jTableGrade.setOpaque(false);
        jScrollPane28.setViewportView(jTableGrade);
        jTableGrade.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        Stu_Grade.add(jScrollPane28, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 53, 480, 373));

        jButtonfindGrade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonfindGrade.setForeground(new java.awt.Color(0, 0, 255));
        jButtonfindGrade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/flash_light_find.png"))); // NOI18N
        jButtonfindGrade.setText("Find Grade");
        jButtonfindGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonfindGradeActionPerformed(evt);
            }
        });
        Stu_Grade.add(jButtonfindGrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 212, 171, 38));

        jLabel79.setText("Note: *Please select Subject Code And Student");

        jLabel80.setText("Id And Click AddFinalResult button to ");

        jLabel81.setText("Generate Student Final results.");

        jLabel82.setText("*If you want to see Student Grade just");

        jLabel83.setText("Select Course code and click \"FindGrade\"");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel79)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel83)
                    .addComponent(jLabel82)
                    .addComponent(jLabel81)
                    .addComponent(jLabel80))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel79)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel80)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel81)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel82)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel83)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        Stu_Grade.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        studentmain.add(Stu_Grade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1430, -1, -1));

        Stu_marks.setBackground(new java.awt.Color(153, 153, 255));
        Stu_marks.setMaximumSize(new java.awt.Dimension(823, 421));

        marksDisplay.setBackground(new java.awt.Color(153, 153, 255));
        marksDisplay.setLayout(new java.awt.CardLayout());

        SubjectForm.setBackground(new java.awt.Color(153, 153, 255));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Please Select Subject Code And Exam Type");

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/UORicon.png"))); // NOI18N

        javax.swing.GroupLayout SubjectFormLayout = new javax.swing.GroupLayout(SubjectForm);
        SubjectForm.setLayout(SubjectFormLayout);
        SubjectFormLayout.setHorizontalGroup(
            SubjectFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubjectFormLayout.createSequentialGroup()
                .addGroup(SubjectFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SubjectFormLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel41))
                    .addGroup(SubjectFormLayout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jLabel42)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        SubjectFormLayout.setVerticalGroup(
            SubjectFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubjectFormLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel42)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        marksDisplay.add(SubjectForm, "card3");

        Jtable_ooad_mid_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_ooad_mid_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_ooad_mid_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_ooad_mid_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STUDENT_ID", "Mid_Marks"
            }
        ));
        jScrollPane10.setViewportView(Jtable_ooad_mid_marks);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 255));
        jLabel40.setText("OOAD MID MARKS");

        javax.swing.GroupLayout showOoadMidMarksLayout = new javax.swing.GroupLayout(showOoadMidMarks);
        showOoadMidMarks.setLayout(showOoadMidMarksLayout);
        showOoadMidMarksLayout.setHorizontalGroup(
            showOoadMidMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showOoadMidMarksLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(showOoadMidMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        showOoadMidMarksLayout.setVerticalGroup(
            showOoadMidMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showOoadMidMarksLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel40)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        marksDisplay.add(showOoadMidMarks, "card3");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 255));
        jLabel37.setText("OOAD FINAL MARKS");

        Jtable_ooad_final_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_ooad_final_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_ooad_final_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_ooad_final_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STUDENT_ID", "Final_Marks"
            }
        ));
        jScrollPane7.setViewportView(Jtable_ooad_final_marks);

        javax.swing.GroupLayout showOoadFinalMarksLayout = new javax.swing.GroupLayout(showOoadFinalMarks);
        showOoadFinalMarks.setLayout(showOoadFinalMarksLayout);
        showOoadFinalMarksLayout.setHorizontalGroup(
            showOoadFinalMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showOoadFinalMarksLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(showOoadFinalMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        showOoadFinalMarksLayout.setVerticalGroup(
            showOoadFinalMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showOoadFinalMarksLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        marksDisplay.add(showOoadFinalMarks, "card5");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 255));
        jLabel34.setText("DBMS ASSESSMENT MARKS");

        Jtable_dbms_ass_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_dbms_ass_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_dbms_ass_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_dbms_ass_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STUDENT_ID", "ASSESSMENT _01", "ASSESSMENT_02", "ASSESSMENT_03"
            }
        ));
        jScrollPane4.setViewportView(Jtable_dbms_ass_marks);

        javax.swing.GroupLayout showDbmsAssMarksLayout = new javax.swing.GroupLayout(showDbmsAssMarks);
        showDbmsAssMarks.setLayout(showDbmsAssMarksLayout);
        showDbmsAssMarksLayout.setHorizontalGroup(
            showDbmsAssMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showDbmsAssMarksLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(showDbmsAssMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(259, Short.MAX_VALUE))
        );
        showDbmsAssMarksLayout.setVerticalGroup(
            showDbmsAssMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showDbmsAssMarksLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        marksDisplay.add(showDbmsAssMarks, "card3");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 255));
        jLabel36.setText("DBMS FINAL MARKS");

        Jtable_dbms_Final_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_dbms_Final_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_dbms_Final_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_dbms_Final_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STUDENT_ID", "Final_Prac_Marks", "Final_Thory_Marks"
            }
        ));
        jScrollPane6.setViewportView(Jtable_dbms_Final_marks);

        javax.swing.GroupLayout showDbmsFinalMarksLayout = new javax.swing.GroupLayout(showDbmsFinalMarks);
        showDbmsFinalMarks.setLayout(showDbmsFinalMarksLayout);
        showDbmsFinalMarksLayout.setHorizontalGroup(
            showDbmsFinalMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showDbmsFinalMarksLayout.createSequentialGroup()
                .addGroup(showDbmsFinalMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showDbmsFinalMarksLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel36))
                    .addGroup(showDbmsFinalMarksLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        showDbmsFinalMarksLayout.setVerticalGroup(
            showDbmsFinalMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showDbmsFinalMarksLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel36)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        marksDisplay.add(showDbmsFinalMarks, "card5");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 51, 255));
        jLabel35.setText("DBMS QUIZ MARKS");

        Jtable_dbms_Quiz_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_dbms_Quiz_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_dbms_Quiz_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_dbms_Quiz_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "stu_id", "Quiz_01", "Quiz_02", "Quiz_03"
            }
        ));
        jScrollPane5.setViewportView(Jtable_dbms_Quiz_marks);

        javax.swing.GroupLayout showDbmsQuizMarksLayout = new javax.swing.GroupLayout(showDbmsQuizMarks);
        showDbmsQuizMarks.setLayout(showDbmsQuizMarksLayout);
        showDbmsQuizMarksLayout.setHorizontalGroup(
            showDbmsQuizMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showDbmsQuizMarksLayout.createSequentialGroup()
                .addGroup(showDbmsQuizMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showDbmsQuizMarksLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(showDbmsQuizMarksLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel35)))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        showDbmsQuizMarksLayout.setVerticalGroup(
            showDbmsQuizMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showDbmsQuizMarksLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        marksDisplay.add(showDbmsQuizMarks, "card4");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 255));
        jLabel39.setText("OOAD ASSESSMENT MARKS");

        Jtable_ooad_ass_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_ooad_ass_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_ooad_ass_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_ooad_ass_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STUDENT_ID", "ASSESSMENT _01", "ASSESSMENT_02"
            }
        ));
        jScrollPane9.setViewportView(Jtable_ooad_ass_marks);

        javax.swing.GroupLayout showOoadAssMarksLayout = new javax.swing.GroupLayout(showOoadAssMarks);
        showOoadAssMarks.setLayout(showOoadAssMarksLayout);
        showOoadAssMarksLayout.setHorizontalGroup(
            showOoadAssMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showOoadAssMarksLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(showOoadAssMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        showOoadAssMarksLayout.setVerticalGroup(
            showOoadAssMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showOoadAssMarksLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        marksDisplay.add(showOoadAssMarks, "card3");

        Jtable_ooad_quiz_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_ooad_quiz_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_ooad_quiz_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_ooad_quiz_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "stu_id", "Quiz_01", "Quiz_02", "Quiz_03", "Quiz_04"
            }
        ));
        jScrollPane8.setViewportView(Jtable_ooad_quiz_marks);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 51, 255));
        jLabel38.setText("OOAD QUIZ MARKS");

        javax.swing.GroupLayout showOoadQuizMarksLayout = new javax.swing.GroupLayout(showOoadQuizMarks);
        showOoadQuizMarks.setLayout(showOoadQuizMarksLayout);
        showOoadQuizMarksLayout.setHorizontalGroup(
            showOoadQuizMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showOoadQuizMarksLayout.createSequentialGroup()
                .addGroup(showOoadQuizMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showOoadQuizMarksLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel38))
                    .addGroup(showOoadQuizMarksLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        showOoadQuizMarksLayout.setVerticalGroup(
            showOoadQuizMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showOoadQuizMarksLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel38)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        marksDisplay.add(showOoadQuizMarks, "card4");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 255));
        jLabel43.setText("CL ASSESSMENT MARKS");

        Jtable_cl_ass_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_cl_ass_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_cl_ass_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_cl_ass_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STUDENT_ID", "ASSESSMENT _01", "ASSESSMENT_02", "ASSESSMENT_03"
            }
        ));
        jScrollPane11.setViewportView(Jtable_cl_ass_marks);

        javax.swing.GroupLayout showClAssMarksLayout = new javax.swing.GroupLayout(showClAssMarks);
        showClAssMarks.setLayout(showClAssMarksLayout);
        showClAssMarksLayout.setHorizontalGroup(
            showClAssMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showClAssMarksLayout.createSequentialGroup()
                .addGroup(showClAssMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showClAssMarksLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel43))
                    .addGroup(showClAssMarksLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        showClAssMarksLayout.setVerticalGroup(
            showClAssMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showClAssMarksLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel43)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        marksDisplay.add(showClAssMarks, "card3");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 51, 255));
        jLabel44.setText("CL QUIZ MARKS");

        Jtable_Cl_Quiz_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_Cl_Quiz_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_Cl_Quiz_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_Cl_Quiz_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "stu_id", "Quiz_01", "Quiz_02", "Quiz_03"
            }
        ));
        jScrollPane12.setViewportView(Jtable_Cl_Quiz_marks);

        javax.swing.GroupLayout showClQuizMarksLayout = new javax.swing.GroupLayout(showClQuizMarks);
        showClQuizMarks.setLayout(showClQuizMarksLayout);
        showClQuizMarksLayout.setHorizontalGroup(
            showClQuizMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showClQuizMarksLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(showClQuizMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        showClQuizMarksLayout.setVerticalGroup(
            showClQuizMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showClQuizMarksLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        marksDisplay.add(showClQuizMarks, "card4");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 255));
        jLabel45.setText("CL FINAL MARKS");

        Jtable_cl_Final_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_cl_Final_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_cl_Final_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_cl_Final_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STUDENT_ID", "Final_Prac_Marks", "Final_Thory_Marks"
            }
        ));
        jScrollPane13.setViewportView(Jtable_cl_Final_marks);

        javax.swing.GroupLayout showClFinalMarksLayout = new javax.swing.GroupLayout(showClFinalMarks);
        showClFinalMarks.setLayout(showClFinalMarksLayout);
        showClFinalMarksLayout.setHorizontalGroup(
            showClFinalMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showClFinalMarksLayout.createSequentialGroup()
                .addGroup(showClFinalMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showClFinalMarksLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel45))
                    .addGroup(showClFinalMarksLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        showClFinalMarksLayout.setVerticalGroup(
            showClFinalMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showClFinalMarksLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel45)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        marksDisplay.add(showClFinalMarks, "card5");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 51, 255));
        jLabel46.setText("JAVA QUIZ MARKS");

        Jtable_Java_Quiz_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_Java_Quiz_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_Java_Quiz_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_Java_Quiz_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "stu_id", "Quiz_01", "Quiz_02", "Quiz_03"
            }
        ));
        jScrollPane14.setViewportView(Jtable_Java_Quiz_marks);

        javax.swing.GroupLayout showJavaQuizMarksLayout = new javax.swing.GroupLayout(showJavaQuizMarks);
        showJavaQuizMarks.setLayout(showJavaQuizMarksLayout);
        showJavaQuizMarksLayout.setHorizontalGroup(
            showJavaQuizMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showJavaQuizMarksLayout.createSequentialGroup()
                .addGroup(showJavaQuizMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showJavaQuizMarksLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel46))
                    .addGroup(showJavaQuizMarksLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(266, Short.MAX_VALUE))
        );
        showJavaQuizMarksLayout.setVerticalGroup(
            showJavaQuizMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showJavaQuizMarksLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        marksDisplay.add(showJavaQuizMarks, "card4");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 255));
        jLabel47.setText("JAVA FINAL MARKS");

        Jtable_java_Final_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_java_Final_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_java_Final_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_java_Final_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STUDENT_ID", "Final_Prac_Marks", "Final_Thory_Marks"
            }
        ));
        jScrollPane15.setViewportView(Jtable_java_Final_marks);

        javax.swing.GroupLayout showJavaFinalMarksLayout = new javax.swing.GroupLayout(showJavaFinalMarks);
        showJavaFinalMarks.setLayout(showJavaFinalMarksLayout);
        showJavaFinalMarksLayout.setHorizontalGroup(
            showJavaFinalMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showJavaFinalMarksLayout.createSequentialGroup()
                .addGroup(showJavaFinalMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showJavaFinalMarksLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(showJavaFinalMarksLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel47)))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        showJavaFinalMarksLayout.setVerticalGroup(
            showJavaFinalMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showJavaFinalMarksLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        marksDisplay.add(showJavaFinalMarks, "card5");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 0, 255));
        jLabel49.setText("JAVA MID MARKS");

        Jtable_java_mid_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_java_mid_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_java_mid_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_java_mid_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STUDENT_ID", "Mid_Prac_Marks", "Mid_Theory_Marks", "Mid_Marks"
            }
        ));
        jScrollPane16.setViewportView(Jtable_java_mid_marks);

        javax.swing.GroupLayout showJavaMidMarksLayout = new javax.swing.GroupLayout(showJavaMidMarks);
        showJavaMidMarks.setLayout(showJavaMidMarksLayout);
        showJavaMidMarksLayout.setHorizontalGroup(
            showJavaMidMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showJavaMidMarksLayout.createSequentialGroup()
                .addGroup(showJavaMidMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showJavaMidMarksLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel49))
                    .addGroup(showJavaMidMarksLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        showJavaMidMarksLayout.setVerticalGroup(
            showJavaMidMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showJavaMidMarksLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel49)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        marksDisplay.add(showJavaMidMarks, "card3");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 51, 255));
        jLabel50.setText("WEBT QUIZ MARKS");

        Jtable_Webt_Quiz_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_Webt_Quiz_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_Webt_Quiz_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_Webt_Quiz_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "stu_id", "Quiz_01", "Quiz_02", "Quiz_03"
            }
        ));
        jScrollPane17.setViewportView(Jtable_Webt_Quiz_marks);

        javax.swing.GroupLayout showWebtQuizMarksLayout = new javax.swing.GroupLayout(showWebtQuizMarks);
        showWebtQuizMarks.setLayout(showWebtQuizMarksLayout);
        showWebtQuizMarksLayout.setHorizontalGroup(
            showWebtQuizMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showWebtQuizMarksLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(showWebtQuizMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        showWebtQuizMarksLayout.setVerticalGroup(
            showWebtQuizMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showWebtQuizMarksLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        marksDisplay.add(showWebtQuizMarks, "card4");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 255));
        jLabel51.setText("WEBT FINAL MARKS");

        Jtable_webt_Final_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_webt_Final_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_webt_Final_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_webt_Final_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STUDENT_ID", "Final_Prac_Marks", "Final_Thory_Marks"
            }
        ));
        jScrollPane18.setViewportView(Jtable_webt_Final_marks);

        javax.swing.GroupLayout showWebtFinalMarksLayout = new javax.swing.GroupLayout(showWebtFinalMarks);
        showWebtFinalMarks.setLayout(showWebtFinalMarksLayout);
        showWebtFinalMarksLayout.setHorizontalGroup(
            showWebtFinalMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showWebtFinalMarksLayout.createSequentialGroup()
                .addGroup(showWebtFinalMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showWebtFinalMarksLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel51))
                    .addGroup(showWebtFinalMarksLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        showWebtFinalMarksLayout.setVerticalGroup(
            showWebtFinalMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showWebtFinalMarksLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel51)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        marksDisplay.add(showWebtFinalMarks, "card5");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 255));
        jLabel52.setText("WEBT MID MARKS");

        Jtable_webt_mid_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_webt_mid_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_webt_mid_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_webt_mid_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STUDENT_ID", "Mid_Prac_Marks", "Mid_Theory_Marks", "Mid_Marks"
            }
        ));
        jScrollPane19.setViewportView(Jtable_webt_mid_marks);

        javax.swing.GroupLayout showWebtMidMarksLayout = new javax.swing.GroupLayout(showWebtMidMarks);
        showWebtMidMarks.setLayout(showWebtMidMarksLayout);
        showWebtMidMarksLayout.setHorizontalGroup(
            showWebtMidMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showWebtMidMarksLayout.createSequentialGroup()
                .addGroup(showWebtMidMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showWebtMidMarksLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel52))
                    .addGroup(showWebtMidMarksLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        showWebtMidMarksLayout.setVerticalGroup(
            showWebtMidMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showWebtMidMarksLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel52)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        marksDisplay.add(showWebtMidMarks, "card3");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 255));
        jLabel53.setText("C ASSESSMENT MARKS");

        Jtable_c_ass_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_c_ass_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_c_ass_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_c_ass_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STUDENT_ID", "ASSESSMENT _01", "ASSESSMENT_02", "ASSESSMENT_03"
            }
        ));
        jScrollPane20.setViewportView(Jtable_c_ass_marks);

        javax.swing.GroupLayout showCAssMarksLayout = new javax.swing.GroupLayout(showCAssMarks);
        showCAssMarks.setLayout(showCAssMarksLayout);
        showCAssMarksLayout.setHorizontalGroup(
            showCAssMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showCAssMarksLayout.createSequentialGroup()
                .addGroup(showCAssMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showCAssMarksLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel53))
                    .addGroup(showCAssMarksLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        showCAssMarksLayout.setVerticalGroup(
            showCAssMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showCAssMarksLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel53)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        marksDisplay.add(showCAssMarks, "card3");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 51, 255));
        jLabel54.setText("C QUIZ MARKS");

        Jtable_c_Quiz_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_c_Quiz_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_c_Quiz_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_c_Quiz_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "stu_id", "Quiz_01", "Quiz_02", "Quiz_03"
            }
        ));
        jScrollPane21.setViewportView(Jtable_c_Quiz_marks);

        javax.swing.GroupLayout showCQuizMarksLayout = new javax.swing.GroupLayout(showCQuizMarks);
        showCQuizMarks.setLayout(showCQuizMarksLayout);
        showCQuizMarksLayout.setHorizontalGroup(
            showCQuizMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showCQuizMarksLayout.createSequentialGroup()
                .addGroup(showCQuizMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showCQuizMarksLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel54))
                    .addGroup(showCQuizMarksLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(262, Short.MAX_VALUE))
        );
        showCQuizMarksLayout.setVerticalGroup(
            showCQuizMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showCQuizMarksLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        marksDisplay.add(showCQuizMarks, "card4");

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 0, 255));
        jLabel55.setText("C FINAL MARKS");

        Jtable_c_Final_marks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        Jtable_c_Final_marks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jtable_c_Final_marks.setForeground(new java.awt.Color(51, 51, 255));
        Jtable_c_Final_marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STUDENT_ID", "Final_Prac_Marks", "Final_Thory_Marks"
            }
        ));
        jScrollPane22.setViewportView(Jtable_c_Final_marks);

        javax.swing.GroupLayout showCFinalMarksLayout = new javax.swing.GroupLayout(showCFinalMarks);
        showCFinalMarks.setLayout(showCFinalMarksLayout);
        showCFinalMarksLayout.setHorizontalGroup(
            showCFinalMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showCFinalMarksLayout.createSequentialGroup()
                .addGroup(showCFinalMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showCFinalMarksLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel55))
                    .addGroup(showCFinalMarksLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        showCFinalMarksLayout.setVerticalGroup(
            showCFinalMarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showCFinalMarksLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel55)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        marksDisplay.add(showCFinalMarks, "card5");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Student Marks");

        com_select_course.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        com_select_course.setForeground(new java.awt.Color(0, 0, 255));
        com_select_course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Subject", "ICT1213", "ICT1223", "ICT1232", "ICT1233", "ICT1242", "ICT1243" }));
        com_select_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_select_courseActionPerformed(evt);
            }
        });

        com_exam_type.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        com_exam_type.setForeground(new java.awt.Color(0, 0, 255));
        com_exam_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Exam", "Assessment", "Quiz", "Mid Term", "Final", " " }));

        btn_search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_search.setForeground(new java.awt.Color(0, 0, 255));
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_search_16px.png"))); // NOI18N
        btn_search.setText("search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(102, 51, 255));
        jButton14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton14.setForeground(new java.awt.Color(51, 0, 255));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/stu_back.png"))); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Stu_marksLayout = new javax.swing.GroupLayout(Stu_marks);
        Stu_marks.setLayout(Stu_marksLayout);
        Stu_marksLayout.setHorizontalGroup(
            Stu_marksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stu_marksLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel31)
                .addGap(61, 61, 61)
                .addComponent(com_select_course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(com_exam_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Stu_marksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Stu_marksLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(marksDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        Stu_marksLayout.setVerticalGroup(
            Stu_marksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stu_marksLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(Stu_marksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(com_select_course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(com_exam_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search))
                .addContainerGap(1367, Short.MAX_VALUE))
            .addGroup(Stu_marksLayout.createSequentialGroup()
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1355, Short.MAX_VALUE))
            .addGroup(Stu_marksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Stu_marksLayout.createSequentialGroup()
                    .addContainerGap(510, Short.MAX_VALUE)
                    .addComponent(marksDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(471, Short.MAX_VALUE)))
        );

        btn_search.getAccessibleContext().setAccessibleName("Search");

        studentmain.add(Stu_marks, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1440, 540, 1400));

        Stu_medical.setBackground(new java.awt.Color(153, 153, 255));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Student Medical");

        jButton12.setBackground(new java.awt.Color(102, 51, 255));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(51, 0, 255));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/stu_back.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jTableStu_Medical.setAutoCreateRowSorter(true);
        jTableStu_Medical.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTableStu_Medical.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medical_No", "Stu_id", "Type", "Medical_Date", "Sub_code"
            }
        ));
        jTableStu_Medical.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane27.setViewportView(jTableStu_Medical);
        if (jTableStu_Medical.getColumnModel().getColumnCount() > 0) {
            jTableStu_Medical.getColumnModel().getColumn(0).setHeaderValue("Medical_No");
            jTableStu_Medical.getColumnModel().getColumn(1).setHeaderValue("Stu_id");
            jTableStu_Medical.getColumnModel().getColumn(2).setHeaderValue("Type");
            jTableStu_Medical.getColumnModel().getColumn(3).setHeaderValue("Medical_Date");
            jTableStu_Medical.getColumnModel().getColumn(4).setHeaderValue("Sub_code");
        }

        btn_show_medical.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_show_medical.setForeground(new java.awt.Color(0, 0, 255));
        btn_show_medical.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/flash_light_find.png"))); // NOI18N
        btn_show_medical.setText("Show");
        btn_show_medical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_show_medicalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Stu_medicalLayout = new javax.swing.GroupLayout(Stu_medical);
        Stu_medical.setLayout(Stu_medicalLayout);
        Stu_medicalLayout.setHorizontalGroup(
            Stu_medicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stu_medicalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Stu_medicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Stu_medicalLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_show_medical)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 36, Short.MAX_VALUE))
        );
        Stu_medicalLayout.setVerticalGroup(
            Stu_medicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stu_medicalLayout.createSequentialGroup()
                .addGroup(Stu_medicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_show_medical))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        studentmain.add(Stu_medical, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 2429, -1, -1));

        Stu_gpa.setBackground(new java.awt.Color(153, 153, 255));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Student GPA");

        jButton15.setBackground(new java.awt.Color(102, 51, 255));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton15.setForeground(new java.awt.Color(51, 0, 255));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/stu_back.png"))); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/flash_light_find.png"))); // NOI18N
        jButton1.setText("SHOW GPA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTableGpa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stu_id", "ICT1213", "ICT1223", "ICT1232", "ICT1233", "ICT1242", "ICT1243", "TOTAL"
            }
        ));
        jScrollPane29.setViewportView(jTableGpa);

        jTextStu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextStu.setForeground(new java.awt.Color(0, 0, 255));

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel84.setText("Stu_Id");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 51, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/inserticon.png"))); // NOI18N
        jButton2.setText("AddGpa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Stu_gpaLayout = new javax.swing.GroupLayout(Stu_gpa);
        Stu_gpa.setLayout(Stu_gpaLayout);
        Stu_gpaLayout.setHorizontalGroup(
            Stu_gpaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stu_gpaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(Stu_gpaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Stu_gpaLayout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(689, 689, 689)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Stu_gpaLayout.createSequentialGroup()
                        .addComponent(jLabel84)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Stu_gpaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextStu)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        Stu_gpaLayout.setVerticalGroup(
            Stu_gpaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stu_gpaLayout.createSequentialGroup()
                .addGroup(Stu_gpaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGroup(Stu_gpaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Stu_gpaLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(Stu_gpaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel84)
                            .addComponent(jTextStu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Stu_gpaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        studentmain.add(Stu_gpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 2901, -1, 420));

        StudentDetails.setBackground(new java.awt.Color(153, 153, 255));
        StudentDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Student_details.setAutoCreateRowSorter(true);
        jTable_Student_details.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTable_Student_details.setForeground(new java.awt.Color(0, 0, 204));
        jTable_Student_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stu_id", "Stu_name", "Stu_Address", "Stu_tel", "Stu_Gender", "Department_Name", "Age"
            }
        ));
        jScrollPane3.setViewportView(jTable_Student_details);

        StudentDetails.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 727, 322));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Student Details");
        StudentDetails.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton16.setBackground(new java.awt.Color(102, 51, 255));
        jButton16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton16.setForeground(new java.awt.Color(51, 0, 255));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/stu_back.png"))); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        StudentDetails.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 50, 50));

        studentmain.add(StudentDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 840, 400));

        Stu_Attendance.setBackground(new java.awt.Color(153, 153, 255));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 51, 255));
        jLabel29.setText("Student Attendance");

        jComboAttendance.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboAttendance.setForeground(new java.awt.Color(0, 102, 255));
        jComboAttendance.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select_Attendance", "Summary", "Practical", "Theory" }));

        BtnAttendanceSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtnAttendanceSearch.setForeground(new java.awt.Color(0, 51, 255));
        BtnAttendanceSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_search_16px.png"))); // NOI18N
        BtnAttendanceSearch.setText("Search");
        BtnAttendanceSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAttendanceSearchActionPerformed(evt);
            }
        });

        AttenDisplay.setBackground(new java.awt.Color(153, 153, 255));
        AttenDisplay.setLayout(new java.awt.CardLayout());

        AttendanceForm.setBackground(new java.awt.Color(153, 153, 255));

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Please Select Attendance");

        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/UORicon.png"))); // NOI18N

        javax.swing.GroupLayout AttendanceFormLayout = new javax.swing.GroupLayout(AttendanceForm);
        AttendanceForm.setLayout(AttendanceFormLayout);
        AttendanceFormLayout.setHorizontalGroup(
            AttendanceFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttendanceFormLayout.createSequentialGroup()
                .addGroup(AttendanceFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AttendanceFormLayout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(jLabel65))
                    .addGroup(AttendanceFormLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel64)))
                .addContainerGap(274, Short.MAX_VALUE))
        );
        AttendanceFormLayout.setVerticalGroup(
            AttendanceFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttendanceFormLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel64)
                .addGap(27, 27, 27)
                .addComponent(jLabel65)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        AttenDisplay.add(AttendanceForm, "card3");

        Summary.setBackground(new java.awt.Color(153, 153, 255));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Student Attendance Summary");

        tbl_summary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Att_Index", "Stu_Id", "Tot_Days"
            }
        ));
        jScrollPane23.setViewportView(tbl_summary);

        javax.swing.GroupLayout SummaryLayout = new javax.swing.GroupLayout(Summary);
        Summary.setLayout(SummaryLayout);
        SummaryLayout.setHorizontalGroup(
            SummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SummaryLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(SummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addContainerGap(344, Short.MAX_VALUE))
        );
        SummaryLayout.setVerticalGroup(
            SummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SummaryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel61)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        AttenDisplay.add(Summary, "card2");

        Theory.setBackground(new java.awt.Color(153, 153, 255));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Student theory Attendance");

        tbl_theoryAtten.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stu_Id", "ICT1213_T", "ICT1223_T", "ICT1232_T", "ICT1233_T", "ICT1242_T", "ICT1243_T"
            }
        ));
        jScrollPane24.setViewportView(tbl_theoryAtten);

        javax.swing.GroupLayout TheoryLayout = new javax.swing.GroupLayout(Theory);
        Theory.setLayout(TheoryLayout);
        TheoryLayout.setHorizontalGroup(
            TheoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TheoryLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(TheoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(258, Short.MAX_VALUE))
        );
        TheoryLayout.setVerticalGroup(
            TheoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TheoryLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        AttenDisplay.add(Theory, "card2");

        practical.setBackground(new java.awt.Color(153, 153, 255));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Student Practical Attendance");

        tbl_practicalAtten.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stu_Id", "ICT1213_P", "ICT1232_P", "ICT1233_P", "ICT1242_P", "ICT1243_P"
            }
        ));
        jScrollPane25.setViewportView(tbl_practicalAtten);

        javax.swing.GroupLayout practicalLayout = new javax.swing.GroupLayout(practical);
        practical.setLayout(practicalLayout);
        practicalLayout.setHorizontalGroup(
            practicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(practicalLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(practicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63)
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(273, Short.MAX_VALUE))
        );
        practicalLayout.setVerticalGroup(
            practicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(practicalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        AttenDisplay.add(practical, "card2");

        jButton17.setBackground(new java.awt.Color(102, 51, 255));
        jButton17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton17.setForeground(new java.awt.Color(51, 0, 255));
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/stu_back.png"))); // NOI18N
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Stu_AttendanceLayout = new javax.swing.GroupLayout(Stu_Attendance);
        Stu_Attendance.setLayout(Stu_AttendanceLayout);
        Stu_AttendanceLayout.setHorizontalGroup(
            Stu_AttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stu_AttendanceLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel29)
                .addGap(41, 41, 41)
                .addComponent(jComboAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnAttendanceSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(AttenDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Stu_AttendanceLayout.setVerticalGroup(
            Stu_AttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stu_AttendanceLayout.createSequentialGroup()
                .addGroup(Stu_AttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Stu_AttendanceLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(Stu_AttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnAttendanceSearch)
                            .addComponent(jComboAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)))
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(AttenDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
        );

        studentmain.add(Stu_Attendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 523, 820, 410));

        javax.swing.GroupLayout student_penalLayout = new javax.swing.GroupLayout(student_penal);
        student_penal.setLayout(student_penalLayout);
        student_penalLayout.setHorizontalGroup(
            student_penalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentmain, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
        );
        student_penalLayout.setVerticalGroup(
            student_penalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentmain, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        window.add(student_penal, "card2");

        notice_penal.setBackground(new java.awt.Color(153, 153, 255));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Notices");

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel95.setText("Notice Number");

        jTextNoticeId.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextNoticeId.setForeground(new java.awt.Color(0, 0, 255));
        jTextNoticeId.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextNoticeId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNoticeIdActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/SearchNotice.png"))); // NOI18N
        jButton7.setText("Search");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        jScrollPane2.setForeground(new java.awt.Color(0, 0, 255));
        jScrollPane2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        NoticeArea.setBackground(new java.awt.Color(153, 255, 255));
        NoticeArea.setColumns(20);
        NoticeArea.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        NoticeArea.setRows(5);
        NoticeArea.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(NoticeArea);

        WriteNoticePanel.setBackground(new java.awt.Color(51, 102, 255));
        WriteNoticePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel96.setText("Title");

        jTextnoticeTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextnoticeTitle.setForeground(new java.awt.Color(0, 0, 204));
        jTextnoticeTitle.setCaretColor(new java.awt.Color(204, 255, 204));

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel97.setText("Date");

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton13.setForeground(new java.awt.Color(0, 0, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_save_as_30px.png"))); // NOI18N
        jButton13.setText("Save");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton20.setForeground(new java.awt.Color(0, 0, 255));
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_delete_sign_16px.png"))); // NOI18N
        jButton20.setText("Cancel");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton21.setForeground(new java.awt.Color(0, 0, 255));
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_erase_16px.png"))); // NOI18N
        jButton21.setText("Clear");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jComboFormat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboFormat.setForeground(new java.awt.Color(255, 255, 255));
        jComboFormat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Format", "pdf", "txt" }));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setForeground(new java.awt.Color(204, 204, 255));

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel98.setText("NOTE: This Sysytem Support to create PDF And TXT Formats.");

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel99.setText("Remember Most suitable is Txt Format...");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel98))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel99)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel98)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel99)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout WriteNoticePanelLayout = new javax.swing.GroupLayout(WriteNoticePanel);
        WriteNoticePanel.setLayout(WriteNoticePanelLayout);
        WriteNoticePanelLayout.setHorizontalGroup(
            WriteNoticePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WriteNoticePanelLayout.createSequentialGroup()
                .addGroup(WriteNoticePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WriteNoticePanelLayout.createSequentialGroup()
                        .addGroup(WriteNoticePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(WriteNoticePanelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel96)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextnoticeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(WriteNoticePanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel97)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(WriteNoticePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(WriteNoticePanelLayout.createSequentialGroup()
                                        .addComponent(jButton13)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton20)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton21))
                                    .addGroup(WriteNoticePanelLayout.createSequentialGroup()
                                        .addComponent(add_date, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WriteNoticePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        WriteNoticePanelLayout.setVerticalGroup(
            WriteNoticePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WriteNoticePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(WriteNoticePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextnoticeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel96))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(WriteNoticePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WriteNoticePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel97)
                        .addComponent(jComboFormat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(add_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(WriteNoticePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WriteNoticePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton21))
                    .addGroup(WriteNoticePanelLayout.createSequentialGroup()
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 0, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_view_details_30px.png"))); // NOI18N
        jButton8.setText("View");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 0, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_create_new_30px.png"))); // NOI18N
        jButton9.setText("Create Notice");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(0, 0, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_print_30px.png"))); // NOI18N
        jButton11.setText("Print");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableNotice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Date"
            }
        ));
        jTableNotice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNoticeMouseClicked(evt);
            }
        });
        jScrollPane30.setViewportView(jTableNotice);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane30, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );

        jButton22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton22.setForeground(new java.awt.Color(0, 0, 255));
        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotmis/img/icons8_erase_16px.png"))); // NOI18N
        jButton22.setText("Clear");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout notice_penalLayout = new javax.swing.GroupLayout(notice_penal);
        notice_penal.setLayout(notice_penalLayout);
        notice_penalLayout.setHorizontalGroup(
            notice_penalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notice_penalLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(notice_penalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(WriteNoticePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(notice_penalLayout.createSequentialGroup()
                .addComponent(jLabel95)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextNoticeId, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton22)
                .addGap(10, 10, 10)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        notice_penalLayout.setVerticalGroup(
            notice_penalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notice_penalLayout.createSequentialGroup()
                .addGroup(notice_penalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel95)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notice_penalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton22)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18))
                    .addComponent(jTextNoticeId, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(notice_penalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(notice_penalLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(WriteNoticePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(notice_penalLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane2))))
        );

        window.add(notice_penal, "card2");

        WelCome.setBackground(new java.awt.Color(153, 153, 255));
        WelCome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        window.add(WelCome, "card2");

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(Ststic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(window, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(window, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))
            .addComponent(Ststic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_marksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_marksActionPerformed
        
        window.removeAll();
        window.removeAll();
        window.repaint();
        window.revalidate();

        window.add(marks_penal);
        window.repaint();
        window.revalidate();
       // Marks m1=new Marks();
        //Desktop.add(m1).setVisible(true);
        
    }//GEN-LAST:event_btn_marksActionPerformed

    private void btn_noticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_noticeActionPerformed
        
        window.removeAll();
        window.removeAll();
        window.repaint();
        window.revalidate();

        window.add(notice_penal);
        window.repaint();
        window.revalidate();
       /* Desktop.removeAll();
        Notice n1=new Notice();
        Desktop.add(n1).setVisible(true);*/
        
    }//GEN-LAST:event_btn_noticeActionPerformed

    private void btn_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_courseActionPerformed
        
        window.removeAll();
        window.removeAll();
        window.repaint();
        window.revalidate();

        window.add(course_penal);
        window.repaint();
        window.revalidate();
       /* Desktop.removeAll();
        Courses c1=new Courses();
        Desktop.add(c1).setVisible(true);*/
        
    }//GEN-LAST:event_btn_courseActionPerformed

    private void btn_profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_profileActionPerformed
        
        window.removeAll();
        window.removeAll();
        window.repaint();
        window.revalidate();
        window.add(pWindow);
        
        //window.add(Profile_penal);
        window.repaint();
        window.revalidate();
       /* Desktop.removeAll();
        Profile p1=new Profile();
        Desktop.add(p1).setVisible(true);*/
        
        
    }//GEN-LAST:event_btn_profileActionPerformed

    private void btn_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_studentActionPerformed
        
        window.removeAll();
        window.removeAll();
        window.repaint();
        window.revalidate();

        window.add(student_penal);
        window.repaint();
        window.revalidate();
       /* Desktop.removeAll();
        Student s1=new Student();
        Desktop.add(s1).setVisible(true);*/
        
    }//GEN-LAST:event_btn_studentActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_phoneActionPerformed

    private void Comp_DepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Comp_DepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Comp_DepActionPerformed

    private void btn_image_choiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_image_choiceActionPerformed

        JFileChooser file =new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter =new FileNameExtensionFilter("*.images","jpg","png");
        int result = file.showSaveDialog(null);

        if(result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lbl_image.setIcon(ResizeImage(path,null));
            ImgPath =path;
        }
        else{
            System.out.println("No File selected..");
        }

    }//GEN-LAST:event_btn_image_choiceActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        String UpdateQuery =null;
        PreparedStatement ps =null;
        //insert data to database.
        if(checkinput() && ImgPath != null)
        {

            try {

//                PreparedStatement ps=conn.prepareStatement("INSERT INTO lecturers(lecturer_Id,lecturer_Name,Department_name,Subject,Email,Phone_Number,Address,image)values(?,?,?,?,?,?,?,?)");
//                ps.setString(1,txt_lec_id.getText());
//                ps.setString(2,txt_name.getText());
//                ps.setString(3,Comp_Dep.getSelectedItem().toString());
//                ps.setString(4,txt_subject.getText());
//                ps.setString(5,txt_email.getText());
//                ps.setString(6,txt_phone.getText());
//                ps.setString(7,txt_address.getText());
//
//                InputStream img=new FileInputStream(new File(ImgPath));
//                ps.setBlob(8, img);
//                ps.executeUpdate();
//                JOptionPane.showMessageDialog(null, "data is Inserted...");
                  
        //Here We want update paticular User Id update only....
                UpdateQuery="UPDATE `lecturers` SET `lecturer_Name`=?,`Department_name`=?,`Subject`=?,`Email`=?,`Phone_Number`=?,`Address`=?,`image`=? WHERE `lecturer_Id`=?";
                ps =conn.prepareStatement(UpdateQuery);
                
                ps.setString(1,txt_name.getText());
                ps.setString(2,Comp_Dep.getSelectedItem().toString());
                ps.setString(3,txt_subject.getText());
                ps.setString(4,txt_email.getText());
                ps.setString(5,txt_phone.getText());
                ps.setString(6,txt_address.getText());
                InputStream img=new FileInputStream(new File(ImgPath));
                ps.setBlob(7, img);
                ps.setString(8,txt_lec_id.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Your Profile Details Updated Successfully...");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        window.removeAll();
        window.repaint();
        window.revalidate();
        pWindow.repaint();
        pWindow.revalidate();
        window.add(pWindow);
        window.repaint();
        window.revalidate();
        }else{
            JOptionPane.showMessageDialog(null,"One or more fields are Empty");
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_profileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_profileMouseClicked

    private void pWindowPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_pWindowPropertyChange
        
 
           
        
    }//GEN-LAST:event_pWindowPropertyChange

    private void btn_eligibilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eligibilityActionPerformed
        window.removeAll();
        window.removeAll();
        window.repaint();
        window.revalidate();

        window.add(Stu_Eligibility);
        window.repaint();
        window.revalidate();
        setVisible(true);
        eligibility();
        
    }//GEN-LAST:event_btn_eligibilityActionPerformed

    private void btn_marks1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_marks1ActionPerformed
        
        window.removeAll();
        window.removeAll();
        window.repaint();
        window.revalidate();

        window.add(Stu_marks);
        window.repaint();
        window.revalidate();
    }//GEN-LAST:event_btn_marks1ActionPerformed

    private void btn_gradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gradeActionPerformed
        
        window.removeAll();
        window.removeAll();
        window.repaint();
        window.revalidate();

        window.add(Stu_Grade);
        window.repaint();
        window.revalidate();
    }//GEN-LAST:event_btn_gradeActionPerformed

    private void btn_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_detailsActionPerformed

        
        window.removeAll();
        window.removeAll();
        window.repaint();
        window.revalidate();

        window.add(StudentDetails);
        window.repaint();
        window.revalidate();
        
        Update_table();
        
        
        
        
    }//GEN-LAST:event_btn_detailsActionPerformed

    private void btn_gpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gpaActionPerformed
        window.removeAll();
        window.removeAll();
        window.repaint();
        window.revalidate();

        window.add(Stu_gpa);
        window.repaint();
        window.revalidate();
    }//GEN-LAST:event_btn_gpaActionPerformed

    private void btn_attendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_attendanceActionPerformed
        
        window.removeAll();
        window.removeAll();
        window.repaint();
        window.revalidate();

        window.add(Stu_Attendance);
        window.repaint();
        window.revalidate();
    }//GEN-LAST:event_btn_attendanceActionPerformed

    private void btn_medicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_medicalActionPerformed
        
        window.removeAll();
        window.removeAll();
        window.repaint();
        window.revalidate();

        window.add(Stu_medical);
        window.repaint();
        window.revalidate();
    }//GEN-LAST:event_btn_medicalActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        
        
        window.removeAll();
        window.repaint();
        window.revalidate();

        window.add(student_penal);
        window.repaint();
        window.revalidate();
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        
        String Subject=(String)com_select_course.getSelectedItem();
        String Marks=(String)com_exam_type.getSelectedItem();
        if((Subject==""&& Subject=="Select Subject") && (Marks=="" && Marks=="Select Exam")){
            JOptionPane.showMessageDialog(null,"Please select Subject & Exam Type");
        }
        else if("ICT1213".equals(Subject)){
            switch(Marks){
                case "Assessment":show_DBMS_AssMark();
                                break;
                case "Quiz":show_DBMS_QuizMark();      
                            break;
                case "Mid Term":marksDisplay.removeAll();
                                marksDisplay.repaint();
                                marksDisplay.revalidate();
                                JOptionPane.showMessageDialog(null,"This Course Do not Conduct Mid Term");
                                break;
                case "Final":show_DBMS_FinalMark();     
                            break;
                default:        marksDisplay.removeAll();
                                marksDisplay.repaint();
                                marksDisplay.revalidate();
                                JOptionPane.showMessageDialog(null,"Please Select Exam Type");
                            break;
            }
        }
        else if("ICT1223".equals(Subject)){
            switch(Marks){
                case "Assessment":show_OOAD_AssMark();
                                break;
                case "Quiz":show_OOAD_QuizMark();      
                            break;
                case "Mid Term":show_OOAD_MidMark();
                                break;
                case "Final":show_OOAD_FinalMark();     
                            break;
                default:        marksDisplay.removeAll();
                                marksDisplay.repaint();
                                marksDisplay.revalidate();
                                JOptionPane.showMessageDialog(null,"Please Select Exam Type");
                            break;
            }
        }
        else if("ICT1232".equals(Subject)){
            switch(Marks){
                case "Assessment":show_CL_AssMark();
                                break;
                case "Quiz":show_CL_QuizMark();      
                            break;
                case "Mid Term":marksDisplay.removeAll();
                                marksDisplay.repaint();
                                marksDisplay.revalidate();
                                JOptionPane.showMessageDialog(null,"This Course Do not Conduct Mid Term");
                                break;
                case "Final":show_CL_FinalMark();     
                            break;
                default:        marksDisplay.removeAll();
                                marksDisplay.repaint();
                                marksDisplay.revalidate();
                                JOptionPane.showMessageDialog(null,"Please Select Exam Type");
                            break;
            }
        }
        else if("ICT1233".equals(Subject)){
            switch(Marks){
                case "Assessment":marksDisplay.removeAll();
                                marksDisplay.repaint();
                                marksDisplay.revalidate();
                                JOptionPane.showMessageDialog(null,"This Course Do not Conduct Assessments");
                                break;
                case "Quiz":show_JAVA_QuizMark();      
                            break;
                case "Mid Term":show_JAVA_MidMark();
                                break;
                case "Final":show_JAVA_FinalMark();     
                            break;
                default:        marksDisplay.removeAll();
                                marksDisplay.repaint();
                                marksDisplay.revalidate();
                                JOptionPane.showMessageDialog(null,"Please Select Exam Type");
                            break;
            }
        }
        else if("ICT1242".equals(Subject)){
            switch(Marks){
                case "Assessment":marksDisplay.removeAll();
                                marksDisplay.repaint();
                                marksDisplay.revalidate();
                                JOptionPane.showMessageDialog(null,"This Course Do not Conduct Assessments");
                                break;
                case "Quiz":show_WEBT_QuizMark();      
                            break;
                case "Mid Term":show_WEBT_MidMark();
                                break;
                case "Final":show_WEBT_FinalMark();     
                            break;
                default:        marksDisplay.removeAll();
                                marksDisplay.repaint();
                                marksDisplay.revalidate();
                                JOptionPane.showMessageDialog(null,"Please Select Exam Type");
                            break;
            }
        }
        else if("ICT1243".equals(Subject)){
            switch(Marks){
                case "Assessment":show_C_AssMark();
                                break;
                case "Quiz":show_C_QuizMark();      
                            break;
                case "Mid Term":marksDisplay.removeAll();
                                marksDisplay.repaint();
                                marksDisplay.revalidate();
                                JOptionPane.showMessageDialog(null,"This Course Do not Conduct Mid Term");
                                break;
                case "Final":show_C_FinalMark();     
                            break;
                default:        marksDisplay.removeAll();
                                marksDisplay.repaint();
                                marksDisplay.revalidate();
                                JOptionPane.showMessageDialog(null,"Please Select Exam Type");
                            break;
            }
        }
        else{
                    marksDisplay.removeAll();
                    marksDisplay.repaint();
                    marksDisplay.revalidate();
            JOptionPane.showMessageDialog(null,"Select A Course And Exam Type");
        }
        
    }//GEN-LAST:event_btn_searchActionPerformed

    private void com_select_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_select_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_com_select_courseActionPerformed

    private void BtnAttendanceSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAttendanceSearchActionPerformed
        setVisible(true);
        SwAtten();
        
    }//GEN-LAST:event_BtnAttendanceSearchActionPerformed

    private void text_stu_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_stu_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_stu_idActionPerformed

    private void combo_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_courseActionPerformed

    private void btnAddQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddQuizActionPerformed
        
        AssessmentPanel.setVisible(false);
        MidPanel.setVisible(false);
        FinalPanel.setVisible(false);
        QuizPanel.setVisible(true);
        
    }//GEN-LAST:event_btnAddQuizActionPerformed

    private void btnAddAssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAssActionPerformed
        
        QuizPanel.setVisible(false);
        MidPanel.setVisible(false);
        FinalPanel.setVisible(false);
        AssessmentPanel.setVisible(true);
       
    }//GEN-LAST:event_btnAddAssActionPerformed

    private void btnAddMidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMidActionPerformed
        
        QuizPanel.setVisible(false);
        FinalPanel.setVisible(false);
        AssessmentPanel.setVisible(false);
        MidPanel.setVisible(true);
    }//GEN-LAST:event_btnAddMidActionPerformed

    private void btnAddFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFinalActionPerformed
        
        QuizPanel.setVisible(false);
        AssessmentPanel.setVisible(false);
        MidPanel.setVisible(false);
        FinalPanel.setVisible(true);
    }//GEN-LAST:event_btnAddFinalActionPerformed

    private void btn_quiz_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quiz_addActionPerformed
      
        AddQuiz_Marks();
        
    }//GEN-LAST:event_btn_quiz_addActionPerformed

    private void btn_update_quizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_quizActionPerformed
        
        Update_Quiz_Marks();
    }//GEN-LAST:event_btn_update_quizActionPerformed

    private void btn_ass_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ass_addActionPerformed
        Add_Ass_Marks();
    }//GEN-LAST:event_btn_ass_addActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
       
        txtA1.setText("");
        txtA2.setText("");
        txtA3.setText("");
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_Q_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Q_clearActionPerformed
        
        txtQ1.setText("");
        txtQ2.setText("");
        txtQ3.setText("");
        txtQ4.setText("");
        
    }//GEN-LAST:event_btn_Q_clearActionPerformed

    private void btn_update_assActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_assActionPerformed
        
        Update_Ass_Marks();
    }//GEN-LAST:event_btn_update_assActionPerformed

    private void btn_Mid_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Mid_addActionPerformed
        Add_Mid_Marks();
    }//GEN-LAST:event_btn_Mid_addActionPerformed

    private void btn_mid_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mid_clearActionPerformed
        
        txtMid_t.setText("");
        txtMid_p.setText("");
    }//GEN-LAST:event_btn_mid_clearActionPerformed

    private void btn_update_midActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_midActionPerformed
        Update_Mid_Marks();
    }//GEN-LAST:event_btn_update_midActionPerformed

    private void btn_Final_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Final_addActionPerformed
        
        Add_Final_Marks();
        
    }//GEN-LAST:event_btn_Final_addActionPerformed

    private void btn_update_finalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_finalActionPerformed
        
        Update_Final_Marks();
    }//GEN-LAST:event_btn_update_finalActionPerformed

    private void btn_final_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_final_clearActionPerformed
        txtFinal_t.setText("");
        txtFinal_p.setText("");
    }//GEN-LAST:event_btn_final_clearActionPerformed

    private void btn_show_medicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_show_medicalActionPerformed
        
        show_stu_medical();
    }//GEN-LAST:event_btn_show_medicalActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        window.removeAll();
        window.repaint();
        window.revalidate();

        window.add(student_penal);
        window.repaint();
        window.revalidate();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        window.removeAll();
        window.repaint();
        window.revalidate();

        window.add(student_penal);
        window.repaint();
        window.revalidate();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        window.removeAll();
        window.repaint();
        window.revalidate();

        window.add(student_penal);
        window.repaint();
        window.revalidate();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
       
        window.removeAll();
        window.repaint();
        window.revalidate();

        window.add(student_penal);
        window.repaint();
        window.revalidate();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        window.removeAll();
        window.repaint();
        window.revalidate();

        window.add(student_penal);
        window.repaint();
        window.revalidate();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        window.removeAll();
        window.repaint();
        window.revalidate();

        window.add(student_penal);
        window.repaint();
        window.revalidate();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void btnSetFinalresultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetFinalresultsActionPerformed
        
        
            set_final_results();
        
    }//GEN-LAST:event_btnSetFinalresultsActionPerformed

    private void jButtonfindGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonfindGradeActionPerformed
        
        find_grade();
    }//GEN-LAST:event_jButtonfindGradeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        showGpa();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        find_gpa();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonChooseResourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooseResourseActionPerformed
        chFiles();
    }//GEN-LAST:event_jButtonChooseResourseActionPerformed

    private void jTextC_Lecture_weeknoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextC_Lecture_weeknoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextC_Lecture_weeknoActionPerformed

    private void jTextC_Lecture_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextC_Lecture_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextC_Lecture_IdActionPerformed

    private void jButtonAddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCourseActionPerformed
       insertCourses();
    }//GEN-LAST:event_jButtonAddCourseActionPerformed

    private void jButtonUpdateCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateCourseActionPerformed
        UpdateCourses();
    }//GEN-LAST:event_jButtonUpdateCourseActionPerformed

    private void jButtonDeleteCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteCourseActionPerformed
        Delete_Course_Rows();
    }//GEN-LAST:event_jButtonDeleteCourseActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void txt_lec_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lec_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lec_idActionPerformed

    private void jButtoncancelpwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncancelpwdActionPerformed
        jPanelChangePwd.setVisible(false);
    }//GEN-LAST:event_jButtoncancelpwdActionPerformed

    private void jButtonSavePwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSavePwdActionPerformed
            PwdChange();
            
    }//GEN-LAST:event_jButtonSavePwdActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
                    Login out=new Login();
                    out.setVisible(true);
                    out.pack();
                    out.setLocationRelativeTo(null);
                    
                    //close current form
                    this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        window.removeAll();
        window.removeAll();
        window.repaint();
        window.revalidate();
       
        window.add(Profile_penal);
        window.add(Profile_penal).repaint();
        window.add(Profile_penal).revalidate();
        window.repaint();
        window.revalidate();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void pwdConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdConfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdConfirmActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        try {
            Db_connection.connect().close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jComboBoxchCourse.setSelectedItem("Select Course Code");
        jTextC_Lecture_name.setText("");
        jTextC_Lecture_Id.setText("");
        jTextC_Lecture_hourse.setText("");
        jTextC_Practical_hours.setText("");
        jTextC_Lecture_weekno.setText("");
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextNoticeIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNoticeIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNoticeIdActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        NoticeArea.setText("");
        try {
            Show_Notice();
        } catch (SQLException ex) {
            Logger.getLogger(LecturerMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LecturerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        NoticeArea.setText("");
        sh_notice_jtable();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTableNoticeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNoticeMouseClicked
        mouseClickNotice();
    }//GEN-LAST:event_jTableNoticeMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        WriteNoticePanel.setVisible(true);
        NoticeArea.setText("");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        WriteNoticePanel.setVisible(false);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

        try {
            Create_Notice();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        Print_Notices();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        NoticeArea.setText("");
        jTextnoticeTitle.setText("");
        jTextNoticeId.setText("");
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        NoticeArea.setText("");
        jTextnoticeTitle.setText("");
        jTextNoticeId.setText("");
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        window.removeAll();
        window.repaint();
        window.revalidate();
        pWindow.repaint();
        pWindow.revalidate();
        window.add(pWindow);
        window.repaint();
        window.revalidate();
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        
        jPanelChangePwd.setVisible(true);
    }//GEN-LAST:event_jButton24ActionPerformed

   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LecturerMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LecturerMain().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel AssessmentPanel;
    public static javax.swing.JPanel AttenDisplay;
    public static javax.swing.JPanel AttendanceForm;
    public static javax.swing.JButton BtnAttendanceSearch;
    private javax.swing.JComboBox<String> Comp_Dep;
    public static javax.swing.JLabel DateLbl;
    public static javax.swing.JPanel FinalPanel;
    private javax.swing.JTable Jtable_Cl_Quiz_marks;
    private javax.swing.JTable Jtable_Java_Quiz_marks;
    private javax.swing.JTable Jtable_Webt_Quiz_marks;
    private javax.swing.JTable Jtable_c_Final_marks;
    private javax.swing.JTable Jtable_c_Quiz_marks;
    private javax.swing.JTable Jtable_c_ass_marks;
    private javax.swing.JTable Jtable_cl_Final_marks;
    private javax.swing.JTable Jtable_cl_ass_marks;
    private javax.swing.JTable Jtable_dbms_Final_marks;
    private javax.swing.JTable Jtable_dbms_Quiz_marks;
    private javax.swing.JTable Jtable_dbms_ass_marks;
    private javax.swing.JTable Jtable_java_Final_marks;
    private javax.swing.JTable Jtable_java_mid_marks;
    private javax.swing.JTable Jtable_ooad_ass_marks;
    private javax.swing.JTable Jtable_ooad_final_marks;
    private javax.swing.JTable Jtable_ooad_mid_marks;
    private javax.swing.JTable Jtable_ooad_quiz_marks;
    private javax.swing.JTable Jtable_webt_Final_marks;
    private javax.swing.JTable Jtable_webt_mid_marks;
    private javax.swing.JPanel MainPanel;
    public static javax.swing.JPanel MidPanel;
    public static javax.swing.JTextArea NoticeArea;
    private javax.swing.JPanel Profile_penal;
    public static javax.swing.JPanel QuizPanel;
    private javax.swing.JPanel Ststic;
    public static javax.swing.JPanel Stu_Attendance;
    public static javax.swing.JPanel Stu_Eligibility;
    public static javax.swing.JPanel Stu_Grade;
    public static javax.swing.JPanel Stu_gpa;
    private javax.swing.JPanel Stu_marks;
    public static javax.swing.JPanel Stu_medical;
    private javax.swing.JPanel StudentDetails;
    private javax.swing.JPanel StudentFormInro;
    private javax.swing.JPanel SubjectForm;
    public static javax.swing.JPanel Summary;
    public static javax.swing.JPanel Theory;
    public static javax.swing.JLabel TimeLbl1;
    private javax.swing.JPanel Title;
    private javax.swing.JPanel WelCome;
    public static javax.swing.JPanel WriteNoticePanel;
    public static datechooser.beans.DateChooserCombo add_date;
    public static javax.swing.JButton btnAddAss;
    public static javax.swing.JButton btnAddFinal;
    public static javax.swing.JButton btnAddMid;
    public static javax.swing.JButton btnAddQuiz;
    public static javax.swing.JButton btnSetFinalresults;
    public static javax.swing.JButton btn_Final_add;
    public static javax.swing.JButton btn_Mid_add;
    public static javax.swing.JButton btn_Q_clear;
    private javax.swing.JButton btn_add;
    public static javax.swing.JButton btn_ass_add;
    private javax.swing.JButton btn_attendance;
    public static javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_course;
    private javax.swing.JButton btn_details;
    private javax.swing.JButton btn_eligibility;
    public static javax.swing.JButton btn_final_clear;
    private javax.swing.JButton btn_gpa;
    private javax.swing.JButton btn_grade;
    private javax.swing.JButton btn_image_choice;
    private javax.swing.JButton btn_marks;
    private javax.swing.JButton btn_marks1;
    private javax.swing.JButton btn_medical;
    public static javax.swing.JButton btn_mid_clear;
    private javax.swing.JButton btn_notice;
    private javax.swing.JButton btn_profile;
    public static javax.swing.JButton btn_quiz_add;
    private javax.swing.JButton btn_search;
    public static javax.swing.JButton btn_show_medical;
    private javax.swing.JButton btn_student;
    public static javax.swing.JButton btn_update_ass;
    public static javax.swing.JButton btn_update_final;
    public static javax.swing.JButton btn_update_mid;
    public static javax.swing.JButton btn_update_quiz;
    public static javax.swing.JComboBox<String> c_code;
    private javax.swing.JComboBox<String> com_exam_type;
    private javax.swing.JComboBox<String> com_select_course;
    public static javax.swing.JComboBox<String> combo_course;
    private javax.swing.JPanel course_penal;
    public static javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    public static javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    public static javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton20;
    public static javax.swing.JButton jButton21;
    public static javax.swing.JButton jButton22;
    public static javax.swing.JButton jButton23;
    public static javax.swing.JButton jButton24;
    public static javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton4;
    public static javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    public static javax.swing.JButton jButton7;
    public static javax.swing.JButton jButton8;
    public static javax.swing.JButton jButton9;
    public static javax.swing.JButton jButtonAddCourse;
    public static javax.swing.JButton jButtonChooseResourse;
    public static javax.swing.JButton jButtonDeleteCourse;
    private javax.swing.JButton jButtonSavePwd;
    public static javax.swing.JButton jButtonUpdateCourse;
    private javax.swing.JButton jButtoncancelpwd;
    public static javax.swing.JButton jButtonfindGrade;
    public static javax.swing.JComboBox<String> jComboAttendance;
    public static javax.swing.JComboBox<String> jComboBoxchCourse;
    public static javax.swing.JComboBox<String> jComboFormat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    public javax.swing.JLabel jLabel67;
    public javax.swing.JLabel jLabel68;
    public javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    public javax.swing.JLabel jLabel72;
    public javax.swing.JLabel jLabel73;
    public javax.swing.JLabel jLabel74;
    public javax.swing.JLabel jLabel75;
    public javax.swing.JLabel jLabel76;
    public javax.swing.JLabel jLabel77;
    public javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public static javax.swing.JPanel jPanelChangePwd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    public static javax.swing.JScrollPane jScrollPane23;
    public static javax.swing.JScrollPane jScrollPane24;
    public static javax.swing.JScrollPane jScrollPane25;
    public static javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public static javax.swing.JTable jTableGpa;
    public static javax.swing.JTable jTableGrade;
    public static javax.swing.JTable jTableNotice;
    public static javax.swing.JTable jTableStu_Medical;
    private javax.swing.JTable jTable_Student_details;
    public static javax.swing.JTextField jTextC_Lecture_Id;
    public static javax.swing.JTextField jTextC_Lecture_hourse;
    public static javax.swing.JTextField jTextC_Lecture_name;
    public static javax.swing.JTextField jTextC_Lecture_weekno;
    public static javax.swing.JTextField jTextC_Practical_hours;
    public static javax.swing.JTextField jTextNoticeId;
    public static javax.swing.JTextField jTextStu;
    public static javax.swing.JTextField jTextnoticeTitle;
    public static javax.swing.JTextField jtxt_stuid;
    public static javax.swing.JLabel lbl_LecAddress;
    public static javax.swing.JLabel lbl_LecDip;
    public static javax.swing.JLabel lbl_LecEmail;
    public static javax.swing.JLabel lbl_LecName;
    public static javax.swing.JLabel lbl_LecPhone;
    public static javax.swing.JLabel lbl_LecPic;
    public static javax.swing.JLabel lbl_LecSub;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JPanel marksDisplay;
    public static javax.swing.JPanel marks_penal;
    private javax.swing.JPanel notice_penal;
    public static javax.swing.JPanel pWindow;
    public static javax.swing.JPanel practical;
    public static javax.swing.JPasswordField pwdConfirm;
    public static javax.swing.JPasswordField pwdNew;
    public static javax.swing.JPasswordField pwdOld;
    public static javax.swing.JTextField pwdUserId;
    private javax.swing.JPanel showCAssMarks;
    private javax.swing.JPanel showCFinalMarks;
    private javax.swing.JPanel showCQuizMarks;
    private javax.swing.JPanel showClAssMarks;
    private javax.swing.JPanel showClFinalMarks;
    private javax.swing.JPanel showClQuizMarks;
    private javax.swing.JPanel showDbmsAssMarks;
    private javax.swing.JPanel showDbmsFinalMarks;
    private javax.swing.JPanel showDbmsQuizMarks;
    private javax.swing.JPanel showJavaFinalMarks;
    private javax.swing.JPanel showJavaMidMarks;
    private javax.swing.JPanel showJavaQuizMarks;
    private javax.swing.JPanel showOoadAssMarks;
    private javax.swing.JPanel showOoadFinalMarks;
    private javax.swing.JPanel showOoadMidMarks;
    private javax.swing.JPanel showOoadQuizMarks;
    private javax.swing.JPanel showWebtFinalMarks;
    private javax.swing.JPanel showWebtMidMarks;
    private javax.swing.JPanel showWebtQuizMarks;
    private javax.swing.JPanel student_penal;
    private javax.swing.JPanel studentmain;
    public static javax.swing.JTable tbl_StuEligible;
    public static javax.swing.JTable tbl_practicalAtten;
    public static javax.swing.JTable tbl_summary;
    public static javax.swing.JTable tbl_theoryAtten;
    public static javax.swing.JTextField text_stu_id;
    public static javax.swing.JTextField txtA1;
    public static javax.swing.JTextField txtA2;
    public static javax.swing.JTextField txtA3;
    public static javax.swing.JTextField txtFinal_p;
    public static javax.swing.JTextField txtFinal_t;
    public static javax.swing.JTextField txtMid_p;
    public static javax.swing.JTextField txtMid_t;
    public static javax.swing.JTextField txtQ1;
    public static javax.swing.JTextField txtQ2;
    public static javax.swing.JTextField txtQ3;
    public static javax.swing.JTextField txtQ4;
    private javax.swing.JTextArea txt_address;
    private javax.swing.JTextField txt_email;
    public static javax.swing.JTextField txt_lec_id;
    public static javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_phone;
    private javax.swing.JTextField txt_subject;
    private javax.swing.JPanel window;
    // End of variables declaration//GEN-END:variables

   
}

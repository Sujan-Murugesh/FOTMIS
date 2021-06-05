package fotmis;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sujan
 */
public class Marks extends LecturerMain{

    
   
   
    //=====================Quiz Mark Add===========================================
    public boolean checkQuizInputs(){
        return !(txtQ1.getText()==null 
                ||txtQ2.getText()==null
                ||txtQ3.getText()==null);    
    }
    public void  AddQuizMark(){
        String AddStuId=text_stu_id.getText();
        String AddCourseCode=(String)combo_course.getSelectedItem();
        if((AddStuId==null) || ("Select Subject Code".equals(AddCourseCode))){
            JOptionPane.showMessageDialog(null,"Please fillout the StuId And Select Course code");
        }
        else{
        switch(AddCourseCode){
            case "ICT1213":
                            if(checkQuizInputs()==true || txtQ4==null){
                                try {
                                    PreparedStatement ps=conn.prepareStatement("INSERT INTO `quiz_marks_dbms`(Stu_id,Q1,Q2,Q3)values(?,?,?,?)");
                                    ps.setString(1,text_stu_id.getText());
                                    ps.setString(2,txtQ1.getText());
                                    ps.setString(3,txtQ2.getText());
                                    ps.setString(4,txtQ3.getText());
                                    ps.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "data is Inserted...");
                                }
                                catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null,ex.getMessage());
                                }
                            }else{
                                JOptionPane.showMessageDialog(null,"Please check input feilds");
                            }
                            
                break;
            case "ICT1223":
                            if(checkQuizInputs()==true  || txtQ4!=null){
                                try {
                                    PreparedStatement ps=conn.prepareStatement("INSERT INTO `quiz_marks_ooad`(Stu_id,Q1,Q2,Q3,Q4)values(?,?,?,?,?)");
                                    ps.setString(1,text_stu_id.getText());
                                    ps.setString(2,txtQ1.getText());
                                    ps.setString(3,txtQ2.getText());
                                    ps.setString(4,txtQ3.getText());
                                    ps.setString(5,txtQ4.getText());
                                    ps.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "data is Inserted...");
                                } 
                                catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null,ex.getMessage());
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Please fillout the marks feilds");
                            }
                break;
            case "ICT1232":                        
                            if(checkQuizInputs()==true || txtQ4==null){
                                try {
                                    PreparedStatement ps=conn.prepareStatement("INSERT INTO `quiz_marks_cl`(Stu_id,Q1,Q2,Q3)values(?,?,?,?)");
                                    ps.setString(1,text_stu_id.getText());
                                    ps.setString(2,txtQ1.getText());
                                    ps.setString(3,txtQ2.getText());
                                    ps.setString(4,txtQ3.getText());
                                    ps.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "data is Inserted...");
                                } 
                                catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null,ex.getMessage());
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Please fillout the marks feilds");
                            }
                break;
            case "ICT1233":
                            
                            if(checkQuizInputs()==true || txtQ4==null){
                                try {
                                    PreparedStatement ps=conn.prepareStatement("INSERT INTO `quiz_marks_java`(Stu_id,Q1,Q2,Q3)values(?,?,?,?)");
                                    ps.setString(1,text_stu_id.getText());
                                    ps.setString(2,txtQ1.getText());
                                    ps.setString(3,txtQ2.getText());
                                    ps.setString(4,txtQ3.getText());
                                    ps.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "data is Inserted...");
                                } 
                                catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null,ex.getMessage());
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Please fillout the marks feilds");
                            }
                break;
            case "ICT1242":
                            
                            if(checkQuizInputs()==true || txtQ4==null){
                                try {
                                    PreparedStatement ps=conn.prepareStatement("INSERT INTO `quiz_marks_webt`(Stu_id,Q1,Q2,Q3)values(?,?,?,?)");
                                    ps.setString(1,text_stu_id.getText());
                                    ps.setString(2,txtQ1.getText());
                                    ps.setString(3,txtQ2.getText());
                                    ps.setString(4,txtQ3.getText());
                                    ps.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "data is Inserted...");
                                }
                                catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null,ex.getMessage());
                                }
                            }else{
                                JOptionPane.showMessageDialog(null,"Please fillout the marks feilds");
                            }
                break;
            case "ICT1243":
                            
                            if(checkQuizInputs()==true || txtQ4==null){
                                try {
                                    PreparedStatement ps=conn.prepareStatement("INSERT INTO `quiz_marks_c`(Stu_id,Q1,Q2,Q3)values(?,?,?,?)");
                                    ps.setString(1,text_stu_id.getText());
                                    ps.setString(2,txtQ1.getText());
                                    ps.setString(3,txtQ2.getText());
                                    ps.setString(4,txtQ3.getText());
                                    ps.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "data is Inserted...");
                                } 
                                catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null,ex.getMessage());
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Please fillout the marks feilds");
                            }
                break;
        }
        }
    }
    
    //===================QUIZ MARKS UPDATE====================================
    public void updateQuizMarks(){
        
        String UpdateQuery =null;
        PreparedStatement ps =null;
        String AddStuId=text_stu_id.getText();
        String AddCourseCode=(String)combo_course.getSelectedItem();
        
        if((AddStuId==null) || ("Select Subject Code".equals(AddCourseCode))){
         
            JOptionPane.showMessageDialog(null,"Please Check StuID & CourseCode Feilds");
        }
        else{
            switch(AddCourseCode){
                case "ICT1213": if(checkQuizInputs()&& text_stu_id!=null){
                    try {
                            UpdateQuery = "UPDATE quiz_marks_dbms SET Q1 =?,Q2 =?,Q3 =? WHERE Stu_id =?";
                                ps =conn.prepareStatement(UpdateQuery);

                                    ps.setString(1,txtQ1.getText());
                                    ps.setString(2,txtQ2.getText());
                                    ps.setString(3,txtQ3.getText());
                                    ps.setString(4,text_stu_id.getText());
                                    ps.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "data is Updated...");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Check Input feields");
                }
                    break;
                case "ICT1223":if((checkQuizInputs() || txtQ4.getText()==null) && (AddStuId!=null)){
                    try {
                            UpdateQuery = "UPDATE quiz_marks_ooad SET Q1 =?,Q2 =?,Q3 =?,Q4 =? WHERE Stu_id =?";
                                ps =conn.prepareStatement(UpdateQuery);

                                    ps.setString(1,txtQ1.getText());
                                    ps.setString(2,txtQ2.getText());
                                    ps.setString(3,txtQ3.getText());
                                    ps.setString(4,txtQ4.getText());
                                    ps.setString(5,text_stu_id.getText());
                                    ps.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "data is Updated...");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Check Input feields");
                }
                    break;
                case "ICT1232":if(checkQuizInputs()&& text_stu_id!=null){
                    try {
                            UpdateQuery = "UPDATE quiz_marks_cl SET Q1 =?,Q2 =?,Q3 =? WHERE Stu_id =?";
                                ps =conn.prepareStatement(UpdateQuery);

                                    ps.setString(1,txtQ1.getText());
                                    ps.setString(2,txtQ2.getText());
                                    ps.setString(3,txtQ3.getText());
                                    ps.setString(4,text_stu_id.getText());
                                    ps.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "data is Updated...");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Check Input feields");
                }
                    break;
                case "ICT1233":if(checkQuizInputs()&& text_stu_id!=null){
                    try {
                            UpdateQuery = "UPDATE quiz_marks_java SET Q1 =?,Q2 =?,Q3 =? WHERE Stu_id =?";
                                ps =conn.prepareStatement(UpdateQuery);

                                    ps.setString(1,txtQ1.getText());
                                    ps.setString(2,txtQ2.getText());
                                    ps.setString(3,txtQ3.getText());
                                    ps.setString(4,text_stu_id.getText());
                                    ps.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "data is Updated...");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Check Input feields");
                }
                    break;
                case "ICT1242":if(checkQuizInputs()&& text_stu_id!=null){
                    try {
                            UpdateQuery = "UPDATE quiz_marks_webt SET Q1 =?,Q2 =?,Q3 =? WHERE Stu_id =?";
                                ps =conn.prepareStatement(UpdateQuery);

                                    ps.setString(1,txtQ1.getText());
                                    ps.setString(2,txtQ2.getText());
                                    ps.setString(3,txtQ3.getText());
                                    ps.setString(4,text_stu_id.getText());
                                    ps.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "data is Updated...");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Check Input feields");
                }
                    break;
                case "ICT1243":if(checkQuizInputs()&& text_stu_id!=null){
                    try {
                            UpdateQuery = "UPDATE quiz_marks_c SET Q1 =?,Q2 =?,Q3 =? WHERE Stu_id =?";
                                ps =conn.prepareStatement(UpdateQuery);

                                    ps.setString(1,txtQ1.getText());
                                    ps.setString(2,txtQ2.getText());
                                    ps.setString(3,txtQ3.getText());
                                    ps.setString(4,text_stu_id.getText());
                                    ps.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "data is Updated...");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Check Input feields");
                }
                    break;
            }
    }
    }
    
    //================================ASSESSMENT MARKS INSERT==============================
    public boolean checkAssInputs(){
        return !(txtA1.getText()==null 
                ||txtA2.getText()==null
                ||txtA3.getText()==null);    
    }
    public void addAssessmentMarks(){
        String AddStuId=text_stu_id.getText();
        String CoCode=(String)combo_course.getSelectedItem();
        if((AddStuId==null) || ("Select Subject Code".equals(CoCode))){
            JOptionPane.showMessageDialog(null,"Please fillout the StuId And Select Course code");
        }
        else{
            if(null != CoCode)switch (CoCode) {
                case "ICT1213":
                    if(true==checkAssInputs()){
                        try {
                            PreparedStatement ps=conn.prepareStatement("INSERT INTO `ass_marks_dbms`(Stu_id,A1,A2,A3)values(?,?,?,?)");
                            ps.setString(1,text_stu_id.getText());
                            ps.setString(2,txtA1.getText());
                            ps.setString(3,txtA2.getText());
                            ps.setString(4,txtA3.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Inserted...");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Please fillOut the Marks Feilds");
                    }   break;
                case "ICT1223":
                    if(txtA1!=null || txtA2!=null || null==txtA3){
                        try {
                            PreparedStatement ps=conn.prepareStatement("INSERT INTO `ass_marks_ooad`(Stu_id,A1,A2)values(?,?,?)");
                            ps.setString(1,text_stu_id.getText());
                            ps.setString(2,txtA1.getText());
                            ps.setString(3,txtA2.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Inserted...");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Please fillOut the Marks Feilds");
                    }   break;
                case "ICT1232":
                    if(checkAssInputs()){
                        try {
                            PreparedStatement ps=conn.prepareStatement("INSERT INTO `ass_marks_cl`(Stu_id,A1,A2,A3)values(?,?,?,?)");
                            ps.setString(1,text_stu_id.getText());
                            ps.setString(2,txtA1.getText());
                            ps.setString(3,txtA2.getText());
                            ps.setString(4,txtA3.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Inserted...");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Please fillOut the Marks Feilds");
                    }   break;
                case "ICT1233":
                    JOptionPane.showMessageDialog(null,"This course doesn't conduct Any Assesments");
                    break;
                case "ICT1242":
                    JOptionPane.showMessageDialog(null,"This course doesn't conduct Any Assesments");
                    break;
                case "ICT1243":
                    if(checkAssInputs()){
                        try {
                            PreparedStatement ps=conn.prepareStatement("INSERT INTO `ass_marks_c`(Stu_id,A1,A2,A3)values(?,?,?,?)");
                            ps.setString(1,text_stu_id.getText());
                            ps.setString(2,txtA1.getText());
                            ps.setString(3,txtA2.getText());
                            ps.setString(4,txtA3.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Inserted...");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Please fillOut the Marks Feilds");
                    }   break;
                default:
                    break;
            }
        }
    }
    
    public void updateAssMarks(){
        String UpdateQuery =null;
        PreparedStatement ps =null;
        String AddStuId=text_stu_id.getText();
        String CoCode=(String)combo_course.getSelectedItem();
        if((AddStuId==null) || ("Select Subject Code".equals(CoCode))){
            JOptionPane.showMessageDialog(null,"Please fillout the StuId And Select Course code");
        }
        else{
            if(null != CoCode)switch (CoCode) {
                case "ICT1213":
                    if(true==checkAssInputs()){
                        try {
                            UpdateQuery = "UPDATE ass_marks_dbms SET A1 =?,A2 =?,A3 =? WHERE Stu_id =?";
                            ps =conn.prepareStatement(UpdateQuery);
                            ps.setString(1,txtA1.getText());
                            ps.setString(2,txtA2.getText());
                            ps.setString(3,txtA3.getText());
                            ps.setString(4,text_stu_id.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Updated...");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Please fillOut the Marks Feilds");
                    }   break;
                case "ICT1223":
                    if(txtA1!=null || txtA2!=null || null==txtA3){
                        try {
                            UpdateQuery = "UPDATE ass_marks_ooad SET A1 =?,A2 =? WHERE Stu_id =?";
                            ps =conn.prepareStatement(UpdateQuery);
                            ps.setString(1,txtA1.getText());
                            ps.setString(2,txtA2.getText());
                            ps.setString(3,text_stu_id.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Updated...");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Please fillOut the Marks Feilds");
                    }   break;
                case "ICT1232":
                    if(checkAssInputs()){
                        try {
                            UpdateQuery = "UPDATE ass_marks_cl SET A1 =?,A2 =?,A3 =? WHERE Stu_id =?";
                            ps =conn.prepareStatement(UpdateQuery);
                            ps.setString(1,txtA1.getText());
                            ps.setString(2,txtA2.getText());
                            ps.setString(3,txtA3.getText());
                            ps.setString(4,text_stu_id.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Updated...");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Please fillOut the Marks Feilds");
                    }   break;
                case "ICT1233":
                    JOptionPane.showMessageDialog(null,"This course doesn't conduct Any Assesments");
                    break;
                case "ICT1242":
                    JOptionPane.showMessageDialog(null,"This course doesn't conduct Any Assesments");
                    break;
                case "ICT1243":
                    if(checkAssInputs()){
                        try {
                            UpdateQuery = "UPDATE ass_marks_c SET A1 =?,A2 =?,A3 =? WHERE Stu_id =?";
                            ps =conn.prepareStatement(UpdateQuery);
                            ps.setString(1,txtA1.getText());
                            ps.setString(2,txtA2.getText());
                            ps.setString(3,txtA3.getText());
                            ps.setString(4,text_stu_id.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Updated...");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Please fillOut the Marks Feilds");
                    }   break;
                default:
                    break;
            }
        }
    
    }
        
    public void addMidMarks(){
       
       
        
       
        String AddStuId=text_stu_id.getText();
        String CoCode=(String)combo_course.getSelectedItem();
        if((AddStuId==null) || ("Select Subject Code".equals(CoCode))){
            JOptionPane.showMessageDialog(null,"Please fillout the StuId And Select Course code");
        }else{
            switch(CoCode){
                case "ICT1213":JOptionPane.showMessageDialog(null,"This course doesn;t conduct Mid_Exams!");
                    break;
                case "ICT1223":if(txtMid_p==null ||txtMid_t!=null){
                                    
                                    txtMid_p.setVisible(false);
                                    try {
                                        PreparedStatement ps=conn.prepareStatement("INSERT INTO `mid_marks_ooad`(Stu_id,Mid_Marks)values(?,?)");
                                        ps.setString(1,text_stu_id.getText());
                                        ps.setString(2,txtMid_t.getText());
                                        ps.executeUpdate();
                                        JOptionPane.showMessageDialog(null, "data is Inserted...");
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(null,ex.getMessage());
                                    }
                                    txtMid_p.setVisible(true);
                                }
                                else{
                                     JOptionPane.showMessageDialog(null,"Please check input feilds!");
                                }
                    break;
                case "ICT1232":JOptionPane.showMessageDialog(null,"This course doesn;t conduct Mid_Exams!");
                    break;
                case "ICT1233":if(txtMid_t!=null || txtMid_p!=null){
                                    
                                    try {
                                        int Mt=Integer.parseInt(txtMid_t.getText());
                                        int Mp=Integer.parseInt(txtMid_p.getText());
                                        String Mtotal=String.valueOf((Mt+Mp)/2) ;
                                        PreparedStatement ps=conn.prepareStatement("INSERT INTO `mid_marks_java`(Stu_id,Mid_prac_Marks,Mid_theory_marks,Mid_Marks)values(?,?,?,?)");
                                        ps.setString(1,text_stu_id.getText());
                                        ps.setString(2,txtMid_p.getText());
                                        ps.setString(3,txtMid_t.getText());
                                        ps.setString(4, Mtotal);
                                        ps.executeUpdate();
                                        JOptionPane.showMessageDialog(null, "data is Inserted...");
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(null,ex.getMessage());
                                    }
                                }
                                else{
                                     JOptionPane.showMessageDialog(null,"Please check input feilds!");
                                }
                    break;
                case "ICT1242":if(txtMid_t!=null || txtMid_p!=null){
                                    
                                    try {
                                        
                                        int Mt=Integer.parseInt(txtMid_t.getText());
                                        int Mp=Integer.parseInt(txtMid_p.getText());
                                        String Mtotal=String.valueOf((Mt+Mp)/2) ;
                                      
                                        PreparedStatement ps=conn.prepareStatement("INSERT INTO `mid_marks_webt`(Stu_id,Mid_prac_Marks,Mid_theory_marks,Mid_Marks)values(?,?,?,?)");
                                        ps.setString(1,text_stu_id.getText());
                                        ps.setString(2,txtMid_p.getText());
                                        ps.setString(3,txtMid_t.getText());
                                        ps.setString(4, Mtotal);
                                        ps.executeUpdate();
                                        JOptionPane.showMessageDialog(null, "data is Inserted...");
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(null,ex.getMessage());
                                    }
                                }
                                else{
                                     JOptionPane.showMessageDialog(null,"Please check input feilds!");
                                }
                    break;
                case "ICT1243":JOptionPane.showMessageDialog(null,"This course doesn;t conduct Mid_Exams!");
                    break;
            }
        }
    
    }
     
     //UpdateMid Marks
    
    public void updatemidMarks(){
        String UpdateQuery =null;
        PreparedStatement ps =null;
        String AddStuId=text_stu_id.getText();
        String CoCode=(String)combo_course.getSelectedItem();
        if((AddStuId==null) || ("Select Subject Code".equals(CoCode))){
            JOptionPane.showMessageDialog(null,"Please fillout the StuId And Select Course code");
        }
        else{
            switch(CoCode){
                case "ICT1213":JOptionPane.showMessageDialog(null,"This course doesn;t conduct Mid_Exams!");
                    break;
                case "ICT1223":if(txtMid_p==null ||txtMid_t!=null){
                                    
                                    txtMid_p.setVisible(false);
                                    try {
                                        UpdateQuery = "UPDATE mid_marks_ooad SET Mid_Marks =? WHERE Stu_id =?";
                                        ps =conn.prepareStatement(UpdateQuery);
                                        ps.setString(1,txtMid_t.getText());
                                        ps.setString(4,text_stu_id.getText());
                                        ps.executeUpdate();
                                        JOptionPane.showMessageDialog(null, "data is Updated...");
                                        
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(null,ex.getMessage());
                                    }
                                    txtMid_p.setVisible(true);
                                }
                                else{
                                     JOptionPane.showMessageDialog(null,"Please check input feilds!");
                                }
                    break;
                case "ICT1232":JOptionPane.showMessageDialog(null,"This course doesn;t conduct Mid_Exams!");
                    break;
                case "ICT1233":if(txtMid_t!=null || txtMid_p!=null){
                                    
                                    try {
                                        int Mt=Integer.parseInt(txtMid_t.getText());
                                        int Mp=Integer.parseInt(txtMid_p.getText());
                                        String Mtotal=String.valueOf((Mt+Mp)/2) ;
                                        UpdateQuery = "UPDATE mid_marks_ooad SET Mid_prac_Marks =? ,Mid_theory_marks,Mid_Marks =? WHERE Stu_id =?";
                                        ps =conn.prepareStatement(UpdateQuery);
                                    
                                        ps.setString(1,txtMid_t.getText());
                                        ps.setString(2,txtMid_p.getText());
                                        ps.setString(3, Mtotal);
                                        ps.setString(4,text_stu_id.getText());
                                        ps.executeUpdate();
                                        JOptionPane.showMessageDialog(null, "data is Updated...");
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(null,ex.getMessage());
                                    }
                                }
                                else{
                                     JOptionPane.showMessageDialog(null,"Please check input feilds!");
                                }
                    break;
                case "ICT1242":if(txtMid_t!=null || txtMid_p!=null){
                                    
                                    try {
                                        
                                        int Mt=Integer.parseInt(txtMid_t.getText());
                                        int Mp=Integer.parseInt(txtMid_p.getText());
                                        String Mtotal=String.valueOf((Mt+Mp)/2) ;
                                        UpdateQuery = "UPDATE mid_marks_webt SET Mid_prac_Marks =? ,Mid_theory_marks,Mid_Marks =? WHERE Stu_id =?";
                                        ps =conn.prepareStatement(UpdateQuery);
                                    
                                        ps.setString(1,txtMid_t.getText());
                                        ps.setString(2,txtMid_p.getText());
                                        ps.setString(3, Mtotal);
                                        ps.setString(4,text_stu_id.getText());
                                        ps.executeUpdate();
                                        JOptionPane.showMessageDialog(null, "data is Updated...");
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(null,ex.getMessage());
                                    }
                                }
                                else{
                                     JOptionPane.showMessageDialog(null,"Please check input feilds!");
                                }
                    break;
                case "ICT1243":JOptionPane.showMessageDialog(null,"This course doesn;t conduct Mid_Exams!");
                    break;
            }
        }

    }
     
   //===========================INSERT FINAL MARKS=================================
    public void AddFinalMarks(){
        String AddStuId=text_stu_id.getText();
        String CoCode=(String)combo_course.getSelectedItem();
        if((AddStuId==null) || ("Select Subject Code".equals(CoCode))){
            JOptionPane.showMessageDialog(null,"Please fillout the StuId And Select Course code");
        }
        else{
            switch(CoCode){
                case "ICT1213":if(txtFinal_t!=null || txtFinal_p!=null){
                    try {
                        PreparedStatement ps=conn.prepareStatement("INSERT INTO `final_marks_dbms`(Stu_id,Final_prac_Marks,Final_theory_Marks)values(?,?,?)");
                            ps.setString(1,text_stu_id.getText());
                            ps.setString(2,txtFinal_p.getText());
                            ps.setString(3,txtFinal_t.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Inserted...");    
                    } 
                    catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please check input feilds...");
                }
                break;
                case "ICT1223":if(txtFinal_t!=null || txtFinal_p==null){
                     try {
                        PreparedStatement ps=conn.prepareStatement("INSERT INTO `final_marks_OOAD`(Stu_id,Final_Marks)values(?,?)");
                            ps.setString(1,text_stu_id.getText());
                            ps.setString(2,txtFinal_t.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Inserted...");    
                    } 
                    catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please check input feilds...");
                }
                break;
                case "ICT1232":if(txtFinal_t!=null || txtFinal_p!=null){
                    try {
                        PreparedStatement ps=conn.prepareStatement("INSERT INTO `final_marks_cl`(Stu_id,Final_prac_Marks,Final_theory_Marks)values(?,?,?)");
                            ps.setString(1,text_stu_id.getText());
                            ps.setString(2,txtFinal_p.getText());
                            ps.setString(3,txtFinal_t.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Inserted...");    
                    } 
                    catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please check input feilds...");
                }
                break;
                  case "ICT1233":if(txtFinal_t!=null || txtFinal_p!=null){
                    try {
                        PreparedStatement ps=conn.prepareStatement("INSERT INTO `final_marks_java`(Stu_id,Final_prac_Marks,Final_theory_Marks)values(?,?,?)");
                            ps.setString(1,text_stu_id.getText());
                            ps.setString(2,txtFinal_p.getText());
                            ps.setString(3,txtFinal_t.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Inserted...");    
                    } 
                    catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please check input feilds...");
                }
                break;
                 case "ICT1242":if(txtFinal_t!=null || txtFinal_p!=null){
                    try {
                        PreparedStatement ps=conn.prepareStatement("INSERT INTO `final_marks_webt`(Stu_id,Final_prac_Marks,Final_theory_Marks)values(?,?,?)");
                            ps.setString(1,text_stu_id.getText());
                            ps.setString(2,txtFinal_p.getText());
                            ps.setString(3,txtFinal_t.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Inserted...");    
                    } 
                    catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please check input feilds...");
                }
                break;
                 case "ICT1243":if(txtFinal_t!=null || txtFinal_p!=null){
                    try {
                        PreparedStatement ps=conn.prepareStatement("INSERT INTO `final_marks_c`(Stu_id,Final_prac_Marks,Final_theory_Marks)values(?,?,?)");
                            ps.setString(1,text_stu_id.getText());
                            ps.setString(2,txtFinal_p.getText());
                            ps.setString(3,txtFinal_t.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Inserted...");    
                    } 
                    catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please check input feilds...");
                }
                break;
            }
        }
    }
    //================UPDATE FINAL MARKS==========================================
    
    public void UpdateFinalMarks(){
        String UpdateQuery =null;
        PreparedStatement ps =null;
        String AddStuId=text_stu_id.getText();
        String CoCode=(String)combo_course.getSelectedItem();
        if((AddStuId==null) || ("Select Subject Code".equals(CoCode))){
            JOptionPane.showMessageDialog(null,"Please fillout the StuId And Select Course code");
        }
        else{
            switch(CoCode){
                case "ICT1213":if(txtFinal_t!=null || txtFinal_p!=null){
                    try {
                        UpdateQuery = "UPDATE final_marks_ooad SET Final_prac_Marks =? ,Final_theory_marks WHERE Stu_id =?";
                        ps =conn.prepareStatement(UpdateQuery);
                            
                            ps.setString(1,txtFinal_p.getText());
                            ps.setString(2,txtFinal_t.getText());
                            ps.setString(3,text_stu_id.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Updated...");    
                    } 
                    catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please check input feilds...");
                }
                break;
                case "ICT1223":if(txtFinal_t!=null || txtFinal_p==null){
                     try {
                        UpdateQuery = "UPDATE final_marks_ooad SET Final_Marks =? WHERE Stu_id =?";
                        ps =conn.prepareStatement(UpdateQuery);
                            ps.setString(1,text_stu_id.getText());
                            ps.setString(2,txtFinal_t.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Updated...");    
                    } 
                    catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please check input feilds...");
                }
                break;
                case "ICT1232":if(txtFinal_t!=null || txtFinal_p!=null){
                    try {
                        UpdateQuery = "UPDATE final_marks_cl SET Final_prac_Marks =? ,Final_theory_marks WHERE Stu_id =?";
                        ps =conn.prepareStatement(UpdateQuery);
                            
                            ps.setString(1,txtFinal_p.getText());
                            ps.setString(2,txtFinal_t.getText());
                            ps.setString(3,text_stu_id.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Updated...");    
                    } 
                    catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please check input feilds...");
                }
                break;
                  case "ICT1233":if(txtFinal_t!=null || txtFinal_p!=null){
                    try {
                        UpdateQuery = "UPDATE final_marks_java SET Final_prac_Marks =? ,Final_theory_marks WHERE Stu_id =?";
                        ps =conn.prepareStatement(UpdateQuery);
                            
                            ps.setString(1,txtFinal_p.getText());
                            ps.setString(2,txtFinal_t.getText());
                            ps.setString(3,text_stu_id.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Updated...");     
                    } 
                    catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please check input feilds...");
                }
                break;
                 case "ICT1242":if(txtFinal_t!=null || txtFinal_p!=null){
                    try {
                        UpdateQuery = "UPDATE final_marks_webt SET Final_prac_Marks =? ,Final_theory_marks WHERE Stu_id =?";
                        ps =conn.prepareStatement(UpdateQuery);
                            
                            ps.setString(1,txtFinal_p.getText());
                            ps.setString(2,txtFinal_t.getText());
                            ps.setString(3,text_stu_id.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Updated...");     
                    } 
                    catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please check input feilds...");
                }
                break;
                 case "ICT1243":if(txtFinal_t!=null || txtFinal_p!=null){
                    try {
                        UpdateQuery = "UPDATE final_marks_c SET Final_prac_Marks =? ,Final_theory_marks WHERE Stu_id =?";
                        ps =conn.prepareStatement(UpdateQuery);
                            
                            ps.setString(1,txtFinal_p.getText());
                            ps.setString(2,txtFinal_t.getText());
                            ps.setString(3,text_stu_id.getText());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "data is Updated...");     
                    } 
                    catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please check input feilds...");
                }
                break;
            }
        }
    }
   
    
   //===========================GET FINAL RESULTS END===============================

    
}

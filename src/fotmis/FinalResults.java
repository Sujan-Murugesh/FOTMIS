package fotmis;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sujan
 */
public class FinalResults extends LecturerMain{
    
    public static int fQ;
    public static int fA;
    public static int fMid;
    public static int fTotal;
    public static int finalresults;
    public static String grade;
    public static float gpa;

    
    //=========================================================================================
    //setFinal Marks
    public void setFinalMarksDbms(){
        try {
                    String qry="select Final_prac_Marks,Final_theory_Marks from final_marks_dbms where Stu_id='"+jtxt_stuid.getText()+"' ";
                    
                    pst=conn.prepareStatement(qry);
                    rs=pst.executeQuery();
                    if(rs.next()){
                        int ft,fp;
                        
                        fp=Integer.parseInt(rs.getString("Final_prac_Marks"));
                        ft=Integer.parseInt(rs.getString("Final_theory_Marks"));
                        
                        fTotal=((int)(0.4*ft)+(int)(0.3*fp));
                    }
                } catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    public void setFinalMarksOoad(){
        try {
                    String qry="select Final_Marks from final_marks_ooad where Stu_id='"+jtxt_stuid.getText()+"' ";
                    
                    pst=conn.prepareStatement(qry);
                    rs=pst.executeQuery();
                    if(rs.next()){
                        int ft;
                        
                        ft=Integer.parseInt(rs.getString("Final_Marks"));
                        
                        fTotal=(int) (0.6*ft);
                    }
                } catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    public void setFinalMarksCl(){
        try {
                    String qry="select Final_prac_Marks,Final_theory_Marks from final_marks_cl where Stu_id='"+jtxt_stuid.getText()+"' ";
                    
                    pst=conn.prepareStatement(qry);
                    rs=pst.executeQuery();
                    if(rs.next()){
                        int ft,fp;
                        
                        fp=Integer.parseInt(rs.getString("Final_prac_Marks"));
                        ft=Integer.parseInt(rs.getString("Final_theory_Marks"));
                        
                        fTotal=((int)(0.4*ft)+(int)(0.3*fp));
                    }
                } catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    public void setFinalMarksJava(){
        try {
                    String qry="select Final_prac_Marks,Final_theory_Marks from final_marks_java where Stu_id='"+jtxt_stuid.getText()+"' ";
                    
                    pst=conn.prepareStatement(qry);
                    rs=pst.executeQuery();
                    if(rs.next()){
                        int ft,fp;
                        
                        fp=Integer.parseInt(rs.getString("Final_prac_Marks"));
                        ft=Integer.parseInt(rs.getString("Final_theory_Marks"));
                        
                        fTotal=((int)(0.4*ft)+(int)(0.3*fp));
                    }
                } catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    public void setFinalMarksWebt(){
        try {
                    String qry="select Final_prac_Marks,Final_theory_Marks from final_marks_webt where Stu_id='"+jtxt_stuid.getText()+"' ";
                    
                    pst=conn.prepareStatement(qry);
                    rs=pst.executeQuery();
                    if(rs.next()){
                        int ft,fp;
                        
                        fp=Integer.parseInt(rs.getString("Final_prac_Marks"));
                        ft=Integer.parseInt(rs.getString("Final_theory_Marks"));
                        
                        fTotal=((int)(0.4*ft)+(int)(0.3*fp));
                    }
                } catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    public void setFinalMarksC(){
        try {
                    String qry="select Final_prac_Marks,Final_theory_Marks from final_marks_c where Stu_id='"+jtxt_stuid.getText()+"' ";
                    
                    pst=conn.prepareStatement(qry);
                    rs=pst.executeQuery();
                    if(rs.next()){
                        int ft,fp;
                        
                        fp=Integer.parseInt(rs.getString("Final_prac_Marks"));
                        ft=Integer.parseInt(rs.getString("Final_theory_Marks"));
                        
                        fTotal=((int)(0.3*ft)+(int)(0.4*fp));
                    }
                } catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    //=========================================================================================
    //set final assessment marks
    public void setFinalAssDbms(){
        try {
                    String qry="select A1,A2,A3 from ass_marks_dbms where `Stu_id`='"+jtxt_stuid.getText()+"'";
                    pst=conn.prepareStatement(qry);
                    rs=pst.executeQuery();
                    if(rs.next()){
                        int a1,a2,a3;
                
                   
                    a1=Integer.parseInt(rs.getString("A1"));
                    a2=Integer.parseInt(rs.getString("A2"));
                    a3=Integer.parseInt(rs.getString("A3"));
                    
                    if(a1<=a2 && a1<=a3){
                     fA = (int) (0.2*(a2+a3));
                }
                else if(a2<=a1 && a2<=a3){
                     fA = (int) (0.2*(a1+a3));
                }
                else{
                     fA=  (int) (0.2*(a1+a2));
                }
                    }
                }catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    public void setFinalAssOoad(){
        try {
                    String qry="select A1,A2 from ass_marks_ooad where `Stu_id`='"+jtxt_stuid.getText()+"'";
                    pst=conn.prepareStatement(qry);
                    rs=pst.executeQuery();
                    if(rs.next()){
                        int a1,a2,a3;
                            a1=Integer.parseInt(rs.getString("A1"));
                            a2=Integer.parseInt(rs.getString("A2"));

                            fA = (int) (0.1*(a1+a2));
                    }
                }catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    public void setFinalAssCl(){
        try {
                    String qry="select A1,A2,A3 from ass_marks_cl where `Stu_id`='"+jtxt_stuid.getText()+"'";
                    pst=conn.prepareStatement(qry);
                    rs=pst.executeQuery();
                    if(rs.next()){
                        int a1,a2,a3;
                
                   
                        a1=Integer.parseInt(rs.getString("A1"));
                        a2=Integer.parseInt(rs.getString("A2"));
                        a3=Integer.parseInt(rs.getString("A3"));
                    
                        if(a1<=a2 && a1<=a3){
                         fA = (int) (0.2*(a2+a3));
                        }
                        else if(a2<=a1 && a2<=a3){
                         fA = (int) (0.2*(a1+a3));
                        }
                        else{
                         fA=  (int) (0.2*(a1+a2));
                        }
                    }
           }
        catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    public void setFinalAssC(){
        try {
                    String qry="select A1,A2,A3 from ass_marks_c where `Stu_id`='"+jtxt_stuid.getText()+"'";
                    pst=conn.prepareStatement(qry);
                    rs=pst.executeQuery();
                    if(rs.next()){
                        int a1,a2,a3;
                
                   
                        a1=Integer.parseInt(rs.getString("A1"));
                        a2=Integer.parseInt(rs.getString("A2"));
                        a3=Integer.parseInt(rs.getString("A3"));
                    
                        if(a1<=a2 && a1<=a3){
                         fA = (int) (0.2*(a2+a3));
                        }
                        else if(a2<=a1 && a2<=a3){
                         fA = (int) (0.2*(a1+a3));
                        }
                        else{
                         fA=  (int) (0.2*(a1+a2));
                        }
                    }
           }
        catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    //=========================================================================================
    //set final Quiz marks 
    public void setFinalQuizDbms(){
        try {
            String qry="select Q1,Q2,Q3 from quiz_marks_dbms where Stu_id='"+jtxt_stuid.getText()+"'";
            pst=conn.prepareStatement(qry);
            rs=pst.executeQuery();
            if(rs.next()){
                int q1,q2,q3;
                q1=Integer.parseInt(rs.getString("Q1"));
                q2=Integer.parseInt(rs.getString("Q2"));
                q3=Integer.parseInt(rs.getString("Q3"));
                
                if(q1<=q2 && q1<=q3){
                     fQ = (int) (0.1*(q2+q3));
                }
                else if(q2<=q1 && q2<=q3){
                     fQ = (int) (0.1*(q1+q3));
                }
                else{
                     fQ=  (int) (0.1*(q1+q2));
                }  
            }
        }catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    public void setFinalQuizOoad(){
        try {
            String qry="select Q1,Q2,Q3,Q4 from quiz_marks_ooad where Stu_id='"+jtxt_stuid.getText()+"'";
            pst=conn.prepareStatement(qry);
            rs=pst.executeQuery();
            if(rs.next()){
                int q1,q2,q3,q4;
                q1=Integer.parseInt(rs.getString("Q1"));
                q2=Integer.parseInt(rs.getString("Q2"));
                q3=Integer.parseInt(rs.getString("Q3"));
                q4=Integer.parseInt(rs.getString("Q4"));
                
                if(q1<=q2 && q1<=q3 && q1<=q4){
                     fQ = (int) (0.1*(q2+q3+q4));
                }
                else if(q2<=q1 && q2<=q3 && q2<=q4){
                     fQ = (int) (0.1*(q1+q3+q4));
                }
                else if(q3<=q1 && q3<=q2 && q3<=q4){
                    fQ= (int)(0.1*(q1+q2+q4));
                }
                else{
                     fQ=  (int) (0.1*(q1+q2+q3));
                }  
            }
        }catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    public void setFinalQuizCl(){
        try {
            String qry="select Q1,Q2,Q3 from quiz_marks_cl where Stu_id='"+jtxt_stuid.getText()+"'";
            pst=conn.prepareStatement(qry);
            rs=pst.executeQuery();
            if(rs.next()){
                int q1,q2,q3;
                q1=Integer.parseInt(rs.getString("Q1"));
                q2=Integer.parseInt(rs.getString("Q2"));
                q3=Integer.parseInt(rs.getString("Q3"));
                
                if(q1<=q2 && q1<=q3){
                     fQ = (int) (0.1*(q2+q3));
                }
                else if(q2<=q1 && q2<=q3){
                     fQ = (int) (0.1*(q1+q3));
                }
                else{
                     fQ=  (int) (0.1*(q1+q2));
                }  
            }
        }catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    public void setFinalQuizJava(){
        try {
            String qry="select Q1,Q2,Q3 from quiz_marks_java where Stu_id='"+jtxt_stuid.getText()+"'";
            pst=conn.prepareStatement(qry);
            rs=pst.executeQuery();
            if(rs.next()){
                int q1,q2,q3;
                q1=Integer.parseInt(rs.getString("Q1"));
                q2=Integer.parseInt(rs.getString("Q2"));
                q3=Integer.parseInt(rs.getString("Q3"));
                
                if(q1<=q2 && q1<=q3){
                     fQ = (int) (0.1*(q2+q3));
                }
                else if(q2<=q1 && q2<=q3){
                     fQ = (int) (0.1*(q1+q3));
                }
                else{
                     fQ=  (int) (0.1*(q1+q2));
                }  
            }
        }catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    public void setFinalQuizWebt(){
        try {
            String qry="select Q1,Q2,Q3 from quiz_marks_webt where Stu_id='"+jtxt_stuid.getText()+"'";
            pst=conn.prepareStatement(qry);
            rs=pst.executeQuery();
            if(rs.next()){
                int q1,q2,q3;
                q1=Integer.parseInt(rs.getString("Q1"));
                q2=Integer.parseInt(rs.getString("Q2"));
                q3=Integer.parseInt(rs.getString("Q3"));
                
                if(q1<=q2 && q1<=q3){
                     fQ = (int) (0.1*(q2+q3));
                }
                else if(q2<=q1 && q2<=q3){
                     fQ = (int) (0.1*(q1+q3));
                }
                else{
                     fQ=  (int) (0.1*(q1+q2));
                }  
            }
        }catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    public void setFinalQuizC(){
        try {
            String qry="select Q1,Q2,Q3 from quiz_marks_c where Stu_id='"+jtxt_stuid.getText()+"'";
            pst=conn.prepareStatement(qry);
            rs=pst.executeQuery();
            if(rs.next()){
                int q1,q2,q3;
                q1=Integer.parseInt(rs.getString("Q1"));
                q2=Integer.parseInt(rs.getString("Q2"));
                q3=Integer.parseInt(rs.getString("Q3"));
                
                if(q1<=q2 && q1<=q3){
                     fQ = (int) (0.1*(q2+q3));
                }
                else if(q2<=q1 && q2<=q3){
                     fQ = (int) (0.1*(q1+q3));
                }
                else{
                     fQ=  (int) (0.1*(q1+q2));
                }  
            }
        }catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    //=========================================================================================
    //set Mid marks
    public void setfinalMidOoad(){
        try {
                    String qry="select Mid_Marks from mid_marks_ooad where `Stu_id`='"+jtxt_stuid.getText()+"'";
                    pst=conn.prepareStatement(qry);
                    rs=pst.executeQuery();
                    if(rs.next()){
                         int mid;
                           mid =Integer.parseInt(rs.getString("Mid_Marks"));
                           fMid = (int) (0.2*mid);
                    }
                }catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    public void setfinalMidJava(){
        try {
                    String qry="select Mid_Marks from mid_marks_java where `Stu_id`='"+jtxt_stuid.getText()+"'";
                    pst=conn.prepareStatement(qry);
                    rs=pst.executeQuery();
                    if(rs.next()){
                         int mid;
                           mid =Integer.parseInt(rs.getString("Mid_Marks"));
                           fMid = (int) (0.2*mid);
                    }
                }catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    public void setfinalMidWebt(){
        try {
                    String qry="select Mid_Marks from mid_marks_webt where `Stu_id`='"+jtxt_stuid.getText()+"'";
                    pst=conn.prepareStatement(qry);
                    rs=pst.executeQuery();
                    if(rs.next()){
                         int mid;
                           mid =Integer.parseInt(rs.getString("Mid_Marks"));
                           fMid = (int) (0.2*mid);
                    }
                }catch(SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    //=========================================================================================
    public void setFinalResultsDbms(){
        finalresults=(int)(fQ+fA+fTotal);
    } 
    
    public void setFinalResultsOoad(){
        finalresults=(int)(fQ+fA+fMid+fTotal);
    }
    
    public void setFinalResultsCl(){
        finalresults=(int)(fQ+fA+fTotal);
    }
    
    public void setFinalResultsJava(){
        finalresults=(int)(fQ+fMid+fTotal);
    }
    
    public void setFinalResultsWebt(){
        finalresults=(int)(fQ+fMid+fTotal);
    }
    
    public void setFinalResultsC(){
        finalresults=(int)(fQ+fA+fTotal);
    }
    //=====================================SET GRADES==========================================
     public void setGrade(){
         if(finalresults<=100 && finalresults>=95){
                        grade = "A+";
                    }
                    else if(finalresults<=94 && finalresults>=90){
                        grade = "A";
                    }
                    else if(finalresults<=89 && finalresults>=85){
                        grade = "A-";
                    }
                    else if(finalresults<=84 && finalresults>=80){
                        grade = "B+";
                    }
                    else if(finalresults<=79 && finalresults>=75){
                        grade = "B";
                    }
                    else if(finalresults<=74 && finalresults>=70){
                        grade = "B-";
                    }
                    else if(finalresults<=69 && finalresults>=65){
                        grade = "C+";
                    }
                    else if(finalresults<=64 && finalresults>=60){
                        grade = "C";
                    }
                    else if(finalresults<=59 && finalresults>=55){
                        grade = "C-";
                    }
                    else if(finalresults<=54 && finalresults>=50){
                        grade = "D+";
                    }
                    else if(finalresults<=49 && finalresults>=45){
                        grade = "D";
                    }
                    else if(finalresults<=44 && finalresults>=40){
                        grade = "D-";
                    }
                    else{
                        grade = "F";
                    }
     }
    //=====================================SET GPA=============================================
     public void setThreeCreditGpa(){
         switch(grade){
             case "A+":gpa=(float)((4.0*3)/3);
                 break;
             case "A": gpa=(float)((4.0*3)/3);
                 break;
             case "A-":gpa=(float)((3.7*3)/3);
                 break;
             case "B+":gpa=(float)((3.3*3)/3);
                 break;
             case "B":gpa=(float)((3.0*3)/3);
                 break;
             case "B-":gpa=(float)((2.7*3)/3);
                 break;
             case "C+":gpa=(float)((2.3*3)/3);
                 break;
             case "C":gpa=(float)((2.0*3)/3);
                 break;
             case "C-":gpa=(float)((1.7*3)/3);
                 break;
             case "D+":gpa=(float)((1.3*3)/3);
                 break;
             case "D":gpa=(float)((1.0*3)/3);
                 break;
             case "D-":gpa=(float)((0.7*3)/3);
                 break;
             case "F":gpa=(float)((0*3)/3);
                 break;
         }
     }
     
     public void setTwoCreditGpa(){
         switch(grade){
             case "A+":gpa=(float)((4.0*2)/2);
                 break;
             case "A": gpa=(float)((4.0*2)/2);
                 break;
             case "A-":gpa=(float)((3.7*2)/2);
                 break;
             case "B+":gpa=(float)((3.3*2)/2);
                 break;
             case "B":gpa=(float)((3.0*2)/2);
                 break;
             case "B-":gpa=(float)((2.7*2)/2);
                 break;
             case "C+":gpa=(float)((2.3*2)/2);
                 break;
             case "C":gpa=(float)((2.0*2)/2);
                 break;
             case "C-":gpa=(float)((1.7*2)/2);
                 break;
             case "D+":gpa=(float)((1.3*2)/2);
                 break;
             case "D":gpa=(float)((1.0*2)/2);
                 break;
             case "D-":gpa=(float)((0.7*2)/2);
                 break;
             case "F":gpa=(float)((0*2)/2);
                 break;
         }
     }
    //=====================================inserts results=====================================
    //dbms
        public void insert_final_resultsDbms(){
            if("".equals(jtxt_stuid.getText())){
                JOptionPane.showMessageDialog(null,"Please FillOut Student Id");
            }else{
            try {
                         PreparedStatement ps=conn.prepareStatement("INSERT INTO `final_result_dbms`(Stu_id,Quiz,Assessment,FinalMarks,Grade,GPA)values(?,?,?,?,?,?)");
                                ps.setString(1,jtxt_stuid.getText());
                                ps.setInt(2,fQ);
                                ps.setInt(3,fA);
                                ps.setInt(4,finalresults);
                                ps.setString(5,grade);
                                ps.setFloat(6, gpa);
                                ps.executeUpdate();
                                JOptionPane.showMessageDialog(null, "data is Inserted...");
                } 
            catch(SQLException ex) {
                                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
            }
    }
    //ooad
        public void insert_final_resultsOoad(){
            if("".equals(jtxt_stuid.getText())){
                JOptionPane.showMessageDialog(null,"Please FillOut Student Id");
            }else{
            try {
                         PreparedStatement ps=conn.prepareStatement("INSERT INTO `final_result_ooad`(Stu_id,Quiz,Assessment,Mid,FinalMarks,Grade,GPA)values(?,?,?,?,?,?,?)");
                                ps.setString(1,jtxt_stuid.getText());
                                ps.setInt(2,fQ);
                                ps.setInt(3,fA);
                                ps.setInt(4,fMid);
                                ps.setInt(5,finalresults);
                                ps.setString(6,grade);
                                ps.setFloat(7, gpa);
                                ps.executeUpdate();
                                JOptionPane.showMessageDialog(null, "data is Inserted...");
                } 
            catch(SQLException ex) {
                                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
            }
    }
    //Cl
    public void insert_final_resultsCl(){
            if("".equals(jtxt_stuid.getText())){
                JOptionPane.showMessageDialog(null,"Please FillOut Student Id");
            }else{
            try {
                         PreparedStatement ps=conn.prepareStatement("INSERT INTO `final_result_cl`(Stu_id,Quiz,Assessment,FinalMarks,Grade,GPA)values(?,?,?,?,?,?)");
                                ps.setString(1,jtxt_stuid.getText());
                                ps.setInt(2,fQ);
                                ps.setInt(3,fA);
                                ps.setInt(4,finalresults);
                                ps.setString(5,grade);
                                ps.setFloat(6, gpa);
                                ps.executeUpdate();
                                JOptionPane.showMessageDialog(null, "data is Inserted...");
                } 
            catch(SQLException ex) {
                                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
            }
    } 
    //java
        public void insert_final_resultsJava(){
            if("".equals(jtxt_stuid.getText())){
                JOptionPane.showMessageDialog(null,"Please FillOut Student Id");
            }else{
            try {
                         PreparedStatement ps=conn.prepareStatement("INSERT INTO `final_result_java`(Stu_id,Quiz,Mid,FinalMarks,Grade,GPA)values(?,?,?,?,?,?)");
                                ps.setString(1,jtxt_stuid.getText());
                                ps.setInt(2,fQ);
                                ps.setInt(3,fMid);
                                ps.setInt(4,finalresults);
                                ps.setString(5,grade);
                                ps.setFloat(6, gpa);
                                ps.executeUpdate();
                                JOptionPane.showMessageDialog(null, "data is Inserted...");
                } 
            catch(SQLException ex) {
                                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
            }
    }
    //webt
        public void insert_final_resultsWebt(){
            if("".equals(jtxt_stuid.getText())){
                JOptionPane.showMessageDialog(null,"Please FillOut Student Id");
            }else{
            try {
                         PreparedStatement ps=conn.prepareStatement("INSERT INTO `final_result_webt`(Stu_id,Quiz,Mid,FinalMarks,Grade,GPA)values(?,?,?,?,?,?)");
                                ps.setString(1,jtxt_stuid.getText());
                                ps.setInt(2,fQ);
                                ps.setInt(3,fMid);
                                ps.setInt(4,finalresults);
                                ps.setString(5,grade);
                                ps.setFloat(6, gpa);
                                ps.executeUpdate();
                                JOptionPane.showMessageDialog(null, "data is Inserted...");
                } 
            catch(SQLException ex) {
                                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
            }
    }
    //c
        public void insert_final_resultsC(){
            if("".equals(jtxt_stuid.getText())){
                JOptionPane.showMessageDialog(null,"Please FillOut Student Id");
            }else{
            try {
                         PreparedStatement ps=conn.prepareStatement("INSERT INTO `final_result_c`(Stu_id,Quiz,Assessment,FinalMarks,Grade,GPA)values(?,?,?,?,?,?)");
                                ps.setString(1,jtxt_stuid.getText());
                                ps.setInt(2,fQ);
                                ps.setInt(3,fA);
                                ps.setInt(4,finalresults);
                                ps.setString(5,grade);
                                ps.setFloat(6, gpa);
                                ps.executeUpdate();
                                JOptionPane.showMessageDialog(null, "data is Inserted...");
                } 
            catch(SQLException ex) {
                                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
            }
    }
    //=========================================================================================
    public void setFinalResults(){
        
        String Stu=jtxt_stuid.getText();
        String course=(String)c_code.getSelectedItem();
        if((Stu==null) || ("Select Subject Code".equals(course))){
            JOptionPane.showMessageDialog(null,"Please fillout the StuId And Select Course code");
        }
        else{
            switch(course){
                case "ICT1213": setFinalQuizDbms();
                                setFinalAssDbms();
                                setFinalMarksDbms();
                                setFinalResultsDbms();
                                setGrade();
                                setThreeCreditGpa();
                                insert_final_resultsDbms();
                break;
                case "ICT1223": setFinalQuizOoad();
                                setFinalAssOoad();
                                setfinalMidOoad();
                                setFinalMarksOoad();
                                setFinalResultsOoad();
                                setGrade();
                                setThreeCreditGpa();
                                insert_final_resultsOoad();
                break;
                case "ICT1232": setFinalQuizCl();
                                setFinalAssCl();
                                setFinalMarksCl();
                                setFinalResultsCl();
                                setGrade();
                                setTwoCreditGpa();
                                insert_final_resultsCl();
                break;
                case "ICT1233": setFinalQuizJava();
                                setfinalMidJava();
                                setFinalMarksJava();
                                setFinalResultsJava();
                                setGrade();
                                setThreeCreditGpa();
                                insert_final_resultsJava();
                break;
                case "ICT1242": setFinalQuizWebt();
                                setfinalMidWebt();
                                setFinalMarksWebt();
                                setFinalResultsWebt();
                                setGrade();
                                setTwoCreditGpa();
                                insert_final_resultsWebt();
                break;
                case "ICT1243": setFinalQuizC();
                                setFinalAssC();
                                setFinalMarksC();
                                setFinalResultsC();
                                setGrade();
                                setThreeCreditGpa();
                                insert_final_resultsC();
                break;
            }
        }
    }   
}

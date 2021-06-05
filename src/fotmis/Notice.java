package fotmis;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import static fotmis.LecturerMain.NoticeArea;
import static fotmis.LecturerMain.jTableNotice;
import java.awt.HeadlessException;
import java.awt.print.PrinterException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Sujan
 */
public class Notice extends LecturerMain{
    String noticePath;
    //===================================================================================
    //when user click search button this method will working....
    public void showNotice() throws SQLException, FileNotFoundException, IOException{
        String Feild=jTextNoticeId.getText();
        if(!"".equals(Feild)){
        try {
         String qry="select * from notice where id='"+Integer.parseInt(jTextNoticeId.getText())+"'";
         PreparedStatement ps=conn.prepareStatement(qry);
         rs=ps.executeQuery();
         int no=Integer.parseInt(jTextNoticeId.getText());
         
          if(rs.next()){
                if(no==rs.getInt("id")){
                   String f=rs.getString("Notice");
                   NoticeArea.setText(f);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Notice Not Found!");
                }
          } 
     } catch(SQLException ex) {
                  JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        }else{
            JOptionPane.showMessageDialog(null,"please Fillout file Id");
        }
    }
    //==================================================================================
    public void setJtableNotice(){
         try {
         String qry="select id,Title,Date from notice";
         PreparedStatement ps=conn.prepareStatement(qry);
         rs=ps.executeQuery();
         jTableNotice.setModel(DbUtils.resultSetToTableModel(rs));
          }
         
      catch (SQLException | NumberFormatException e) {
         
         System.out.println(e);
     }
    }
    //===================================================================================
    public void mouseClickAction(){
        int index=jTableNotice.getSelectedRow();
         try {
            String qry="select * from notice";
            PreparedStatement ps=conn.prepareStatement(qry);
            rs=ps.executeQuery();
            //Selected row 1st index is 0 so i add here 1
            if(rs.next()){
                if(index==rs.getInt("id")){
                    String f=rs.getString("Notice");
                    NoticeArea.setText(f);                   
                }
            }
        } catch (SQLException | NumberFormatException e) {
         JOptionPane.showMessageDialog(null,e.getMessage());
     }
    }
    //=============================CREATE NOTICE===============================================
    public void chooiceNoticeDirectory(){
        JFileChooser jfc= new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        JOptionPane.showMessageDialog(null,"Directory Location","Chooice A Directory To Save Notice",1);
        jfc.setMultiSelectionEnabled(true);
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //FILES_AND_DIRECTORIES  i want only folders...
        //int returnValue =jfc.showOpenDialog(null);
        int returnValue=jfc.showSaveDialog(null);
        if(returnValue == JFileChooser.APPROVE_OPTION){
            File[] files=jfc.getSelectedFiles();
           // JOptionPane.showMessageDialog(null,"Directories Selected");
            //System.out.println("Directories found");
            Arrays.asList(files).forEach((File x)->{
                if(x.isDirectory()){
                    noticePath = x.getAbsolutePath();
                    //System.out.println(x.getName());
                    JOptionPane.showMessageDialog(null,x.getName());
                }
            });  
        }
    }
    //=================================================================================================
    public void createNotice() throws FileNotFoundException{
        chooiceNoticeDirectory();
        String noticeName=(String)jTextnoticeTitle.getText();
        
        String format=(String)jComboFormat.getSelectedItem().toString();
        String paraharaph=NoticeArea.getText();
   
        int opt=JOptionPane.showConfirmDialog(null,"If you want to upload?","Save",JOptionPane.YES_NO_OPTION);
        if(null != format)switch (format) {
            case "txt":
                try {
                    FileWriter writer=new FileWriter(noticePath+"\\"+noticeName+".txt");
                    try (BufferedWriter bw = new BufferedWriter(writer)) {
                        NoticeArea.write(bw);
                    }
                    NoticeArea.setText("");
                    NoticeArea.requestFocus();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,e);
                }
                
                if(opt==0){ 
                try {
                    JFileChooser chooser=new JFileChooser(noticePath+"\\"+noticeName+".txt");
                    File selectedFile =chooser.getSelectedFile();
                    PreparedStatement ps=conn.prepareStatement("INSERT INTO `notice`(Title,Date,Notice)values(?,?,?)");
                    ps.setString(1, noticeName);
                    //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                    String addDate;
                    addDate =add_date.getText();
                    ps.setString(2,addDate);
                    InputStream file=new FileInputStream(new File(noticePath+"\\"+noticeName+".txt").getAbsoluteFile());
                    ps.setBlob(3,file);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,noticeName+".txt Successfully Uploaded..." );
                }catch(SQLException ex) {
                  JOptionPane.showMessageDialog(null,ex.getMessage());
                }
                }
                break;
            case "pdf":
                Document document=new Document();
                try {
                    PdfWriter writer=PdfWriter.getInstance(document,new FileOutputStream(noticePath+"\\"+noticeName+".pdf"));
                    document.open();
                    document.add(new Paragraph(paraharaph));
                    document.close();
                    writer.close();
                }  catch (DocumentException | FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null,e);
                }  
                if(opt==0){ 
                try {
                    JFileChooser chooser=new JFileChooser(noticePath+"\\"+noticeName+".pdf");
                    File selectedFile =chooser.getSelectedFile();
                    PreparedStatement ps=conn.prepareStatement("INSERT INTO `notice`(Title,Date,Notice)values(?,?,?)");
                    ps.setString(1, noticeName);
                    //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                    //String addDate;
                   // addDate = dateFormat.format(add_date.getText());
                    String addDate;
                    addDate =add_date.getText();
                    ps.setString(2,addDate);
                    //byte[] bytes = StoredFilePath.getBytes();
                    //ps.setString(3,StoredFilePath);
                    InputStream file=new FileInputStream(new File(noticePath+"\\"+noticeName+".pdf").getAbsoluteFile());
                    ps.setBlob(3,file);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,noticeName+".Pdf Successfully Uploaded..." );
                }catch(SQLException ex) {
                  JOptionPane.showMessageDialog(null,ex.getMessage());
                }
                }
                break;
            default:
                JOptionPane.showMessageDialog(null,"Please Select File Format");
                break;
        }
    }
    //=================================================================================================
    public void printNotice(){
        try {
            boolean complete=NoticeArea.print();
            if(complete){
                JOptionPane.showMessageDialog(null,"Done Printing","Information",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"Printing !","Printer",JOptionPane.ERROR_MESSAGE);
            }
        } catch (PrinterException | HeadlessException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
     //=================================================================================================
    
}

package fotmis;

import static fotmis.LecturerMain.DateLbl;
import static fotmis.LecturerMain.TimeLbl1;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import javax.swing.Timer;
import java.util.*;

/**
 *
 * @author Sujan
 */
public class Clock{
   // Timer timer;
    public void setTime(){
       
//        ActionListener actionListener = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Date date = new Date(1000);
//                DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
//                String time =timeFormat.format(date);
//                TimeLbl1.setText(time);
//                
//                Date date2 = new Date(1000);
//                DateFormat timeFormat2 = new SimpleDateFormat("dd/MM/yyyy");
//                String time2 =timeFormat2.format(date2);
//                DateLbl.setText(time2);
//            }
//        };
//        timer =new Timer(1000, actionListener);
//        timer.setInitialDelay(0);
//        timer.start();
          int day,month,year;
          int millisec,second,minute,hour;
          GregorianCalendar date=new GregorianCalendar();
          GregorianCalendar mon=new GregorianCalendar();
          day=date.get(Calendar.DAY_OF_MONTH);
          month=mon.get(Calendar.MONTH);
          year=date.get(Calendar.YEAR);
          
          millisec=date.get(Calendar.MILLISECOND);
          second=date.get(Calendar.SECOND);
          minute=date.get(Calendar.MINUTE);
          hour=date.get(Calendar.HOUR);
          TimeLbl1.setText(hour+":"+minute+":"+second);
          DateLbl.setText(day+"/"+month+"/"+year);
          
          
    }
    
}

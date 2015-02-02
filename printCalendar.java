
import java.util.ArrayList;
import java.util.Calendar;


/**
 *
 * @author Ravi Sharma
 * The printCalendar class is responsible to print the month view of the calendar
 * The month view is printed using a calendar object
 */
public class printCalendar {
    /**
     * The instances used are the current day calendar object
     * And a calendar object that stores the first date of the current month
     * an int value of the max amount of days in the current month
     */
Calendar cal;
Calendar firstDay;
private int x;
private Calendar highLightCurrentDate;
 private ArrayList<Integer> currentMonthEventDates;
public printCalendar(Calendar c){
    cal=c;
    firstDay = Calendar.getInstance();
    firstDay.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),1);
     x = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
   currentMonthEventDates = new ArrayList<Integer>();
   highLightCurrentDate= Calendar.getInstance();

}
/**
 * Sets the calendar to the current date calendar object
 * @param setCal the current calendar
 */
public void setCalendar(Calendar setCal){
    cal=setCal;
}
/**
 * The printCal method is the method responsible for printing the month view of a calendar
 * @param calToPrint, the month to print
 * @param highLightDates the arraylist of integer dates which have to be highlighted
 */
public void printCal(Calendar calToPrint,ArrayList<Integer> highLightDates){
     cal=calToPrint;
     firstDay.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),1);
     x = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
String[]months= {"January","Febuary","March","April","May","June","July","August","September","October","November","December"};
System.out.printf("%13s","");
System.out.println(months[cal.get(Calendar.MONTH)]+" "+cal.get(Calendar.YEAR));
System.out.println();
System.out.printf("%-5s%-5s%-5s%-5s%-5s%-5s%-5s","Su","Mo","Tu","We","Th","Fr","Sa");
System.out.println();
//Handles the case when the first is on a sunday
if(firstDay.get(Calendar.DAY_OF_WEEK)==1){
     if(highLightDates.contains(1)||(1==highLightCurrentDate.get(Calendar.DATE)&&highLightCurrentDate.get(Calendar.MONTH)==cal.get(Calendar.MONTH)&&highLightCurrentDate.get(Calendar.YEAR)==cal.get(Calendar.YEAR))){
            System.out.printf("%1s%3s"," [1]","");
    } 
    else{System.out.printf("%s%4s","1","");}
    for(int i=2;i<=x;i++){
        if(highLightDates.contains(i)||(i==highLightCurrentDate.get(Calendar.DATE)&&highLightCurrentDate.get(Calendar.MONTH)==cal.get(Calendar.MONTH)&&highLightCurrentDate.get(Calendar.YEAR)==cal.get(Calendar.YEAR))){
                    System.out.printf("%-5s","["+i+"]");
                    if(highLightDates.contains(i+1)){
                       System.out.printf("%-5s","["+(i+1)+"]");
                    } 
                    if(i==7||i==14||i==21||i==28){
            System.out.println();
        }
                  
        }
        else{
        System.out.printf("%-5s",i);
        if(i==7||i==14||i==21||i==28){
            System.out.println();
        }
        }
       
    }
}
//Handles the case when the first is on a Monday

if(firstDay.get(Calendar.DAY_OF_WEEK)==2){
     if(highLightDates.contains(1)||(1==highLightCurrentDate.get(Calendar.DATE)&&highLightCurrentDate.get(Calendar.MONTH)==cal.get(Calendar.MONTH)&&highLightCurrentDate.get(Calendar.YEAR)==cal.get(Calendar.YEAR))){
            System.out.printf("%7s%3s"," [1]","");
    } 
    else{System.out.printf("%6s%4s","1","");}
     for(int i=2;i<=x;i++){
          if(highLightDates.contains(i)||(i==highLightCurrentDate.get(Calendar.DATE)&&highLightCurrentDate.get(Calendar.MONTH)==cal.get(Calendar.MONTH)&&highLightCurrentDate.get(Calendar.YEAR)==cal.get(Calendar.YEAR))){
                    System.out.printf("%-5s","["+i+"]");
                   
                    if(i==6||i==13||i==20||i==27){
            System.out.println();
            
        } 
                 
        }
          else{
        System.out.printf("%-5s",i);
        if(i==6||i==13||i==20||i==27){
            System.out.println();
        } 
          }
    }
}
//Handles the case when the first is on a Tuesday

if(firstDay.get(Calendar.DAY_OF_WEEK)==3){
    if(highLightDates.contains(1)||(1==highLightCurrentDate.get(Calendar.DATE)&&highLightCurrentDate.get(Calendar.MONTH)==cal.get(Calendar.MONTH)&&highLightCurrentDate.get(Calendar.YEAR)==cal.get(Calendar.YEAR))){
            System.out.printf("%12s%3s"," [1]","");
    } 
    else{System.out.printf("%11s%4s","1","");}
    for(int i=2;i<=x;i++){
           if(highLightDates.contains(i)||(i==highLightCurrentDate.get(Calendar.DATE)&&highLightCurrentDate.get(Calendar.MONTH)==cal.get(Calendar.MONTH)&&highLightCurrentDate.get(Calendar.YEAR)==cal.get(Calendar.YEAR))){
                    System.out.printf("%-5s","["+i+"]");
                   
                    if(i==5||i==12||i==19||i==26){
            System.out.println();
            
        } 
                
        }
           else{
        System.out.printf("%-5s",i);
        if(i==5||i==12||i==19||i==26){
            System.out.println();
        } 
           }
    }
}
//Handles the case when the first is on a Wednesday

if(firstDay.get(Calendar.DAY_OF_WEEK)==4){
    if(highLightDates.contains(1)||(1==highLightCurrentDate.get(Calendar.DATE)&&highLightCurrentDate.get(Calendar.MONTH)==cal.get(Calendar.MONTH)&&highLightCurrentDate.get(Calendar.YEAR)==cal.get(Calendar.YEAR))){
            System.out.printf("%17s%3s"," [1]","");
    } 
    else{
    System.out.printf("%16s%4s","1","");
    }
    for(int i=2;i<=x;i++){
         if(highLightDates.contains(i)||(i==highLightCurrentDate.get(Calendar.DATE)&&highLightCurrentDate.get(Calendar.MONTH)==cal.get(Calendar.MONTH)&&highLightCurrentDate.get(Calendar.YEAR)==cal.get(Calendar.YEAR))){
                    System.out.printf("%-5s","["+i+"]");
                   
                    if(i==4||i==11||i==18||i==25){
            System.out.println();
            
        } 
                    
        }
       
         else{
        System.out.printf("%-5s",i);
        if(i==4||i==11||i==18||i==25){
            System.out.println();
        }
         }
        
    }
}
//Handles the case when the first is on a Thursday

if(firstDay.get(Calendar.DAY_OF_WEEK)==5){
     if(highLightDates.contains(1)||(1==highLightCurrentDate.get(Calendar.DATE)&&highLightCurrentDate.get(Calendar.MONTH)==cal.get(Calendar.MONTH)&&highLightCurrentDate.get(Calendar.YEAR)==cal.get(Calendar.YEAR))){
            System.out.printf("%22s%3s"," [1]","");
    } 
    else{System.out.printf("%21s%4s","1","");}
    for(int i=2;i<=x;i++){
         if(highLightDates.contains(i)||(i==highLightCurrentDate.get(Calendar.DATE)&&highLightCurrentDate.get(Calendar.MONTH)==cal.get(Calendar.MONTH)&&highLightCurrentDate.get(Calendar.YEAR)==cal.get(Calendar.YEAR))){
                    System.out.printf("%-5s","["+i+"]");
                   
                    if(i==3||i==10||i==17||i==24||i==31){
            System.out.println();
            
        } 
        }
         else{
        System.out.printf("%-5s",i);
        if(i==3||i==10||i==17||i==24||i==31){
            System.out.println();
        } 
         }
    }
}
//Handles the case when the first is on a Friday

if(firstDay.get(Calendar.DAY_OF_WEEK)==6){
     if(highLightDates.contains(1)||(1==highLightCurrentDate.get(Calendar.DATE)&&highLightCurrentDate.get(Calendar.MONTH)==cal.get(Calendar.MONTH)&&highLightCurrentDate.get(Calendar.YEAR)==cal.get(Calendar.YEAR))){
            System.out.printf("%27s%3s"," [1]","");
    } 
    else{System.out.printf("%26s%4s","1","");}
    for(int i=2;i<=x;i++){
           if(highLightDates.contains(i)||(i==highLightCurrentDate.get(Calendar.DATE)&&highLightCurrentDate.get(Calendar.MONTH)==cal.get(Calendar.MONTH)&&highLightCurrentDate.get(Calendar.YEAR)==cal.get(Calendar.YEAR))){
                    System.out.printf("%-5s","["+i+"]");
                   
                    if(i==2||i==9||i==16||i==23||i==30){
            System.out.println();
            
        } 
                  
        }
           else{
        System.out.printf("%-5s",i);
        if(i==2||i==9||i==16||i==23||i==30){
            System.out.println();
        } 
           }
    }
}
//Handles the case when the first is on a Saturday

if(firstDay.get(Calendar.DAY_OF_WEEK)==7){
     if(highLightDates.contains(1)||(1==highLightCurrentDate.get(Calendar.DATE)&&highLightCurrentDate.get(Calendar.MONTH)==cal.get(Calendar.MONTH)&&highLightCurrentDate.get(Calendar.YEAR)==cal.get(Calendar.YEAR))){
            System.out.printf("%32s%3s"," [1]","");
    } 
    else{System.out.printf("%31s%4s","1","");
     }
     System.out.println();
    for(int i=2;i<=x;i++){
         if(highLightDates.contains(i)||(i==highLightCurrentDate.get(Calendar.DATE)&&highLightCurrentDate.get(Calendar.MONTH)==cal.get(Calendar.MONTH)&&highLightCurrentDate.get(Calendar.YEAR)==cal.get(Calendar.YEAR))){
                    System.out.printf("%-5s","["+i+"]");
                   
                    if(i==8||i==15||i==22||i==29){
            System.out.println();
            
        } 
                
        }
         else{
                System.out.printf("%-5s",i);
                if(i==8||i==15||i==22||i==29){
            System.out.println();
    }
         }
    }
}
}



    
}

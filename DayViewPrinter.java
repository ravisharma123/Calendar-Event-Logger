
import java.util.ArrayList;
import java.util.Calendar;



/**
 *
 * @author Ravi Sharma
 * The DayViewPrinter class is responsible to print the calendar with a day view
 * which lists all events happening on the current day being viewed by user
 */
public class DayViewPrinter {
    /**
     * The instance variables used are the current date calendar object
     * all the events in an arraylist
     */
private Calendar currentDate;
private ArrayList<Event> allEvents;
public DayViewPrinter(Calendar setCurrentDate, ArrayList<Event>setAllEvents){
    currentDate=setCurrentDate;
    allEvents=setAllEvents;
    
}
/**
 * This method prints all events happening on the current date in sorted order
 * @param dayToGetEventsFor, the date to print the events for
 */
public void printDateandEventsOnThisDay(Calendar dayToGetEventsFor){
    int x=0;
    for(int i=0;i<allEvents.size();i++){
        if(allEvents.get(i).getDate()==dayToGetEventsFor.get(Calendar.DATE)&&allEvents.get(i).getMonth()==dayToGetEventsFor.get(Calendar.MONTH)&&allEvents.get(i).getYear()==dayToGetEventsFor.get(Calendar.YEAR)){
            System.out.println((allEvents.get(i).getMonth()+1)+"/"+allEvents.get(i).getDate()+"/"+allEvents.get(i).getYear()+" "+allEvents.get(i).getStringStartandFinish()+" "+allEvents.get(i).getEventTitle());
            x++;
        }
    }
    if(x==0){
        
        System.out.println((dayToGetEventsFor.get(Calendar.MONTH)+1)+"/"+dayToGetEventsFor.get(Calendar.DATE)+"/"+dayToGetEventsFor.get(Calendar.YEAR)+"  No Events On this Date");
    }
}
}

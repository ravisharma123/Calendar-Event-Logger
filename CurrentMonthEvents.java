
import java.util.ArrayList;
import java.util.Calendar;


/**
 *
 * @author Ravi Sharma
 
 The CurrentMonthEvents class is responsible for extracting
all the events that are happening in the current month so they can be used to 
highlight these dates in the month view of the calendar
 
 */

public class CurrentMonthEvents {
    /**
     * The instance variables used are an arraylist of all the events 
     * an arraylist that holds only current month event dates
     * and a calendar object that is current month
     */
private ArrayList<Event> allEvents;
private ArrayList<Integer> currentMonthEventDates;
private Calendar currentMonth;
/**
 * The constructor takes in all the events from the main class and the current calendar object
 * @param setAllEvents, all the events 
 * @param currentCal the current calendar for todays date
 */
    public CurrentMonthEvents(ArrayList<Event> setAllEvents,Calendar currentCal){
        allEvents=setAllEvents;
        currentMonthEventDates=new ArrayList<>();
        currentMonth=currentCal;
    }
    /**
     * This method sets all the events
     * @param setAllEvents, all events
     */
    public void setAllEvents(ArrayList<Event> setAllEvents){
        allEvents=setAllEvents;
    }
    /**
     * This method sets the current month to get all events happening in this month
     * @param setCurrentMonth 
     */
    public void setCurrentMonth(Calendar setCurrentMonth){
        currentMonth= setCurrentMonth;
    }
    /**
     * This method extracts all the events happening in the current month 
     * and it stores them in a new arrayList called currentMonthEventDates
     * @return currentMonthEventDates (arrayList holding all the integer event dates)
     */
    public ArrayList<Integer> getCurrentMonthEventDates(){
    if(currentMonthEventDates.size()>0){
        currentMonthEventDates.removeAll(currentMonthEventDates);
    }
    for(int i=0;i<allEvents.size();i++){
        if(allEvents.get(i).getMonth()==currentMonth.get(Calendar.MONTH)&&allEvents.get(i).getYear()==currentMonth.get(Calendar.YEAR)){
            currentMonthEventDates.add(allEvents.get(i).getDate());
        }
    }
    return currentMonthEventDates;
            
}
    /**
     * this method empties out the current month event dates because 
     * when user navigates to the next month the array list needs to be empty
     * so that the previous months dates don't get highlighted on the next month
     */
    public void reset(){
        currentMonthEventDates.removeAll(currentMonthEventDates);
    }
    /**
     * prints the currentMonthEventDates
     */
    public void printCurrentEventDates(){
    for(int i=0; i<currentMonthEventDates.size();i++){
        System.out.println(currentMonthEventDates.get(i));
    }
}
}

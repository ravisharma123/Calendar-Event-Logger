
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

/*
 * The Event Class
 */

/**
 *
 * @author Ravi Sharma
 * This class is responsible for creating an event object that hold
 * the event title, the date, the start time and end time
 */
public class Event{
private String eventTitle;
private Calendar startTime;
private Calendar endTime;
private Calendar eventDateandTime;
private String stringStartandFinish;

/**
 * This constructor creates an event and initializes the title and date
 * @param setEventTitle, the title for the event to be scheduled
 * @param setEventDateandTime, the events date for when it should be scheduled
 */
    public Event(String setEventTitle, Calendar setEventDateandTime){
        eventTitle=setEventTitle;
        eventDateandTime=setEventDateandTime;
    }
    public Event(){
        
    }
    /**
     * This method returns the date of the event
     * @return eventDateandTime, the date of the event
     */
    public int getDate(){
        return eventDateandTime.get(Calendar.DATE);
    }
    /**
     * Returns the month of the event
     * @return the month
     */
    public int getMonth(){
        return eventDateandTime.get(Calendar.MONTH);
    }
    /**
     * Returns the year of the event
     * @return  the year
     */
    public int getYear(){
        return eventDateandTime.get(Calendar.YEAR);
        
    }
    /**
     * Returns the specific time of the event
     * @return the time
     */
    public Date getDateandTime(){
                return eventDateandTime.getTime();

    } 
    /**
     * Returns the even title
     * @return eventTitle
     */
    public String getEventTitle(){
        return eventTitle;
    }
    /**
     * Sets the title of the event 
     * @param setTitle, the title to be set for the event
     */
    public void setEventTitle(String setTitle){
        eventTitle=setTitle;
    }
    /**
     * This method sets the finishing time of the event
     * @param setEndTime, the finish time of event
     */
    public void setEventFinishTime(Calendar setEndTime){
        endTime=setEndTime;
    }
    /**
     * Gets the finishing time of the event
     * @return 
     */
    public Calendar getEventFinishTime(){
        return endTime;
    }
    /**
     * Set the starting time of the event
     * @param setStart, the start time
     */
    public void setStartTime(Calendar setStart){
        startTime=setStart;
    }
    /**
     * gets the start time of the event
     * @return the starting time
     */
    public Calendar getEventStartTime(){
        return startTime;
    }
    /**
     * Prints the start to finish time in a certain format (army time 24hours clock format)
     * @return the String format of the start to finish time
     */
    public String printStartToFinishTime(){
        return ""+startTime.get(Calendar.HOUR)+":"+startTime.get(Calendar.MINUTE)+"-"+endTime.get(Calendar.HOUR)+":"+endTime.get(Calendar.MINUTE);
    }
    /**
     * Sets the string format of the start to finish time
     * @param setStartFinish, the formated string to display time of the event from start to finish
     */
    public void setStringStartTimeandFinishTime(String setStartFinish){
        stringStartandFinish=setStartFinish;
    }/**
     * Gets the string format of the start to finish
     * @return String format of event timing
     */
    public String getStringStartandFinish(){
        return stringStartandFinish;
    }
}

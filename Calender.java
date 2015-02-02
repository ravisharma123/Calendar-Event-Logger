
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
/**
 * 
 * @author Ravi Sharma
 * This is the Calendar class that holds the main method and 
 * this class is responsible for the interactions between the user
 * It also displays a menu that allows user to perform a certain action 
 */
public class Calender{
    /**
     * The instance variables used are 
     * a printCalendar object used to print the month view of the calendar
     * an objects CurrentMonthEvents that holds all the events happening in current month
     * a Calendar object for the currentCalendar
     * and a Calendar object used to delete all events on a selected date
     */
       private static printCalendar calPrinter;
       private static CurrentMonthEvents currentEvents;
       private static Calendar currentCal = Calendar.getInstance();
       private static ArrayList<Event> events = new ArrayList<Event>();
       private static Calendar delete = Calendar.getInstance();

    public static void main(String[]args) throws FileNotFoundException{
       
        System.out.println();
        currentCal = Calendar.getInstance();
        calPrinter = new printCalendar(currentCal);
        currentEvents = new CurrentMonthEvents(events,currentCal);
        calPrinter.printCal(currentCal,currentEvents.getCurrentMonthEventDates());
        menu();

        
    }
    /**
     * This method is the menu method that displays the menu and interacts with the user
     * so that user can perform certain tasks such as view the calendar either by date or month
     * or create an event, delete an event on a certain date or delete all events, or go to a
     * certain date and get a list of events scheduled on that date, or print the event list lastly 
     * it allows them to quit
     * @throws FileNotFoundException 
     */
    public static void menu() throws FileNotFoundException{
        //initially print current calendar month view
           currentCal = Calendar.getInstance();
        calPrinter = new printCalendar(currentCal);
         currentEvents = new CurrentMonthEvents(events,currentCal);
        System.out.println();
        //display the menu
        System.out.println("[V]eiw By, [C]reate, [G]o to, [D]elete, [E]vent List, [Q]uit");
        Scanner inputReader = new Scanner(System.in);
        String option = inputReader.next();
        //handles the view option
        if(option.equalsIgnoreCase("v")){
           System.out.println("[D]ay, [M]onth");
           String viewBy = inputReader.next();
           //handles the month view
        if(viewBy.equalsIgnoreCase("m")){
            calPrinter.printCal(currentCal,currentEvents.getCurrentMonthEventDates());
        System.out.println();
        System.out.println("[N]ext, [P]revious, [M]ain Menu");
        String traverseOption = inputReader.next();
        while(!traverseOption.equalsIgnoreCase("m")){
            //n to navigate forward and p to go backwards
        if(traverseOption.equalsIgnoreCase("n")){

             currentEvents.reset();
             currentCal.add(Calendar.MONTH, 1);
             calPrinter.setCalendar(currentCal);
             currentEvents.setCurrentMonth(currentCal);
             calPrinter.printCal(currentCal,currentEvents.getCurrentMonthEventDates());
             
        }
        else if(traverseOption.equalsIgnoreCase("p")){
             currentEvents.reset();
             currentCal.add(Calendar.MONTH, -1);
             calPrinter.setCalendar(currentCal);
             currentEvents.setCurrentMonth(currentCal);
             calPrinter.printCal(currentCal,currentEvents.getCurrentMonthEventDates());
        }
       
          System.out.println();
          System.out.println("[N]ext, [P]revious, [M]ain Menu");
          traverseOption = inputReader.next();
        }
        menu();
           }
        else{
            sortEvents();
            DayViewPrinter printDateView = new DayViewPrinter(currentCal, events);
            printDateView.printDateandEventsOnThisDay(currentCal);
            System.out.println("[N]ext, [P]revious, [M]ain Menu");
            Scanner traverseByDateScanner = new Scanner(System.in);
            String traverseByDateOption = traverseByDateScanner.next();
            while(!traverseByDateOption.equalsIgnoreCase("m")){
            if(traverseByDateOption.equalsIgnoreCase("n")){
                currentCal.add(Calendar.DATE, 1);
                printDateView.printDateandEventsOnThisDay(currentCal);
            }
            else if(traverseByDateOption.equalsIgnoreCase("p")){
                currentCal.add(Calendar.DATE, -1);
                printDateView.printDateandEventsOnThisDay(currentCal);
            }
                        System.out.println("[N]ext, [P]revious, [M]ain Menu");
                        traverseByDateOption = traverseByDateScanner.next();
        }
            menu();
        }
        }
        //handles the case if user wants to create an event
        else if(option.equalsIgnoreCase("c")){
            createEvents();
        }
        //prints out all current events if user type in e for event list
        else if(option.equalsIgnoreCase("e")){
            if(events.isEmpty()){
                System.out.println("No events");
            }
            printAllEventListInSortedOrder();
            menu();
        }
        //handles the deletion option
        else if(option.equalsIgnoreCase("d")){
            Delete();
        }
        //handles the go to date option
        else if(option.equalsIgnoreCase("g")){
            sortEvents();
            System.out.println("Enter the date you want to navigate to (MM/DD/YYYY");
            Calendar goToDate = Calendar.getInstance();
            Scanner goToDateScanner = new Scanner(System.in);
            String dateToGoTo = goToDateScanner.next();
            int monthToGoTo = Integer.parseInt(dateToGoTo.substring(0,2));
            int dateToGo = Integer.parseInt(dateToGoTo.substring(3,5));
            int yearToGoTo= Integer.parseInt(dateToGoTo.substring(6));
            goToDate.set(yearToGoTo, monthToGoTo-1, dateToGo);
            DayViewPrinter printDateToGoTo= new DayViewPrinter(goToDate, events);
            printDateToGoTo.printDateandEventsOnThisDay(goToDate);
            menu();
            
        }
        //When user quits a file is created called reservations.txt that holds all the reservations that exist
        else if(option.equalsIgnoreCase("q")){
            PrintWriter out = new PrintWriter("reservations.txt");
            if(!events.isEmpty()){
            sortEvents();
        for(int i=0;i<events.size();i++){
           out.println((events.get(i).getMonth()+1)+"/"+events.get(i).getDate()+"/"+events.get(i).getYear()+" "+events.get(i).getStringStartandFinish()+" "+events.get(i).getEventTitle());
        }
        }
            out.close();
        }

    }
    /**
     * This method is used to create an event which consists of getting
     * user input for the title date and start time and finish time
     * and constructing an event object of that and adding it to the eventList
     * @throws FileNotFoundException 
     */
    public static void createEvents() throws FileNotFoundException{
        System.out.println("Enter Event Title");
        Scanner eventCreaterScanner = new Scanner(System.in);
        String eventTitle = eventCreaterScanner.nextLine();
        System.out.println("Enter Date of Event MM/DD/YYYY");
        String inputedDate= eventCreaterScanner.next();
        System.out.println("Enter start time of event (24 hour army time clock) HH:MM");
        String startTime = eventCreaterScanner.next();
        System.out.println("Enter ending time of event (24 hour army time clock) HH:MM");
        String endingTime = eventCreaterScanner.next();
        String startHour = startTime.substring(0,2);
        String startMinute = startTime.substring(3);
        String endHour = endingTime.substring(0, 2);
        String endMinute = endingTime.substring(3);
        int setStartHour=0;
        int setStartMinute=0;
        int setEndingHour=0;
        int setEndingMinute=0;
        if(startHour.startsWith("0")){
            setStartHour=Integer.parseInt(startHour.substring(1));
        }
        else{
            setStartHour=Integer.parseInt(startHour);
        }
        if(startMinute.startsWith("0")){
            setStartMinute=Integer.parseInt(startMinute.substring(1));
        }
        else{
            setStartMinute=Integer.parseInt(startMinute);
        }
        if(endHour.startsWith("0")){
            setEndingHour=Integer.parseInt(endHour.substring(1));
        }
        else{
            setEndingHour=Integer.parseInt(endHour);
        }
        if(endMinute.startsWith("0")){
            setEndingMinute=Integer.parseInt(endMinute.substring(1));
        }
        else{
            setEndingMinute=Integer.parseInt(endMinute);
        }
        
        String month=inputedDate.substring(0,2);
        String date = inputedDate.substring(3,5);
        int year = Integer.parseInt(inputedDate.substring(6));
        int monthInt=0;
        int dateInt =0;
        if(month.startsWith("0")){
            monthInt=Integer.parseInt(month.substring(1));
        }
        else{
            monthInt=Integer.parseInt(month);
        }
         if(date.startsWith("0")){
            dateInt=Integer.parseInt(date.substring(1));
        }
         else{
             dateInt=Integer.parseInt(date);
         }

        Calendar setEventDate = Calendar.getInstance();
        setEventDate.set(year, monthInt-1, dateInt);
        Calendar setStartTimeofEvent = Calendar.getInstance();
        setStartTimeofEvent.set(year, monthInt-1, dateInt, setStartHour, setStartMinute);
        Calendar setEndTimeofEvent =Calendar.getInstance();
        setEndTimeofEvent.set(year, monthInt-1, dateInt, setEndingHour, setEndingMinute);
        if(setEndTimeofEvent.before(setStartTimeofEvent)){
            System.out.println("The ending time is not valid because it is before the starting time of the event. Please create event again");
            createEvents();
        }
        else{
        Event newEvent = new Event(eventTitle,setEventDate);
        newEvent.setStartTime(setStartTimeofEvent);
        newEvent.setEventFinishTime(setEndTimeofEvent);
        newEvent.setStringStartTimeandFinishTime(startHour+":"+startMinute+"-"+endHour+":"+endMinute);
        events.add(newEvent);
        currentEvents.setAllEvents(events);
        menu();
        }
    }
    /**
     * This method is responsible for printing all the events in the arraylist in order from most recent to latest
     */
    public static void printAllEventListInSortedOrder(){
        sortEvents();
        for(int i=0;i<events.size();i++){
            System.out.println((events.get(i).getMonth()+1)+"/"+events.get(i).getDate()+"/"+events.get(i).getYear()+" "+events.get(i).getStringStartandFinish()+" "+events.get(i).getEventTitle());
        }
    }
    /**
     * This method is responsible for deleting all events on a certain date or all events in the arraylist of events
     * @throws FileNotFoundException 
     */
    public static void Delete() throws FileNotFoundException{
        System.out.println("[S]elected, [A]ll");
        Scanner deleteEventScanner = new Scanner(System.in);
        String deleteOption = deleteEventScanner.next();
        if(deleteOption.equalsIgnoreCase("s")){
            System.out.println("Enter the Date to delete all events scheduled on that date(MM/DD/YYYY");
            String eventsToDelete = deleteEventScanner.next();
            int monthToDelete= Integer.parseInt(eventsToDelete.substring(0,2));
            int dateToDelete = Integer.parseInt(eventsToDelete.substring(3,5));
            int yearToDelete = Integer.parseInt(eventsToDelete.substring(6));
            delete.set(yearToDelete, monthToDelete-1, dateToDelete);
            for(int i=0;i<events.size();i++){
                if(events.get(i).getMonth()==delete.get(Calendar.MONTH)&&events.get(i).getDate()==delete.get(Calendar.DATE)&&events.get(i).getYear()==delete.get(Calendar.YEAR)){
                    events.remove(i);
                }
            }
                    
            
        }
        else if(deleteOption.equalsIgnoreCase("a")){
            events.removeAll(events);
        }
        menu();
    }
    /**
     * This method sorts the arrayList of events in ascending order sing a comparator and anonymous class
     */
    public static void sortEvents(){
        if(events.size()>0){
         Comparator<Event> comp = new Comparator<Event>(){
            public int compare(Event e1, Event e2){
                if(e1.getEventStartTime().before(e2.getEventStartTime())){
                    return -1;
                }
                else if(e1.getEventStartTime().after(e2.getEventStartTime())){
                    return 1;
                }
                else{
                    return 0;
                }
                 }
                
        };
        Collections.sort(events, comp);
        
    }}
    
    
}
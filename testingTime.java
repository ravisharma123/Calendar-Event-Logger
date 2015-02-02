
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ravi Sharma
 */
public class testingTime {
public static void main(String[]args){
    Calendar dateOne = Calendar.getInstance();
    dateOne.set(2014, 9, 10, 7, 30);
        Calendar dateOneEndTime = Calendar.getInstance();
        dateOneEndTime.set(2014, 9, 10, 7, );
        System.out.println(dateOne.before(dateOneEndTime));
}
}

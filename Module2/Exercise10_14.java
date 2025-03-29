//*10.14 (The MyDate class) Design a class named MyDate. The class contains:

// The data fields year, month, and day that represent a date. month is 0-based, i.e., 0 is for January.

// A no-arg constructor that creates a MyDate object for the current date.

// A constructor that constructs a MyDate object with a specified elapsed time since midnight, January 1, 1970, in milliseconds.

// A constructor that constructs a MyDate object with the specified year, month, and day.

// Three getter methods for the data fields year, month, and day, respectively.

// A method named setDate(long elapsedTime) that sets a new date for the object using the elapsed time.

// Draw the UML diagram for the class then implement the class. Write a test program that creates two MyDate objects (using new MyDate() and new MyDate(34355555133101L)) and displays their year, month, and day.

//        System.out.println("The date after " + milliseconds + " milliseconds have passed since 01/01/1970 is " + (month + 1) + "/" + day + "/" + year + ".");

//        System.out.println("Today's date is: " + (month + 1) + "/" + day + "/" + year);
import java.util.GregorianCalendar;


class Exercise10_14 {
    public static void main (String[] args){
        MyDate date = new MyDate();
        long elapsedTime = 34355555133101L;
        MyDate date2 = new MyDate(elapsedTime);

        System.out.println("Today's date is " + date.getDay() + "/" + (date.getMonth() + 1) + "/" + date.getYear());
        System.out.println("The date after " + elapsedTime + " milliseconds have passed will be " + date2.getDay() + "/" + (date2.getMonth() + 1) + "/" + date2.getYear());

    }
}

class MyDate {
    //no arg constructor that creates a MyDate object for the current date
    private int year;
    private int month;
    private int day;

    public MyDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(System.currentTimeMillis());
        year = calendar.get(GregorianCalendar.YEAR);
        month = calendar.get(GregorianCalendar.MONTH); //do I need to +1 for folk?
        day = calendar.get(GregorianCalendar.DAY_OF_MONTH);

    }
    public MyDate(long milliseconds) {
        this.setDate(milliseconds);



}
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month - 1;
        this.day = day;
    }

    //month getter
    public int getMonth(){
        return month;
    }
    //day getter
    public int getDay(){
        return day;
    }
    //year getter
    public int getYear(){
        return year;
    }
    //setter
    public void setDate(long milliseconds){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(milliseconds);
        
        this.month = calendar.get(GregorianCalendar.MONTH);
        this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        this.year = calendar.get(GregorianCalendar.YEAR);
    }

}
package toolBox.io;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

import static java.time.temporal.ChronoUnit.YEARS;

/**
 * Created by Ari on 8/16/16.
 */
public class DateTime {

    public static void main(String[] args) {
        getCurrentDate();
        getCurrentDateTime();
        getCurrentDayMonthYear();
        getSpecificDate(1982,9,12);
        isSameDates(1982,9,12);
        isAnniversary(1982,9,12);
        getCurrentTime();
        addHours(12);
        addWeeks(4);
        subtractYears(3);
        getCurrentUTCClock();
        getCurrentLocalClock();
        isDateBefore(getSpecificDate(2007,10,10),getCurrentDate());
        isDateAfter(getCurrentDate(),getSpecificDate(1982,9,12));
        isDateBetween(getSpecificDate(1982,9,12),getCurrentDate(),getSpecificDate(2001,12,21) );
        daysBetweenDates(getSpecificDate(1982,9,12), getCurrentDate());
        printAllTimeZones();
        getCurrentZonedDateTime("America/Toronto");

        howManyDaysInAMonth(2001, 12);
        isLeapYear(2012);
        defaultFormatting("19590709");
        customFormatting("Jun 03 2003");
        dateToPrettyString(LocalDateTime.now());
    }

    /**
     *Displays Today's date by YYYY-MM-dd format
     */
    private static LocalDate getCurrentDate() {
        LocalDate today = LocalDate.now();
        System.out.print("Today's Local date : " + today);
        System.out.println("#1");
        return today;
    }
    /**
     *Displays Today's date  and time by YYYY-MM-ddHH:MM:SS:MLS format
     */
    private static LocalDateTime getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.print("The current Local date and time: " + now);
        System.out.println("#2");
        return now;
    }
    /**
     *Displays Today's date by Year: YYYY Month: MM day: dd format
     */
    private static void getCurrentDayMonthYear() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year: %d Month: %d day: %d \t ", year, month, day);
        System.out.println("#3");
    }
    /**
     *Takes 3 int values by year month, day and places it in a parallel date format
     */

    private static LocalDate getSpecificDate(int year, int month, int day) {
        LocalDate specificDate = LocalDate.of(year, month, day);
        System.out.print("Your Date of birth is : " + specificDate);
        System.out.println("#4");
        return specificDate;
    }
    /**
     *Compares getSpecificDate input value with current date and uses if else statements to see if they are the same
     * returns result
     */
    private static boolean isSameDates(int year, int month, int day) {
        LocalDate testDate = getSpecificDate(year, month, day);
        LocalDate today = getCurrentDate();
        boolean isSameDate = false;
        if(testDate.equals(today)){
            System.out.printf("Today %s and date1 %s are the same date ", today, testDate);
            isSameDate = true;
        } else {
            System.out.printf("Today %s and date1 %s are NOT the same date ", today, testDate);
        }
        System.out.println("#5");
        return isSameDate;
    }
    /**
     *Compares getSpecificDate input value with current date's month and day, uses a boolean value and
     * if else statement to see if they are the same
     * returns result
     */
    private static boolean isAnniversary(int year, int month, int day) {
        LocalDate originalDate = getSpecificDate(year, month, day);
        LocalDate today = getCurrentDate();
        boolean isAnnualRecurrence = false;
        MonthDay anniversary = MonthDay.of(originalDate.getMonth(), originalDate.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);
        if(currentMonthDay.equals(anniversary)){
            System.out.print("Today is the anniversary!!");
            isAnnualRecurrence = true;

        } else {
            System.out.print("Today is NOT the anniversary.");
        }
        System.out.println("#6");
        return isAnnualRecurrence;
    }
    /**
     *Displays Today's time by HH:MM:SS:mls format
     */
    private static LocalTime getCurrentTime() {
        LocalTime time = LocalTime.now();
        System.out.print("local time now : " + time);
        System.out.println("#7");
        return time;
    }
    /**
     *Displays Today's time  +plus int input hours+ by HH:MM:SS:mls format
     */
    private static LocalTime addHours(int hours) {
        LocalTime time = getCurrentTime();
        LocalTime newTime = time.plusHours(hours);
        System.out.print("Time after "+hours+" hours : " + newTime);
        System.out.println("#8");
        return newTime;
    }
    /**
     *Displays Today's date by YYYY-MM-dd then adds +int input of weeks+ and displays that date by YYYY-MM-dd format
     */
    private static LocalDate addWeeks(int weeks) {
        LocalDate today = getCurrentDate();
        LocalDate newDate = today.plus(weeks, ChronoUnit.WEEKS);
        System.out.print("Today is : " + today);
        System.out.print("Date after "+weeks+" week(s) : " + newDate);
        System.out.println("#9");
        return newDate;
    }
    /**
     *Displays -int input minus number of years from Today's date
     * then displays by YYYY-MM-dd format
     */
    private static LocalDate subtractYears(int years) {
        LocalDate today = getCurrentDate();
        LocalDate newDate = today.minus(1, YEARS);
        System.out.print("Date, "+years+" year(s) ago : " + newDate);
        System.out.println("#10");
        return newDate;
    }
    /**
     *Displays SystemClock[]
     */
    private static Clock getCurrentUTCClock() {
        Clock clock = Clock.systemUTC();
        System.out.print("UTC Clock : " + clock);
        System.out.println("#11");
        return clock;
    }
    /**
     *Displays local time zones SystemClock[]
     */
    private static Clock getCurrentLocalClock() {
        Clock clock = Clock.systemDefaultZone();
        System.out.print("Local Time Zone Clock : " + clock);
        System.out.println("#12");
        return clock;
    }
    /**
     *Displays input date YYYY-MM-dd and verifies whether it is before second input date YYYY-MM-dd
     * returns result
     */
    private static boolean isDateBefore(LocalDate testDate, LocalDate isBeforeDate) {
        boolean isBefore = false;
        if(testDate.isBefore(isBeforeDate)){
            System.out.print(testDate+" is before "+isBeforeDate);
            isBefore = true;
        } else {
            System.out.print(testDate+" is NOT before "+isBeforeDate);
        }
        System.out.println("#13");
        return isBefore;
    }
    /**
     *Displays input date YYYY-MM-dd and verifies whether it is after second input date YYYY-MM-dd
     *returns result
     */
    private static boolean isDateAfter(LocalDate testDate, LocalDate isAfterDate) {
        boolean isBefore = false;
        if(testDate.isAfter(isAfterDate)){
            System.out.print(testDate+" is after "+isAfterDate);
            isBefore = true;
        } else {
            System.out.print(testDate+" is NOT after "+isAfterDate);
        }
        System.out.println("#14");
        return isBefore;
    }
    /**
     *Displays input date YYYY-MM-dd and compares it see if it is before to second input date YYYY-MM-dd
     * compares second input date to  see if it is before third input date YYYY-MM-dd
     * returns result is between or is not between
     */
    private static boolean isDateBetween(LocalDate testDate, LocalDate rangeStartDate, LocalDate rangeEndDate) {
        boolean isDateWithinRange = false;
        if(isDateAfter(testDate,rangeStartDate) && isDateBefore(testDate,rangeEndDate)) {
            System.out.print(testDate+" is between "+rangeStartDate+" and "+rangeEndDate);
            isDateWithinRange = true;
        } else {
            System.out.print(testDate+" is NOT between "+rangeStartDate+" and "+rangeEndDate);
        }
        System.out.println("#15");
        return isDateWithinRange;
    }
    /**
     *Returns a count of days between first input date and second input date in YYYY-MM-dd format
     */
    private static int daysBetweenDates(LocalDate start, LocalDate end) {
        Period daysBetween = Period.between(start, end);
        System.out.print("There are "+daysBetween.getDays()+" days between "+start+" and "+end);
        System.out.print("There are "+daysBetween.getMonths()+" months between "+start+" and "+end);
        System.out.print("There are "+daysBetween.getYears()+" years between "+start+" and "+end);
        System.out.println("#16");
        return daysBetween.getDays();
    }
    /**
     *Generates a list of all time one call names
     */
    private static void printAllTimeZones() {
        String[] allTimeZones = TimeZone.getAvailableIDs();
        System.out.println("TIME ZONE: ---------------------------------------------- ");
        for(String timeZone : allTimeZones) {
            System.out.println("TIME ZONE: "+timeZone);
        }
        System.out.print("TIME ZONE: ---------------------------------------------- ");
        System.out.println("#17");
    }
    /**
     * Displays current tdate and time by local time zone in YYYY-MM-ddHH:MM:SS.mls-12hr:00min format
     */
    private static ZonedDateTime getCurrentZonedDateTime(String timeZone) {
        ZoneId requestedZone = ZoneId.of(timeZone);
        LocalDateTime here = getCurrentDateTime();
        ZonedDateTime there = ZonedDateTime.of(here,requestedZone);
        System.out.print("The current date and time in "+requestedZone+" is: "+there);
        System.out.println("#18");
        return there;
    }
    /**
     *Calculates input of YYYY MM and returns a count of days in that month
     */
    private static int howManyDaysInAMonth(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year,month);
        int daysInMonth = yearMonth.lengthOfMonth();
        System.out.printf("Days in month year %s: %d", yearMonth, daysInMonth);
        System.out.println("#19");
        return daysInMonth;
    }
    /**
     *Takes YYYY input and calculates whether or not it was/is/will be a leap year
     */
    private static boolean isLeapYear(int year) {
        LocalDate today = getCurrentDate();
        LocalDate checkYear = getSpecificDate(year,today.getMonthValue(),today.getDayOfMonth());
        boolean isLeapYear = false;
        if(checkYear.isLeapYear()) {
            System.out.print(year+" is a leap year");
            isLeapYear = true;
        } else {
            System.out.print(year+" is NOT a leap year");
        }
        System.out.println("#20");
        return isLeapYear;
    }
    /**
     *takes a number string of YYYYMMdd and converts it to YYYY-MM-dd format
     */
    private static void defaultFormatting(String basicIsoDate) {
        LocalDate formattedDate = LocalDate.parse(basicIsoDate, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s ", basicIsoDate, formattedDate);
        System.out.println("#21");
    }
    /**
     *takes a MMM dd YYYY string and parses it into YYYY-MM-dd format
     */
    private static void customFormatting(String prettyDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
            LocalDate formattedDate = LocalDate.parse(prettyDate, formatter);
            System.out.printf("Successfully parsed String %s, date is %s", prettyDate, formattedDate);
        } catch (DateTimeParseException ex) {
            System.out.printf("%s is not parsable!", prettyDate);
            ex.printStackTrace();
        }
        System.out.println("#22");
    }
    /**
     *Takes LocalDateTime.now() and converts it into MMM dd YYYY 00:00 AM/PM format ****
     */
    private static String dateToPrettyString(LocalDateTime myDateTime) {
        String prettyString = null;
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
            prettyString = myDateTime.format(format);
            System.out.printf("Pretty date time String : %s ", prettyString);
        } catch (DateTimeException ex) {
            System.out.printf("%s can't be formatted!", myDateTime);
            ex.printStackTrace();
        }
        System.out.println("#23");
        return prettyString;
    }


}

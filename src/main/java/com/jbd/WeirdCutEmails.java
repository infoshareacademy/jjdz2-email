package com.jbd;




import com.sun.org.apache.xml.internal.security.utils.RFC2253Parser;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.joda.time.*;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.LocalTime.*;
import org.joda.time.*;
import org.joda.time.convert.DurationConverter;
import org.joda.time.format.DateTimeFormat;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.joda.time.DateTimeConstants.*;

public class WeirdCutEmails {

    LocalDateTime data5 = LocalDateTime.parse("2007-12-03T10:15:30");


   // String datum1 = "Sun, 18 Apr 2004 02:32:43";
   // LocalDateTime data1 = LocalDateTime.parse("Sun, 18 Apr 2004 02:32:43");

    String dateTime = "Sun, 18 Apr 2004 02:32:43";
    // Format for input
    org.joda.time.format.DateTimeFormatter dtf = DateTimeFormat.forPattern("EEE, dd MMM yyyy kk:mm:ss");
    // Parsing the date

    // Format for output
    org.joda.time.format.DateTimeFormatter dtfOut = DateTimeFormat.forPattern("EEE, dd MMM yyyy kk:mm:ss");
    // Printing the date


  //  LocalDateTime data2 = LocalDateTime.parse("Date: Sun, 18 Apr 2004 02:32:43");
  //  LocalDateTime data4 = LocalDateTime.parse("2nd October 2007 at 13:45.30.123456789");

  //  List<Email> result01;

   // LocalDateTime nowDateTime = LocalDateTime.now();
   // LocalDateTime olop = data5;


   // int yearOfCentury = data1.getYearOfCentury();
  //  int monthOfYear = data1.getMonthOfYear();
   // int dayOfMonth= data1.getDayOfMonth();
   // int miliSecondsOfDay = data1.getMillisOfDay();




public void test() {
    dtfOut.parseDateTime(dateTime);

    System.out.println(dtf);

    System.out.println(dtfOut);

    //System.out.println(dtfOut.print(jodatime));


    // System.out.println(str1);

//data007 = LocalDateTime.parse(data1, frm)

}
    public void isWorkingDay(){    // pobieramy z listy maili dzień tygodnia i sprawdzany czy była odpowiedź w ciągu 5 dni roboczych


       LocalDateTime sobota = new LocalDateTime(DayOfWeek.SATURDAY);
       LocalDateTime niedziela = new LocalDateTime(DayOfWeek.SUNDAY);


        boolean czySobota = false;
        boolean czyNiedziela = false;

if (czySobota|czyNiedziela == true)
        {
            System.out.println("jest sobota lub niedziela");   // Dodaj do listy
        }

    }

    public void fiveDaysNoAnswer() {   // porównujemy daty każdego z maili do teraźniejszości w milisekundach w kolejności rosnącej lub malejącej dodajemy do listy

        DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
        DateTime end = new DateTime(DateTime.now());

// duration in ms between two instants
        Duration dur = new Duration(start, end);
        Object o = dur;
// calc will be the same as end
        DateTime calc = start.plus(dur);

        System.out.println("dur =     " + dur);
        System.out.println("calc:    " + calc);




        DateTime start1 = new DateTime(2010, 12, 25, 0, 0, 0, 0);
        DateTime end1 = new DateTime(DateTime.now());

        Duration dur1 = new Duration(start1, end1);


        DateTime calc1 = start.plus(dur);

        System.out.println("dur1 =     " + dur1);
        System.out.println("calc1:    " + calc1);

    }


    public static void main(String[] args) {
        WeirdCutEmails lolo = new WeirdCutEmails();
        //  lolo.test();
        //lolo.fiveDaysNoAnswer();
        lolo.isWorkingDay();

    }}


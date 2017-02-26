package com.jbd.database;

import com.jbd.database.REST.Report;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@RequestScoped
public class ActivityReport {
    private List<User> userList = new ArrayList<>();
    private Map<String, Long> userMap;
    List<Report> reportList = new ArrayList<>();
    @Inject
    ManageDB manageDB;

    public List<Report> generateReport() {
        //userList = manageDB.searchForAll();
        List<User> resultList = new ArrayList<>();

        User s1 = new User();
        User s2 = new User();
        User s3 = new User();
        User s4 = new User();
        User s5 = new User();

        String time = "2017-02-01 10:30";
        String time2 = "2017-02-02 11:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime formatDateTime = LocalDateTime.parse(time, formatter);
        LocalDateTime date = LocalDateTime.parse(time2, formatter);

        s1.setLoginTime(formatDateTime);
        s1.setUsermail("mar@wp.pl");
        s1.setUsername("marcin");

        s2.setLoginTime(formatDateTime);
        s2.setUsermail("mar@wp.pl");
        s2.setUsername("marcin");

        s3.setLoginTime(date);
        s3.setUsermail("mar@wp.pl");
        s3.setUsername("marcin");

        s4.setLoginTime(formatDateTime);
        s4.setUsermail("jul@wp.pl");
        s4.setUsername("jula");

        s5.setLoginTime(formatDateTime);
        s5.setUsermail("mar@wp.pl");
        s5.setUsername("marcin");

        userList.add(s1);
        userList.add(s2);
        userList.add(s3);
        userList.add(s5);
        userList.add(s4);

        userList.forEach(System.out::println);


        Collections.sort(userList);
        System.out.println("After Sort: ");
        for (User u : userList
                ) {
            System.out.println(u);

        }
        int counter = 0;

        for (int i = 0; i < userList.size(); i++) {
            if (counter == 0) {
                reportList.add(new Report(userList.get(i), 1));
                counter++;
            } else {
                if (searchUser(userList.get(i))) {
                    System.out.println("Found user!");
                    int number = searchAndReturnUser(userList.get(i));
                    reportList.get(number).setCounter(reportList.get(number).getCounter()+1);
               }

                else {
                    System.out.println("Not the same!");
                    reportList.add(new Report(userList.get(i), 1));
                }

            }


        }


        System.out.println("Report!");
        for (Report r : reportList
                ) {
            System.out.println(r);

        }

    return  reportList;
    }

    public Boolean searchUser(User user) {
        for (Report r : reportList) {
            if (r.getUser().getLoginTime().getDayOfMonth() == user.getLoginTime().getDayOfMonth() && r.getUser().getUsername().equals(user.getUsername())) {
                return true;

            }
            break;
        }
        return false;
    }

    public int searchAndReturnUser(User user) {
        for (int i = 0; i < reportList.size(); i++) {
            if (reportList.get(i).getUser().getLoginTime().getDayOfMonth() == user.getLoginTime().getDayOfMonth() && reportList.get(i).getUser().getUsername().equals(user.getUsername()))
                return i;
        }
        return 1;
    }

}

package com.jbd.database;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@RequestScoped
public class ActivityReport {
    private List<User> userList = new ArrayList<>();
    private Map<String,Long> userMap;
    @Inject
    ManageDB manageDB;

    public void  generateReport(){
    userList = manageDB.searchForAll();
    List<User> resultList = new ArrayList<>();

    userList.forEach(System.out::println);


        if (userList.get(0).getUsername().equals("marcin")){
            System.out.println("Yes");
        }
        else{
            System.out.println("no");
        }

     resultList=  userList.stream()
                .filter(p -> p.getUsername().equals("marcin"))
                .peek(System.out::println)
                .collect(Collectors.toList());

        resultList.forEach(System.out::println);
    }
}

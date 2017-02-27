package com.jbd;


import com.jbd.authorization.SessionData;

public class Report {
    private SessionData user;
    private int counter;

    public SessionData getUser() {
        return user;
    }

    public void setUser(SessionData user) {
        this.user = user;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Report(SessionData user, int counter) {
        this.user = user;
        this.counter = counter;
    }

    public Report() {
    }

    @Override
    public String toString() {
        return "Report{" +
                "user=" + user +
                ", counter=" + counter +
                '}';
    }
}

//
//    SELECT DAYOFMONTH(loginTime), COUNT(username) FROM User WHERE username = 'Marcin Bartoszek' GROUP BY DAYOFMONTH(loginTime);
//
//
//        SELECT DATE_FORMAT(loginTime, '%Y %m %d'), COUNT(username) FROM User WHERE username = 'Marcin Bartoszek' GROUP BY
//        DATE_FORMAT(loginTime, '%Y %m %d');
//
//        INSERT INTO User values ('1', '2017-02-01', 'mb@wp.pl', 'marcin');
//        INSERT INTO User values ('2', '2017-02-01', 'mb@wp.pl', 'marcin');
//        INSERT INTO User values ('3', '2017-02-02', 'mb@wp.pl', 'marcin');
//        INSERT INTO User values ('4', '2017-02-01', 'em@wp.pl', 'jula');
package com.jbd.cutEmails;




import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


@SessionScoped
public class Fdna implements Serializable {
    public LocalDateTime data6 = LocalDateTime.of(2015, Month.DECEMBER, 05, 23, 59, 59);
    private List<LocalDateTime> ehe = new ArrayList<>();


    public void setEhe (List<LocalDateTime> ehe){
        ehe.add(data6);
        this.ehe.addAll(ehe);

    }
    public List<LocalDateTime> getEhe() {
        return ehe;
    }

}

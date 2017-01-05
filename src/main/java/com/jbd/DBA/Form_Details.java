package com.jbd.DBA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Form_Details implements Serializable {
    @Id
    @Column(name = "id_form_details")
    private Long id;

    private String response;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Form_Details{" +
                "id=" + id +
                ", response='" + response + '\'' +
                '}';
    }
}

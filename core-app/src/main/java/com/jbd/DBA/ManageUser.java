package com.jbd.DBA;


import com.jbd.Authorization.SessionData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
public class ManageUser implements Serializable {
    private static final Logger LOGGER = LogManager.getLogger(ManageUser.class);

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void saveUser(SessionData sessionData) {
        entityManager.persist(sessionData);
        LOGGER.info("Added to DB: " + sessionData.getUsername());
    }

    public SessionData getUser(Long id){
        SessionData sessionData =entityManager.find(SessionData.class, id);
        if (sessionData != null)
            LOGGER.info("Found user: " + sessionData.getUsername());
        else
            LOGGER.info("No user at DB with id: " + id);
        return sessionData;

        }

    public List<SessionData> searchForAll(){
        List<SessionData> userList = new ArrayList<>();
        TypedQuery<SessionData> query = entityManager.createNamedQuery("SessionData.findAll", SessionData.class);
        userList = query.getResultList();
        LOGGER.debug("All user list: " + userList);
        return userList;
    }
    @Transactional
    public void updateUser(SessionData user){
        entityManager.merge(user);
        LOGGER.info("Updated user: " + user.toString());
    }

    @Transactional
    public void saveForm(Form nameForm){
        entityManager.persist(nameForm);
        LOGGER.info("Save form to DB successfully!");
    }

    public Form getFormByName(String name){
        TypedQuery<Form> query = entityManager.createNamedQuery("Form.findByName", Form.class);
        query.setParameter("name",name);
        Form form = query.getSingleResult();
        LOGGER.info("Found user by name: " + form.getName());
        return form;
    }

    @Transactional
    public void saveFormDetails(Form_Details form_details){
        entityManager.persist(form_details);
        LOGGER.info("Save form_details to DB successfully!");
    }

    public Form_Details getFormDetails(Long id){
        Form_Details form_details = entityManager.find(Form_Details.class, id);
        LOGGER.info("Collected data form_details");
        return form_details;
    }





}

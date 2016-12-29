package com.jbd.DBA;


import com.jbd.Authorization.SessionData;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
public class SaveUser implements Serializable {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void saveUser(SessionData sessionData){
        entityManager.persist(sessionData);
    }

    public SessionData getUser(Long id){
        SessionData sessionData =entityManager.find(SessionData.class, id);
        return sessionData;
        }

    public List<SessionData> searchForAll(){
        List<SessionData> userList = new ArrayList<>();
        TypedQuery<SessionData> query = entityManager.createNamedQuery("SessionData.findAll", SessionData.class);
        userList = query.getResultList();
        System.out.println(userList);
        return userList;
    }


}

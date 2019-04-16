package io.khasang.bend.controller;

import io.khasang.bend.entity.HomePagesUrl;
import io.khasang.bend.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Controller
@RequestMapping("/")
public class FrontendController {

    protected EntityManager entityManager;

    @RequestMapping(value = "{homepageadress}", method = RequestMethod.GET)
    String getDynamicUriValueRegex(@PathVariable("homepageadress") String homepageadress){

        Query q = entityManager.createQuery("FROM HomePagesUrl WHERE url = ?1");
        q.setParameter(1, homepageadress);
        System.err.println("location query"+q.toString());
        List<HomePagesUrl> resultList = q.getResultList();
        if (!resultList.isEmpty()){
            System.out.println("location"+ homepageadress +"catched");
        }
        return "student-template";
    }


    //далее нужно проверить студент это или школа.. а лучше проверять это сразу в одном sql-запросе

//    @RequestMapping(value = "{name}", method = RequestMethod.GET)
//    String getDynamicUriValueRegex(@PathVariable("name") String name){
//        System.out.println("Name is "+name);
//        return "student-template";
//    }
//    @RequestMapping(value = "{name}", method = RequestMethod.GET)
//    String getDynamicUriValueRegex(@PathVariable("name") String name){
//        System.out.println("Name is "+name);
//        return "student-template";
//    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }


}

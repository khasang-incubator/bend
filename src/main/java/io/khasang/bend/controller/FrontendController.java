package io.khasang.bend.controller;

import io.khasang.bend.entity.HomePagesUrl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    String getDynamicUriValueRegex(@PathVariable("homepageadress") String homepageadress, Model model){

        Query q = entityManager.createQuery("FROM HomePagesUrl WHERE url = ?1");

        q.setParameter(1, homepageadress);
        System.err.println("location query"+q.toString());
        List<HomePagesUrl> resultList = q.getResultList();
        if (!resultList.isEmpty()){
            HomePagesUrl homePagesUrl = resultList.get(0);
            int i = homePagesUrl.getEntityId();
                switch (i){
                    case 0:
                        model.addAttribute("urlId", homePagesUrl.getId());
                        return "student-template";
                    case 1:
                        model.addAttribute("urlId", homePagesUrl.getId());
                        return "manager-template";
                }

            System.out.println("location"+ homepageadress +"catched");
        }
        return "student-template";
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
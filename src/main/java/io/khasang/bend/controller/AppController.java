package io.khasang.bend.controller;

import io.khasang.bend.service.*;
import io.khasang.bend.service.impl.BarsikCat;
import io.khasang.bend.service.impl.MurzikCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@ImportResource(value = "classpath:ioc.xml")
public class AppController {
    private final KnightService knightService;
    private final CreateTable createTable;
    private final QueriesTableCats queriesTableCats;
    private final MurzikCat murzik;
    private final BarsikCat barsik;

    @Autowired
    public AppController(KnightService knightService, CreateTable createTable, QueriesTableCats queriesTableCats, MurzikCat murzik, BarsikCat barsik) {
        this.knightService = knightService;
        this.createTable = createTable;
        this.queriesTableCats = queriesTableCats;
        this.murzik = murzik;
        this.barsik = barsik;
    }

    @RequestMapping("/quest/{val}")
    public String getQuest(@PathVariable("val") String enemy, Model model) {
        model.addAttribute("info", knightService.getAchievement(enemy));
        return "quest";
    }

    @RequestMapping("/create")
    public String getTableCreateStatus(Model model) {
        model.addAttribute("name", createTable.getTableCreationStatus("cats"));
        return "create";
    }

    @RequestMapping("/cats/insert")
    public String getInsertCatStatus(Model model) {
        model.addAttribute("name", queriesTableCats.getInsertCatStatus(barsik));
        return "insert";
    }

    @RequestMapping("/cats/select")
    public String getSelectCatStatus(Model model) {
        model.addAttribute("name", queriesTableCats.getSelectCatStatus(barsik.getCat_id()));
        return "select";
    }

    @RequestMapping("/cats/select.all")
    public String getSelectAllCatsStatus(Model model) {
        model.addAttribute("name", queriesTableCats.getSelectAllCatsStatus());
        return "select";
    }

    @RequestMapping("/cats/update")
    public String getUpdateCatsStatus(Model model) {
        model.addAttribute("name", queriesTableCats.getUpdateCatsStatus(murzik.getCat_id()));
        return "update";
    }

    @RequestMapping("/cats/delete")
    public String getDeleteCatsStatus(Model model) {
        model.addAttribute("name", queriesTableCats.getDeleteCatStatus(murzik));
        return "delete";
    }
}

package io.khasang.bend.controller;

import io.khasang.bend.service.QueriesTableColors;
import io.khasang.bend.service.impl.CreateTableColors;
import io.khasang.bend.service.impl.colors.ColorGrey;
import io.khasang.bend.service.impl.colors.ColorSmoke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppControllerColors {
    private final CreateTableColors createTable;
    private final QueriesTableColors queriesTableColors;
    private final ColorGrey grey;
    private final ColorSmoke smoke;

    @Autowired
    public AppControllerColors(CreateTableColors createTable, QueriesTableColors queriesTableColors, ColorGrey grey, ColorSmoke smoke) {
        this.createTable = createTable;
        this.queriesTableColors = queriesTableColors;
        this.grey = grey;
        this.smoke = smoke;
    }

    @RequestMapping("/create/colors")
    public String getTableCreateStatus(Model model) {
        model.addAttribute("name", createTable.getTableCreationStatus("colors"));
        return "create";
    }

    @RequestMapping("/colors/insert")
    public String getInsertColorStatus(Model model) {
        model.addAttribute("name", queriesTableColors.getInsertColorStatus(smoke));
        return "insert";
    }

    @RequestMapping("/colors/select")
    public String getSelectColorStatus(Model model) {
        model.addAttribute("name", queriesTableColors.getSelectColorStatus(grey.getId()));
        return "select";
    }

    @RequestMapping("/colors/select/all")
    public String getSelectAllColorsStatus(Model model) {
        model.addAttribute("name", queriesTableColors.getSelectAllColorsStatus());
        return "select";
    }

    @RequestMapping("/colors/update")
    public String getUpdateColorsStatus(Model model) {
        model.addAttribute("name", queriesTableColors.getUpdateColorsStatus(smoke.getId()));
        return "update";
    }

    @RequestMapping("/colors/delete")
    public String getDeleteColorStatus(Model model) {
        model.addAttribute("name", queriesTableColors.getDeleteColorStatus(smoke));
        return "delete";
    }
}

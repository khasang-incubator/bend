package io.khasang.bend.service.impl;

import io.khasang.bend.service.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope("prototype")
public class CreateTableCat implements CreateTable {
    private List<String> list = new ArrayList<>();
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getAllCatsByName(Long id) {
        if (list.size() == 0) {
            list.add("Barsik");
        }

        System.err.println(list.toString());
        String query = "select * from cats where cat_id = ?";

        try {
            BarsikCat cat = jdbcTemplate.queryForObject(query, new Object[]{id}, (rs, rowNum) -> {
                BarsikCat cat1 = new BarsikCat();
                cat1.setName(rs.getString("name"));
                cat1.setSecretField(rs.getString("description"));
                return cat1;
            });
            return cat.toString();
        } catch (BadSqlGrammarException e) {
            return "table creation failed";
        }
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}

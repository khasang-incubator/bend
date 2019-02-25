package io.khasang.bend.service.impl;

import io.khasang.bend.service.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreateTableCats implements CreateTable {
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getTableCreationStatus(String val) {
//
//        try {
//            jdbcTemplate.execute("DROP TABLE IF EXISTS " + val);
//            jdbcTemplate.execute("CREATE TABLE public.cats(cat_id integer NOT NULL , " +
//                    "name varchar(255), description varchar(255) , color_id integer, PRIMARY KEY (cat_id))");
//            return "table " + val + " created";
//        } catch (BadSqlGrammarException e) {
//            return "table creation failed: " + e.getMessage();
//        }
        return null;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

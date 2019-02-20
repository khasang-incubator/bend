package io.khasang.bend.service.impl;

import io.khasang.bend.service.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreateTableCat implements CreateTable {
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getTableCreationStatus(String val) {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS " + val);
            jdbcTemplate.execute("CREATE TABLE public.cats\n" +
                    "(\n" +
                    "    cat_id bigint NOT NULL,\n" +
                    "    description character varying(255),\n" +
                    "    name character varying(255),\n" +
                    "    CONSTRAINT cats_pkey PRIMARY KEY (cat_id)\n" +
                    ")");
            return "table created";
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

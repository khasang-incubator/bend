package io.khasang.bend.service.impl;

import io.khasang.bend.service.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreateTableCat implements CreateTable {
    private JdbcTemplate jdbcTemplate;
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String getAllCatsByName(Long id) {
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

    @Override
    public String getTableCreationStatus(String val) {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS cats");
            jdbcTemplate.execute("CREATE TABLE public.cats " +
                    "( cat_id bigint NOT NULL, description character varying(255), " +
                    "name character varying(255), " +
                    "CONSTRAINT cats_pkey PRIMARY KEY (cat_id))");
            return "table created";
        } catch (BadSqlGrammarException ex) {
            return "table creation failed";
        }
    }
}
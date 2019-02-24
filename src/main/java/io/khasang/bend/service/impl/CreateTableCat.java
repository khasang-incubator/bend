package io.khasang.bend.service.impl;

import io.khasang.bend.model.Cat;
import io.khasang.bend.service.CatQuery;
import io.khasang.bend.service.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateTableCat implements CatQuery, CreateTable {
    private JdbcTemplate jdbcTemplate;


    @Override
    public Cat getCatById(long catId) {
        String query = "SELECT * FROM cats WHERE cat_id = ?";
        try {
            Cat cat = (Cat) jdbcTemplate.queryForObject(
                    query, new Object[]{catId},
                    new BeanPropertyRowMapper(Cat.class));
            return cat;
        } catch (BadSqlGrammarException | EmptyResultDataAccessException e) {
            System.err.println("BSGE OR ERDAE Exception");
            return null;
        }
    }

    @Override
    public String updateCatWithId(String name, String description, long id) {
        String query = "UPDATE cats SET name =?,description=? WHERE cat_id=?";
        try {
            jdbcTemplate.update(query, name, description, id);
            return "cat updated";
        } catch (DataAccessException e) {
            return "update failed";
        }
    }

    @Override
    public String deleteCatWithId(long id) {
        String query = "DELETE FROM cats WHERE cat_id=?";
        try {
            jdbcTemplate.update(query, id);
            return "delete successful";
        } catch (DataAccessException e) {
            return "failed to delete";
        }
    }

    @Override
    public String addNewCat(long id, String name, String description) {
        String query = "INSERT INTO cats (cat_id, name, description) VALUES (?,?,?)";
        try {
            jdbcTemplate.update(query, id, name, description);
            return "added successful";
        } catch (DataAccessException e) {
            return "add failed";
        }
    }


    @Override
    public List<Cat> getAllCats() {
        String query = "SELECT * FROM cats";
        try {
            List<Cat> catList = jdbcTemplate.query(query, (rs, rowNum) -> {
                Cat cat = new Cat();
                cat.setDescription(rs.getString("description"));
                cat.setCatId((rs.getLong("cat_id")));
                cat.setName(rs.getString("name"));
                return cat;
            });

            return catList;

        } catch (BadSqlGrammarException e) {
            return null;
        }
    }

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

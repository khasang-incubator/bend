package io.khasang.bend.model.dao.impl;

import io.khasang.bend.service.Cat;
import io.khasang.bend.service.CatDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlainCatDao implements CatDao{

    private JdbcTemplate jdbcTemplate;
    private static Logger logger = LoggerFactory.getLogger(PlainCatDao.class);

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String create(Long id, String nm, String desc) {
        logger.error(id + " " + nm + " " + desc);
        try {
            jdbcTemplate.execute("INSERT INTO cats (cat_id, name, description)\n" +
                    "VALUES\n" +
                    " (id,nm,desc);");
            return "create successfull";
        } catch (BadSqlGrammarException ex) {
            logger.error("insertion error",ex);
            ex.printStackTrace();
        }
        return "creating failed";
    }

    @Override
    public String delete(Long id) {//небезопасно втыкать параметр в sql
        try {
            jdbcTemplate.execute(" DELETE FROM cats\n" +
                    "WHERE cats.id = id ");
            return "delete successfull";
        } catch (BadSqlGrammarException ex) {
            logger.error("delete cat entity with id="+id+" failed ",ex);
            ex.printStackTrace();
        }
        return "deleting failed";
    }

    @Override
    public String update(Long id, String nm, String desc) {
        try {
            jdbcTemplate.execute("UPDATE table\n" +
                    "SET cat_id = id,\n" +
                    "    name = nm\n" +
                    "    description = desc,\n" +
                    "WHERE cats.id = id ");
            return "successfully updated";
        } catch (BadSqlGrammarException ex) {
            logger.error("update cat entity with id="+id+" failed ",ex);
            ex.printStackTrace();
        }
        return "updaing failed";
    }
}
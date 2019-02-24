package io.khasang.bend.model.dao.impl;

import io.khasang.bend.model.dao.CatDao;
import io.khasang.bend.service.Cat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class PlainCatDao implements CatDao{

    private JdbcTemplate jdbcTemplate;
    private static Logger logger = LoggerFactory.getLogger(PlainCatDao.class);

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String create(Long id, String nm, String desc) {
        String query="INSERT INTO cats (cat_id, name, description)\n" +
                "VALUES\n" +
                " (?,?,?);";
        try {
            jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setLong(1, id);
                    ps.setString(2, nm);
                    ps.setString(3, desc);
                    return ps.execute();
                }
            });
            return "cat created";
        } catch (BadSqlGrammarException ex) {
            logger.error("insertion error:"+query,ex);
            ex.printStackTrace();
        }
        return "creating cat failed";
    }

    @Override
    public String update( String nm, String desc, Long id) {
        String query="UPDATE cats \n" +
                "SET name=?,\n" +
                "description=?\n" +
                "WHERE cat_id =?";
        try {
            jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setString(1, nm);
                    ps.setString(2, desc);
                    ps.setLong(3, id);
                    return ps.execute();
                }
            });
            return "successfully updated";
        } catch (BadSqlGrammarException ex) {
            logger.error("update cat entity with id="+id+" failed ",ex);
            ex.printStackTrace();
        }
        return "updaing cat failed";
    }

    @Override
    public String delete(Long id) {//небезопасно втыкать параметр в sql
        try {
            String query=" DELETE FROM cats\n" +
                    "WHERE cats.cat_id = ? ";
            jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setLong(1, id);
                    return ps.execute();
                }
            });
            return "delete successfull";
        } catch (BadSqlGrammarException ex) {
            logger.error("delete cat entity with id="+id+" failed ",ex);
            ex.printStackTrace();
        }
        return "deleting cat failed";
    }
}
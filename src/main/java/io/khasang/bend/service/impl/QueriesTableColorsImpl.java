package io.khasang.bend.service.impl;

import io.khasang.bend.service.Color;
import io.khasang.bend.service.QueriesTableColors;
import io.khasang.bend.service.impl.colors.ColorGrey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class QueriesTableColorsImpl implements QueriesTableColors {
    private JdbcTemplate jdbcTemplate;


    @Override
    public String getInsertColorStatus(Color color) {
        String query = "INSERT INTO colors (id, name) VALUES" +
                " (" + color.getId() + ", " + color.getName() + ")";

        try {
            jdbcTemplate.execute(query);
            return "color " + color.getName() + " inserted";
        } catch (BadSqlGrammarException e) {
            return "cat insert failed: " + e.getMessage();
        }
    }

    @Override
    public String getSelectColorStatus(long id) {
        String query = "select * from colors where id = ?";

        try {
            Color color = jdbcTemplate.queryForObject(query, new Object[]{id}, (rs, rowNum) -> getSelectColor(rs));
            return color.toString();
        } catch (BadSqlGrammarException e) {
            return "cat selected failed";
        }
    }

    @Override
    public List<Color> getSelectAllColorsStatus() {
        String query = "select id, name from colors";

        try {
            return jdbcTemplate.query(query, (rs, rowNum) -> getSelectColor(rs));
        } catch (BadSqlGrammarException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private Color getSelectColor(ResultSet rs) throws SQLException {
        Color color = new ColorGrey();
        color.setId(rs.getInt("id"));
        color.setName(rs.getString("name"));
        return color;
    }

    @Override
    public String getUpdateColorsStatus(long id) {
        try {
            jdbcTemplate.execute("update colors set name='white' where id=" + id);
            return "colors updated";
        } catch (BadSqlGrammarException e) {
            return "update failed: " + e.getMessage();
        }
    }

    @Override
    public String getDeleteColorStatus(Color color) {
        String query = "delete from  colors  where id=" + color.getId();
        try {
            jdbcTemplate.execute(query);
            return "color " + color.getName() + " deleted from colors";
        } catch (BadSqlGrammarException e) {
            return "delete failed: " + e.getMessage();
        }
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

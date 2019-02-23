package io.khasang.bend.service.impl;

import io.khasang.bend.service.Cat;
import io.khasang.bend.service.QueriesTableCats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class QueriesTableCatsImpl implements QueriesTableCats {
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getInsertCatStatus(Cat cat) {
//        String query = "INSERT INTO cats VALUES ( cat_id=?, name=?, description=?, color_id=?)";

        String query = "INSERT INTO cats (cat_id, name, description, color_id) VALUES" +
                " (" + cat.getCat_id() + ", " + cat.getName() + ", " + cat.getDescription()
                + ", " + cat.getColor_id() + ")";

        try {
            jdbcTemplate.execute(query);
            return "cat " + cat.getName() + " inserted";
        } catch (DataAccessException e) {
            return "cat insert failed: " + e.getMessage();
        }
    }

    @Override
    public String getSelectCatStatus(long id) {
        String query = "select * from cats where cat_id = ?";

        try {
            Cat cat = jdbcTemplate.queryForObject(query, new Object[]{id}, (rs, rowNum) -> getSelectCat(rs));
            return cat.toString();
        } catch (BadSqlGrammarException e) {
            return "cat selected failed";
        }
    }

    @Override
    public List<Cat> getSelectAllCatsStatus() {
        String query = "select cat_id, name, description, color_id from cats";

        try {
            List<Cat> cats = jdbcTemplate.query(query, (rs, rowNum) -> getSelectCat(rs));
            return cats;
        } catch (BadSqlGrammarException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private Cat getSelectCat(ResultSet rs) throws SQLException {
        Cat cat = new BarsikCat();
        cat.setCat_id(rs.getInt("cat_id"));
        cat.setName(rs.getString("name"));
        cat.setDescription(rs.getString("description"));
        cat.setColor_id(rs.getInt("color_id"));
        return cat;
    }

    @Override
    public String getUpdateCatsStatus(int cat_id) {
        try {
            jdbcTemplate.execute("update cats set description='good' where cat_id=" + cat_id);
            return "cats updated";
        } catch (DataAccessException e) {
            return "update failed: " + e.getMessage();
        }
    }

    @Override
    public String getDeleteCatStatus(Cat cat) {
        String query = "delete from  cats  where cat_id=" + cat.getCat_id();
        try {
            jdbcTemplate.execute(query);
            return "cat " + cat.getName() + " deleted from cats";
        } catch (DataAccessException e) {
            return "delete failed: " + e.getMessage();
        }
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

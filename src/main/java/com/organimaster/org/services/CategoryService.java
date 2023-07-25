package com.organimaster.org.services;

import com.organimaster.org.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Category> spGetCategories() {
        String storedProcedureQuery = "CALL sp_get_category()";
        return jdbcTemplate.query(storedProcedureQuery,
                (rs, rowNum) -> {
                    Category category = new Category();
                    category.setId(rs.getLong("id"));
                    category.setCategoryName(rs.getString("category_name"));
                    return category;
                });
    }

    public int insertSpCategory(String categoryName) {
        try {
            jdbcTemplate.update("CALL sp_insert_category(?, @result)", categoryName);
            Integer result = jdbcTemplate.queryForObject("SELECT @result", Integer.class);
            return (result != null) ? result : -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Return -1 for any exceptions
        }
    }
}

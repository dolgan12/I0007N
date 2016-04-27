package com.garpo.i0007n.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Conny Garpö on 4/27/2016.
 */
public class MySQLCategoryDAO implements CategoryDAO{
    @Override
    public List<Category> getAllCategories() throws Exception {
        List<Category> categories = new ArrayList<>();
        String selectSql = "SELECT id, description FROM category ORDER BY id";
        Connection con = MySQLDatabase.getInstance().getConnection();

        Statement selectStatement = con.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(selectSql);

        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String description = resultSet.getString("description");
            Category category = new Category(id, description);
            categories.add(category);
        }
        return categories;
    }

    {

}
}

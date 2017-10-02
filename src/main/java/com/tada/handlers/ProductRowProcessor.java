package com.tada.handlers;

import org.apache.commons.dbutils.BasicRowProcessor;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.LinkedList;

import com.tada.beans.Category;
import com.tada.beans.Image;
import com.tada.beans.Product;

public class ProductRowProcessor extends BasicRowProcessor {

    @Override
    public List<Product> toBeanList(ResultSet rs, Class clazz) {
        try {
            List newlist = new LinkedList();
            while (rs.next()) {
                newlist.add(toBean(rs, clazz));
            }
            return newlist;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Product toBean(ResultSet result, Class type) throws SQLException {

        Image image = new Image(
            result.getInt("idImage"),
            result.getString("url")
        );

        Category category = new Category(
            result.getInt("idCategory"),
            result.getString("categoryName")
        );

        return new Product(
            result.getInt("idProduct"),
            result.getString("name"),
            result.getBigDecimal("price"),
            category,
            result.getString("description"),
            result.getInt("stock"),
            image
        );

    }
}

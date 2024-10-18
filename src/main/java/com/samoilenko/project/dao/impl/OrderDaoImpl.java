package com.samoilenko.project.dao.impl;

import com.samoilenko.project.dao.OrderDao;
import com.samoilenko.project.model.Order;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root" ;
    private static final String PASSWORD = "root";


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public void addOrder(Order order) {
        String query = "INSERT INTO Orders (OrderNumber, CustomerName, State, TaxRate, ProductType, Area, CostPerSquareFoot, LaborCostPerSquareFoot, MaterialCost, LaborCost, Tax, Total, OrderDate) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, order.getOrderNumber());
            ps.setString(2, order.getCustomerName());
            ps.setString(3, order.getState());
            ps.setBigDecimal(4, order.getTaxRate());
            ps.setString(5, order.getProductType());
            ps.setDouble(4, order.getTaxRate().doubleValue());
            ps.setString(5, order.getProductType());
            ps.setDouble(6, order.getArea().doubleValue());
            ps.setDouble(7, order.getCostPerSquareFoot().doubleValue());
            ps.setDouble(8, order.getLaborCostPerSquareFoot().doubleValue());
            ps.setDouble(9, order.getMaterialCost().doubleValue());
            ps.setDouble(10, order.getLaborCost().doubleValue());
            ps.setDouble(11, order.getTax().doubleValue());
            ps.setDouble(12, order.getTotal().doubleValue());

            ps.executeUpdate();  // Execute the insert query
            System.out.println("Order added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int id) {
        String query = "DELETE FROM Orders WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();  // Execute the delete query

            if (rowsAffected > 0) {
                System.out.println("Order deleted successfully!");
            } else {
                System.out.println("Order not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrder(int id, Order order) {
        String query = "UPDATE Orders SET CustomerName = ?, State = ?, TaxRate = ?, ProductType = ?, Area = ?, CostPerSquareFoot = ?, LaborCostPerSquareFoot = ?, MaterialCost = ?, LaborCost = ?, Tax = ?, Total = ? "
                + "WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            // Example: Update with new values (you can retrieve values from the user or from a specific order object)
            ps.setString(2, order.getCustomerName());
            ps.setString(3, order.getState());
            ps.setBigDecimal(4, order.getTaxRate());
            ps.setString(5, order.getProductType());
            ps.setDouble(6, order.getTaxRate().doubleValue());
            ps.setString(7, order.getProductType());
            ps.setDouble(8, order.getArea().doubleValue());
            ps.setDouble(9, order.getCostPerSquareFoot().doubleValue());
            ps.setDouble(10, order.getLaborCostPerSquareFoot().doubleValue());
            ps.setDouble(11, order.getMaterialCost().doubleValue());
            ps.setDouble(12, order.getLaborCost().doubleValue());
            ps.setDouble(13, order.getTax().doubleValue());
            ps.setDouble(14, order.getTotal().doubleValue());

            int rowsAffected = ps.executeUpdate();  // Execute the update query
            if (rowsAffected > 0) {
                System.out.println("Order updated successfully!");
            } else {
                System.out.println("Order not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getOrdersByDate(String date) {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM Orders WHERE OrderDate = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, date);
            ResultSet rs = ps.executeQuery();  // Execute the select query

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("OrderNumber"),
                        rs.getString("CustomerName"),
                        rs.getString("State"),
                        rs.getBigDecimal("TaxRate"),
                        rs.getString("ProductType"),
                        rs.getBigDecimal("Area"),
                        rs.getBigDecimal("CostPerSquareFoot"),
                        rs.getBigDecimal("LaborCostPerSquareFoot"),
                        rs.getBigDecimal("MaterialCost"),
                        rs.getBigDecimal("LaborCost"),
                        rs.getBigDecimal("Tax"),
                        rs.getBigDecimal("Total"),
                        rs.getString("OrderDate")
                );
                orders.add(order);  // Add the order to the list
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM Orders";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("OrderNumber"),
                        rs.getString("CustomerName"),
                        rs.getString("State"),
                        rs.getBigDecimal("TaxRate"),
                        rs.getString("ProductType"),
                        rs.getBigDecimal("Area"),
                        rs.getBigDecimal("CostPerSquareFoot"),
                        rs.getBigDecimal("LaborCostPerSquareFoot"),
                        rs.getBigDecimal("MaterialCost"),
                        rs.getBigDecimal("LaborCost"),
                        rs.getBigDecimal("Tax"),
                        rs.getBigDecimal("Total"),
                        rs.getString("OrderDate")
                );
                orders.add(order);  // Add the order to the list
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

}

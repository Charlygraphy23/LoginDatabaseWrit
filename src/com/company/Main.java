package com.company;

import handeller.DbHandeller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;

public class Main {

    static private Connection connection;
    static private DbHandeller handeller;
    static private PreparedStatement preparedStatement;


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        handeller=new DbHandeller();
        connection=handeller.getDbHandller();

        writedata();
        displaydata();
    }

    private static void displaydata() throws SQLException {

        preparedStatement=connection.prepareStatement("SELECT * FROM users");

        ResultSet set=preparedStatement.executeQuery();

        while (set.next()){
            System.out.println("Name "+set.getString("firstname")+" Last Name "+set.getString("lastname")+" Username "+set.getString("username")+" Address "+set.getString("address")+" Age "+set.getString("age"));
        }

    }

    private static void writedata() throws SQLException {
        preparedStatement=connection.prepareStatement("INSERT INTO users (firstname,lastname,username,address,age)"+"VALUES (?,?,?,?,?)");

        preparedStatement.setString(1,"Raj");
        preparedStatement.setString(2,"Roy");
        preparedStatement.setString(3,"@raj23");
        preparedStatement.setString(4,"Bankura");
        preparedStatement.setInt(5,22);
        preparedStatement.executeUpdate();
    }
}

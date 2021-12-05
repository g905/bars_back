/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.g905.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author zharnikov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(dbTest());
    }

    public static String dbTest() {
        String url = "jdbc:sqlite:/home/zharnikov/NetBeansProjects/SpringBoot/test.db";
        String output = "";
        output += "\nconnecting...";

        try (Connection conn = DriverManager.getConnection(url)) {
            output += "\nconnection successfull";

            String sql = "select * from 'models'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                output += "\n";
                output += "id: " + rs.getInt("id") + "; ";
                output += "name: " + rs.getString("name") + "; ";
                output += "cool? " + rs.getBoolean("cool") + "; ";
            }
        } catch (SQLException e) {
            output += "\nconnection fail";
            e.printStackTrace();
        }

        return output;
    }

}

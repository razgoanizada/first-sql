package com.javalecture;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        MySQL sql = new MySQL();



        sql.perform("CREATE TABLE students(" +
                "name varchar(500) DEFAULT NULL, phone_number varchar(500) NOT NULL, age int DEFAULT NULL, GPA double NOT NULL)"
        );

        sql.perform("INSERT INTO students VALUES" +
                "('Sharon', '0523912542', 33, 78.2)," +
                "('Dorin', '0523912543', 22, 86)," +
                "('Ofer', '0523912544', 26, 69.1)," +
                "('Haviv', '0523912545', 30, 93.7)," +
                "('Dor', '052312546', 28, 97.12)," +
                "('Eli', '0523912547', 29, 86)," +
                "('Dorel', '0523912548', 26, 76)"
        );

        sql.query("SELECT name, GPA FROM students ORDER BY GPA DESC", (rs) -> {
            while (rs.next()){
                System.out.print(rs.getString("name"));
                System.out.println( "   " + rs.getString("GPA"));
            }

        });

        System.out.println("***************************************************************************************");

        sql.query("SELECT * FROM students WHERE name LIKE '%Dor%'", (rs) -> {
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }

        });

        System.out.println("***************************************************************************************");


        sql.query("SELECT name, age FROM students WHERE GPA = 86", (rs) -> {
            while (rs.next()){
                System.out.print(rs.getString("name"));
                System.out.println( "   " + rs.getString("age"));
            }

        });


        System.out.println("***************************************************************************************");

        sql.query("SELECT name FROM students WHERE GPA > 78 AND age > 28", (rs) -> {
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }

        });

    }

}

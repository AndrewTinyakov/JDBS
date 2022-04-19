package DB;

import com.mysql.cj.jdbc.result.ResultSetImpl;

import java.sql.*;
import java.util.Scanner;

public class Registration implements RegisterInterface {

    private boolean acception;

    public Registration() {

    }


    @Override
    public boolean register() throws SQLException {
        try {
            Class.forName(forName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            Statement statement = conn.createStatement();

            try {
                statement.executeUpdate(registration());
                acception = true;
            } catch (Exception e) {
                System.err.println(e);
                acception = false;
            }
        }

        return acception;
    }

    private String registration() {
        System.out.println("Enter login");
        String login = sc.next();

        System.out.println("Enter age");
        String age = sc.next();

        System.out.println("Enter password");
        String password = sc.next();

        System.out.println("Enter email");
        String email = sc.next();

        String sql = "insert into mydbtest.users(name, password, age, mail) value(\""+ login+ " \", \" "+ password +"\", 16, \" " + email+"\" );";
        return sql;
    }
}

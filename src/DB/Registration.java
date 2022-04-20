package DB;

import java.sql.*;

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
        String login = "";
        while (true) {
            System.out.println("Enter login");
            login = sc.next();
            login = login.trim();

            String sql = "select login from mydbtest.users where login = \'" + login + "\';";

            try {
                Class.forName(forName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try (Connection conn = DriverManager.getConnection(url, userName, password)) {
                Statement statement = conn.createStatement();
                try {
                    ResultSet resultSet = statement.executeQuery(sql);
                    if (resultSet.next()) {
                        System.out.println("This login is already taken");
                        System.out.println();
                    }
                    else {
                        break;
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {

            }
        }
            System.out.println("Enter password");
            String password = sc.next();

            System.out.println("Enter email");
            String email = sc.next();

            System.out.println("Enter age");
            String age = sc.next();

            String sql = "insert into mydbtest.users(login, password, age, mail) value(\'" + login + " \', \'" + password + "\', 16, \' " + email + "\' );";
            return sql;

    }

}

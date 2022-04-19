package DB;

import java.sql.*;

public class Login implements LoginInterface {
    private boolean acception;

    public Login() throws SQLException {



    }


    @Override
    public boolean login() throws SQLException {
        try {
            Class.forName(forName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            Statement statement = conn.createStatement();

            try {
                ResultSet resultSet = statement.executeQuery(log());

                if (resultSet != null) {
                    acception = true;
                } else {
                    acception = false;
                }
            } catch (Exception e) {
                System.err.println(e);
                acception = false;
            }
        }
        return acception;
    }

    private String log() {
        System.out.println("Enter login");
        String login = sc.next();

        System.out.println("Enter password");
        String password = sc.next();

        String sql = "select * from mydbtest.users where name = \"" + login + "\" and password = \"" + password + "\";";
        return sql;
    }
}

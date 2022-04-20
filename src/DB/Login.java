package DB;

import java.sql.*;

public class Login implements LoginInterface {
    private boolean acception;
    private String login;


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
                while (resultSet.next()) {
                    String tryLogin = resultSet.getString(1);
                    tryLogin = tryLogin.trim();
                    if (tryLogin.equals(login)) {
                        acception = true;
                    } else {
                        acception = false;
                    }

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
        login.trim();
        this.login = login;

        System.out.println("Enter password");
        String password = sc.next();
        password.trim();

        String sql = "select login from mydbtest.users where login = \'" + login + "\' and password = \'"  + password + "\';";
        return sql;
    }
}

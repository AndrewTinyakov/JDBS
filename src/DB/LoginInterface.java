package DB;

import java.sql.SQLException;
import java.util.Scanner;

public interface LoginInterface {

    public boolean login() throws SQLException;
    final String userName = "root";
    final String password = "root";
    final String url = "jdbc:mysql://localhost:3305/mydbtest";
    final String forName = "com.mysql.cj.jdbc.Driver";

    Scanner sc = new Scanner(System.in);

}

package SignIn;

import DB.Login;
import DB.Registration;


import java.sql.SQLException;
import java.util.Scanner;


public class Start {
    public Start() throws SQLException {
        start();
    }

    public static void start() throws SQLException {
        boolean accaption = false;
        boolean isLoggedIn = false;

        while (!isLoggedIn) {

            System.out.println("Enter 1 if you want to log in");
            System.out.println("Enter 2 if you want to register");

            Scanner sc = new Scanner(System.in);
            String logReg = sc.next();

            switch (logReg) {
                case "1":
                    Login login = new Login();
                    accaption = login.login();
                    if (accaption) {
                        System.out.println("You logged in");
                        isLoggedIn = true;
                    } else {
                        System.out.println("Ops... You didn't logged in");
                    }
                    break;
                case "2":
                    Registration registration = new Registration();
                    accaption = registration.register();
                    if (accaption) {
                        System.out.println("You registered");
                    } else {
                        System.out.println("This user already exists");
                    }
                    break;
                default:
                    System.out.println("Enter again");
                    break;
            }
        }
    }


}

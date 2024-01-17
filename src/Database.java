/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author MarcoMan
 *         Channel: https://www.youtube.com/channel/UCPgcmw0LXToDn49akUEJBkQ
 *         Please support our channel (SUBSCRIBE --> TURN ON NOTIFICATION -->
 *         HIT THE LIKE BUTTON)
 */

public class Database {

    static Connection connectDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            // MY DATABASE IS marcoData
            Connection connect = DriverManager.getConnection("jdbc:sqlite:libraryManagementSystem.sqlite");
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}

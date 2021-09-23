package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.*;
import org.json.simple.parser.*;

/**
 *
 * @author AndresFWilT
 */
public class ConnectionBD {

    public static Connection getConnection() {
        JSONParser parser = new JSONParser();
        Connection conn = null;
        // conectar
        try {
            String credentials_path = System.getProperty("user.dir") + "/src/utils/CredencialesBD.json";
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(credentials_path));
            String host = (String) jsonObject.get("db_ip");
            String port = (String) jsonObject.get("dp_port");
            String username = (String) jsonObject.get("db_user");
            String password = (String) jsonObject.get("db_pssword");
            String dbURL = "jdbc:mysql://" + host + ":" + port + "/reto4";
            conn = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException | FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}

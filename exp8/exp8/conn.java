package myjava.exp8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class conn {
    Connection c;
    Statement s;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Information", "root", "!$#@n0j#@030103");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

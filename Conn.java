package bank.management.system;

import java.sql.*;

// There are 5 steps in JDBC Connectivity
/*
1. Register Driver
2. Create Connection
3. Create Statement
4. Execute Query
5. Close Connection
 */
public class Conn {

    Connection c;
    Statement s;
 
    public Conn() {
// Try and catch and mysql is an external entity so there are chances of exceptions during runtime
        try {
//  We dont need the below 2 lines as we have imported the library
//  Class Named class - static method forName - to write driver name
        //    Class.forName(com.mysql.cj.jdbc.Driver);

//  url passed is a connection string. You want jdbc connectivity of mysql database
//jdbc:mysql://localhost:3306/.. - no need to write this as mysql by default works on 3306 localhost
            c = DriverManager.getConnection("jdbc:mysql:///bankManagementSystem", "root", "asuz2528");

            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}



package db;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;

@Data
@AllArgsConstructor
public class DbConfig {
    private String host;
    private String port;
    private String db;

    public Connection connect(){
        Connection connection = null;
        try{
            String url = "jdbc:mysql://"+ host+":"+ port + "/" + db;
            connection = DriverManager.getConnection(url,"root","123456");
           // System.out.println("conectado a la base de datos");
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

}

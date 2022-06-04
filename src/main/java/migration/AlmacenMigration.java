package migration;

import db.DbConfig;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AlmacenMigration {

    private Connection connection;


    public AlmacenMigration(){
        DbConfig dbConfig = new DbConfig("localhost", "3306", "merca_facil_laura");
        connection = dbConfig.connect();
        creteTableAlmacen();
    }


    public void creteTableAlmacen(){
        String query = String.format(
                "CREATE TABLE almacen" +
                        "(id_almacen INT PRIMARY KEY," +
                        "codigo_almacen int(30), nombre_almacen varchar(30))"+
                        "direccion_almacen varchar(30), telefono_almacen int(30)), gerente int(30))"    );

        try{
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
   /* public <Faker> void almacenSeed(){
        Faker faker = new Faker();
        for(int i=1; i<100; i++) {
            String query = String.format(
                    "INSERT INTO almacen (id_almacen, codigo_almacen, nombre_almacen,direccion_almacen,telefono_almacen,gerente)" +
                            " VALUES(,'%s', '%s')",
                    i, faker.name().fullName(), faker.name().lastName());
            try {
                Statement statement = connection.createStatement();
                statement.execute(query);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }*/

}

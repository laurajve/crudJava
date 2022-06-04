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
        //creteTableAlmacen();
    }


    public void creteTableAlmacen(){
        String query = String.format(
                "CREATE TABLE IF NOT EXISTS merca_facil_laura.almacen (\n" +
                        "  id_almacen INT NOT NULL AUTO_INCREMENT,\n" +
                        "  codigo_almacen INT NOT NULL,\n" +
                        "  nombre_almacen VARCHAR(50) NOT NULL,\n" +
                        "  direccion_almacen VARCHAR(30) NOT NULL,\n" +
                        "  telefono_almacen INT NOT NULL,\n" +
                        "  gerente VARCHAR(45) NOT NULL,\n" +
                        "  PRIMARY KEY (`id_almacen`))\n" +
                        "ENGINE = InnoDB\n" +
                        "DEFAULT CHARACTER SET = utf8mb4\n" +
                        "COLLATE = utf8mb4_0900_ai_ci;"    );

        try{
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
            connection.close();
            System.out.println("se crea de forma exitosa la tabla Almacen");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertAlmacen(String codigo, String nombre,String direccion, String telefono,String gerente){
        String query = String.format(
                "INSERT INTO `merca_facil_laura`.`almacen`" +
                        "(codigo_almacen, nombre_almacen, direccion_almacen, telefono_almacen, gerente) " +
                        "values ('%s', '%s', '%s', '%s', '%s');",codigo,nombre,direccion,telefono,gerente );

        System.out.println(query);

        try{
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
            connection.close();
            System.out.println("se ingresa el almacen de forma exitosa");
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

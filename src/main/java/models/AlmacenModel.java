package models;

import db.DbConfig;
import dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class AlmacenModel {
    private DbConfig dbConfig;
    private Connection connection;

    //constructor
    public AlmacenModel(){
        dbConfig = new DbConfig("localhost", "3306", "merca_facil_laura");
        connection = dbConfig.connect();
    }
//metodo para traer alamcen por id
    public void getAlmacen(String id){

        try {
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM almacen WHERE id_almacen ="+ id +";");
            while (result.next()) {
                      System.out.println(result.getString("gerente"));
                }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //metodo para modificar almacen



}
import dtos.UserDto;
import models.AlmacenModel;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class Main {
     public static void main(String[] args) {
         System.out.println("hola");

         AlmacenModel almacenModel = new AlmacenModel();
         almacenModel.getAlmacen("20");
        /* List<UserDto> users = AlmacenModel;
         for(UserDto user: users){
             System.out.println(user.getName());
         }*/
     }






       //  try {
         //    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/merca_facil_laura","root","123456");


          //   Statement statement = connection.createStatement();
           //  ResultSet resultSet = statement.executeQuery("select * from almacen");
          //   while (resultSet.next()) {
          //       System.out.println(resultSet.getString("gerente"));
            // }

       //  } catch (SQLException throwables) {
          //   throwables.printStackTrace();
       //  }

     }



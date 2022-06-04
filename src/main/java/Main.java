import dtos.AlmacenDto;
import dtos.UserDto;
import migration.AlmacenMigration;
import models.AlmacenModel;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class Main {
     public static void main(String[] args) {
         System.out.println("hola");

         AlmacenMigration almacenMigration = new AlmacenMigration();
         //almacenMigration.creteTableAlmacen();
        /* almacenMigration.insertAlmacen("123","ferreteria","venecia","8402497","daniela4");*/

         AlmacenModel almacenModel = new AlmacenModel();
        // AlmacenDto almacen = almacenModel.getAlmacenById("2");
         //List<AlmacenDto> almacenList = almacenModel.listAlmacen();
         almacenModel.updateAlmacen("3","333","fre y ad","medellin","2220807","diego");
        // System.out.println(almacen.getId_almacen());
        /* List<UserDto> users = AlmacenModel;
         for(UserDto user: users){
             System.out.println(user.getName());
         }*/
     }

}



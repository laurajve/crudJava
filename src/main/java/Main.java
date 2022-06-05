import dtos.AlmacenDto;
import dtos.UserDto;
import migration.AlmacenMigration;
import models.AlmacenModel;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
         System.out.println("hola");
         int option =0;
         Boolean  ejecutar =true;
         Scanner leerTeclado = new Scanner(System.in);



         while(ejecutar){

             switch(option) {
                 case 0:
                     System.out.println(" Selecciones una opcion:");
                     System.out.println(" 1. Crear tabla almacen en la base de datos");
                     System.out.println(" 2. Insertar un almances en la tabla alamacen");
                     System.out.println(" 3. Mostrar todos los registros de la tabla");
                     System.out.println(" 4. Consultar un almacen por id");
                     System.out.println(" 5. Actualizar");
                     System.out.println(" 6. Salir");
                     option = leerTeclado.nextInt();
                     break;
                 case 1:
                     AlmacenMigration almacenMigration = new AlmacenMigration();
                     almacenMigration.creteTableAlmacen();
                     System.out.println(" ingrese 0 para regresar al menu");
                     option = leerTeclado.nextInt();
                     break;
                 case 2:
                     almacenMigration = new AlmacenMigration();
                     System.out.println(" ingrese el codidgo del almance");
                     String codigo=leerTeclado.next();
                     System.out.println(" ingrese el nombre del almance");
                     String nombre=leerTeclado.next();
                     System.out.println(" ingrese la direccion  del almance");
                     String direccion=leerTeclado.next();
                     System.out.println(" ingrese el telefono del almance");
                     String telefono=leerTeclado.next();
                     System.out.println(" ingrese el nombre gerente del almance");
                     String gerente=leerTeclado.next();
                     almacenMigration.insertAlmacen(codigo,nombre,direccion,telefono,gerente);
                     System.out.println(" ingrese 0 para regresar al menu");
                     option = leerTeclado.nextInt();
                     break;
                 case 3:
                     AlmacenModel almacenModel = new AlmacenModel();
                     List<AlmacenDto> almacenDtoList = almacenModel.listAlmacen();
                     System.out.println("___________________________________________________" +
                             "___________________________________________________" );
                     System.out.println("id_almacen"+"  | codigo_almacen" +"  nombre_almacen"+"        direccion_almacen"
                             +"     telefono_almacen"+"     gerente");
                     System.out.println("___________________________________________________" +
                             "___________________________________________________" );
                     for(AlmacenDto almacenDto: almacenDtoList){
                         System.out.println(almacenDto.getId_almacen()+"           | "+almacenDto.getCodigo_almacen()
                                         +"             "+almacenDto.getNombre_almacen()+ "         " +almacenDto.getDireccion_almacen()
                                         +"     "+almacenDto.getTelefono_almacen()+ "     " + almacenDto.getGerente());
                     }
                     System.out.println(" ingrese 0 para regresar al menu");
                     option = leerTeclado.nextInt();
                     break;
                 case 4:
                     System.out.println(" ingrese el id_alamacen a consultar");
                     almacenModel = new AlmacenModel();
                     String id_Almacen=leerTeclado.next();
                     AlmacenDto almacenDto = almacenModel.getAlmacenById(id_Almacen);
                     System.out.println("___________________________________________________" +
                             "___________________________________________________" );
                     System.out.println("id_almacen"+"  | codigo_almacen" +"  nombre_almacen"+"        direccion_almacen"
                             +"     telefono_almacen"+"     gerente");
                     System.out.println("___________________________________________________" +
                             "___________________________________________________" );

                     System.out.println(almacenDto.getId_almacen()+"           | "+almacenDto.getCodigo_almacen()
                             +"             "+almacenDto.getNombre_almacen()+ "         " +almacenDto.getDireccion_almacen()
                             +"     "+almacenDto.getTelefono_almacen()+ "     " + almacenDto.getGerente());
                     System.out.println(" ingrese 0 para regresar al menu");
                     option = leerTeclado.nextInt();
                     break;
                 case 5:
                     System.out.println(" ingrese elid el almancen a actualizar");
                     String idAlmacenUp=leerTeclado.next();
                     System.out.println(" ingrese el codidgo del almance");
                     String codigoUp=leerTeclado.next();
                     System.out.println(" ingrese el nombre del almance");
                     String nombreUp=leerTeclado.next();
                     System.out.println(" ingrese la direccion  del almance");
                     String direccionUp=leerTeclado.next();
                     System.out.println(" ingrese el telefono del almance");
                     String telefonoUp=leerTeclado.next();
                     System.out.println(" ingrese el nombre gerente del almance");
                     String gerenteUp=leerTeclado.next();
                     almacenModel = new AlmacenModel();
                     almacenModel.updateAlmacen(idAlmacenUp,codigoUp,nombreUp,direccionUp,telefonoUp,gerenteUp);
                     System.out.println(" ingrese 0 para regresar al menu");
                     option = leerTeclado.nextInt();
                     break;
                 case 6:
                     ejecutar= false;
                     break;

                 default:
                     System.out.println(" opcion no valida: ingrese 0 para regresar al menu");
                     option = leerTeclado.nextInt();
                     break;

             }
         }

         System.out.println(" Cerrando aplicacion");







     }

}



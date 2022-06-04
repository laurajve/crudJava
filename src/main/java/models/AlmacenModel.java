package models;

import db.DbConfig;
import dtos.AlmacenDto;
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
    public AlmacenDto getAlmacenById(String id){
        AlmacenDto almacenDto = new AlmacenDto();

        try {
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM almacen WHERE id_almacen ="+ id +";");
            while (result.next()) {
                almacenDto.setId_almacen(Integer.valueOf(result.getString("id_almacen")));
                almacenDto.setCodigo_almacen(Integer.valueOf(result.getString("codigo_almacen")));
                almacenDto.setNombre_almacen(result.getString("nombre_almacen"));
                almacenDto.setDireccion_almacen(result.getString("direccion_almacen"));
                almacenDto.setTelefono_almacen(Integer.valueOf(result.getString("telefono_almacen")));
                almacenDto.setGerente(result.getString("gerente"));
                }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return almacenDto;
    }

    /**
     * metodo que hizo laura para obtener de la base de datos todos los elementos de la tabla
     * almacen
     * @return retorna una lista de almacenes
     */
    public List<AlmacenDto> listAlmacen(){
        List<AlmacenDto> almacenDtoList = new ArrayList<>();
        AlmacenDto almacenDto;


        try {
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM almacen ;");
            while (result.next()) {
                almacenDto = new AlmacenDto();
                almacenDto.setId_almacen(Integer.valueOf(result.getString("id_almacen")));
                almacenDto.setCodigo_almacen(Integer.valueOf(result.getString("codigo_almacen")));
                almacenDto.setNombre_almacen(result.getString("nombre_almacen"));
                almacenDto.setDireccion_almacen(result.getString("direccion_almacen"));
                almacenDto.setTelefono_almacen(Integer.valueOf(result.getString("telefono_almacen")));
                almacenDto.setGerente(result.getString("gerente"));
                almacenDtoList.add(almacenDto);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return almacenDtoList;
    }

    //metodo para modificar almacen (update)

    public void updateAlmacen(String id_almacen,String codigo, String nombre,String direccion, String telefono,String gerente){

        try {
            Statement statement = connection.createStatement();
            String query = String.format(
                    "UPDATE `merca_facil_laura`.`almacen`" +
                            "SET" +
                            "`codigo_almacen` = '%s'," +
                            "`nombre_almacen` = '%s'," +
                            "`direccion_almacen` = '%s'," +
                            "`telefono_almacen` = '%s'," +
                            "`gerente` = '%s'" +
                            "WHERE `id_almacen` = '%s';",codigo,nombre,direccion,telefono,gerente,id_almacen );
            int result = statement.executeUpdate(query);

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
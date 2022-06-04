package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Almacen {
    private int id_almacen;
    private int codigo_almacen;
    private String nombre_almacen;
    private String direccion_almacen;
    private int telefono_almacen;
    private String gerente;

}

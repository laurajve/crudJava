package dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlmacenDto {
    private int id_almacen;
    private int codigo_almacen;
    private String nombre_almacen;
    private String direccion_almacen;
    private int telefono_almacen;
    private String gerente;

}

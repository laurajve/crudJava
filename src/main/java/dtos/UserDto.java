package dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id_almacen;
    private int codigo_almacen;
    private String nombre_almacen;
    private String direccion_almacen;
    private int telefono_almacen;
    private String gerente;

    public int getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    public int getCodigo_almacen() {
        return codigo_almacen;
    }

    public void setCodigo_almacen(int codigo_almacen) {
        this.codigo_almacen = codigo_almacen;
    }

    public String getNombre_almacen() {
        return nombre_almacen;
    }

    public void setNombre_almacen(String nombre_almacen) {
        this.nombre_almacen = nombre_almacen;
    }

    public String getDireccion_almacen() {
        return direccion_almacen;
    }

    public void setDireccion_almacen(String direccion_almacen) {
        this.direccion_almacen = direccion_almacen;
    }

    public int getTelefono_almacen() {
        return telefono_almacen;
    }

    public void setTelefono_almacen(int telefono_almacen) {
        this.telefono_almacen = telefono_almacen;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }
}

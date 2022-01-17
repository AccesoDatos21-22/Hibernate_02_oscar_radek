package def;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Seguro implements Serializable {
    public  enum Seguros{HOGAR,COCHE,MOTO,VIAJE}
    public  enum Sexos{HOMBRE,MUJER}
    private int idseguro;
    private String nif;
    private String nombre;
    private String ape1;
    private String ape2;
    private int edad;
    private Sexos sexo;
    private String casado;
    private int numhijos;
    private Timestamp fechacreacion;
    private Seguros tiposeguro;
    private Boolean mayorEdad;



    public Seguro(int idseguro, String nif, String nombre, String ape1, String ape2, int edad, Sexos sexo, String casado, int numhijos, Timestamp fechacreacion, Seguros tiposeguro) {
        this.idseguro = idseguro;
        this.nif = nif;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.edad = edad;
        this.sexo = sexo;
        this.casado = casado;
        this.numhijos = numhijos;
        this.fechacreacion = fechacreacion;
        this.tiposeguro = tiposeguro;
        this.mayorEdad=edad>=18;

    }
    public Seguro(String nif, String nombre, String ape1, String ape2, int edad, Sexos sexo, String casado, int numhijos, Timestamp fechacreacion, Seguros tiposeguro) {
        this.nif = nif;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.edad = edad;
        this.sexo = sexo;
        this.casado = casado;
        this.numhijos = numhijos;
        this.fechacreacion = fechacreacion;
        this.tiposeguro = tiposeguro;
        this.mayorEdad=edad>=18;

    }


    public Seguro() {

    }

    @Id
    @Column(name = "IDSEGURO")
    public int getIdseguro() {
        return idseguro;
    }

    public void setIdseguro(int idseguro) {
        this.idseguro = idseguro;
    }

    @Basic
    @Column(name = "NIF")
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Basic
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "APE1")
    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    @Basic
    @Column(name = "APE2")
    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    @Basic
    @Column(name = "EDAD")
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Basic
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "SEXO")
    public Sexos getSexo() {
        return sexo;
    }

    public void setSexo(Sexos sexo) {
        this.sexo = sexo;
    }

    @Basic
    @Column(name = "CASADO")
    public String getCasado() {
        return casado;
    }

    public void setCasado(String casado) {
        this.casado = casado;
    }

    @Basic
    @Column(name = "NUMHIJOS")
    public int getNumhijos() {
        return numhijos;
    }

    public void setNumhijos(int numhijos) {
        this.numhijos = numhijos;
    }

    @Basic
    @Column(name = "FECHACREACION")
    public Timestamp getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Timestamp fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Basic
    @Column(name = "TIPOSEGURO")
    @Enumerated(EnumType.STRING)
    public Seguros getTiposeguro() {
        return tiposeguro;
    }

    public void setTiposeguro(Seguros tiposeguro) {
        this.tiposeguro = tiposeguro;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seguro seguro = (Seguro) o;
        return idseguro == seguro.idseguro && edad == seguro.edad && sexo == seguro.sexo && numhijos == seguro.numhijos && Objects.equals(nif, seguro.nif) && Objects.equals(nombre, seguro.nombre) && Objects.equals(ape1, seguro.ape1) && Objects.equals(ape2, seguro.ape2) && Objects.equals(casado, seguro.casado) && Objects.equals(fechacreacion, seguro.fechacreacion) && Objects.equals(tiposeguro, seguro.tiposeguro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idseguro, nif, nombre, ape1, ape2, edad, sexo, casado, numhijos, fechacreacion, tiposeguro);
    }

    @Override
    public String toString() {
        return "Seguro{" +
                "idseguro=" + idseguro +
                ", nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ape1='" + ape1 + '\'' +
                ", ape2='" + ape2 + '\'' +
                ", edad=" + edad +
                ", sexo=" + sexo +
                ", casado='" + casado + '\'' +
                ", numhijos=" + numhijos +
                ", fechacreacion=" + fechacreacion +
                ", tiposeguro='" + tiposeguro + '\'' +
                ", mayoEdad='" + mayorEdad + '\'' +
                '}';
    }

    @Basic
    @Column(name = "MAYORDEEDAD")
    public Boolean getMayorEdad() {
        return mayorEdad;
    }

    public void setMayorEdad(Boolean mayorEdad) {
        this.mayorEdad = edad>=18;
    }
}

import def.Seguro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;

public class SeguroTest {
    private static SeguroPersistent seguroPersistent;

    @BeforeAll
    public static void setup() {
        seguroPersistent = new SeguroPersistent();
    }

    @Test
    @DisplayName("Introduir nuevo seguro")
    public void introducirSeguro() {

        Seguro seguroExistente = new Seguro(888, "test01", "oscar", "gonzalez", "Strozzi",
                20, Seguro.Sexos.HOMBRE, "N", 0, Timestamp.valueOf("2021-05-02 04:04:05"), Seguro.Seguros.COCHE,  Date.valueOf("2001-12-03"), Time.valueOf("10:06:13"),  new char[]{'a','b','c'});

        seguroPersistent.insertarSeguro(seguroExistente);
        Assertions.assertEquals(seguroExistente, seguroPersistent.buscar(888), "El seguro no existe, por lo que no salta falso.");
        seguroPersistent.eliminarSeguro(seguroExistente);
    }


    @Test
    @DisplayName("Buscar un seguro")
    public void buscarSeguro() {
        Seguro seguro = new Seguro(339, "test02", "Juan", "Pepe", "Aler",
                19, Seguro.Sexos.HOMBRE, "S", 2, Timestamp.valueOf("2021-07-02 04:04:05"), Seguro.Seguros.COCHE,  Date.valueOf("2001-12-03"), Time.valueOf("10:06:13"), new char[]{'a','b','c'});

        Assertions.assertEquals(seguro, seguroPersistent.buscar(339), "El seguro debe de existir antes de ejecutar el test");

    }

    @Test
    @DisplayName("Eliminar un seguro")
    public void eliminarSeguro() {
        Seguro seguro = new Seguro(338, "test02", "Juan", "Pepe", "Aler",
                19, Seguro.Sexos.HOMBRE, "S", 2, Timestamp.valueOf("2021-07-02 04:04:05"), Seguro.Seguros.COCHE,  Date.valueOf("2001-12-03"), Time.valueOf("10:06:13"), new char[]{'a','b','c'});
        seguroPersistent.insertarSeguro(seguro);
        seguroPersistent.eliminarSeguro(seguro);
        Seguro buscar = seguroPersistent.buscar(54);
        Assertions.assertNull(buscar, "El test no es nulo porque no se ha eliminado correctamente");

    }

    @Test
    @DisplayName("Actualizar un seguro")
    public void actualizarSeguro() {
        Seguro seguro = new Seguro(337, "test03", "Alberto", "Jeimenz", "Aler",
                19, Seguro.Sexos.HOMBRE, "S", 2, Timestamp.valueOf("2021-07-02 04:04:05"), Seguro.Seguros.COCHE,  Date.valueOf("2001-12-03"), Time.valueOf("10:06:13"), new char[]{'a','b','c'});

        seguroPersistent.actualizarSeguro(seguro);
        Seguro buscar = seguroPersistent.buscar(seguro.getIdseguro());
        Assertions.assertEquals(buscar, seguro, "No coincide.");

    }

    @Test
    @DisplayName("Comprobar si es mayor de edad")
    public void testMayorEdad() {
        Seguro mayor1 = new Seguro(777, "mayorSI", "oscar", "gonzalez", "Strozzi",
                20, Seguro.Sexos.HOMBRE, "N", 0, Timestamp.valueOf("2021-05-02 04:04:05"), Seguro.Seguros.COCHE,  Date.valueOf("2012-12-03"), Time.valueOf("10:06:13"),new char[]{'a','b','c'});
        Seguro mayor2 = new Seguro(778, "mayorNo", "oscar", "gonzalez", "Strozzi",
                12, Seguro.Sexos.HOMBRE, "N", 0, Timestamp.valueOf("2021-05-02 04:04:05"), Seguro.Seguros.COCHE,  Date.valueOf("2000-02-03"), Time.valueOf("10:06:13"), new char[]{'a','b','c'});

//        seguroPersistent.insertarSeguro(mayor1);
//        seguroPersistent.insertarSeguro(mayor2);

        Seguro buscar1 = seguroPersistent.buscar(777);
        Seguro buscar2 = seguroPersistent.buscar(778);
        Assertions.assertTrue(buscar1.getMayorEdad(), "Debe devolver true, ya que es mayor de edad");
        Assertions.assertFalse(buscar2.getMayorEdad(), "Debe devolver false, ya que es menor de edad");

    }

    @Test
    @DisplayName("Comprobar seguro")
    public void testTipoSeguro() {
        Seguro mayor1 = new Seguro(885, "casas", "oscar", "gonzalez", "Strozzi",
                20, Seguro.Sexos.HOMBRE, "N", 0, Timestamp.valueOf("2021-05-02 04:04:05"), Seguro.Seguros.COCHE,  Date.valueOf("2001-12-03"), Time.valueOf("10:06:13"), new char[]{'a','b','c'});
//        seguroPersistent.insertarSeguro(mayor1);

        Seguro buscar1 = seguroPersistent.buscar(885);
        Assertions.assertEquals(Seguro.Seguros.COCHE, buscar1.getTiposeguro());
    }
    @Test
    @DisplayName("Comprobar fecha de nacimiento")
    public void testFechaNacimiento() {
        Seguro mayor1 = new Seguro(887, "fecha", "de ", "nacimiento", "Strozzi",
                20, Seguro.Sexos.HOMBRE, "N", 0, Timestamp.valueOf("2021-05-02 04:04:05"), Seguro.Seguros.COCHE,  Date.valueOf("2001-12-03"), Time.valueOf("10:06:13"),new char[]{'a','b','c'});
//        seguroPersistent.insertarSeguro(mayor1);

        Seguro buscar1 = seguroPersistent.buscar(887);
        Assertions.assertEquals(Date.valueOf("2001-12-03"), buscar1.getFechaNacimiento());
    }

    @Test
    @DisplayName("Comprobar hora de contacto")
    public void testHoraContacto() {
        Seguro hora = new Seguro(889, "hora", "de ", "contacto", "Strozzi",
                20, Seguro.Sexos.HOMBRE, "N", 0, Timestamp.valueOf("2021-05-02 04:04:05"), Seguro.Seguros.COCHE,  Date.valueOf("2001-12-03"), Time.valueOf("11:06:13"),new char[]{'a','b','c'});
//        seguroPersistent.insertarSeguro(hora);

        Seguro buscar1 = seguroPersistent.buscar(889);
        Assertions.assertEquals(Time.valueOf("11:06:13"), buscar1.getHoraContacto());
    }

    @Test
    @DisplayName("Comprobar claves blob")
    public void testClaves() {
        Seguro claves = new Seguro(999, "test", "claves ", "blob", "Strozzi",
                20, Seguro.Sexos.HOMBRE, "N", 0, Timestamp.valueOf("2021-05-02 04:04:05"), Seguro.Seguros.COCHE,  Date.valueOf("2001-12-03"), Time.valueOf("11:06:13"),new char[]{'l','o','b'});
//        seguroPersistent.insertarSeguro(claves);

        Seguro buscar = seguroPersistent.buscar(999);
        Assertions.assertTrue(Arrays.equals(buscar.getClaves(), new char[]{'l', 'o', 'b'}));
    }
}

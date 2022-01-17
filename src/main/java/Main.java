import def.Seguro;

import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {

        Seguro seguro = new Seguro(115, "test06", "Pedro", "Gonzalez", "Perez",
                34, Seguro.Sexos.HOMBRE, "S", 12, Timestamp.valueOf("2021-12-02 04:04:05"), Seguro.Seguros.COCHE);

        SeguroPersistent seguroPersistent = new SeguroPersistent();
        seguroPersistent.insertarSeguro(seguro);
        seguroPersistent.actualizarSeguro(seguro);
//        seguroPersistent.eliminarSeguro(seguro);
        System.out.println(seguroPersistent.buscar(115));


    }
}

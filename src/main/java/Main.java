import def.Seguro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {

        Seguro seguro = new Seguro(338, "test04", "Juan", "Pepe", "Aler",
                19, 2, "S", 2, Timestamp.valueOf("2021-07-02 04:04:05"), "No-epic");


        SeguroPersistent seguroPersistent = new SeguroPersistent();
            seguroPersistent.insertarSeguro(seguro);
        System.out.println(seguroPersistent.buscar(338));


    }
}

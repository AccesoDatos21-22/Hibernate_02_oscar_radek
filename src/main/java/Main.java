import def.Seguro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        Seguro seguro = new Seguro(338, "test02", "Juan", "Pepe", "Aler",
                19, 1, "S", 2, Timestamp.valueOf("2021-07-02 04:04:05"), "No-epic");
            SeguroPersistent seguroPersistent= new SeguroPersistent();
        System.out.println(seguroPersistent.buscar(1));
//            seguroPersistent.
//            seguroPersistent.insertarSeguro(seguro);


    }
}

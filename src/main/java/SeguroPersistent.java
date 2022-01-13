import def.Seguro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SeguroPersistent {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Prueba");

    private EntityManager manager;
    private EntityTransaction entityTransaction;

    public SeguroPersistent() {
        manager = entityManagerFactory.createEntityManager();
    }

    public void insertarSeguro(Seguro seguro) {
        try {
            iniciarTransaccion();
            manager.persist(seguro);
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
            liberar();
        }
    }


    public void eliminarSeguro(Seguro seguro) {
        try {
            iniciarTransaccion();
            manager.remove(seguro);
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
            liberar();
        }
    }

    public void actualizarSeguro(Seguro seguro) {
        try {
            iniciarTransaccion();
            manager.merge(seguro);
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
            liberar();
        }
    }

    public Seguro buscar(int idSeguro) {
        Seguro seguro;
        try {
            iniciarTransaccion();
            seguro = manager.find(Seguro.class, idSeguro);
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
            liberar();
        }
        return seguro;
    }

    private void iniciarTransaccion() {
        entityTransaction = manager.getTransaction();
        entityTransaction.begin();

    }

    private void liberar() {
        if (entityTransaction != null)
            entityTransaction = null;
    }

}

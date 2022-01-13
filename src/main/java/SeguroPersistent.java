import def.Seguro;

import javax.persistence.*;

public class SeguroPersistent {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Prueba");

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public SeguroPersistent() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void insertarSeguro(Seguro seguro) {
        try {
            iniciarTransaccion();
            entityManager.persist(seguro);
            entityTransaction.commit();
        }catch(Exception e){
            System.err.println("Error:" + e.getMessage());
        } finally {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
            liberar();
        }
    }


    public void eliminarSeguro(Seguro seguro) {
        iniciarTransaccion();

        liberar();
    }

    public void actualizarSeguro(Seguro seguro) {
        iniciarTransaccion();

        liberar();
    }

    public Seguro buscar(int idSeguro) {
        Seguro seguro = null;
        iniciarTransaccion();
        seguro=entityManager.find(Seguro.class,idSeguro);
        liberar();
        return seguro;
    }

    private void iniciarTransaccion() {
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

    }

    private void liberar() {
        if (entityTransaction != null)
            entityTransaction = null;
    }

}

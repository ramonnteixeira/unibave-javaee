package net.unibave.ecommerce.base;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class PersistenceProducer {
    
    @PersistenceContext
    private EntityManager em;

    @Default
    @Produces
    public EntityManager createEntityManager() {
        return em;
    }

    public void close(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }

}

package net.unibave.ecommerce.aluno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import net.unibave.ecommerce.base.CrudRepository;

@ApplicationScoped
public class AlunoRepository implements CrudRepository<Aluno, Long>{

    @Inject
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Aluno> getEntityClass() {
        return Aluno.class;
    }
    
}

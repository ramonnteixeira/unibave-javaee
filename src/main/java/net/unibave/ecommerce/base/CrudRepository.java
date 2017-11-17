package net.unibave.ecommerce.base;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public interface CrudRepository<E, PK> {

    EntityManager getEntityManager();
    Class<E> getEntityClass();
    
//    default Class<E> getEntityClass() {
//        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
//        return (Class<E>) type.getActualTypeArguments()[0];
//    }

    default List<E> listar() {
        return getEntityManager().createQuery("select a from " + getEntityClass().getSimpleName() + " a", getEntityClass()).getResultList();
    }

    default E buscar(final PK id) {
        return getEntityManager().find(getEntityClass(), id);
    }
    
    @Transactional
    default E inserir(final E entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    @Transactional
    default E atualizar(final PK id, final E entity) {
//        if(!entity.getId().equals(id)) {
//            throw new IllegalArgumentException();
//        }
        
        return getEntityManager().merge(entity);
    }

    @Transactional
    default void deletar(final PK id) {
        getEntityManager().remove(getEntityManager().find(getEntityClass(), id));
    }
    
}

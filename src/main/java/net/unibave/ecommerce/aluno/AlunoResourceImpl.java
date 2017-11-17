package net.unibave.ecommerce.aluno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import net.unibave.ecommerce.base.CrudRepository;
import net.unibave.ecommerce.base.CrudResource;

@Path("/alunos")
@ApplicationScoped
public class AlunoResourceImpl implements CrudResource<Aluno, Long> {

    @Inject
    private AlunoRepository repository;

    @Override
    public CrudRepository<Aluno, Long> getRepository() {
        return repository;
    }
    
}
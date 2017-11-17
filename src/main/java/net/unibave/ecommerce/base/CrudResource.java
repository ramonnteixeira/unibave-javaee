package net.unibave.ecommerce.base;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CrudResource<E, PK> {

    CrudRepository<E, PK> getRepository();
    
    @PUT
    @Path(value = "{id}")
    default Response atualizar(@PathParam(value = "id") final PK id, final E entity) {
        return Response.ok(getRepository().atualizar(id, entity)).build();        
    }

    @GET
    @Path(value = "{id}")
    default Response buscar(@PathParam(value = "id") final PK id) {
        return Response.ok(getRepository().buscar(id)).build();
    }

    @DELETE
    @Path(value = "{id}")
    default Response deletar(@PathParam(value = "id") final PK id) {
        getRepository().deletar(id);
        return Response.noContent().build();
    }

    @POST
    default Response inserir(final E entity) {
        return Response.created(null).entity(getRepository().inserir(entity)).build();
    }

    @GET
    default Response listar() {
        return Response.ok(getRepository().listar()).build();
    }
    
}

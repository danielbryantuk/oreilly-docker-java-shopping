package uk.co.taidev.springshopping.product.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import uk.co.taidev.springshopping.product.daos.ProductDAO;
import uk.co.taidev.springshopping.product.model.Product;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    private ProductDAO productDAO;

    @Inject
    public ProductResource(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GET
    @Timed
    public Response getAllProducts() {
        return Response.status(200)
                .entity(productDAO.findAll())
                .build();
    }

    @GET
    @Timed
    @Path("{id}")
    public Response getProduct(@PathParam("id") String productId) {
        Long id;
        try {
            id = Long.parseLong(productId);
        } catch (NumberFormatException nfe) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .build();
        }

        Optional<Product> result = productDAO.findById(id);

        if (result.isPresent()) {
            return Response.status(Response.Status.OK)
                    .entity(result.get())
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        }
    }
}

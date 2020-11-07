/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restFull;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import rest.Model.util.AlistarModelTrace;
import rest.Model.util.AlistarModelTrace.APICreateEntityRequestType;
import rest.Model.util.AlistarModelTrace.APICreateEntityResponseType;

/**
 * REST Web Service
 *
 * @author Rosemberg
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of restFull.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        String h="hola";
        return h;
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public APICreateEntityResponseType createEntity(APICreateEntityRequestType request)
    {
        AlistarModelTrace x= new AlistarModelTrace();
        APICreateEntityResponseType response = x.new APICreateEntityResponseType();
        
        return response;
    }
}

package org.realrest.presentation.resources;

import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * @author volodymyr.tsukur
 */
@Path("/")
public class EntryPointResource {

    @Inject
    private StandardRepresentationFactory standardRepresentationFactory;

    @GET
    @Produces(RepresentationFactory.HAL_JSON)
    public Representation services(@Context final UriInfo uriInfo) {
        return standardRepresentationFactory.newRepresentation().
                withLink("hotels", uriInfo.getBaseUriBuilder().path(HotelsResource.class).build());
    }

}
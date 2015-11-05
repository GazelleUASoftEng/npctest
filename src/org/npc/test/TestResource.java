package org.npc.test;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.npc.test.commands.ProductByLookupCodeQuery;
import org.npc.test.commands.ProductQuery;
import org.gazelle.api.Product;
import org.gazelle.api.ProductListing;
import org.gazelle.repositories.ProductRepository;

@Path("product")
public class TestResource {
	
	
	@GET
	@Path("bylookupcode/{lookupcode}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@PathParam("lookupcode") String lookupcode) { 
		
		return (new ProductByLookupCodeQuery()).setProductRepository(new ProductRepository()).
				setLookupCode(lookupcode).
				execute();				
	}
	
	
	
	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN)
	public int test() {
		return 4;
	}
}

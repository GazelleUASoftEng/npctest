package org.npc.test;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.npc.test.commands.CreateTransactionCommand;
import org.gazelle.api.Transaction;
import org.gazelle.enums.TransactionApiRequestStatus;


//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;

//@Component
@Path("transaction")
public class TransactionResource {
	@PUT
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public TransactionApiRequestStatus createTransaction(JAXBElement<Transaction> apiTransaction) {
	
		org.gazelle.models.Transaction transaction = new org.gazelle.models.Transaction(apiTransaction.getValue());
		transaction.save();
		Transaction finishTransaction = new Transaction(transaction);

		return finishTransaction.getApiRequestStatus();
	}
	
	@POST
	@Path("test")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String testString(JAXBElement<Transaction> apiTransaction){
		org.gazelle.models.Transaction transaction = new org.gazelle.models.Transaction(apiTransaction.getValue());
				transaction.save();
				Transaction finishTransaction = apiTransaction.getValue().setId(transaction.getId());
				finishTransaction.setId(UUID.randomUUID());
				return transaction.getId().toString();
	}
}
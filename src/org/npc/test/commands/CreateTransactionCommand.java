package org.npc.test.commands;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.npc.test.commands.interfaces.ResultCommandInterface;
import org.gazelle.api.Transaction;
import org.gazelle.enums.TransactionType;
import org.gazelle.repositories.interfaces.TransactionRepositoryInterface;

public class CreateTransactionCommand implements ResultCommandInterface<Transaction> {
	@Override
	public Transaction execute() {
		//this.apiTransaction.setId(UUID.randomUUID()); not sure if uuid is set by client or server
		org.npc.testmodel.models.Transaction modelTransaction = new Transaction(this.apiTransaction);

		modelProduct.save();

		return this.apiTransaction;
	}

	//Properties
	private Transaction apiTransaction;
	public Transaction getApiTransaction() {
		return this.apiTransaction;
	}
	public CreateTransactionCommand setApiTransaction(Transaction apiTransaction) {
		this.apiTransaction = apiTransaction;
		return this;
	}
	
	private TransactionRepositoryInterface transactionRepository;
	public TransactionRepositoryInterface getTransactionRepository() {
		return this.transactionRepository;
	}
	public CreateTransactionCommand setTransactionRepository(TransactionRepositoryInterface transactionRepository) {
		this.transactionRepository = transactionRepository;
		return this;
	}
}
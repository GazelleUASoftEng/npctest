package org.npc.test.commands;

import org.gazelle.api.Product;
import org.gazelle.enums.ProductApiRequestStatus;
import org.gazelle.repositories.interfaces.ProductRepositoryInterface;

public class ProductByLookupCodeQuery {

	
	public Product execute() {
		if (lookupCode == "") {
			return new Product().setApiRequestStatus(ProductApiRequestStatus.NOT_FOUND);
		}
		
		if (this.productRepository.byLookupCode(this.lookupCode).equals(null)) {
			return new Product().setApiRequestStatus(ProductApiRequestStatus.NOT_FOUND);
		}
		
		return new Product(this.productRepository.byLookupCode(this.lookupCode));
	}
	
	private String lookupCode;
	
	public ProductByLookupCodeQuery setLookupCode (String lookupCode) {
		
		
		this.lookupCode = lookupCode;
		return this;
	}
	public String getLookupCode () {
		return this.lookupCode;
	}
	
	private ProductRepositoryInterface productRepository;
	public ProductRepositoryInterface getProductRepository() {
		return this.productRepository;
	}
	public ProductByLookupCodeQuery setProductRepository(ProductRepositoryInterface productRepository) {
		this.productRepository = productRepository;
		return this;
	}
}

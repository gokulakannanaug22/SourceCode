package com.att.idp.ms.pricingpromotion.common.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PricingRestRequestValidator implements Validator{
	
	/*@Autowired
    public PricingRestRequestValidator(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }*/

	@Override
	public boolean supports(Class<?> clazz) {

		return PricingRestRequest.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "uuId", "uuId is empty");
		
		PricingRestRequest p = (PricingRestRequest) target;
		
	}
	
	/*private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }*/

}

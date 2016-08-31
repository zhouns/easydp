package com.sgepm.easydp.common.persistence.validate;

public class BeanValidateException extends RuntimeException {

	private static final long serialVersionUID = -6791818615674791844L;
	
    public BeanValidateException(){
        super();
    }

    public BeanValidateException(String message){
        super(message);
    }

    public BeanValidateException(Throwable cause){
        super(cause);
    }
	
    public BeanValidateException(String message, Throwable cause){
        super(message, cause);
    }

}

package com.sgepm.easydp.common.persistence;

public class IBaseException extends RuntimeException {

	private static final long serialVersionUID = -1551283640950416252L;
	
    public IBaseException(){
        super();
    }

    public IBaseException(String message, Throwable cause){
        super(message, cause);
    }

    public IBaseException(String message){
        super(message);
    }

    public IBaseException(Throwable cause){
        super(cause);
    }

}

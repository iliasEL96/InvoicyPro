package com.InvoicifyPro.InvoicifyPro.exception;

public class ResourceNotFoundException  extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException (String ressourceName, Long ressourceId){
        super(ressourceName +" not found with id" + ressourceId);
    }



}

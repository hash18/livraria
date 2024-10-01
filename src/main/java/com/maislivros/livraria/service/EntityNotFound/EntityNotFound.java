package com.maislivros.livraria.service.EntityNotFound;

/**
 *
 * @author Rangel
 */
public class EntityNotFound extends RuntimeException {
    public EntityNotFound(String msg){
        super(msg);
    }
}

package com.lecteuraudio.webservice.exception;

import javax.persistence.PersistenceException;

public class Conflict extends PersistenceException {

    public Conflict(String message) {
        super(message);
    }

}

package com.app.koachoo.exceptions;

public class GoalsNotFoundException extends Exception {

        public GoalsNotFoundException(Long id) {
            super("Goal id not found : " + id);
        }

}

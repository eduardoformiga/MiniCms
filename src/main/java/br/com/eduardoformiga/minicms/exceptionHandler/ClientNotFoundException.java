package br.com.eduardoformiga.minicms.exceptionHandler;

public class ClientNotFoundException extends Exception {
    public ClientNotFoundException(String message) {
        super(message);
    }
}

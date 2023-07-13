package br.com.banco.exception;

public class ContaNaoEncontradaException extends RuntimeException{
    public ContaNaoEncontradaException(String message){
        super(message);
    }
}

package br.com.banco.exception;

public class TransferenciaNaoEncontradaException extends RuntimeException{
    public TransferenciaNaoEncontradaException(String message){
        super(message);
    }
}

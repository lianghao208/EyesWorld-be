package org.tvos.exception;

/**
 * 删除相片异常
 */
public class DeleteException extends RuntimeException {
    public DeleteException(String message){
        super(message);
    }

    public DeleteException(String message, Throwable cause){
        super(message, cause);
    }
}

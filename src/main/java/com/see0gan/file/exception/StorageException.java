package com.see0gan.file.exception;

public class StorageException extends RuntimeException {

  

	/**
	 * 
	 */
	private static final long serialVersionUID = -351060442464198308L;

	public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}

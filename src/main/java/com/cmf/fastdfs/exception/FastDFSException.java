package com.cmf.fastdfs.exception;

/**
 * FastDFS Exception
 */
public class FastDFSException extends Exception {

    private int errorCode = 0;

    public FastDFSException(int errorCode) {
        this.errorCode = errorCode;
    }

    public FastDFSException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public FastDFSException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public FastDFSException(Throwable cause, int errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public FastDFSException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
                            int errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }
}

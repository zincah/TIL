package org.example.effective.chapter10.item73;

public class CruzlinkException extends RuntimeException{

    private String ERROR_CODE = "";
    private String ERROR_MSG = "";

    /**
     *
     *
     * @param errorCode
     * @param errorMsg
     */
    public CruzlinkException(String errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);

        this.ERROR_CODE = errorCode;
        this.ERROR_MSG = errorMsg;
    }

}

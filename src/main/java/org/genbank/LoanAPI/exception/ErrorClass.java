package org.genbank.LoanAPI.exception;

import java.time.LocalDateTime;
import java.util.Date;

public class ErrorClass {

    String errMsg;
    LocalDateTime timestamp;
    String details;
    String errorCode;



    public ErrorClass(String errMsg, LocalDateTime timestamp, String details,String errorCode) {
        super();
        this.errMsg = errMsg;
        this.timestamp = timestamp;
        this.details = details;
        this.errorCode = errorCode;
    }



    public String getErrMsg() {
        return errMsg;
    }



    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }



    public LocalDateTime getTimestamp() {
        return timestamp;
    }



    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }



    public String getDetails() {
        return details;
    }



    public void setDetails(String details) {
        this.details = details;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "ErrorClass{" +
                "errMsg='" + errMsg + '\'' +
                ", timestamp=" + timestamp +
                ", details='" + details + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
}


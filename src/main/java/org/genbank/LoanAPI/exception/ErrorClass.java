package org.genbank.LoanAPI.exception;

import java.util.Date;

public class ErrorClass {

    String errMsg;
    Date timestamp;
    String details;



    public ErrorClass(String errMsg, Date timestamp, String details) {
        super();
        this.errMsg = errMsg;
        this.timestamp = timestamp;
        this.details = details;
    }



    public String getErrMsg() {
        return errMsg;
    }



    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }



    public Date getTimestamp() {
        return timestamp;
    }



    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }



    public String getDetails() {
        return details;
    }



    public void setDetails(String details) {
        this.details = details;
    }



    @Override
    public String toString() {
        return "Error [errMsg=" + errMsg + ", timestamp=" + timestamp + ", details=" + details + "]";
    }




}


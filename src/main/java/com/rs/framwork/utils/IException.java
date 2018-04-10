package com.rs.framwork.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class IException  extends RuntimeException{

	private static final long serialVersionUID = -2380911758285157331L;
	private static Log   log = LogFactory.getLog(IException.class);
    private String            errCode;
    private String            errMsg;

    public IException() {
        super();
    }

    public IException(String message, Throwable cause) {
        super(message, cause);
        log.error(cause);
    }

    public IException(String message) {
        super(message);
        log.error(message);
    }

    public IException(Throwable cause) {
        super(cause);
        log.error(cause);
    }

    public IException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }
	
	
}

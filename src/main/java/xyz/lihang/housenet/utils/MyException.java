package xyz.lihang.housenet.utils;

/**
 * Created by Administrator on 2017/11/2.
 */
public  class MyException extends RuntimeException {
    private String errorMsg;


    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
        this.errorMsg = message;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

package mingu.spring.aop.dto;

import java.io.Serializable;
import java.util.Map;

public class InputRequestInfo implements Serializable {
    private String requestType;
    private Map<String, Object> requestParams;

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public void setRequestParams(Map<String, Object> requestParams) {
        this.requestParams = requestParams;
    }

    public String getRequestType() {
        return requestType;
    }

    public Map<String, Object> getRequestParams() {
        return requestParams;
    }

    @Override
    public String toString() {
        return "InputRequestInfo{" +
                "requestType='" + requestType + '\'' +
                ", requestParams=" + requestParams +
                '}';
    }
}

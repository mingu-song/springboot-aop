package mingu.spring.aop.dto;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class OutputResponseInfo implements Serializable {
    private HttpStatus responseState;
    private Object payload;

    public HttpStatus getResponseState() {
        return responseState;
    }

    public void setResponseState(HttpStatus responseState) {
        this.responseState = responseState;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "OutputResponseInfo{" +
                "responseState=" + responseState +
                ", payload=" + payload +
                '}';
    }
}

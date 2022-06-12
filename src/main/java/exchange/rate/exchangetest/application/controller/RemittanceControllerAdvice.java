package exchange.rate.exchangetest.application.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RemittanceControllerAdvice {

    @ExceptionHandler(Exception.class)
    public String onException(Exception e) {
        e.printStackTrace();
        return "error";
    }
}

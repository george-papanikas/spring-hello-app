package gr.aueb.cf.springhello5.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Locale;

@ControllerAdvice
public class ErrorController {

    private final MessageSource messageSource;
    private MessageSourceAccessor accessor;

    @PostConstruct
    private void init() {
        accessor = new MessageSourceAccessor(messageSource, Locale.getDefault());
    }

    @Autowired
    public ErrorController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler({NoResourceFoundException.class })
    public String handleException(NoResourceFoundException ex, Model model) {
        //model.addAttribute("message", "Resource not found");
        model.addAttribute("message", accessor.getMessage("error.generic"));
        return "error";
    }
}

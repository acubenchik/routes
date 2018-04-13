package com.routes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
public class LocaleController {

//    @Value("#{greeting}")
//    public String greeting;

    @Autowired
    private MessageSource myMessageSource;


    @RequestMapping(value = "greeting/get", method = RequestMethod.GET)
    @ResponseBody
    public String greet() {
        return myMessageSource.getMessage("greeting", null, Locale.forLanguageTag("en-US"));
    }
}

package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by oa on 6/2/2019.
 */
@Configuration
@RestController
public class FilterController
{
	private static final Logger log = LoggerFactory.getLogger(FilterController.class);
    @RequestMapping(value = { "/secure-code" })
    public String secureCode() {
log.info("ENTERED ");
        return "2@F1FR$(%23";
    }

    @RequestMapping(value = { "/secure-code/public" })
    public String pubCode() {

        return "2@CLASG$(%23";
    }


    @RequestMapping(value = { "/auth-failed"})
    public String authFailed()
    {
        return "auth-failed";
    }


}

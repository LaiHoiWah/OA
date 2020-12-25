package com.wah.oa.manager.core.hello.httpservice;

import com.wah.commons.security.response.Response;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/1.0/hello")
public class HelloRestController{

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response index(){
        return new Response("Hello World");
    }
}

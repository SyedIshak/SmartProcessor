package com.pramati.SmartProcessor.route;

import javax.annotation.PostConstruct;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

public abstract class SmartRouteBuilder extends RouteBuilder {
    
    @PostConstruct
    private void initConfig() {
	restConfiguration().component("restlet").host("localhost").port("9090").bindingMode(RestBindingMode.json).enableCORS(true).corsHeaderProperty("Access-Control-Allow-Origin", "chrome-extension://ffhaplmengfpeelmahaepabopnocpjmm")
        .corsHeaderProperty("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
        .corsHeaderProperty("Access-Control-Allow-Headers",
                "Origin, Accept, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers")
        .corsHeaderProperty("Access-Control-Max-Age", "1234");
    }
}

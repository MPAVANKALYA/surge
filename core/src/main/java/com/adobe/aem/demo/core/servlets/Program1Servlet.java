
package com.adobe.aem.demo.core.servlets;

import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

@Component(
    service = Servlet.class,
    property = {
        "sling.servlet.resourceTypes=demo1/content/prog", 
        "sling.servlet.methods=GET",
        "sling.servlet.extensions=json" 
    }
)
public class Program1Servlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest req, SlingHttpServletResponse res) 
            throws IOException {

       
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");

       
        JsonObjectBuilder object = Json.createObjectBuilder();
        object.add("name", "Pavan Kalyan Mogeeli");
        object.add("surname", "Mogeeli");

        
        res.getWriter().write(object.build().toString());
    }
}




package com.adobe.aem.demo.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;


@Component(service=Servlet.class,
property={"sling.servlet.methods=GET",
    "sling.servlet.paths=/bin/pavan/kalyan"
  
     
}
)
public class Surge extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        

                response.getWriter().write("Surge software solutions");
    }


    
}

package com.adobe.aem.demo.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;



@Component(service=Servlet.class,
property=
{
    "sling.servlet.methods=GET",
    "sling.servlet.Paths=/bin/demo1/content/prog"


}
   )
public class program3 extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {



                response.getWriter().write("pavan");

        
    }




}

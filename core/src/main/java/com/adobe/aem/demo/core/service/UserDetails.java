package com.adobe.aem.demo.core.service;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service=UserDetails.class,enabled=true,immediate=true)
public class UserDetails {


     private static final Logger LOG=LoggerFactory.getLogger("UserDetails.class");

private String userName;
private int userId;
private String userSecret;
private String userApi;

      @Activate   
public void activate()
{
   
}

@Deactivate
public void deActivate()
{
    
}

@Modified
public void update()
{
    

}
}
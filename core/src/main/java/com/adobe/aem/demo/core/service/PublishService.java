package com.adobe.aem.demo.core.service;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate=true,service=PublishService.class)
public class PublishService {

    
    private static final Logger LOG=LoggerFactory.getLogger("AutorService.class");
 @Activate   
public void activate()
{
     LOG.info("AuthorService activate() execution started");
}

@Deactivate
public void deActivate()
{
    LOG.info("AuthorService Deactivate() execution started");
}

@Modified
public void update()
{
    LOG.info("AuthorService update() execution started");
}


public String printData()
{
    return "Dats coming from printDat() availabe in publishService ";
}



}

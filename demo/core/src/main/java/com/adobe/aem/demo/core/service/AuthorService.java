package com.adobe.aem.demo.core.service;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate=true)
public class AuthorService {

    private static final Logger LOG=LoggerFactory.getLogger("AutorService.class");
@Reference
PublishService publishService;
 @Activate   
public void activate()
{
    String result=publishService.printData();
     LOG.info("AuthorService activate() execution started");
     LOG.info("result {}",result);
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

}

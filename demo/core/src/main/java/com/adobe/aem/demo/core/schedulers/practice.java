package com.adobe.aem.demo.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Component(service=Runnable.class,immediate = true)
@Designate(ocd=practice1.class)
public class practice implements Runnable{
   // Private static Final  Logger LOG=LoggerFactory.getLogger(practice.class);
private static final Logger LOG=LoggerFactory.getLogger("ContentExpiryDate.class");

    @Reference
    Scheduler scheduler;

    @Override
    public void run() {
        
        LOG.info("run() is executing sucessfully");
    }

    @Activate
    public void activate(practice1 prac)
    {
            pavan(prac);
    }


     @Deactivate
    public void deActivate(practice1 prac)
    {
        pavan(prac);
    }

    @Modified
    public void update(practice1 prac)
    {
        pavan(prac);
    }

 

    public void pavan(practice1 prac)
    {
        if(prac.enable())


        {
            ScheduleOptions options =scheduler.EXPR(prac.expression());
            options.canRunConcurrently(false) ;
            options.name(prac.getService_name());

         scheduler.schedule(this, options);




        }
        else{
                scheduler.unschedule(prac.getService_name());
        }
    }
    

}

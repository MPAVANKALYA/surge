package com.adobe.aem.demo.core.schedulers;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;




@ObjectClassDefinition(name="dynamic class" ,description="shedulerrun indepentendly")
public @interface practice1 { 



   
    @AttributeDefinition(name=" service name" , description="schedulername",type=AttributeType.STRING )
    public String getService_name() default "practice";



    @AttributeDefinition(name=" can run concurrent" , description="schedulername concurrent",type=AttributeType.STRING )
    boolean scheduler_concurrent() default false;
    

    @AttributeDefinition(name=" service name" , description="schedulername",type=AttributeType.BOOLEAN)
    public boolean enable() default true;

    @AttributeDefinition(name=" service name" , description="schedulername",type=AttributeType.STRING )
    public String expression() default "*/3 * * * * * ?";

}

package com.adobe.aem.demo.core.models;


import java.util.List;
import java.util.ListIterator;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Nested {


    
    @ValueMapValue
    private String text;

    @ValueMapValue
    private String country;

    public String getText() {
        return text;
    }

    public String getCountry() {
        return country;
    }

    // @ChildResource
    // public List<Nested1> nested;

    // public List<Nested1> getNested() {
    //     return nested;
    // }

   
}

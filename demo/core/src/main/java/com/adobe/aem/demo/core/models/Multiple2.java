package com.adobe.aem.demo.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables={Resource.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Multiple2 {

    @ValueMapValue
    private String image4;

    @ValueMapValue
    private String image5;
    
    @ChildResource
    List<Nersted1> nested;

    public String getImage4() {
        return image4;
    }

    public String getImage5() {
        return image5;
    }

    public List<Nersted1> getNested() {
        return nested;
    }

}

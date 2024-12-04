package com.adobe.aem.demo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables={Resource.class},defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class Multiple {

@ValueMapValue
private String text2;


@ValueMapValue
private String image3;





public String getText2() {
    return text2;
}


public String getImage3() {
    return image3;
}


}


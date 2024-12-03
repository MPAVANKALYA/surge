package com.adobe.aem.demo.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables= {Resource.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Task3 {
    @ValueMapValue
    private String text1;

    @ValueMapValue
    private String image1;

    @ValueMapValue
    private String image2;

    @ValueMapValue
    private String checkbox ;
    
    @ChildResource
    List<Multiple> mul;

    @ChildResource
    List<Multiple2> mul1 ;

    @ChildResource
    private String select;
    

    public String getSelect() {
        return select;
    }

    public List<Multiple> getMul() {
        return mul;
    }

    public List<Multiple2> getMul1() {
        return mul1;
    }

    public String getText1() {
        return text1;
    }

    public String getImage1() {
        return image1;
    }

    public String getImage2() {
        return image2;
    }

    public String getCheckbox() {
        return checkbox;
    }




}

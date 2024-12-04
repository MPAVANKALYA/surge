package com.adobe.aem.demo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DialogModel {

    @ValueMapValue
    private String Textfield;

    @ValueMapValue
    private String path;

    @ValueMapValue
    private String check;

    @ValueMapValue
    private String select;

    public String getTextfield() {
        return Textfield;
    }
public String getPath() {
        return path;
    }

    public String getCheck() {
        return check;
    }

    public String getSelect() {
        return select;
    }
}

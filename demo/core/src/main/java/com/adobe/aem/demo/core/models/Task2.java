
package com.adobe.aem.demo.core.models;
import java.util.List;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

// Sling Model annotation to define this as a model class
@Model(adaptables ={ Resource.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Task2 {


    @ValueMapValue
    private String text;

    @ChildResource
    private List<Multi> mul;

    // Getter for text property
    public String getText() {
        return text;
    }

    // Getter for the child resource list
    public List<Multi> getMul() {
        return mul;
    }
}



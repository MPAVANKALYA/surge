package com.adobe.aem.demo.core.schedulers;



import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.sling.commons.scheduler.Job;
import org.apache.sling.commons.scheduler.JobContext;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component(service = Job.class, immediate = true)
@Designate(ocd = Task15Scheduler.Config.class)
public class Task15Scheduler implements Job {

    private static final Logger log = LoggerFactory.getLogger(Task15Scheduler.class);
    private static final String SERVICE_USER = "scheduleService";
    
    // Credentials for basic authentication
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @ObjectClassDefinition(name = "My Scheduler Job Configuration")
    public @interface Config {
        @AttributeDefinition(name = "Cron Expression")
        String scheduler_expression() default "0 0/3 * 1/1 * ? *"; // Every 3 minutes
    }

    @Override
    public void execute(JobContext context) {
        HttpClient client = HttpClientBuilder.create().build();

        // URL to your servlet
        String servletUrl = "http://localhost:4502/sites.html/content/demo1/us/en";

        // Obtain ResourceResolver
        ResourceResolver resolver = getServiceResourceResolver();
        if (resolver == null) {
            log.error("Unable to obtain ResourceResolver.");
            return;
        }

        try {
            // Create an HTTP POST request
            HttpPost request = new HttpPost(servletUrl);

            // Add basic authentication
            String authHeader = "Basic " + Base64.getEncoder().encodeToString((USERNAME + ":" + PASSWORD).getBytes(StandardCharsets.UTF_8));
            request.setHeader("Authorization", authHeader);

            // Add parameters if needed (e.g., as JSON or form data)
            StringEntity entity = new StringEntity("param1=value1&param2=value2"); // Update as needed
            request.setEntity(entity);
            request.setHeader("Content-Type", "application/x-www-form-urlencoded"); // Adjust content type if needed

            // Execute the request
            HttpResponse response = client.execute(request);
            try {
                int statusCode = response.getStatusLine().getStatusCode();
                log.info("Servlet called with status code: {}", statusCode);
            } finally {
                ((Closeable) response).close();
            }
        } catch (IOException e) {
            log.error("Error executing HTTP request to servlet: ", e);
        } finally {
            if (resolver != null && resolver.isLive()) {
                resolver.close();
            }
        }
    }

    private ResourceResolver getServiceResourceResolver() {
        Map<String, Object> params = new HashMap<>();
        params.put(ResourceResolverFactory.SUBSERVICE, SERVICE_USER);
        try {
            return resourceResolverFactory.getServiceResourceResolver(params);
        } catch (Exception e) {
            log.error("Error getting ResourceResolver", e);
            return null;
        }
    }
}
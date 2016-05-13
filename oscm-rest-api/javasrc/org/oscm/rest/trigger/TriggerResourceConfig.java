/*******************************************************************************
 *                                                                              
 *  Copyright FUJITSU LIMITED 2016                                           
 *                                                                                                                                 
 *  Creation Date: May 2, 2016                                                      
 *                                                                              
 *******************************************************************************/

package org.oscm.rest.trigger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.ApplicationPath;

import org.oscm.rest.common.CommonFilterFactory;
import org.oscm.rest.common.GsonMessageProvider;

import com.sun.jersey.api.core.ResourceConfig;

/**
 * Registers resources and providers of the trigger component to the
 * application.
 * 
 * @author miethaner
 */
@ApplicationPath("/trigger")
public class TriggerResourceConfig extends ResourceConfig {

    private Map<String, Object> properties;

    public TriggerResourceConfig() {
        properties = new HashMap<String, Object>();
        properties.put(PROPERTY_RESOURCE_FILTER_FACTORIES,
                CommonFilterFactory.class);
    }

    @Override
    public Set<Class<?>> getRootResourceClasses() {
        Set<Class<?>> resource = new HashSet<Class<?>>();

        resource.add(RestTrigger.class);

        return resource;
    }

    @Override
    public Set<Class<?>> getProviderClasses() {
        Set<Class<?>> provider = new HashSet<Class<?>>();

        provider.add(GsonMessageProvider.class);

        return provider;
    }

    @Override
    public boolean getFeature(String arg0) {
        return false;
    }

    @Override
    public Map<String, Boolean> getFeatures() {
        return new HashMap<String, Boolean>();
    }

    @Override
    public Object getProperty(String key) {
        return properties.get(key);
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

}

package com.talmer.plugin.service;

import com.atlassian.configurable.ObjectConfiguration;
import com.atlassian.configurable.ObjectConfigurationException;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.service.AbstractService;
import com.opensymphony.module.propertyset.PropertySet;
import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.JiraClient;

public class SyncService extends AbstractService {



    @Override
    public void init(PropertySet props, long configurationIdentifier) throws ObjectConfigurationException {
        super.init(props, configurationIdentifier);
    }

    @Override
    public void run() {
        System.out.println("Let me do this before run!");
        System.out.println("_______________________________");
        String baseUrl = ComponentAccessor.getApplicationProperties().getString("jira.baseurl");
        //Create JIRA connection
        BasicCredentials creds = new BasicCredentials("admin", "admin");
        JiraClient jira = new JiraClient(baseUrl, creds);
    }

    @Override
    public void destroy() {
        System.out.println("Let me do this before destory!");
        System.out.println("_______________________________");
        super.destroy();
    }

    @Override
    public ObjectConfiguration getObjectConfiguration() throws ObjectConfigurationException {
        return getObjectConfiguration("MYNEWSERVICE", "", null);

    }
}

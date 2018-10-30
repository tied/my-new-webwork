package com.talmer.plugin.service;

import com.atlassian.configurable.ObjectConfiguration;
import com.atlassian.configurable.ObjectConfigurationException;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.service.AbstractService;
import com.opensymphony.module.propertyset.PropertySet;
import com.talmer.plugin.DAO.ExchangeUserDAO;
import com.talmer.plugin.logic.ExchangeUser;
import com.talmer.util.api.DataManipulator;
import com.talmer.util.impl.DataManipulatorImpl;

import javax.inject.Inject;

public class SyncService extends AbstractService {

    public static final String TUTORIAL = "Tutorial";
    private final ExchangeUserDAO userDAO;
    private String tutorial;
    private DataManipulator dataManipulator;

    @Inject
    public SyncService(ExchangeUserDAO userDAO, DataManipulator dataManipulator) {
        this.userDAO = userDAO;
        this.dataManipulator = dataManipulator;
    }

    @Override
    public void init(PropertySet props, long configurationIdentifier) throws ObjectConfigurationException {
        super.init(props, configurationIdentifier);
        if (hasProperty(TUTORIAL)) {
            tutorial = getProperty(TUTORIAL);
        } else {
            tutorial = "I don't like tutorials!";
        }
    }

    @Override
    public void run() {
        System.out.println("Let me do this before run!");
        System.out.println("_______________________________");
        String baseUrl = ComponentAccessor.getApplicationProperties().getString("jira.baseurl");
        try {
            for (ExchangeUser user : userDAO.getExchangeUsers()) {
                System.out.println("Login: " + user.getLogin() + ", Password: " + user.getPassword());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        dataManipulator = new DataManipulatorImpl();
        dataManipulator.setJiraCredentials("admin", "admin");
       

        //Create JIRA connection
//        BasicCredentials creds = new BasicCredentials("admin", "admin");
//        JiraClient jira = new JiraClient(baseUrl, creds);

//        manipulator = new DataManipulatorImpl();



    }

    @Override
    public void destroy() {
        System.out.println("Let me do this before destory!");
        System.out.println("_______________________________");
        super.destroy();
    }

    @Override
    public ObjectConfiguration getObjectConfiguration() throws ObjectConfigurationException {
        return getObjectConfiguration("MYNEWSERVICE", "com.talmer.plugin.service/mynewsyncservice.xml", null);

    }
}

package com.talmer.plugin.service;

import com.atlassian.configurable.ObjectConfiguration;
import com.atlassian.configurable.ObjectConfigurationException;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.service.AbstractService;
//import com.independentsoft.exchange.*;
import com.opensymphony.module.propertyset.PropertySet;
import com.talmer.plugin.jira.webwork.ConfigWebwork;
import com.talmer.util.api.DataManipulator;
import com.talmer.util.impl.DataManipulatorImpl;

//import net.rcarz.jiraclient.BasicCredentials;
//import net.rcarz.jiraclient.JiraClient;

//import javax.inject.Inject;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;

public class SyncService extends AbstractService {

    public static final String TUTORIAL = "Tutorial";

    private String tutorial;

    private DataManipulator dataManipulator;

    @Override
    public void init(PropertySet props, long configurationIdentifier) throws ObjectConfigurationException {
        super.init(props, configurationIdentifier);
        dataManipulator = new DataManipulatorImpl();
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
        //Create JIRA connection
        if (ConfigWebwork.login != null & ConfigWebwork.password != null) {
            System.out.println("JIRA CREDENTIALS HAVE BEEN REGISTERED!!!");
            System.out.println("_________________________________________");
//            this.dataManipulator = new DataManipulatorImpl();
            this.dataManipulator.setJiraCredentials(ConfigWebwork.login, ConfigWebwork.password);
            this.dataManipulator.setExchangeCredentials("n.aleksandrov", "Dahakamer12");
            this.dataManipulator.syncData(baseUrl, "https://mx1.talmer.ru/EWS/Exchange.asmx");

        }
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

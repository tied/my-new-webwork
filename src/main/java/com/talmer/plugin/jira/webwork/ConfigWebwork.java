package com.talmer.plugin.jira.webwork;

import com.atlassian.jira.web.action.ActionViewData;
import com.talmer.plugin.DAO.ExchangeUserDAO;
import com.talmer.plugin.logic.ExchangeUser;
import com.talmer.plugin.logic.ExchangeUserImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.web.action.JiraWebActionSupport;

import javax.inject.Inject;

public class ConfigWebwork extends JiraWebActionSupport {
    private static final Logger log = LoggerFactory.getLogger(ConfigWebwork.class);

    private final ExchangeUserDAO userDAO;
    private String login;
    private String password;

    @Inject
    public ConfigWebwork(ExchangeUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public String execute() throws Exception {
        super.execute();
        return SUCCESS;
    }

    public void doSave() throws Exception {
        ExchangeUser exchangeUser = new ExchangeUserImpl(login, password);
        userDAO.addExchangeUser(exchangeUser);
    }

    @ActionViewData
    public String getLogin() {
        return "";
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @ActionViewData
    public String getPassword() {
        return "";
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

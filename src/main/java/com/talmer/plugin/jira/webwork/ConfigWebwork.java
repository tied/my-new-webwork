package com.talmer.plugin.jira.webwork;

import com.atlassian.jira.web.action.ActionViewData;
import com.talmer.plugin.api.PluginSettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.web.action.JiraWebActionSupport;

import javax.inject.Inject;

public class ConfigWebwork extends JiraWebActionSupport {
    private static final Logger log = LoggerFactory.getLogger(ConfigWebwork.class);
    private final PluginSettingService pluginSettingService;
    private String login;
    private String password;

    @Inject
    public ConfigWebwork(PluginSettingService pluginSettingService) {
        this.pluginSettingService = pluginSettingService;
    }

    @Override
    public String execute() throws Exception {
        super.execute();
        return SUCCESS;
    }

    public void doSave() {
        pluginSettingService.setLogin(login);
        pluginSettingService.setPassword(password);
    }

    @ActionViewData
    public String getLogin() {
        return pluginSettingService.getLogin().isEmpty() ? "" : pluginSettingService.getLogin();
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @ActionViewData
    public String getPassword() {
        return pluginSettingService.getPassword().isEmpty() ? "" : pluginSettingService.getPassword();
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

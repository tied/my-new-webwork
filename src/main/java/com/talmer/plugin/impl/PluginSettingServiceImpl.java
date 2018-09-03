package com.talmer.plugin.impl;

import com.talmer.plugin.api.PluginSettingService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.pluginsettings.PluginSettings;
import com.atlassian.sal.api.pluginsettings.PluginSettingsFactory;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class PluginSettingServiceImpl implements PluginSettingService {
    public final PluginSettings pluginSettings;
    private static final String PLUGIN_STORAGE_KEY = "com.talmer.plugin";
    private static final String LOGIN = null;
    private static final String PASSWORD = null;

    @Inject
    public PluginSettingServiceImpl(@ComponentImport PluginSettingsFactory pluginSettingsFactory) {
        this.pluginSettings = pluginSettingsFactory.createGlobalSettings();

    }

    private void setSettingValue(String settingKey, String settingValue) {
        this.pluginSettings.put(PLUGIN_STORAGE_KEY + settingKey, settingValue != null ? settingValue : "");
    }

    private String getSettingValue(String settingKey) {
        return pluginSettings.get(PLUGIN_STORAGE_KEY + settingKey) != null ? pluginSettings.get(PLUGIN_STORAGE_KEY + settingKey).toString() : "";
    }


    @Override
    public String getLogin() {
        return getSettingValue(LOGIN);
    }

    @Override
    public void setLogin(String login) {
        setSettingValue(LOGIN, login);
    }

    @Override
    public String getPassword() {
        return getSettingValue(PASSWORD);
    }

    @Override
    public void setPassword(String password) {
        setSettingValue(PASSWORD, password);
    }
}

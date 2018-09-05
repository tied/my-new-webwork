package com.talmer.plugin.DAO;

import com.atlassian.activeobjects.external.ActiveObjects;

public class DAOFactory {
    private static ExchangeUserDAO exchangeUserDAO = null;
    private static DAOFactory instance = null;
    private static ActiveObjects ao;

    public DAOFactory(ActiveObjects ao) {
        DAOFactory.ao = ao;
    }

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory(ao);
        }
        return instance;
    }

    public ExchangeUserDAO getExchangeUserDAO() {
        if (exchangeUserDAO == null) {
            exchangeUserDAO = new ExchangeUserDAOImpl(ao);
        }
        return exchangeUserDAO;
    }
}

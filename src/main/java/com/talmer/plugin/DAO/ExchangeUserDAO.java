package com.talmer.plugin.DAO;

import com.talmer.plugin.entity.ExchangeUserEntity;
import com.talmer.plugin.logic.ExchangeUser;

public interface ExchangeUserDAO {
    public ExchangeUserEntity addExchangeUser(ExchangeUser user) throws Exception;

    public ExchangeUserEntity[] getExchangeUsers() throws Exception;

    public ExchangeUserEntity[] deleteExchangeUser(ExchangeUser user) throws Exception;
}

package com.talmer.plugin.DAO;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.sal.api.transaction.TransactionCallback;
import com.talmer.plugin.entity.ExchangeUserEntity;
import com.talmer.plugin.logic.ExchangeUser;
import net.java.ao.Query;

public class ExchangeUserDAOImpl implements ExchangeUserDAO {

    private final ActiveObjects ao;

    public ExchangeUserDAOImpl(ActiveObjects ao) {
        this.ao = ao;
    }

    @Override
    public ExchangeUserEntity addExchangeUser(ExchangeUser exchangeUser) throws Exception {
        return ao.executeInTransaction(() -> {
            ExchangeUserEntity entity = ao.create(ExchangeUserEntity.class);
            entity.setLogin(exchangeUser.getLogin());
            entity.setPassword(exchangeUser.getPassword());
            entity.save();
            return entity;
        });
    }

    @Override
    public ExchangeUserEntity[] getExchangeUsers() throws Exception {
        return ao.executeInTransaction(() -> ao.find(ExchangeUserEntity.class));
    }

    @Override
    public ExchangeUserEntity[] deleteExchangeUser(ExchangeUser user) throws Exception {
        return ao.executeInTransaction(() -> {
            ExchangeUserEntity[] entities = ao.find(ExchangeUserEntity.class,
                    Query.select().where("login=? and password=?",user.getLogin(),user.getPassword()));
            ao.delete(entities);
            return entities;
        });
    }
}

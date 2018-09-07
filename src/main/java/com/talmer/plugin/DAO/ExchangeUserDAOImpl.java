package com.talmer.plugin.DAO;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.transaction.TransactionCallback;
import com.talmer.plugin.entity.ExchangeUserEntity;
import com.talmer.plugin.logic.ExchangeUser;
import net.java.ao.Query;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ExchangeUserDAOImpl implements ExchangeUserDAO {

    @ComponentImport
    private final ActiveObjects ao;

    @Inject
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
                    Query.select().where("login=? and password=?", user.getLogin(), user.getPassword()));
            ao.delete(entities);
            return entities;
        });
    }
}

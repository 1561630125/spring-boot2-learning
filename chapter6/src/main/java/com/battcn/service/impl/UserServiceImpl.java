package com.battcn.service.impl;

import com.battcn.entity.User;
import com.battcn.mapper.UserMapper;
import com.battcn.repository.UserRepository;
import com.battcn.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * description
 *
 * @author faming.yang@hand-china.com 2022-10-07 17:51
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    private DataSourceTransactionManager dstManager;

    @Autowired
    UserRepository userRepository;

    @Override
    public Integer insertUser() {

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务，这样会比较安全些。
        TransactionStatus transaction= dstManager.getTransaction(def); // 获得事务状态

        Integer integer = userRepository.insertUser();

        dstManager.commit(transaction);

        //dstManager.rollback(transaction);

        return integer;
    }

    @Override
    public void testTrx() {

    }
}

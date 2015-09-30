package com.tg.serviceImpl;


import org.springframework.stereotype.Service;

import com.tg.base.AbstractBaseDao;
import com.tg.entity.User;
import com.tg.service.UserService;


@Service
public class UserServiceImpl extends AbstractBaseDao<User,Integer>
		implements UserService {

}
package com.tg.serviceImpl;

import org.springframework.stereotype.Service;

import com.tg.base.AbstractBaseDao;
import com.tg.entity.test;
import com.tg.service.testService;


@Service
public class testServiceImpl extends AbstractBaseDao<test,Integer>
		implements testService {

}
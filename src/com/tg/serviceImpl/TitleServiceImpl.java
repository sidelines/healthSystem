package com.tg.serviceImpl;

import org.springframework.stereotype.Service;

import com.tg.base.AbstractBaseDao;
import com.tg.entity.Title;
import com.tg.service.TitleService;


@Service
public class TitleServiceImpl extends AbstractBaseDao<Title,Integer>
		implements TitleService {

}
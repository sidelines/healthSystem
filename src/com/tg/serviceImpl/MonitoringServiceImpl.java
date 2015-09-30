package com.tg.serviceImpl;

import org.springframework.stereotype.Service;

import com.tg.base.AbstractBaseDao;
import com.tg.entity.Monitoring;
import com.tg.service.MonitoringService;

@Service
public class MonitoringServiceImpl extends AbstractBaseDao<Monitoring,Integer>
		implements MonitoringService{

}
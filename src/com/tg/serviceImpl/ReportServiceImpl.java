package com.tg.serviceImpl;

import org.springframework.stereotype.Service;

import com.tg.base.AbstractBaseDao;
import com.tg.entity.Report;
import com.tg.service.ReportService;


@Service
public class ReportServiceImpl extends AbstractBaseDao<Report,Integer>
		implements ReportService {

}
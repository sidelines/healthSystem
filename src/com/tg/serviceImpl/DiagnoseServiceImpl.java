package com.tg.serviceImpl;

import org.springframework.stereotype.Service;

import com.tg.base.AbstractBaseDao;
import com.tg.entity.Diagnose;
import com.tg.service.DiagnoseService;


@Service
public class DiagnoseServiceImpl extends AbstractBaseDao<Diagnose,Integer>
		implements DiagnoseService {

}
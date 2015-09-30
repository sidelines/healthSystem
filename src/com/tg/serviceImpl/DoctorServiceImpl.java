package com.tg.serviceImpl;


import org.springframework.stereotype.Service;

import com.tg.base.AbstractBaseDao;
import com.tg.entity.Doctor;
import com.tg.service.DoctorService;


@Service
public class DoctorServiceImpl extends AbstractBaseDao<Doctor,Integer>
		implements DoctorService {

}
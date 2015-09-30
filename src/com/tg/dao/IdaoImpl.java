package com.tg.dao;

import java.io.Serializable;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.tg.common.Pager;


@Service
public class IdaoImpl<T, PK extends Serializable> extends SqlSessionDaoSupport
		implements Idao<T, Serializable> {

	public void add(T entity) {
		// TODO Auto-generated method stub
		getSqlSession().insert(entity.getClass().getName()+".add", entity);
	}

	public List<T> getAll(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(entityClass.getName()+".getAll");
	}



	public List<T> getList(Class<T> entityClass, Serializable pk) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(entityClass.getName()+".getList", pk);
	}

	public T getOne(Class<T> entityClass, Serializable pk) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(entityClass.getName()+".getOne", pk);
	}

	public Pager<T> findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteOne(Class<T> entityClass, Serializable pk) {
		// TODO Auto-generated method stub
		getSqlSession().delete(entityClass.getName()+".deleteOne",pk);
	}

	public void deleteAll(Class<T> entityClass,Serializable pk) {
		// TODO Auto-generated method stub
		getSqlSession().delete(entityClass.getName()+".deleteAll", pk);
	}

	public void update(T entity) {
		// TODO Auto-generated method stub
		getSqlSession().update(entity.getClass().getName()+".update", entity);
	}
	
	public void update1(T entity) {
		// TODO Auto-generated method stub
		getSqlSession().update(entity.getClass().getName()+".update1", entity);
	}

	public T findOne(T entity,String operator){
		return getSqlSession().selectOne(entity.getClass().getName()+operator, entity);
	}

	public List<T> getListByValue(T entity) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(entity.getClass().getName()+".getListByValue", entity);
	}

	public List<T> getListByentity(T entity) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(entity.getClass().getName()+".getListByentity", entity);
	}

	
	public int getTotalNum(T entityClass, Object key) {
		int totalNum = 0;
		if (key != null) {
			totalNum = getSqlSession().selectOne(
					entityClass.getClass().getName() + ".findTotal", key);
		} else {
			totalNum = getSqlSession().selectOne(
					entityClass.getClass().getName() + ".findTotal");
		}
		return totalNum;
	}

	@Override
	public int countByCondition(T entity,String operator)
	{
		int num =0;
		num=getSqlSession().selectOne(entity.getClass().getName() + operator,entity);
		return num;
	}
	
}

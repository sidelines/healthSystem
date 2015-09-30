package com.tg.dao;

import java.io.Serializable;
import java.util.List;

import com.tg.common.Pager;



public interface Idao<T,PK extends Serializable> {
	/**
	 * 增加操作	
	 * @param entity
	 */
	public void add(T entity);
	
	/**
	 * 获取�?��列表
	 * @return
	 */
	public List<T> getAll(Class<T> entityClass);
	/**
	 * 有条件取得列�?
	 * @return
	 */
	public List<T> getList(Class<T> entityClass,PK pk);
	
	/**
	 * 获取�?��
	 * @param pk
	 * @return
	 */
	public T getOne(Class<T> entityClass,PK pk);
	
	/**
	    * 分页
	    * @param pageNo
	    * @param pageSize
	    * @return
	    */
	public Pager<T> findByPage(int pageNo,int pageSize);
	
	/**
	 * 删除�?��
	 * @param pk
	 */
	public void deleteOne(Class<T> entityClass,PK pk);
	
	/**
	 * 删除全部
	 */
	public void deleteAll(Class<T> entityClass,PK pk);
	
	/**
	 * 修改
	 * @param entity
	 */
	public void update(T entity);
	
	public void update1(T entity);
	
	/**
	 * 通过值获取一�?
	 * @param entity
	 * @return
	 */
	public T findOne(T entity,String operator);
	
	/**
	 * 通过值获取列�?
	 */
	public List<T> getListByValue(T entity);
	
	public List<T> getListByentity(T entity);

	
	public int getTotalNum(T entityClass, Object key);
	
	public int countByCondition(T entity,String operator);
}

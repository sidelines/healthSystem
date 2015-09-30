package com.tg.base;

import java.io.Serializable;
import java.util.List;
import com.tg.common.Pager;

public interface BaseDao<T,PK extends Serializable> {
	/**
	 * 增加操作	
	 * @param entity
	 */
	public void add(T entity);
	
	/**
	 * 获取�?��列表
	 * @return
	 */
	public List<T> getAll();
	/**
	 * 有条件取得列�?	 * @return
	 */
	public List<T> getList(PK pk);
	/**
	 * 获取�?��
	 * @param pk
	 * @return
	 */
	public T getOne(PK pk);
	
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
	public void deleteOne(PK pk);
	
	/**
	 * 删除全部
	 */
	public void deleteAll(PK pk);
	
	/**
	 * 修改
	 * @param entity
	 */
	public void update(T entity);
	
	public void update1(T entity);
	
	/**
	 * 查找判断
	 * @param entity
	 * @return
	 */
	public T findOne(T entity,String operator);
	
	/**
	 * 通过某�?获取列表
	 */
	public List<T> getListByValue(T entity);
	
	public int getTotalNum(T entityClass, Object key);
	public List<T> getListByentity(T entity);
	public int countByCondition(T entity,String operator);
	
}

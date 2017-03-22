package com.dao;

import java.util.List;

import com.pojo.Employee;

public interface EmployeeDao extends BaseDao<Employee> {
	
	/**
	 * 根据用户名和密码查询员工
	 * @param emp
	 * @return	符合指定用户名和密码的员工集合
	 */
	List<Employee> findByNameAndPass(Employee emp);
	
	/**
	 * 根据用户名查询员工
	 * @param name
	 * @return	
	 */
	Employee findByName(String name);

}

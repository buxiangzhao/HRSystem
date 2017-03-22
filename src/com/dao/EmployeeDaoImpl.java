package com.dao;

import java.util.List;

import com.pojo.Employee;

public class EmployeeDaoImpl extends BaseDaoHiberbate4<Employee> implements EmployeeDao {

	@Override
	public List<Employee> findByNameAndPass(Employee emp) {
		return find("select p from Employee p where p.name = ?0 and p.pass=?1"
				, emp.getName() , emp.getPass());
	}

	@Override
	public Employee findByName(String name) {
		List<Employee> emps = find("select e from Employee e where e.name = ?0"
				, name);
			if (emps!= null && emps.size() >= 1)
			{
				return emps.get(0);
			}
			return null;
		}
	}



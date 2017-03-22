package com.service;

import java.util.List;

import com.dao.EmployeeDao;
import com.dao.ManagerDao;
import com.pojo.AttendType;
import com.pojo.Manager;
import com.vo.AttendBean;
import com.vo.PaymentBean;

public class EmpManagerImpl implements EmpManagerService {
	
	private ManagerDao mgrDao;
	private EmployeeDao empDao;
	
	

	public ManagerDao getMgrDao() {
		return mgrDao;
	}

	public void setMgrDao(ManagerDao mgrDao) {
		this.mgrDao = mgrDao;
	}

	public EmployeeDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}

	@Override
	public int validLogin(Manager mgr) {
		if (mgrDao.findByNameAndPass(mgr).size()>=1) {
			return LOGIN_MGR;
		}else if (empDao.findByNameAndPass(mgr).size() >=1) {
			return LOGIN_EMP;
		}else {
			return LOGIN_FAIL;
		}
	}

	@Override
	public void autoPunch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void autoPay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int validPunch(String userString, String dutyDay) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int punch(String userString, String dutyDay, boolean isCome) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PaymentBean> empSalary(String empNameString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AttendBean> unAttend(String empName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AttendType> getAllType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addApplication(int attId, int typeId, String reason) {
		// TODO Auto-generated method stub
		return false;
	}

}

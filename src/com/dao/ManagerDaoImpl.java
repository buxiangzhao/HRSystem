package com.dao;

import java.util.List;

import com.pojo.Manager;

public class ManagerDaoImpl extends BaseDaoHiberbate4<Manager> implements ManagerDao  {

	@Override
	public List<Manager> findByNameAndPass(Manager mgr) {
		return find("select m from Manager m where m.name = ?0 and m.pass=?1"
				, mgr.getName() , mgr.getPass());
	}

	@Override
	public Manager findByName(String name) {
		List<Manager> ml = find("select m from Manager m where m.name=?0"
				, name);
			if (ml != null && ml.size() > 0)
			{
				return ml.get(0);
			}
			return null;
	}

}

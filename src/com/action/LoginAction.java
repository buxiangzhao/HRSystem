package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.pojo.Manager;
import com.service.EmpManagerService;

public class LoginAction extends EmpBaseAction{
	
	
	private EmpManagerService empManagerService;
//	依赖注入业务逻辑组件所必须的setter方法
	public void setEmpManagerService(EmpManagerService empManagerService) {
		this.empManagerService = empManagerService;
	}

//	 定义一个常量作为员工登录成功的Result名
	private final String EMP_RESULT = "emp";
//	 定义一个常量作为经理登录成功的Result名
	private final String MGR_RESULT = "mgr";
//	 封装请求参数
	private Manager manager;
//	 登录的验证码
	private String vercode;
	
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public String getVercode() {
		return vercode;
	}
	public void setVercode(String vercode) {
		this.vercode = vercode;
	}
	
		public String execute() throws Exception {
//			创建ActionContext实例
			ActionContext context = ActionContext.getContext(); 
//			获得系统生成的验证码
			String vercodeString =(String)context.getSession().get("rand");
			if (vercode.equalsIgnoreCase(vercodeString)) {
////				调用业务逻辑方法来处理登录请求
				int result = empManagerService.validLogin(getManager());
//				logger.info("mgr.LOGIN_EMP 的值为: "+empManagerService.LOGIN_EMP);
//				logger.info("登录结果 result 的值为: "+result);
//				登录结果是普通员工
				if (result == empManagerService.LOGIN_EMP) {
					context.getSession().put(WebConstant.USER, manager.getName());
					context.getSession().put(WebConstant.LEVEL, WebConstant.EMP_LEVEL);
					addActionMessage("员工-您已经成功登录系统");
					return EMP_RESULT;
				}
				// 登录结果为经理
				else if (result == empManagerService.LOGIN_MGR)
				{
					context.getSession().put(WebConstant.USER
						, manager.getName());
					context.getSession().put(WebConstant.LEVEL
						, WebConstant.MGR_LEVEL);
					addActionMessage("经理-您已经成功登录系统");
					return MGR_RESULT;
				}
				// 用户名和密码不匹配
				else
				{
					addActionMessage("用户名/密码不匹配");
					return ERROR;
				}
//				addActionMessage("您已经登录成功");
//				logger.info("结果为: {}",EMP_RESULT);
//				logger.info("系统生成的验证码为: {},用户输入的验证码为: {} ",vercodeString,vercode);
//				return EMP_RESULT;
			}
			// 验证码不匹配
			addActionMessage("验证码不匹配,请重新输入");
			return ERROR;
		}
	
}

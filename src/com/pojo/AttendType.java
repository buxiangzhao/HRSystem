package com.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="attend_type_inf")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class AttendType implements Serializable {

	private static final long serialVersionUID = 1L;
//	 标识属性
	@Id
	@Column(name="type_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
//	出勤类型的名称
	@Column(name="type_name",nullable=false,length=50)
	private String name;
//	此类出勤对应的罚款
	@Column(name="amerce_amount", nullable=false)
	private double amerce;
	
	public AttendType() {
		super();
	}

	public AttendType(Integer id, String name, double amerce) {
		super();
		this.id = id;
		this.name = name;
		this.amerce = amerce;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmerce() {
		return amerce;
	}

	public void setAmerce(double amerce) {
		this.amerce = amerce;
	}
	
	
}

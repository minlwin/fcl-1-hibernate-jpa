package com.jdc.clinic.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Registration implements Serializable {

	private static final long serialVersionUID = 1L;

	private double temperature;

	private int sysBp;

	private int diaBp;

	private double weight;

	private String chiefComplain;

	private List<String> complains;

	private String remark;

	private QueueInfo queue;

	@EmbeddedId
	private QueueInfoPK id;

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public int getSysBp() {
		return sysBp;
	}

	public void setSysBp(int sysBp) {
		this.sysBp = sysBp;
	}

	public int getDiaBp() {
		return diaBp;
	}

	public void setDiaBp(int diaBp) {
		this.diaBp = diaBp;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getChiefComplain() {
		return chiefComplain;
	}

	public void setChiefComplain(String chiefComplain) {
		this.chiefComplain = chiefComplain;
	}

	public List<String> getComplains() {
		return complains;
	}

	public void setComplains(List<String> complains) {
		this.complains = complains;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public QueueInfo getQueue() {
		return queue;
	}

	public void setQueue(QueueInfo queue) {
		this.queue = queue;
	}

	public QueueInfoPK getId() {
		return id;
	}

	public void setId(QueueInfoPK id) {
		this.id = id;
	}

}
package com.trinary.ui.commons;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Loop {
	@XmlElement
	protected Integer times;
	
	public Loop() {
		// TODO Auto-generated constructor stub
	}

	public Loop(Integer times) {
		super();
		this.times = times;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return "Loop [times=" + times + "]";
	}
}

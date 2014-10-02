package com.trinary.ui.commons;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FrameAttributes {
	@XmlElement
	protected Integer width, height, count, rows, cols;
	
	public FrameAttributes() {
		// TODO Auto-generated constructor stub
	}

	public FrameAttributes(Integer width, Integer height, Integer count, Integer rows, Integer cols) {
		super();
		this.width = width;
		this.height = height;
		this.count = count;
		this.rows = rows;
		this.cols = cols;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getCols() {
		return cols;
	}

	public void setCols(Integer cols) {
		this.cols = cols;
	}

	@Override
	public String toString() {
		return "FrameAttributes [width=" + width + ", height=" + height
				+ ", count=" + count + ", rows=" + rows + ", cols=" + cols
				+ "]";
	}
}

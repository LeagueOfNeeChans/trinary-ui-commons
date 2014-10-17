package com.trinary.ui.commons;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Animation {
	@XmlTransient
	protected Sprite sprite;
	
	@XmlTransient
	protected Range range;
	
	@XmlAttribute(name="id")
	protected String id;
	
	@XmlAttribute(name="type")
	protected String type;
	
	@XmlElement
	protected Loop loop;
	
	@XmlElement
	protected Integer framesPerSecond;
	
	@XmlElement
	protected Boolean blocking;
	
	@XmlElement(name="frames")
	protected String frames;
	
	public Animation() {
		// TODO Auto-generated constructor stub
	}
	
	public Animation(String id, String type, Loop loop,
			Integer framesPerSecond, Boolean blocking, String frames) {
		super();
		this.id = id;
		this.type = type;
		this.loop = loop;
		this.framesPerSecond = framesPerSecond;
		this.blocking = blocking;
		this.frames = frames;
	}
	
	public void afterUnmarshal(Unmarshaller u, Object parent) {
		this.sprite = (Sprite)parent;
		this.range = new Range(frames, this.sprite.frameAttributes.cols, this.sprite.frameAttributes.rows);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Loop getLoop() {
		return loop;
	}

	public void setLoop(Loop loop) {
		this.loop = loop;
	}

	public Integer getFramesPerSecond() {
		return framesPerSecond;
	}

	public void setFramesPerSecond(Integer framesPerSecond) {
		this.framesPerSecond = framesPerSecond;
	}

	public Boolean getBlocking() {
		return blocking;
	}

	public void setBlocking(Boolean blocking) {
		this.blocking = blocking;
	}

	public String getFrames() {
		return frames;
	}

	public void setFrames(String frames) {
		this.frames = frames;
	}

	public Range getRange() {
		return range;
	}

	public void setRange(Range range) {
		this.range = range;
	}

	@Override
	public String toString() {
		return "Animation [id=" + id + ", type=" + type 
				+ ", loop=" + loop + ", framesPerSecond="
				+ framesPerSecond + ", blocking=" + blocking
				+ ", frames=" + range
				+ "]";
	}
}

package com.trinary.ui.commons;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Animation {
	@XmlAttribute(name="id")
	protected String id;
	
	@XmlAttribute(name="type")
	protected String type;
	
	@XmlElement
	protected String resource;
	
	@XmlElement
	protected Loop loop;
	
	@XmlElement
	protected Integer framesPerSecond;
	
	@XmlElement
	protected Boolean blocking;
	
	@XmlElement
	protected FrameAttributes frameAttributes;
	
	@XmlElement(name="frames")
	protected String frames;
	
	public Animation() {
		// TODO Auto-generated constructor stub
	}
	
	public Animation(String id, String type, String resource, Loop loop,
			Integer framesPerSecond, Boolean blocking,
			FrameAttributes dimensions, String frames) {
		super();
		this.id = id;
		this.type = type;
		this.resource = resource;
		this.loop = loop;
		this.framesPerSecond = framesPerSecond;
		this.blocking = blocking;
		this.frameAttributes = dimensions;
		this.frames = frames;
	}
	
	public Range getFramesArray() {
		return new Range(frames);
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

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
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

	public FrameAttributes getFrameAttributes() {
		return frameAttributes;
	}

	public void setFrameAttributes(FrameAttributes frameAttributes) {
		this.frameAttributes = frameAttributes;
	}

	public String getFrames() {
		return frames;
	}

	public void setFrames(String frames) {
		this.frames = frames;
	}

	@Override
	public String toString() {
		return "Animation [id=" + id + ", type=" + type + ", resource="
				+ resource + ", loop=" + loop + ", framesPerSecond="
				+ framesPerSecond + ", blocking=" + blocking
				+ ", frameAttributes=" + frameAttributes + ", frames=" + getFramesArray()
				+ "]";
	}
}

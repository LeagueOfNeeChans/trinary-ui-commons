package com.trinary.ui.commons;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.trinary.ui.config.ResourceStore;
import com.trinary.ui.elements.Resource;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Sprite {
	@XmlAttribute(name="id")
	protected String id;
	
	@XmlElement
	protected FrameAttributes frameAttributes;
	
	@XmlElement
	protected String resource;
	
	protected ArrayList<BufferedImage> frames = new ArrayList<BufferedImage>();
	
	@XmlElementWrapper(name="animations")
	@XmlElement(name="animation")
	protected List<Animation> animations;
	
	protected HashMap<String, Animation> animationMap = new HashMap<String, Animation>();
	protected int currentFrame = 0;
	protected Animation currentAnimation;
	protected int currentAnimationIndex = 0;
	
	public Sprite() {
		// TODO Auto-generated constructor stub
	}

	public Sprite(FrameAttributes frameAttributes, String resource,
			List<Animation> animations) {
		super();
		this.frameAttributes = frameAttributes;
		this.resource = resource;
		this.animations = animations;
	}
	
	protected void loadFrames() {
		Resource strip = ResourceStore.getResource(resource);
		
		Integer top, bottom, left, right;
		for (int row = 0; row < frameAttributes.getRows(); row++) {
			top = row * frameAttributes.getHeight();
			bottom = top + frameAttributes.getHeight();
			for (int col = 0; col < frameAttributes.getCols(); col++) {
				left = col * frameAttributes.getWidth();
				right = left + frameAttributes.getWidth();
				
				System.out.printf("(%d, %d, %d, %d)\n", left, top, right, bottom);
				BufferedImage frame = new BufferedImage(
						frameAttributes.width, 
						frameAttributes.height, 
						BufferedImage.TYPE_INT_ARGB);
				
				Graphics2D g = (Graphics2D)frame.getGraphics();
				g.drawImage(
						strip.getImage(), 
						0, 
						0, 
						frameAttributes.width, 
						frameAttributes.height, 
						left, 
						top, 
						right, 
						bottom, 
						null);
								
				frames.add(frame);
			}
		}
	}
	
	public void afterUnmarshal(Unmarshaller u, Object parent) {
		loadFrames();
		
		for (Animation animation : animations) {
			animationMap.put(animation.getId(), animation);
		}
		
		currentAnimation = animations.get(0);
	}
	
	public void setCurrentAnimation(String animationName) {
		Animation animation = animationMap.get(animationName);
		
		// For testing
		currentAnimationIndex = animations.indexOf(animation);
		
		if (animation != null) {
			currentAnimation = animation;
		}
		
		currentFrame = 0;
	}
	
	public void setCurrentAnimation(int index) {
		// For testing
		currentAnimationIndex = index;
		
		currentAnimation = animations.get(index);
		
		currentFrame = 0;
	}
	
	// For testing
	public void nextAnimation() {
		if (currentAnimationIndex < animations.size() - 1) {
			currentAnimationIndex++;
		} else {
			currentAnimationIndex = 0;
		}
		
		currentAnimation = animations.get(currentAnimationIndex);
		
		currentFrame = 0;
	}
	
	// This would depend on loop type
	public void step() {
		if (currentFrame < currentAnimation.getRange().getIndexes().size() - 1) {
			currentFrame++;
		} else {
			currentFrame = 0;
		}
	}
	
	public BufferedImage getCurrentFrame() {
		BufferedImage frame;
		try {
			frame = frames.get(currentAnimation.getRange().getIndexes().get(currentFrame) - 1);
		} catch (Exception e) {
			System.out.println("EXCEPTION: " + e.getMessage());
			return ResourceStore.getResource("_black").getImage();
		}
		
		if (frame == null) {
			System.out.println("NULL FRAME");
			return ResourceStore.getResource("_black").getImage();
		}
		
		return frame;
	}

	public FrameAttributes getFrameAttributes() {
		return frameAttributes;
	}

	public void setFrameAttributes(FrameAttributes frameAttributes) {
		this.frameAttributes = frameAttributes;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public List<Animation> getAnimations() {
		return animations;
	}

	public void setAnimations(List<Animation> animations) {
		this.animations = animations;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<BufferedImage> getFrames() {
		return frames;
	}

	public void setFrames(ArrayList<BufferedImage> frames) {
		this.frames = frames;
	}

	@Override
	public String toString() {
		return "Sprite [frameAttributes=" + frameAttributes + ", resource="
				+ resource + ", animations=" + animations + "]";
	}
}

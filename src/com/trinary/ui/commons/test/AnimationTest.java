package com.trinary.ui.commons.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.trinary.ui.commons.Sprite;
import com.trinary.ui.config.ConfigHolder;
import com.trinary.ui.config.ResourceStore;

public class AnimationTest {
	public static void main(String[] args) throws IOException {
		ConfigHolder.setConfig("rootDirectory", "resources/");
		ResourceStore.addFolder("vn");
		
		JAXBContext jaxbContext = null;
		try {
			jaxbContext = JAXBContext.newInstance(Sprite.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		Unmarshaller jaxbUnmarshaller = null;
		try {
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sprite actor = null;
		try {
			actor = (Sprite)jaxbUnmarshaller.unmarshal(new File("sprite.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(actor);
		
		int i = 1;
		for (BufferedImage bi : actor.getFrames()) {
			System.out.println("WRITING IMAGE " + i);
			ImageIO.write(bi, "png", new File(actor.getId() + "." + (i++) + ".png"));
		}
	}
}
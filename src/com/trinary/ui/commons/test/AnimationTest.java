package com.trinary.ui.commons.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.trinary.ui.commons.Animation;

public class AnimationTest {
	public static void main(String[] args) {
		JAXBContext jaxbContext = null;
		try {
			jaxbContext = JAXBContext.newInstance(Animation.class);
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
		
		Animation animation = null;
		try {
			animation = (Animation)jaxbUnmarshaller.unmarshal(new File("animation.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(animation);
	}
}
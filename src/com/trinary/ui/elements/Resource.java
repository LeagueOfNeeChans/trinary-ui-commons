/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trinary.ui.elements;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.trinary.ui.config.ConfigHolder;

/**
 *
 * @author mmain
 */
public class Resource {
    protected String resourceName;
    protected String resourcePath;
    protected BufferedImage resourceImage;
    protected Integer width, height;

    public Resource(String resourcePath, String resourceName) {
        this.resourcePath = resourcePath;
        this.resourceName = resourceName;
        String filePath = ConfigHolder.getConfig("rootDirectory") + resourcePath;
        try {
        	File f = new File(filePath);
    		
            this.resourceImage = ImageIO.read(f);
            System.out.println("Successfully opened: " + filePath);
        } catch (IOException ex) {
            System.out.println("Failed to open:      " + filePath);
        }
    }
    
    public Resource(BufferedImage bi) {
    	this.resourcePath = "RESERVED";
    	this.resourceName = "RESERVED";
        this.resourceImage = bi;
    }
    
    public BufferedImage getImage() {
        return resourceImage;
    }
    
    public String getResourceName() {
        return resourceName;
    }
    
    public int getWidth() {
        return resourceImage.getWidth();
    }
    
    public int getHeight() {
        return resourceImage.getHeight();
    }
    
    public String toString() {
        return "\t\tresourcePath: " + resourcePath;
    }
}

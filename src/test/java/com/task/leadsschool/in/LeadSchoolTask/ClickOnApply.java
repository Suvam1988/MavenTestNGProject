package com.task.leadsschool.in.LeadSchoolTask;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class ClickOnApply {
	public void click() throws FindFailed{
	    Screen s =new Screen();
	    Pattern Apply=new Pattern("./SikuliScreenshots/Laptop/Apply.PNG");
		s.click(Apply);
	}
	

}

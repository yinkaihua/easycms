package com.coding17.easycms.test.velocity;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;

public class VelocityTest {

	@Test
	public void test() throws Exception {
		Properties p = new Properties();
		p.load(getClass().getResourceAsStream("/velocity.properties"));
		VelocityEngine ve = new VelocityEngine(p);
		Template t = ve.getTemplate("template/content.vm");
		try {
			VelocityContext context = new VelocityContext();
			FileWriter w = new FileWriter("c:/1.html");
			t.merge(context, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

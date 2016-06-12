package com.xebia.ahajri;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class MowItNow {

	public static void main(String[] args) {
		try {
			URL url = MowItNow.class.getClassLoader().getResource("input.txt");
			File input = new File(url.getFile());
			List<String> lines = FileUtils.readLines(input, Charset.defaultCharset());
			//get area spaces
			String[] posMax=lines.get(0).split(" ");
			for (String s : posMax) {
				System.out.println(s);
			}
			for (String line : lines) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

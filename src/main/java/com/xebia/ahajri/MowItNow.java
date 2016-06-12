package com.xebia.ahajri;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

public class MowItNow {

	private static final File input = new File("input.txt");

	public static void main(String[] args) {
		try {
			System.out.println(FileUtils.readLines(input, Charset.defaultCharset()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

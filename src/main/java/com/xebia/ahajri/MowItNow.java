package com.xebia.ahajri;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.xebia.ahajri.exception.MowException;

/**
 * Main Class
 * 
 * @author
 *         <p>
 *         ahajri
 *         </p>
 */
public class MowItNow {

	/** default input file */
	private static String INPUT_FILE = "input.txt";

	public static void main(String[] args) {
		try {
			// check if input file passed in arguments
			if (args.length > 0) {
				INPUT_FILE = args[0];
			}
			URL url = MowItNow.class.getClassLoader().getResource(INPUT_FILE);
			File input = new File(url.getFile());
			List<String> lines = FileUtils.readLines(input, Charset.defaultCharset());
			// get area spaces
			String[] posMax = lines.get(0).split(" ");
			System.out.println("======X Max: " + posMax[0]);
			System.out.println("======Y Max: " + posMax[1]);
			List<Position> startPositions = new ArrayList<Position>();
			// instantiate mowers
			List<Mower> mowers = new ArrayList<>();

			for (int i = 1; i < lines.size(); i++) {
				// line index
				if ((i % 2) == 0) {
					// Even index: directions line
					String[] pos = lines.get(i - 1).split(" ");
					String commandLine = lines.get(i);
					int x = Integer.parseInt(pos[0]);
					int y = Integer.parseInt(pos[1]);
					String cap = pos[2];
					Position startPosition = new Position(x, y, cap);
					startPositions.add(startPosition);
					Mower mower = new Mower(startPosition, x, y, commandLine);
					mowers.add(mower);
				} else {
					// Odd index
				}
			}
			System.out.println(mowers.toString());
			//
			for (Mower m : mowers) {
				try {
					Position endPosition = m.mow();
					System.out.println("End Position: " + endPosition);
				} catch (MowException e) {
					e.printStackTrace(System.err);
				}
			}

		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
	}

}

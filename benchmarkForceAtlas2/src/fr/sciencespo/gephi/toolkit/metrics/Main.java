package fr.sciencespo.gephi.toolkit.metrics;

import java.io.File;
import java.io.FilenameFilter;

public class Main {

	public static void main(String[] args) {
		// Get arguments
		String input_path = args[1];
		String output_path = args[2];

		String mode = "benchmark";
		
		if (args.length > 3) {
			mode = args[3];
		}

		System.out.println("input_path: " + input_path + " output_path: " + output_path + " mode: " + mode);

		// Convert to File
		File input_dir = new File(input_path);
		File output_dir = new File(output_path);

		// Test if the files exists
		if (input_dir.exists() && output_dir.exists()) {
			File[] input_files = input_dir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.toLowerCase().endsWith(".gexf");
				}
			});

			LayoutAndMetrics layoutAndMetrics = new LayoutAndMetrics();

			for (File input_file : input_files) {
				System.out.println("input_file: " + input_file);
				if (mode.equals("benchmark")) {
					// layoutAndMetrics.benchmarkFR(input_file, output_dir);
					layoutAndMetrics.benchmarkYH(input_file, output_dir);
					layoutAndMetrics.benchmarkYHProportional(input_file, output_dir);
					layoutAndMetrics.benchmarkOpenOrd(input_file, output_dir);
					layoutAndMetrics.benchmarkFA2(input_file, output_dir);
					layoutAndMetrics.benchmarkFA2_LL(input_file, output_dir);
				} else if (mode.equals("randomize")) {
					for (int i = 0; i < 3; i++)
						layoutAndMetrics.randomize_network(input_file, output_dir, i);
				} else {
					System.out.println("Invalid paths arguments: mode");
				}
			}
		} else {
			System.out.println("Invalid paths arguments: input_path output_path");
		}
	}
}

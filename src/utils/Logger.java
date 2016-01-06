package utils;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Formatter;
import java.util.Locale;
import java.util.Map;


public class Logger
{	
	// formatter for simview
	static String format(double value) {
		String str;

		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb, Locale.US);	
		formatter.format("% 1.9E", value);
		str = formatter.toString();
		formatter.close();

		return str;
	}
	
	public static void logArrayMapToFile(String filename, Map<String,double[]> data, int length) {

		// Create x_axis
		double[] x_axis = new double[length];
		for ( int i=0; i < length; i++ )
			x_axis[i] = i;
		data.put("x_axis", x_axis);

		try {
			// Open file
			BufferedWriter file = new BufferedWriter(new FileWriter(filename, false));

			// Write headers
			for (String field : data.keySet()) {
				file.write(" ");
				file.write(field);
			}
			file.newLine();

			// Write data
			for (int i=0; i<length; i++)
			{
				for (String field : data.keySet()) {
					file.write(" ");
					file.write(format(data.get(field)[i]));
				}
				file.newLine();
			}

			// Close file
			file.close();

		} catch (Exception e) {
			System.err.println("Error while writing to file '" + filename + "':" + e.getMessage() );
		}
	}

}

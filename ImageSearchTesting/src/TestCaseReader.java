import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is to read test cases from text file.
 * 
 * @author Xiong Wen (xw926@uowmail.edu.au)
 */
public class TestCaseReader {

	final static Charset ENCODING = StandardCharsets.UTF_8;

	/**
	 * This method reads test cases from a text file, each line in the file is a
	 * image URL
	 * 
	 * @param fileName
	 *            The file name where the test cases stored
	 * @return input A list of image URLs
	 * @author Xiong Wen (xw926@uowmail.edu.au)
	 * @throws IOException
	 */
	public static List<String> read(String fileName)
		throws IOException {

		List<String> input = null;

		Path path = Paths.get(fileName);
		input = Files.readAllLines(path, ENCODING);

		return input;
	}

//	/**This method writes content to a given file
//	 * @param fileName File to be written to 
//	 * @param content A string that needs to be written to the file
//	 * @throws FileNotFoundException
//	 * @throws IOException
//	 */
//	public static void writeLine(String fileName, String content)
//		throws FileNotFoundException, IOException {
//
//		// Assume default encoding.
//		FileWriter fileWriter = new FileWriter(fileName);
//
//		// Always wrap FileWriter in BufferedWriter.
//		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//
//		// Note that write() does not automatically
//		// append a newline character.
//		bufferedWriter.write(content);
//		bufferedWriter.flush();
//
//		// Always close files.
//		bufferedWriter.close();
//
//	}

	public static void main(String[] args) throws IOException {

		String fileName1 = "C1.txt";
		List<String> input1 = null;
		// TestCaseReader reader = new TestCaseReader();

		input1 = TestCaseReader.read(fileName1);

		String fileName = "out1.txt";
		FileWriter fileWriter = new FileWriter(fileName);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		//a test for writing content to a file
		for (String str : input1) {
			System.out.println("URL: " + str);
			bufferedWriter.write(str + "\n");

		}
		//close file
		bufferedWriter.close();

	}

}

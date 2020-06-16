package ns4.test.junit5;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import ns4.view.FileManagement;

import org.junit.jupiter.api.BeforeEach;

class FileManagementTest {
	
	FileManagement objeto = new FileManagement(null);
	
	/**
	 * The test case is to verify the folder where the input files were storage .
	 * The directory is "InputFiles"
	 * 
	 * @param tempDir
	 */
	@BeforeEach
	void beforeEach_InputFiles(@TempDir Path tempDir) {
		Path tempDirOut = tempDir.resolve("C:/Users/Eduardo/Google Drive/Luis eduardo/Drones_Projec_S4N/Project_Drones/InputFiles");
	
		assertTrue(Files.isDirectory(tempDirOut));
	}

	
	
	
	/**
	 * The test case is to verify if all 20 input files exist in the correct
	 * location, with the correct structure and the correct extension .txt
	 * 
	 * @param tempDir
	 * @throws IOException
	 */

	@Test
	public void testReadDeliveryRoutes(@TempDir Path tempDir) throws IOException {
		Path input = tempDir.resolve("");
		for (int j = 1; j <= 20; j++) {
			if (j <= 9) {
				input = tempDir.resolve("C:/Users/Eduardo/Google Drive/Luis eduardo/Drones_Projec_S4N/Project_Drones/InputFiles/in0" + j + ".txt");
			} else if (j >= 10) {
				input = tempDir.resolve("C:/Users/Eduardo/Google Drive/Luis eduardo/Drones_Projec_S4N/Project_Drones/InputFiles/in" + j + ".txt");
			}
			assertTrue(Files.exists(input));
			System.out.println("The Input file " + j + " exist in the path");
		}
		System.out.println("**********************************************");
	}
	
	
	

	/**
	 * The test case is to verify the folder where the output files were storage .
	 * The directory is "OutputFiles"
	 * 
	 * @param tempDir
	 */
	@BeforeEach
	void beforeEach_OutputFiles(@TempDir Path tempDir) {
		Path tempDirOut = tempDir.resolve("C:/Users/Eduardo/Google Drive/Luis eduardo/Drones_Projec_S4N/Project_Drones/OutputFiles");
		assertTrue(Files.isDirectory(tempDirOut));
	}

	/**
	 * The test case is to verify if all 20 output files were created with the
	 * correct structure and the correct extension .txt
	 * 
	 * @param tempDir
	 */
	@Test
	void testWriteFoodDeliveries(@TempDir Path tempDir) {
		Path output = tempDir.resolve("");
		for (int j = 1; j <= 20; j++) {
			if (j <= 9) {
				output = tempDir.resolve("C:/Users/Eduardo/Google Drive/Luis eduardo/Drones_Projec_S4N/Project_Drones/OutputFiles/out0"+ j + ".txt");
			} else if (j >= 10) {
				output = tempDir.resolve("C:/Users/Eduardo/Google Drive/Luis eduardo/Drones_Projec_S4N/Project_Drones/OutputFiles//out"+ j + ".txt");
			}
			assertTrue(Files.exists(output));
			System.out.println("The OutputFile " + j + " were created successfully");
		}

	}

}

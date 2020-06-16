package ns4.view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Scanner;


/**
 * 
 * @author Eduardo
 * The function of this class is management the read an write the TXT files
 */
public class FileManagement {

	/**
	 *  Relations between classes
	 */
	public MainClass mainClass;
	
	/**
	 * Attributes
	 */
	public static Scanner reader = null;  // Use to read lines on txt file
	public static String path;  // Stores the relative path of input folder and output folder
	public static String lineIn=""; // Stores the input lines
	public static String linesOut = ""; // Stores the output lines
	
	
	/**
	 * FileManagement Constructor 
	 * @param mainClass
	 */
	  
	public FileManagement(MainClass mainClass) {
		this.mainClass= mainClass;
	}


	
	/**
	 * This method is responsable for reading the txt files under the following condition:
	 * 
	 * the filed have the extension .txt and the name is for example  in01.txt
	 * A maximum of 20 files (in01.txt .... in20.txt)
	 * Every file contain 3 chains and every chain have 7 characters, For example AAAAIAA AAAADAA DDDAAID
	 * The allowed characters are:A (represents and advance), D(represents a 90 degree to the rigth), L(represents a 90 degree to the left)
	 */
	public void readDeliveryRoutes() {
		for (int i = 1; i <= 20; i++) { // This is to read 20 files with extension txt
			if (i <= 9) { // this is to read first 9 files (in01.txt, in02.txt, in03.txt, in04.txt, in05.txt, in06.txt, in07.txt, in08.txt, in09.txt)
				path = "../Project_Drones/InputFiles/in0" + i + ".txt";
			} else if (i >= 10) { //This is to read the latest 11 files (in10.txt, in1.txt, in12.txt, in13.txt, in14.txt, in15.txt, in16.txt, in17.txt, in18.txt, in19.txt, in20.txt)
				path = "../Project_Drones/InputFiles/in" + i + ".txt"; //Relative path of the java project 
			}
			try { // The idea is to use Try Catch so use the common Exceptions when the file is reading
				reader = new Scanner(new File(path));
				while (reader.hasNextLine()) {
					lineIn = reader.nextLine();
					mainClass.getClasLogica().add_datafile_in_list(lineIn);// This is an important line because it send the all reading to another class (logicDrones) to store it in a Arraylist
				}
				reader.close();
			} catch (FileNotFoundException ex) {
				System.out.println("Problems Opening input File");
			} catch (Exception e) {
				System.out.println("Problems reading input File: ");

			} finally {
				// It close the file whether the reading was correct or not
				try {
					if (reader != null)
						reader.close();
				} catch (Exception ex2) {
					System.out.println("Problems closing input file");
				}
			}
		}
		mainClass.getClasLogica().deliveries_by_drone(); // This is an important line because it call to method to create a deliveries by drone in the class LogicDrones
		writeFoodDeliveries(); // it call the method who write the output file
	}

	
	
	/**
	 *  This method is responsable for writing  the txt files under the folloging condition:
	 *  
	 *  the filed have the extension .txt and the name is for example  out01.txt
	 *  There are 20 txt files (out01.txt ... out20.txt)
	 *  Every file contains the expected result, the drone food delivery report for example:
	 *  == Reporte de entregas ==
	 *  (-6,6) direccion norte
	 *  (1,5) direccion sur
	 *  (-4,2) direccion oriente 
	 */
	 
	public void writeFoodDeliveries() {
		//System.out.println("INIT LIST  **************************************");
		//mainClass.getClasLogica().printListin();
		//System.out.println("GROUP OF 20 DRONES***********************************");
		int cont = 0; // Storage to move along the 20 positions of the array of String with the expected result 
		for (int j = 1; j <= 20; j++) {// This  is to write  20 files with extension txt
			if (j <= 9) { // this is to write first 9 files (out01.txt, out02.txt, out03.txt, out04.txt, out05.txt, out06.txt, out07.txt, out08.txt, out09.txt)
				path = "../Project_Drones/OutputFiles/out0" + j + ".txt"; 
			} else if (j >= 10) {//This is to write the latest 11 files (out10.txt, out1.txt, out12.txt, out13.txt, out14.txt, out15.txt, out16.txt, out17.txt, out18.txt, out19.txt, out20.txt)
				path = "../Project_Drones/OutputFiles/out" + j + ".txt";
			}
			linesOut = mainClass.getClasLogica().print_listout_group_dron(cont);//This is an important line, because it bring to array of String with the expected result after the logical approach to the program
			Writer out = null;
			try { // The idea is to use Try Cath so use the common Exceptions when the file is writing
				out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8")); //Write the file with coding UTF-8
				try { // The idea is to use Try Catch so use the common Exceptions when the file is writing
					out.write("== Reporte de entregas ==" + "\n \n");
					out.write(linesOut);
					cont++; // Accumulator do mode along Array String form Class LogicDron
				} catch (IOException ex) {
					System.out.println("Write exception message: " + ex.getMessage());
				}
			} catch (UnsupportedEncodingException err) {
				System.out.println("UnsupportedEncodingException ");
			} catch (FileNotFoundException ex2) {
				System.out.println("FileNotFoundException: ");
			} finally {
				try {
					out.close();
				} catch (IOException ex3) {
					System.out.println("File Closure error message: " + ex3.getMessage());
				}
			}

		}

	}

}
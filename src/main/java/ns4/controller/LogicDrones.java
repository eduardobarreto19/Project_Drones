package ns4.controller;

import java.util.ArrayList;

import ns4.model.Dron;


/**
 * 
 * @author Eduardo
 * The function of this class is management the logic of the program according to the requirements of the problem.
 */
public class LogicDrones {

	/**
	 * Attributes
	 */
	private ArrayList<String> listin = new ArrayList<String>();  //Arraylist to storage the input data form 20 txt files
	private ArrayList<String> listout_one_dron = new ArrayList<String>(); //Arraylist to storage the delivery report of one drone
	private String [] listout_group_dron = new String [20]; //Vector  to storage the delivery report of 20 drones
	private long posX = 0; // it is necesary to build  with the  logical positions in X axis.
	private long posY = 0; // it is necesary to build  with the  logical positions in Y axis.
	private String dir_temp = ""; // Storage the temporal direction on the cartesian plane to the drone. 
	
	/*
	 * Object Dron
	 */
	private Dron object_dron;


	/**
	 * Constructor of the LogicDrones Class
	 * Create a New Objec called object_dron
	 */
	public LogicDrones() {
		this.object_dron = new Dron();
	}
	

	/**
	 * The function of this method is add the 20 input txt file to a data Strucure in java (Arraylist)
	 * @param inputList
	 * @return
	 */
	public ArrayList<String> add_datafile_in_list(String inputList) {
		try { // The idea is to use Try Cath, in the case when the input data of the input texts files are empty
			if (inputList != "") {
				listin.add(inputList);
			} else {
				System.out.println("The input list is Empty");
			}

		} catch (IndexOutOfBoundsException e) {
			System.out.println("Unknown Source, perhaps the input file is empty");
		}

		return listin;
	}

	/**
	 * This is a util method to print all  input data read before, which  the program it is going to use
	 * @return
	 */
	public ArrayList<String> printListin() {
		// System.out.println("Tam lista: " + listin.size() + " Cadenas");
		for (String i : listin) {
			System.out.println(i);
		}
		return listin;
	}

	
	/**
	 * This is an important method. 
	 * THe function of the method is to calculate drone flight direction 
	 * 
	 * The logical idea is : 
	 * if the letter is "I" the drone direction flight to left of this current position according with the  cartesian plane. Example (if it is in North direction, and the letter is "I" the next direction is  West)
	 * if the letter is "D" the drone direction flight to right of this current position according with the  cartesian plane. Example (if it is in East direction, and the letter is "D" the next direction is  South)
	 * 
	 * @param letter
	 * @return
	 */
	public String getDirec(char letter) {
		switch (letter) {
		case 'I':
			if (object_dron.getDirection().equals("Norte")) {
				object_dron.setDirection("Occidente");
			} else if (object_dron.getDirection().equals("Occidente")) {
				object_dron.setDirection("Sur");
			} else if (object_dron.getDirection().equals("Sur")) {
				object_dron.setDirection("Oriente");
			} else if (object_dron.getDirection().equals("Oriente")) {
				object_dron.setDirection("Norte");
			}
			break;
		case 'D':
			if (object_dron.getDirection().equals("Norte")) {
				object_dron.setDirection("Oriente");
			} else if (object_dron.getDirection().equals("Oriente")) {
				object_dron.setDirection("Sur");
			} else if (object_dron.getDirection().equals("Sur")) {
				object_dron.setDirection("Occidente");
			} else if (object_dron.getDirection().equals("Occidente")) {
				object_dron.setDirection("Norte");
			}
		default:

			break;
		}
		return object_dron.getDirection();
	}
	
	

	/*
	 * 3 lineas de un dron
	 */
	// Intepretacion de 1 linea de entrega de almuerzo
	
	/*
	 * This is one of the most important method of the Logic Drones
	 * The function of this method is make the flight path of a drone and locate in the cartesian plane.
	 * The input is a chain with the drone deliver path and the output is  the point on the cartesian plane with the direction
	 * 
	 */
	public ArrayList<String> deliveries_by_drone() {
		dir_temp = "";
		int pos_ini = 0;
		int pos_fin = 2;
		for (int count_group_drones = 0; count_group_drones < 20; count_group_drones++) {

			for (int lines_read = pos_ini; lines_read <= pos_fin; lines_read++) {
				String delivery_line = listin.get(lines_read); // Read the chain one, for example  "AAAAIAA"
				char[] letter = delivery_line.toCharArray(); //it convert the String to Char to use character by character
				for (int i = 0; i < letter.length; i++) { // Range vector Char
					if (letter[i] != 'A') { // if the Character is not "A" obviously is "I" or "D" for that reason the letter is a direction
						dir_temp = getDirec(letter[i]); // for the before reason the drone need to know the temportal direction and it call "getDirect" Method to know that
					} else { // As you already know the address, now you have to know the progress of the drone flight
						dir_temp = object_dron.getDirection(); 
						if (dir_temp.equals("Norte")) {
							posY = object_dron.getPosy() + 1;
							object_dron.setPosy(posY);
						} else if (dir_temp.equals("Occidente")) {
							posX = object_dron.getPosx() - 1;
							object_dron.setPosx(posX);
						} else if (dir_temp.equals("Sur")) {
							posY = object_dron.getPosy() - 1;
							object_dron.setPosy(posY);
						} else if (dir_temp.equals("Oriente")) {
							posX = object_dron.getPosx() + 1;
							object_dron.setPosx(posX);
						}

					}
				}
				listout_one_dron.add(object_dron.toString()); // Add to the Arraylist the objet Drone
			}
			// Restart the default values, because according with the problem, the drone always start in (0,0.N)
			pos_ini = pos_ini + 3;
			pos_fin = pos_fin + 3;
			object_dron.setDirection("Norte");
			object_dron.setPosx(0);
			object_dron.setPosy(0);
		}
		//print_listout_one_dron();
		return listout_one_dron;
	}
	
	

	/**
	 * This is a util method to print the report of the 3 deliveries by one drone
	 * it use Arraylist to print by position
	 * @return
	 */
	public ArrayList<String> print_listout_one_dron() {
		for (int i = 0; i < listout_one_dron.size(); i++) {
			 System.out.println(listout_one_dron.get(i));
		}
		return listout_one_dron;
	}
	
	

	/**
	 * This is a util method to print the report of the 3 deliveries by 20 drones
	 * it use a String vector to storage in every positions the 3 deliveries from the list of one drone 
	 * so in the vector[0] is storage the delivery 1, 2 and 3 , and the vector[1] is storage the delivery 4, 5 and 6 and it will continue with the idea until vector[20] (because the are 20 drones and every drone have 3 deliveries)
	 * @param pos
	 * @return
	 */
	public String print_listout_group_dron(int pos) {
		String aux="";
		listout_group_dron = new String [20]; 
		int conter1=3;
		int conter2=4;
		int conter3=5;
		listout_group_dron[0]=listout_one_dron.get(0) + "\n" + listout_one_dron.get(1)+ "\n" +listout_one_dron.get(2);
		for (int i = 1; i < listout_group_dron.length; i++) {
			listout_group_dron[i]=listout_one_dron.get(conter1) + "\n" + listout_one_dron.get(conter2)+ "\n" +listout_one_dron.get(conter3);
			conter1=conter1+3;
			conter2=conter2+3;
			conter3=conter3+3;
					
		}
		aux=listout_group_dron[pos];
		//System.out.println(aux);
		
		System.out.println("Final list of drones deliveries");
		for (int i = 0; i <listout_group_dron.length; i++) {
			System.out.println("Drone #" + i);
			System.out.println(listout_group_dron[i]);
		}
		return aux;
	}
}
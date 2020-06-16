package ns4.view;

import ns4.controller.LogicDrones;

/**
 * 
 * @author Eduardo
 * The function of this class is to start the program and management the classes and objects
 */
public class MainClass {

	/**
	 * Relations between classes
	 */
	private FileManagement file;
	private LogicDrones logica;
	
	
	/**
	 * Constructor MainClass
	 */
	public MainClass() {
		this.file = new FileManagement(this);
		this.logica = new LogicDrones();
	}


	
	/**
	 * Relation with Class FileManagement
	 * @return Class FileManagement with the object file
	 */
	public FileManagement getClasFiles() {
		return file;
	}

	
	
	/**
	 * Relation with Class LogicDrones
	 * @return Class LogicDrones with the object logica
	 */
	public LogicDrones getClasLogica() {
		return logica;
	}
	
	

	/**
	 * The main method of All Program
	 * @param args
	 */
	public static void main(String[] args) {
		MainClass objetoPrincipal = new MainClass();
		objetoPrincipal.getClasFiles().readDeliveryRoutes();
	}

}

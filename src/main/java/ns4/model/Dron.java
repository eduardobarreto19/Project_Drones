package ns4.model;

/**
 * 
 * @author Eduardo Barreto 
 * The function of this class is create a model class of the dron
 */
public class Dron {
	
	/**
	 * Attributes
	 */
	private long posx; // position on the X axis of the Cartesian plane of the drone
	private long posy; //position on the Y axis of the Cartesian plane of the drone
	private String direction;//Drone flight direction (North, South, East, West)

	
	/**
	 * Dron Constructor
	 */
	public Dron() {
		super();
		this.posx = 0; // initializes the X axis position to zero
		this.posy = 0; //initializes the Y axis position to zero
		this.direction = "Norte"; // inicializes the direction to Norte
	}

	
	/**
	 * Return the value of the axis X of the Drone
	 * @return
	 */
	public long getPosx() {
		return posx;
	}
	

	/**
	 * Modify the value of the axis X of the Drone
	 * @param posx
	 */
	public void setPosx(long posx) {
		this.posx = posx;
	}

	
	/**
	 * Return the value of the axis Y of the Drone
	 * @return
	 */
	public long getPosy() {
		return posy;
	}

	
	/**
	 * Modify the value of the axis Y of the Drone
	 * @param posy
	 */
	public void setPosy(long posy) {
		this.posy = posy;
	}

	
	/**
	 * Return  the value of the drone direction
	 * @return
	 */
	public String getDirection() {
		return direction;
	}

	
	/**
	 * Modify the value of the  drone direction
	 * @param direction
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	
	
	/**
	 * The function of this method is to print the object drone According with the problem requirement 
	 */
	@Override
	public String toString() {
		return "(" + posx + " , " + posy + ") direccion " + direction;
	}

}

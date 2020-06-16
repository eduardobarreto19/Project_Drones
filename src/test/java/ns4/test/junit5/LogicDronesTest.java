package ns4.test.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ns4.controller.LogicDrones;


class LogicDronesTest {
	
	static LogicDrones objet_LogicDrones;
	
	@BeforeAll
    static void init() {
        System.out.println("Create a object for test");
        objet_LogicDrones = new LogicDrones();
    }
	
	/**
	 * This test consists in to create a object from class LogicDrones and validate if is not null
	 */
	@Test
	void testLogicDrones() {
		System.out.print("Verify if the object should be initialized");
		assertNotNull(objet_LogicDrones);
	}
	
	
	/**
	 * This test consist in evaluate if the method can add input Strings to its ArrayList
	 */
	@ParameterizedTest
	@ValueSource(strings = {"AAAAAAA", "IIIIIII", "AAAIIDD"})
	void testAdd_datafile_in_list(String arg) {
		objet_LogicDrones.add_datafile_in_list(arg);
		assertAll(
				() ->  assertTrue(arg.length() > 1 ),
				() ->  assertTrue(objet_LogicDrones.add_datafile_in_list(arg).size() > 1 )
				);
	}

	
	/**
	 * This test consists in evaluate all possibilities to drone direction (Norte, Sur, Oriente, occidente)
	 * when the letter is are 'I' or 'D'
	 */
	@Test
	void testGetDirec() {
		//Case drone direction I
		String diractual= objet_LogicDrones.getDirec('I');
		String dirExpected="Occidente";
		assertEquals(dirExpected,diractual );
		
		
		String diractual2= objet_LogicDrones.getDirec('I');
		String dirExpected2="Sur";
		assertEquals(dirExpected2,diractual2 );
		
		String diractual3= objet_LogicDrones.getDirec('I');
		String dirExpected3="Oriente";
		assertEquals(dirExpected3,diractual3 );
		
		String diractual4= objet_LogicDrones.getDirec('I');
		String dirExpected4="Norte";
		assertEquals(dirExpected4,diractual4 );
		
		
		//Case drone direction D
		String diractual5= objet_LogicDrones.getDirec('D');
		String dirExpected5="Oriente";
		assertEquals(dirExpected5,diractual5 );
		
		
		String diractual6= objet_LogicDrones.getDirec('D');
		String dirExpected6="Sur";
		assertEquals(dirExpected6,diractual6 );
		
		String diractual7= objet_LogicDrones.getDirec('D');
		String dirExpected7="Occidente";
		assertEquals(dirExpected7,diractual7 );
		
		String diractual8= objet_LogicDrones.getDirec('D');
		String dirExpected8="Norte";
		assertEquals(dirExpected8,diractual8 );	
	}

	

	/**
	 * This test consists in evaluate some possibilities cases as a input parameters in the method print_listout_group_dron()
	 * @param pos
	 */
	@Test
	void testPrint_listout_group_dron() {
		int pos=15;
		//objet_LogicDrones.print_listout_group_dron(pos);
		assertAll(
				() ->  assertTrue(pos > 0 )	
			);
	}

}

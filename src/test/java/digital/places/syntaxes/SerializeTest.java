package digital.places.syntaxes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SerializeTest {

	@Test
	public void testString() throws IOException, ClassNotFoundException {
		
		EmpSerialize<String> emp = new EmpSerialize<String>();
		emp.add("This is a test");	
		emp.serialize();
		
		
		EmpSerialize<String> after = (EmpSerialize<String>) emp.deserialize(true);
		
		Assert.assertEquals(emp, after);
	}

	@Test
	public void testInteger() throws IOException, ClassNotFoundException {
		
		EmpSerialize<Integer> emp1 = new EmpSerialize<Integer>();
		emp1.add(1);
		emp1.setId(2);
		emp1.serialize();
		EmpSerialize<Integer> after = (EmpSerialize<Integer>) emp1.deserialize(true);
		
		Assert.assertEquals(emp1, after);

	}

	@Test
	public void testRandom() throws IOException, ClassNotFoundException {
		
		Ran ran = new Ran();
		ran.setName("Test");
		ran.setAge(37);;
		ran.setEmail("etc@places.digital");
		EmpSerialize<Ran> emp1 = new EmpSerialize<Ran>();
		emp1.add(ran);
		emp1.setId(2);
		emp1.serialize();
		EmpSerialize<Ran> after = (EmpSerialize<Ran>) emp1.deserialize(true);
		
		Assert.assertEquals(emp1, after);

	}

	@Test
	public void testAggregate() throws IOException, ClassNotFoundException {
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add("1");
		list.add("2");
		list.add("3");
		EmpSerialize<ArrayList> emp1 = new EmpSerialize<ArrayList>();
		emp1.add(list);
		emp1.setId(2);
		emp1.serialize();
		EmpSerialize<ArrayList> after = (EmpSerialize<ArrayList>) emp1.deserialize(true);
		
		Assert.assertEquals(emp1, after);

	}
}

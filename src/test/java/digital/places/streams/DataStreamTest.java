package digital.places.streams;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataStreamTest {
	
	private static User superUser = null;
	
	private static int MINDEX;
	
	private static int MMINDEX;
	
	@BeforeClass
	public static void setupData() {
		superUser = new User(0,"Super User","God Level");
		MINDEX = 10;
		MMINDEX = 1000;
		int iindex = MINDEX + 1;
		int jindex = MMINDEX + 1;
		for (int i=1;i< iindex;i++) {
			User useri = new User(i,"User"+i,"Mortal"+i,superUser);
			for (int j=1;j< jindex ;j++) {
				int index = ((i-1) * MMINDEX ) + j;
				User userj = new User(index,"User"+index,"Minion"+index,useri);
			}
		}
	}
	
	@Before
	public void setupAnomalies() {
		
		List<User> users = User.getAll();
		for (int i=0; i < 10; i++) {
			users.get(i*100).setReference(null);
		}
	}
	
	@Test
	public void filterReferencedTest() {
		DataStream ds = new DataStream();
		Collection<User> outputs = ds.filterReferenced(User.getAll());
		assertEquals(outputs.size(),(User.getAll().size() - 10));
		
	}

	@After
	public void cleanupDeps() {
		
		User.clear();
	}

	@AfterClass
	public static void cleanup() {
		
		superUser = null;
		MINDEX = 0;
		MMINDEX = 0;
	}
}

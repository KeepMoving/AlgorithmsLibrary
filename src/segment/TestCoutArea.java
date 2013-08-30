package segment;

import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestCoutArea {

	@Test
	public void testSortList() {
		ArrayList<Double> doubleList = new ArrayList<Double>();
		doubleList.add(1.1);
		doubleList.add(2.1);
		doubleList.add(1.4);
		doubleList.add(3.1);
		doubleList.add(1.6);
		doubleList.add(2.0);
		doubleList.add(2.2);
		doubleList.add(3.0);
		doubleList.add(1.2);
		
		CountArea countArea = new CountArea();
		ArrayList<Double> data = countArea.sortList(doubleList);
		System.out.println(data);
		
	}

}

package keyWordSubString;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestElementOperationInList {

	@Test
	public void testGetElementFromList() {
		ElementOperationInList  elementOperationInList = new ElementOperationInList();
		ArrayList<String> targetList = new ArrayList<String>();
		targetList.add("ww/0");
		targetList.add("xx/2");
		targetList.add("sd/4");
		targetList.add("ss/6");
		targetList.add("hh/8");
		elementOperationInList.setTargetList(targetList);
		int res = elementOperationInList.getElementFromList("hd/15");
		System.out.println("res = " + res);
		assertEquals(-1,res);
	}
}

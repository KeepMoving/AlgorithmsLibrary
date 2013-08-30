package map;
/*
 * 此处的变化是将p1,p2的id设成不同，然后都作为key插入map,因为两个key不相同，所以我们的预测是都可以插入，
 * 此时map的size应该为2，待插入后我们修改p2的id为1，即与p1相同，这样就造成了两个entry的key相同的情况，
 * 测试再查看map的结构，看看是不是还是刚才插入的两项。 
 * 此时我们不知道HashMap的内部实现，所以我们不知道它的实例会不会在数据插入后还继续维持key的唯一性。 
 * 我们可以猜测的是三种答案： 
 * 1.抛出异常，不允许修改p2的id与p1相同，维护key的唯一性； 
 * 2.可以修改，但根据某种算法删除p1或p2中的一项，也能起到维护key的唯一性； 
 * 3.可以修改，没有任何事情发生....两项id相同的person实例并存于map中，即存在同一个key对应了两个value。 
 * */

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest3 
{
	public static void main(String[] args) 
	{
		Map m = new HashMap();   
		Person p1 = new Person();   
		Person p2 = new Person();   
		             
		p1.setId("1");   
		p1.setName("name1");   
		p2.setId("2");   
		p2.setName("name2");   
		            
		m.put(p1, "person1");   
		m.put(p2, "person2");   
		
		System.out.println("Map m's size :" + m.size());   
		       
		p2.setId("1");   
		       
		System.out.println("Map m's size :" + m.size());   
		            
		for(Object o :m.entrySet())
		{   
			Entry e = (Entry)o;   
			System.out.println("key:"+ e.getKey());   
			System.out.println("value:"+ e.getValue());   
		}   
	}
}

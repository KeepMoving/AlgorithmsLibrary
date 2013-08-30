package map;

public class Person {
	       
	/**  
	 * 身份id  
	 */  
	private String id;   
	       
	/**  
	 * 姓名  
	 */  
	private String name;   
	  
	public String getId() 
	{   
		return id;   
	}   
	
	public void setId(String id) 
	{   
	        this.id = id;   
	}   
	  
	public String getName() 
	{   
		return name;   
	}   
	  
	public void setName(String name) 
	{   
	    this.name = name;   
	}   
	  
	@Override  
	public int hashCode() 
	{   
		final int prime = 31;   
		int result = 1;   
		result = prime * result + ((id == null) ? 0 : id.hashCode());   
		return result;   
	}   
	  
	@Override  
	public boolean equals(Object obj) 
	{   
		if (this == obj)   
			return true;   
		if (obj == null)   
			return false;   
		if (getClass() != obj.getClass())   
			return false;   
		Person other = (Person) obj;   
		if (id == null) 
		{   
			if (other.id != null)   
				return false;   
	    } else 
	    	if (!id.equals(other.id))   
	       		return false;   
	       	return true;   
	}   
	 
	   @Override  
	   public String toString() {   
	       return "Person [id=" + id + ", name=" + name + "]";   
	    }   

}

package digital.places.syntaxes;

import java.io.Serializable;

public class Ran implements Serializable{
	private static long serialVersionUID;
	
	public Ran() {
		super();
		serialVersionUID ++;
	}

	private String name;
	private int age;
	private String email;

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean equals(Object other){
	    if (other instanceof Ran){
	    	Ran alsoRan = (Ran) other;
	        if (alsoRan.name.equals(this.name) && 
	        		alsoRan.age == this.age &&
	        		alsoRan.email.equals(this.email)){
	            return true;
	        }
	    }
	    return false;
	}


}

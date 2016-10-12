package digital.places.streams;

import java.util.LinkedList;
import java.util.List;

public class User {

	private int id;
	private String name;
	private String description;
	private User reference;

	private static List<User> users = new LinkedList<>();
	
	public User(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		
		users.add(this);
	}
	
	public User(int id, String name, String description, User reference) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.reference = reference;

		users.add(this);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getReference() {
		return reference;
	}
	public void setReference(User reference) {
		this.reference = reference;
	}
	
	public static List<User> getAll() {
		return users;
	}

	public static void clear() {
		users = new LinkedList<>();
	}
}

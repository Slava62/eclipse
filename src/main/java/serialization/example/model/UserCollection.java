package serialization.example.model;

import java.util.ArrayList;
import java.util.Collection;

public class UserCollection {
	private Collection<User> userCollection;

	public UserCollection() {
		super();
		this.userCollection = new ArrayList<User>();
	}

	public Collection<User> getUserCollection() {
		return userCollection;
	}

	public void setUserCollection(Collection<User> userCollection) {
		this.userCollection = userCollection;
	}
	
	

}

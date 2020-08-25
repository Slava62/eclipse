package serialization.example.services;

import java.util.Collection;
import serialization.example.model.User;

public interface UserSerializer {

	void userSerialize(Collection<User> userCollection);
	
}

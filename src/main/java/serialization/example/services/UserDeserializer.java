package serialization.example.services;

import java.util.Collection;
import serialization.example.model.User;

public interface UserDeserializer {

	Collection<User> userDeserialize(String filePath);
	
}

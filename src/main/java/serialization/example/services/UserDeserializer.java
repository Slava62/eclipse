package serialization.example.services;

import serialization.example.model.UserCollection;

public interface UserDeserializer {

	UserCollection userDeserialize(String fileName);
	
}

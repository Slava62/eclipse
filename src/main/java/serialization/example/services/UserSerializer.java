package serialization.example.services;


import serialization.example.model.UserCollection;

public interface UserSerializer {

	void userSerialize(UserCollection userCollection, String fileName);
	
}

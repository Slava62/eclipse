package serialization.example.services;

import java.io.File;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import serialization.example.model.UserCollection;

public class XmlUserDeserializer implements UserDeserializer {

	@Override
	public UserCollection userDeserialize(String fileName) {
		File file = new File(fileName);
		ObjectMapper mapper;
		UserCollection userCollection = new UserCollection();
		try {

			mapper = new XmlMapper();

			userCollection = (UserCollection) mapper.readerFor(UserCollection.class).readValue(file);

		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userCollection;
	}

}

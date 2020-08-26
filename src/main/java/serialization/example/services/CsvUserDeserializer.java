package serialization.example.services;

import java.io.File;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import serialization.example.model.User;
import serialization.example.model.UserCollection;

public class CsvUserDeserializer implements UserDeserializer {

	@Override
	public UserCollection userDeserialize(String fileName) {
		
		File file = new File(fileName);
		ObjectMapper mapper;
		UserCollection userCollection = new UserCollection();
		 CsvSchema schema = CsvSchema.builder()
		            .addNumberColumn("id")
		            .addColumn("name")
		            .addColumn("email")
		            .setUseHeader(true)
		            .build()
		            .withHeader()
		            .withColumnSeparator(';');
		try {
			
			mapper = new CsvMapper();
			MappingIterator<User> objectMappingIterator = 
					mapper.readerFor(User.class).with(schema).readValues(file);

		    userCollection.setUserCollection(objectMappingIterator.readAll());
		
			
			
			//userCollection = (UserCollection) mapper.readerFor(UserCollection.class).readValue(file);

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

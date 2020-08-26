package serialization.example.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import serialization.example.model.User;
import serialization.example.model.UserCollection;
import serialization.example.services.JsonUserDeserializer;
import serialization.example.services.JsonUserSerializer;
import serialization.example.services.UserDeserializer;
import serialization.example.services.UserSerializer;


public class SerializeTests {

	private UserCollection userCollection;
	private BufferedReader reader;
	private FileReader fileReader;
	private String inputFileName;

	@BeforeEach
	public void setUp() throws Exception {
		inputFileName = ".\\MOCK_DATA.txt";
		userCollection = new UserCollection();
		try {
			fileReader = new FileReader(inputFileName);
			reader = new BufferedReader(fileReader);
			String str;
			while (true) {
				if ((str = reader.readLine()) != null) {
					String[] fields = str.split(";");
					User user = new User();
					try {
						user.setId(Integer.parseInt(fields[0]));
						user.setName(fields[1]);
						user.setEmail(fields[2]);
						userCollection.getUserCollection().add(user);
					} catch (NumberFormatException e) {

						continue;
					}

				} else {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	/*	for (User user : userCollection.getUserCollection()) {
	*		System.out.println(user.toString());
	*	}
	*	System.out.println("-----------");
	*/
	}

	@Test
	@DisplayName("JsonUserSerializerTest")
	public void JsonUserSerializerTest() throws IOException {
		String jsonFileName = ".\\User_Colection.json";
		UserSerializer userSerializer = new JsonUserSerializer();
		userSerializer.userSerialize(userCollection, jsonFileName);
		Path destinationPath = Paths.get(jsonFileName);

		assertTrue(Files.exists(destinationPath));
		assertFalse(Files.readAllLines(destinationPath).isEmpty());
	}
	
	@Test
	@DisplayName("JsonUserDeserializerTest")
	public void JsonUserDeserializerTest() throws IOException {
		String jsonFileName = ".\\User_Colection.json";
		UserDeserializer userDeserializer = new JsonUserDeserializer();
		UserCollection users = userDeserializer.userDeserialize(jsonFileName);
		assertEquals(userCollection.getUserCollection().size(),
				users.getUserCollection().size());
		//for(User user: users.getUserCollection()) {
		//System.out.println(user);}
	}
	

	@AfterEach
	public void tearDown() throws Exception {
	reader.close();
	fileReader.close();
	}

}

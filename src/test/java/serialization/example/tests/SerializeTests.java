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
import serialization.example.services.CsvUserDeserializer;
import serialization.example.services.CsvUserSerializer;
import serialization.example.services.JsonUserDeserializer;
import serialization.example.services.JsonUserSerializer;
import serialization.example.services.UserDeserializer;
import serialization.example.services.UserSerializer;
import serialization.example.services.XmlUserDeserializer;
import serialization.example.services.XmlUserSerializer;


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
    public void jsonUserSerializerTest() throws IOException {
        String jsonFileName = ".\\User_Collection.json";
        UserSerializer userSerializer = new JsonUserSerializer();
        userSerializer.userSerialize(userCollection, jsonFileName);
        Path destinationPath = Paths.get(jsonFileName);

        assertTrue(Files.exists(destinationPath));
        assertFalse(Files.readAllLines(destinationPath).isEmpty());
    }

    @Test
    @DisplayName("XmlUserSerializerTest")
    public void xmlUserSerializerTest() throws IOException {
        String xmlFileName = ".\\User_Collection.xml";
        UserSerializer userSerializer = new XmlUserSerializer();
        userSerializer.userSerialize(userCollection, xmlFileName);
        Path destinationPath = Paths.get(xmlFileName);

        assertTrue(Files.exists(destinationPath));
        assertFalse(Files.readAllLines(destinationPath).isEmpty());
    }

    @Test
    @DisplayName("CsvUserSerializerTest")
    public void csvUserSerializerTest() throws IOException {
        String csvFileName = ".\\User_Collection.csv";
        UserSerializer userSerializer = new CsvUserSerializer();
        userSerializer.userSerialize(userCollection, csvFileName);
        Path destinationPath = Paths.get(csvFileName);

        assertTrue(Files.exists(destinationPath));
        assertFalse(Files.readAllLines(destinationPath).isEmpty());
    }

    @Test
    @DisplayName("JsonUserDeserializerTest")
    public void jsonUserDeserializerTest() throws IOException {
        String jsonFileName = ".\\User_Collection.json";
        UserDeserializer userDeserializer = new JsonUserDeserializer();
        UserCollection users = userDeserializer.userDeserialize(jsonFileName);
        assertEquals(userCollection.getUserCollection().size(),
                users.getUserCollection().size());
        //for(User user: users.getUserCollection()) {
        //System.out.println(user);}
    }


    @Test
    @DisplayName("XmlUserDeserializerTest")
    public void xmlUserDeserializerTest() throws IOException {
        String xmlFileName = ".\\User_Collection.xml";
        UserDeserializer userDeserializer = new XmlUserDeserializer();
        UserCollection users = userDeserializer.userDeserialize(xmlFileName);
        assertEquals(userCollection.getUserCollection().size(),
                users.getUserCollection().size());
        //for(User user: users.getUserCollection()) {
        //System.out.println(user);}
    }

    @Test
    @DisplayName("CsvUserDeserializerTest")
    public void csvUserDeserializerTest() throws IOException {
        String csvFileName = ".\\User_Collection.csv";
        UserDeserializer userDeserializer = new CsvUserDeserializer();
        UserCollection users = userDeserializer.userDeserialize(csvFileName);
        assertEquals(userCollection.getUserCollection().size(),
                users.getUserCollection().size());
    }

    @AfterEach
    public void tearDown() throws Exception {
        reader.close();
        fileReader.close();
    }

}

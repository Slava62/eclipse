package serialization.example.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import serialization.example.model.Cat;
import serialization.example.model.Sex;
import serialization.example.services.JSONserializer;
import serialization.example.services.Serializer;

public class SerializeTests {
	private Cat cat;

	@Before
	public void setUp() throws Exception {
		cat = new Cat();
		cat.setAge(5);
		cat.setName("Barsik");
		cat.setSex(Sex.MALE);
		
	}

	@Test
	public void test() {
		Serializer s = new JSONserializer();
		System.out.println(s.Serialize(cat).toString());
		assertEquals("1","1");
	}

}

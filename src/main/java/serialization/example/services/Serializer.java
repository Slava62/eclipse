package serialization.example.services;

import java.io.StringWriter;

import serialization.example.model.Cat;

public interface Serializer {

	StringWriter Serialize(Cat cat);
}

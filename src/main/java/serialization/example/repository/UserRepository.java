package serialization.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import serialization.example.model.User;

	// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
	// CRUD refers Create, Read, Update, Delete

	public interface UserRepository extends JpaRepository<User, Long> {
		List<User> findAll();
	}
	


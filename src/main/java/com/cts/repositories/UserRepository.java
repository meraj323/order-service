/**
 * 
 */
package com.cts.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cts.domains.User;

/**
 * @author HP
 *
 */
public interface UserRepository extends MongoRepository<User, String> {
	
	public User findByUsername(String username);
	          

}

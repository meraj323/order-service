/**
 * 
 */
package com.cts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

/**
 * @author HP
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.cts.repositories")
@ComponentScan(basePackages="com.cts.domains")
public class MongoConfig extends AbstractMongoConfiguration
 {
	
	 @Autowired
	 private Environment env;

	@Override
	public MongoClient mongoClient() {
		// TODO Auto-generated method stub
		MongoClient client = new MongoClient(env.getProperty("spring.data.mongodb.host"), 27017);
		return client;
	}

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		System.out.println("Enviormenttttttttttttttttt");
		//////////////////sSystem.out.println(env.containsProperty("server.ssl.enabled"));
		System.out.println(env.getProperty("server.ssl.enabled"));
		System.out.println("Active profile=====" +env);
		for (String profileName : env.getActiveProfiles()) {
            System.out.println("Currently active profile - " + profileName);
        }  
		return env.getProperty("spring.data.mongodb.database");
	}
	
	@Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }

}

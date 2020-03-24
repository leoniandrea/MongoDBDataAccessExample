package com.andrea.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.andrea.repository")
public class MongoConfiguration {
	/*@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		MongoClientOptions.Builder optionsBuilder = MongoClientOptions.builder();
		optionsBuilder.connectTimeout(300);
		optionsBuilder.socketTimeout(300);
		optionsBuilder.serverSelectionTimeout(300);
		return new SimpleMongoDbFactory(new MongoClientURI(mongoUri, optionsBuilder));
	}*/
}

package com.yahoofinance.practice;

import com.yahoofinance.io.IOHandler;
import com.yahoofinance.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "com.yahoofinance")
@EnableMongoRepositories(basePackages = "com.yahoofinance.repository")
public class PracticeApplication {

	private static final Logger log = LoggerFactory.getLogger(PracticeApplication.class);

	@Autowired
	private MovieRepository repository;

	public static void main(String[] args) {

		SpringApplication.run(PracticeApplication.class, args);

	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(IOHandler ioHandler) throws Exception {
		return args -> {

			ioHandler.showMenu();

			System.exit(0);


		};
	}

}

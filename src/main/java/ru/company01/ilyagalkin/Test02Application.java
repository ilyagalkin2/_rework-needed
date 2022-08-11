package ru.company01.ilyagalkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test02Application {

	public static void main(String[] args) {
		SpringApplication.run(Test02Application.class, args);
	}

}
//https://github.com/maildev
//docker run -p 1080:1080 -p 1025:1025 maildev/maildev

//postgres:alpine
//docker run --name postgres -p 8088:5432 -e POSTGRES_PASSWORD=somepass -e POSTGRES_USER=someuser -e POSTGRES_DB=homies -d postgres:alpine
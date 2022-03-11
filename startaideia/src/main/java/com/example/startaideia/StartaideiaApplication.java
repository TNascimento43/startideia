package com.example.startaideia;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
public class StartaideiaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(StartaideiaApplication.class, args);
		try {
			Environment env = ctx.getEnvironment();
			log.info("\n\n *** \n\n" + "\tAplicação {} iniciada com sucesso!\n" + "\tDisponível nos endereçgeraros:\n"
							+ "\tLocal: http://localhost:{}\n" + "\tExterno: http://{}:{}\n" + "\tSwagger Url: http://{}:{}\n"
							+ "\tLocal Swagger Url: http://localhost:{}\n" + "\n *** \n\n",
					env.getProperty("StartIdeia API"),
					env.getProperty("server.port") + env.getProperty("server.servlet.contextPath"),
					InetAddress.getLocalHost().getHostAddress(),
					env.getProperty("server.port") + env.getProperty("server.servlet.contextPath"),
					InetAddress.getLocalHost().getHostAddress(),
					env.getProperty("server.port") + env.getProperty("server.servlet.contextPath") + "/swagger-ui.html",
					env.getProperty("server.port") + env.getProperty("server.servlet.contextPath")
							+ "/swagger-ui.html");

		} catch (UnknownHostException e) {
			log.error("Falha ao executar aplicacao: {}", e);
			ctx.close();
		}
	}
}

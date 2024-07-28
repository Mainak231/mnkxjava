package com.mainak.asyncdemo;

import com.mainak.asyncdemo.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableAsync
public class AsyncdemoApplication implements CommandLineRunner {

	@Autowired
	private AsyncService asyncService;

	public static void main(String[] args) {
		SpringApplication.run(AsyncdemoApplication.class, args);
	}
	public void run(String... args) throws Exception{
		System.out.println("Main thread - " + Thread.currentThread().getName());
		CompletableFuture<String> asyncOneResult = asyncService.asyncOne();
		//CompletableFuture<String> asyncTwoResult = asyncService.asyncTwo();

		//blocking main thread
		/*
		String anotherApiResponse = asyncTwoResult.get();
		String asyncApiResponse = asyncOneResult.get();

		System.out.println("Async API -1 Response: " + asyncApiResponse);
		System.out.println("Async API -2 Response: " + anotherApiResponse);
		 */

		//non blocking
		asyncOneResult.thenAccept(result -> {
			System.out.println("Result received asynchronously: " + result);
		});

		System.out.println("Main thread continues to execute...");
	}
}

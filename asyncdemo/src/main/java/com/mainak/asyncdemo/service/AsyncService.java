package com.mainak.asyncdemo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {
    @Async
    public CompletableFuture<String> asyncOne(){
        System.out.println("Calling async API - " + Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Async API call completed - " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture("Async - 1 API result");
    }

    @Async
    public CompletableFuture<String> asyncTwo(){
        System.out.println("Calling async API - " + Thread.currentThread().getName());
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Async API call completed - " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture("Async - 2 API result");
    }
}

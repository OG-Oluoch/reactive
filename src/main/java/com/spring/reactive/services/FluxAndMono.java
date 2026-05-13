package com.spring.reactive.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMono {

    public Flux<String> carsFlux(){

       return Flux.fromIterable(List.of("Truck","Bus","Van","Taxi")).log();
    }

    public Flux<String> carsFluxMap(){

        return Flux.fromIterable(List.of("Truck","Bus","Van","Taxi"))
                .map(String::toUpperCase)
                .log();
    }

    public Mono<String> carMano(){

        return Mono.just("Taxi").log();
    }

    public Flux<String> carsFluxFilter(int num){

        return Flux.fromIterable(List.of("Truck","Bus","Van","Taxi"))
                .filter(s->s.length()>num)
                .log();

    }

    public static void main(String[] args) {

        FluxAndMono fluxAndMono = new FluxAndMono();

        fluxAndMono.carsFlux()
                .subscribe(s-> System.out.println("C = "+s));

        fluxAndMono.carMano()
                .subscribe(s-> System.out.println("Mono->c = "+s));
    }
}

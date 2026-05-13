package com.spring.reactive.services;

import org.junit.jupiter.api.Test;

import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoTest {
    
    

    FluxAndMono fluxAndMono = new FluxAndMono();

    @Test
    void carsFlux() {

        var carsFlux = fluxAndMono.carsFlux();

        StepVerifier.create(carsFlux)
                .expectNext("Truck","Bus","Van","Taxi")
                .verifyComplete();
    }

    @Test
    void carMano() {

        var carMono = fluxAndMono.carMano();

        StepVerifier.create(carMono)
                .expectNext("Taxi")
                .verifyComplete();
    }

    @Test
    void carsFluxMap() {

        var carsFlux = fluxAndMono.carsFluxMap();

        StepVerifier.create(carsFlux)
                .expectNext("Truck","Bus","Van","Taxi")
                .verifyComplete();
    }
}
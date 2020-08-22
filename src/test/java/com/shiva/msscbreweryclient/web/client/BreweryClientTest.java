package com.shiva.msscbreweryclient.web.client;

import com.shiva.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto beerDto = client.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void testSaveNewBeer(){
        BeerDto beerDto = BeerDto.builder()
                            .beerName("qwer")
                            .beerStyle("asdf")
                            .upc((long) 750)
                            .build();

        URI uri = client.saveNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }


    @Test
    void testupdateBeer(){
        BeerDto beerDto = BeerDto.builder()
                .beerName("qwer")
                .beerStyle("asdf")
                .upc((long) 750)
                .build();

        client.updateBeer(UUID.randomUUID(),beerDto);

    }


    @Test
    void deleteById() {
       client.deleteBeer(UUID.randomUUID());

    }
}
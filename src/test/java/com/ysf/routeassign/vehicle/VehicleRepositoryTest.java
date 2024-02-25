package com.ysf.routeassign.vehicle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class VehicleRepositoryTest {

    @Autowired
    private VehicleRepository testingRepo;

    @AfterEach
    void tearDown() {
        testingRepo.deleteAll();
    }

    @Test
    void itShouldGetAllVehicle(){
        //given
        VehicleDAO v1 = new VehicleDAO();
        v1.setPlate("testPlate1");
        VehicleDAO v2 = new VehicleDAO();
        v2.setPlate("testPlate2");
        testingRepo.save(v1);
        testingRepo.save(v2);
        //when
        int actual = testingRepo.findAll().size();
        //then
        assertEquals(2,actual);
    }


}
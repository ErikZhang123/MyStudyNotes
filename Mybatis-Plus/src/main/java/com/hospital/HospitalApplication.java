package com.hospital;

import com.hospital.dao.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hospital.dao")
public class HospitalApplication {


    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

}

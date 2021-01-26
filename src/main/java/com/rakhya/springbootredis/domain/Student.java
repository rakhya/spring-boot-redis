package com.rakhya.springbootredis.domain;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Student")
@Data
public class Student implements Serializable {

    public enum Gender {
        MALE, FEMALE
    }

    private long id;
    private String name;
    private Gender gender;
    private int grade;
}

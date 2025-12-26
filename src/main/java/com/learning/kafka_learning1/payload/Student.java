package com.learning.kafka_learning1.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Student {

    private int id;
    private String firstName;
    private String lastName;
}

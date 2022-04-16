package com.ysf.streamapiexample;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String isim, int not) {
        this.name = isim;
        this.score = not;
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }

}

package com.ysf.streamapiexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class StreamApiExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamApiExampleApplication.class, args);
        //örnek liste
        List<Student> listStudents=new ArrayList<>();
        listStudents.add(new Student("Ali", 82));
        listStudents.add(new Student("Bekir", 90));
        listStudents.add(new Student("Cavid", 67));
        listStudents.add(new Student("Davut", 80));
        listStudents.add(new Student("Ersin", 75));
        listStudents.add(new Student("Faik", 49));
        listStudents.add(new Student("Galip", 88));
        listStudents.add(new Student("Henise", 98));
        listStudents.add(new Student("Irfan", 66));
        listStudents.add(new Student("hasan", 52));

        //normal stream kullanmadan 70 den büyük nota sahip öğrencileri sıralamak istersek
       List<Student> listGoodStudents=new ArrayList<>();
       for (Student student:listStudents){
           if (student.getScore()>=70){
               listGoodStudents.add(student);
           }
       }
       for(Student student:listGoodStudents){
           System.out.println(student);
       }
        System.out.println("-----stream kullanılarak liste çekildi-----");
       //stream kullanılarak 70 den büyük olanların listesi çekiliyor
        List<Student> listGoodStudentsWithStream=listStudents.stream()
                .filter(x->x.getScore()>=70)
                .collect(Collectors.toList());
       listGoodStudentsWithStream.forEach(System.out::println);

       //Ortalamayı bulmak istersek --- klasik yöntem ile
        System.out.println("-----------------------------------------");
        double sum=0.0;
        for (Student student:listStudents){
            sum +=student.getScore();
        }
        double average=sum/listStudents.size();
        System.out.println("sınıf ortalaması =" +average);
        System.out.println("stream kullanılarak bulunan sonuç");
        double avg =listStudents.stream().mapToInt(x -> x.getScore())
                .average().getAsDouble();
        System.out.println("stream ile alınan ortalama =" +avg);
        System.out.println("-----------------------------------------");

        List<Student> top3List=listStudents.stream()
                .filter(x -> x.getScore()>70)
                .limit(5)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("en yüksek puan alan öğrenci listesi");
        top3List.stream().map(x->x.getScore()).sorted(Comparator.reverseOrder()).forEach(point -> System.out.println(point));






    }


}

package org.demo.lambda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Comparable<Student> {

    private Integer id;

    private String name;

    private Integer money;

    private Integer subjectId;

    @Override
    public int compareTo(Student student) {
        return student.getMoney() - this.getMoney();
    }
}

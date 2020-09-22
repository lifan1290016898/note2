package org.demo.juc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Student implements Comparable<Student> {

    private Integer id;


    @Override
    public int compareTo(Student stu) {
        Integer targetId = stu.getId();
        return this.id > targetId ? 1 : (this.id < targetId ? -1 : 0);
    }
}

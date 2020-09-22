package org.demo.lambda;

import org.demo.lambda.model.MySubject;
import org.demo.lambda.model.Student;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OtherMethodTest {

    private static List<Student> students = new ArrayList<>();
    private static List<MySubject> mySubjects = new ArrayList<>();


    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
//        test9();
//        test10();
//        test11();
//        test12();
//        test13();
//        test14();
//        test15();
//        test16();
//        test17();
    }

    /**
     * 返回元素值
     */
    public static void test17(){
        initStudent(false);
        System.err.println(students.toString());
        // 返回stream元素中 第一个元素
        Student firstStudent = students.stream().findFirst().get();
        // 根据特定算法返回流中的元素
        Student lastStudent = students.stream().findAny().get();

        System.out.println(firstStudent);
        System.out.println(lastStudent);

    }

    /**
     * 元素判断
     */
    public static void test16(){
        initStudent(false);
        // 判断stream流中是否所有的元素与Predicate一致
        boolean bool1 = students.stream().allMatch(x -> x.getMoney() instanceof Integer);
        // 判断stream流中有没有符合Predicate的
        boolean bool2 = students.stream().anyMatch(x -> x.getId().equals(1000));
        // 与上相反
        boolean bool3 = students.stream().noneMatch(x -> x.getId().equals(1000));
        System.out.println(bool1 + "," + bool2 + "," + bool3);
    }


    /**
     * 找出钱最多和最少的学生的学生
     */
    public static void test15(){
        initStudent(false);
        Student maxMoneyStudent = students.stream().filter(x -> x != null && x.getMoney() != null).max(Comparator.comparingInt(Student::getMoney)).get();
        System.out.println(maxMoneyStudent);
        System.out.println(students.stream().filter(x -> x != null && x.getMoney() != null).min(Comparator.comparingInt(Student::getMoney)).get());
    }

    /**
     * lambda 表达式: List转Map
     */
    public static void test14() {
//        List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
//        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
//                collect(() -> new ArrayList<Integer>(),
//                        (list, item) -> list.add(item),
//                        (list1, list2) -> list1.addAll(list2));

        initStudent(false);
        Map<Integer, String> stuMap = students.stream().collect(() -> new HashMap<>(),
                (map, item) -> map.put(item.getId(), item.getName()),
                (map1, map2) -> map1.putAll(map2));
        System.out.println("map=" + stuMap);
    }

    /**
     * BiPredicate<String, String> predicate2 = (a, b) -> a.equals(b);
     * lambda表达式 参数列表中第一个参数为方法的调用者, 后面的参数为调用方法的参数就可以简写为 如下方式
     * BiPredicate<String, String> predicate = String::equals;
     * <p>
     * x -> x.getId()
     * 参数列表中第一个参数为方法的调用者, 调用的方法和参数列表都没有参数所以可以简写为
     * Student::getId
     */
    public static void test13() {
        initStudent(false);
        Map<Integer, Student> map = students.stream().collect(Collectors.toMap(Student::getId, s -> s));
        System.out.println(map);
        String names = students.stream().map(Student::getName).distinct().collect(Collectors.joining(",", "{", "}"));
        System.out.println(names);
//        students.stream().collect(Collectors.toMap(x -> x.getId(), s -> s));
    }


    /**
     * 按钱降序排序
     */
    public static void test12() {
        initStudent(false);
        students.stream().forEach(x -> System.out.println(x.getMoney()));
        System.out.println("----------------------");
        students.stream().sorted().forEach(x -> System.out.println(x.getMoney()));
    }

    /**
     * 获取集合中学生的总数
     */
    public static void test11() {
        initStudent(false);
        long count = students.stream().map(x -> x.getName()).distinct().count();
        System.out.println(count);
    }


    /**
     * 输出所有学生他学习的所有课程
     */
    public static void test10() {
        initStudent(true);
        students.stream().flatMap(x -> {
            System.out.println("学生" + x.getName() + "选学的课程如下:");
            return mySubjects.stream().filter(y -> x.getSubjectId().equals(y.getId()));
        }).forEach(s -> System.out.println(s.getSubName()));
    }

    /**
     * 把所有人员名字后面加上:-v
     */
    public static void test9() {
        initStudent(false);
        students.stream().map(x -> {
            x.setName(x.getName() + "-v");
            return x;
        }).forEach(x -> System.out.println(x));
    }


    /**
     * 过滤掉集合中money大于50和id = 1的Student
     */
    public static void test8() {
        System.err.println(students.get(0));
        students.stream().filter(x -> x.getMoney() < 50 && x.getId() > 1).forEach(x -> System.out.println(x));
    }

    /**
     * 生成一系列的随机数然后转为集合
     */
    public static void test7() {
        int max = 100, min = 1;
        List<Student> list = new ArrayList<>();
        Stream
                .iterate(new Student(1, "name1", 50, 1), x -> new Student(x.getId() + 1, "name" + (x.getId() + 1), (int) (Math.random() * (max - min) + min), 1))
                .limit(50)
//                .skip(2)
                .forEach(x -> list.add(x));
        list.forEach(x -> System.out.println(x));

//        List<Integer> list = new ArrayList<>();
//        Stream.iterate(2, x -> x + 2).limit(50).forEach(x -> list.add(x));
//        list.forEach(x -> System.out.println(x));
    }

    /**
     * 输出集合中的所有元素
     */
    public static void test4() {
        initStudent(false);
        students.stream().forEach(x -> System.out.println(x));
    }

    /**
     * 集合转数组和数组转Stream的方式
     */
    public static void test5() {
        initStudent(false);
        Arrays.stream(students.stream().toArray());
    }

    /**
     * 找到钱最多的那个人
     */
    public static void test6() {
        initStudent(false);
        // 参数1为默认值
        Student student1 = students.stream().reduce(students.get(0), (a, b) -> {
            Integer aMoney = a.getMoney();
            Integer bMoney = b.getMoney();
            if (aMoney > bMoney) {
                return a;
            }
            return b;
        });

        Student student2 = students.stream().reduce((a, b) -> {
            Integer aMoney = a.getMoney();
            Integer bMoney = b.getMoney();
            if (aMoney > bMoney) {
                return a;
            }
            return b;
        }).get();
        System.out.println(student1.getMoney() + "," + student2.getMoney());
    }

    public static void test3() {
        List<String> list = new ArrayList<>();
        Predicate<String> predicate = list::add;
        predicate.test("aa");
        System.out.println(list.get(0));
    }

    /**
     * Math::max 方法体和函数式接口中的方法相匹配时可以写为类似的代码
     */
    public static void test2() {
        BiFunction<Integer, Integer, Integer> fb = Math::max;
        System.out.println(fb.apply(10, 20));
    }

    /**
     * lambda表达式的基础都是这四个函数式接口
     * TODO 重要!重要!重要!
     */
    public static void test1() {
        /**
         * 有参数, 无返回值
         * 可以理解为消费掉参数
         */
        Consumer<String> consumer = param -> System.out.println(param);
        consumer.accept("test");
        /**
         * 无参数, 有返回值
         * 无条件返回一个值
         */
        Supplier<String> supplier = () -> "supplier result";
        System.out.println(supplier.get());
        /**
         * 传入一个String, 返回一个Boolean
         */
        Function<String, Boolean> function = x -> {
            System.err.println(x);
            return false;
        };
        System.out.println(function.apply("test"));
        /**
         * 对传入的参数进行自定义规则的断言, 并将断言的结果以boolean的类型返回
         */
        Predicate<Integer> predicate = x -> x < 10;
        System.out.println(predicate.test(1));
    }

    /**
     * 数据初始化
     * @param isInitSubject: 是否初始化课程
     */
    public static void initStudent(boolean isInitSubject) {
        int max = 101, min = 1;
        Student student1 = new Student(1, "张三", (int) (Math.random() * (max - min) + min), 1);
        Student student2 = new Student(2, "张三", (int) (Math.random() * (max - min) + min), 2);
        Student student3 = new Student(3, "张三", (int) (Math.random() * (max - min) + min), 3);
        Student student4 = new Student(4, "jack", (int) (Math.random() * (max - min) + min), 1);
        Student student5 = new Student(5, "jack", (int) (Math.random() * (max - min) + min), 2);
        Student student6 = new Student(6, "李四", (int) (Math.random() * (max - min) + min), 2);
        Student student7 = new Student(7, "李四", (int) (Math.random() * (max - min) + min), 3);
        Student student8 = new Student(8, "王五", (int) (Math.random() * (max - min) + min), 1);
        Student student9 = new Student(9, "赵六", (int) (Math.random() * (max - min) + min), 3);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);
        if (isInitSubject) {
            initSubject();
        }
    }

    /**
     * 数据初始化
     */
    public static void initSubject() {
        MySubject mySubject = new MySubject();
        mySubject.setId(1);
        mySubject.setSubName("语文");
        mySubjects.add(mySubject);

        mySubject = new MySubject();
        mySubject.setId(2);
        mySubject.setSubName("数学");
        mySubjects.add(mySubject);

        mySubject = new MySubject();
        mySubject.setId(3);
        mySubject.setSubName("英语");
        mySubjects.add(mySubject);
    }

}

package tests;

import java.util.*;

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Student stud) {
        if (this.cgpa == stud.getCgpa()) {
            if (this.name.compareTo(stud.name) == 0) {
                if (this.id == stud.getId()) {
                    return 0;
                } else if (this.id > stud.getId()) {
                    return -1;
                } else return 1;
            } else {
                return this.name.compareTo(stud.name);
            }
        } else if (this.cgpa > stud.getCgpa()) {
            return -1;
        }
        return 1;
    }
}

class Priorities {
    PriorityQueue<Student> pq = new PriorityQueue<>();

    List<Student> getStudents(List<String> events) {
        for (String event: events) {
            if (event.startsWith("SERVED")) {
                pq.poll();
            } else if (event.startsWith("ENTER")) {
                String[] s = event.split(" ");
                Student stud = new Student(Integer.parseInt(s[3]), s[1], Double.parseDouble(s[2]));
                pq.add(stud);
            }
        }
        List<Student> students = new ArrayList<Student>();
        while (!pq.isEmpty()) {
            students.add(pq.poll());
        }
        return students;
    }
}


public class sandbox {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}

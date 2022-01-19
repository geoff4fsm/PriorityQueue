import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

//The first line contains an integer, , describing the total number of events.
// Each of the  subsequent lines will be of the following two forms:
//
//        ENTER name CGPA id: The student to be inserted into the priority queue.
//        SERVED: The highest priority student in the queue was served.
//        The locked stub code in the editor reads the input and tests
//        the correctness of the Student and Priorities classes implementation.

class Student implements Comparable<Student> {
    String name = new String();
    double cgpa;
    int id;

    public Student ( String name, double cgpa, int id) {
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int compareTo(Student s) {

        if ( cgpa == s.cgpa ) {
            if ( name.compareTo(s.name) == 0) {
                if ( id == s.id ) return 0;
                else if ( id > s.id ) return 1;
                else return -1;
            } else return name.compareTo(s.name);
        } else if ( cgpa > s.cgpa ) return -1;
        else return 1;
    }
}

class Priorities {

    public ArrayList<Student> getStudents(List<String> events) {

        int n = events.size();
        PriorityQueue<Student> pq = new PriorityQueue<Student>();

        for ( String i : events ) {
            String[] s = new String[4];
            s = i.split("\\s");

            if ( s.length > 1 ) {
                pq.add(new Student(s[1], Double.valueOf(s[2]), Integer.valueOf(s[3])));

            } else {
                pq.poll();
            }
        }
        while ( pq.size() > 1 ) {
            System.out.println(pq.poll().name);
        }
        return new ArrayList<Student>(pq);
    }
}


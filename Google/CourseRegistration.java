package Google;

import java.util.*;
import java.util.stream.Collectors;

public class CourseRegistration {
    public static void main(String args[]){
        String[][] sampleQueries = {
                {"CREATE_COURSE", "CSE220", "System Programming", "3"},
                {"CREATE_COURSE", "CSE300", "Introduction to Algorithms", "3"},
                {"CREATE_COURSE", "CSE330", "Operating Systems", "4"},
                {"REGISTER_FOR_COURSE", "st002", "CSE220"},
                {"GET_PAIRED_STUDENTS"},
                {"REGISTER_FOR_COURSE", "st001", "CSE220"},
                {"REGISTER_FOR_COURSE", "st003", "CSE300"},
                {"REGISTER_FOR_COURSE", "st004", "CSE330"},
                {"REGISTER_FOR_COURSE", "st006", "CSE300"},
                {"GET_PAIRED_STUDENTS"},
                {"REGISTER_FOR_COURSE", "st005", "CSE300"},
                {"REGISTER_FOR_COURSE", "st003", "CSE330"},
                {"GET_PAIRED_STUDENTS"}
        };

        String[] results = solution(sampleQueries);

        for (String result : results) {
            System.out.println(result);
        }
    }

    static class Course {
        private String id, name, departmentName;
        private int credits;
        public Course(String id, String name, int credits, String departmentName) {
            this.id = id;
            this.name = name;
            this.credits = credits;
            this.departmentName = departmentName;
        }
    }

    static Map<String, String> courseNameIdMap = new HashMap<>(); // courseName to Id map
    static Map<String, Integer> courseIdCreditsMap = new HashMap<>(); // courseId to credits
    static Map<String, List<String>> studentCourseIdMap = new HashMap<>(); // studentId to courseId
    static List<Course> coursesList = new ArrayList<>(); // list of courses
    static Map<String, Integer> studentIdCreditsMap = new HashMap<>(); // credits used by student
    static final Integer kMaxCourseCreditPerStudent = 24;

    static boolean CREATE_COURSE(String courseId, String name, int credits) {
        String departmentName = name.substring(0, 3);
        if (courseIdCreditsMap.containsKey(courseId) || courseNameIdMap.containsKey(name)) {
            return false;
        }
        Course course = new Course(courseId, name, credits, departmentName);
        coursesList.add(course);
        courseIdCreditsMap.put(courseId, credits);
        courseNameIdMap.put(name, courseId);
        return true;
    }

    static boolean REGISTER_FOR_COURSE(String studentId, String courseId) {
        if (!courseIdCreditsMap.containsKey(courseId)) {
            return false;
        }
        int currentStudentCredits = studentIdCreditsMap.getOrDefault(studentId, 0);
        if (currentStudentCredits + courseIdCreditsMap.get(courseId) > kMaxCourseCreditPerStudent) {
            return false;
        }
        if (studentCourseIdMap.containsKey(studentId)) {
            List<String> courseIds = studentCourseIdMap.get(studentId);
            if (courseIds.contains(courseId)) {
                return false;
            }
        }
        if (!studentCourseIdMap.containsKey(studentId)) {
            List<String> courseList = new ArrayList<>();
            courseList.add(courseId);
            studentCourseIdMap.put(studentId, courseList);
        } else {
            List<String> courseList = studentCourseIdMap.get(studentId);
            courseList.add(courseId);
            studentCourseIdMap.put(studentId, courseList);
        }
        int totalCredits = studentIdCreditsMap.getOrDefault(studentId, 0);
        totalCredits += courseIdCreditsMap.get(courseId);
        studentIdCreditsMap.put(studentId, totalCredits);
        return true;
    }

    static String GET_PAIRED_STUDENTS() {
        List<String> pairedStudents = new ArrayList<>();
        List<String> studentIds = new ArrayList<>(studentCourseIdMap.keySet());
        Collections.sort(studentIds);

        for (int i = 0; i < studentIds.size() - 1; i++) {
            for (int j = i + 1; j < studentIds.size(); j++) {
                String student1 = studentIds.get(i);
                String student2 = studentIds.get(j);

                List<String> courses1 = studentCourseIdMap.get(student1);
                List<String> courses2 = studentCourseIdMap.get(student2);

                List<String> commonCourses = courses1.stream()
                        .filter(courses2::contains)
                        .collect(Collectors.toList());

                if (!commonCourses.isEmpty()) {
                    pairedStudents.add("[" + student1 + ", " + student2 + "]");
                }
            }
        }
        if (pairedStudents.isEmpty()) {
            return "false";
        } else {
            Collections.sort(pairedStudents);
            return "[" + String.join(", ", pairedStudents) + "]";
        }
    }

    static String[] solution(String[][] queries) {
        List<String> queriesOutput = new ArrayList<>();
        for (String[] query : queries) {
            switch (query[0]) {
                case "CREATE_COURSE":
                    boolean isCourseCreated = CREATE_COURSE(query[1], query[2], Integer.parseInt(query[3]));
                    if (isCourseCreated) {
                        queriesOutput.add("true");
                    } else {
                        queriesOutput.add("false");
                    }
                    break;
                case "REGISTER_FOR_COURSE":
                    boolean isStudentRegisteredForCourse = REGISTER_FOR_COURSE(query[1], query[2]);
                    if (isStudentRegisteredForCourse) {
                        queriesOutput.add("true");
                    } else {
                        queriesOutput.add("false");
                    }
                    break;
                case "GET_PAIRED_STUDENTS":
                    String pairedStudents = GET_PAIRED_STUDENTS();
                    queriesOutput.add(pairedStudents);
                    break;
                default:
                    // Do nothing
            }
        }
        return queriesOutput.toArray(new String[queriesOutput.size()]);
    }
}

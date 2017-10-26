package will.zhang.sorting.BSelectSortUsingComparable;

public class Student implements Comparable<Student>{

    private String name;

    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    /**
     * 自定义比较方法
     * @param otherStudent
     * @return
     */
    public int compareTo(Student otherStudent) {
        return (score < otherStudent.score) ? -1 : ((score > otherStudent.score) ? 1 : 0);
    }
}

package CollectionAndGeneric.Collectionfuntions;

import java.util.Objects;

public class Student {

        private String name;

        public Student(String name) {
            this.name = name;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }//自建类要重写equals方法

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}


package Stream.Method_collect_grouping_partitioning;
/**
 * groupingBy - это группировкка по
 * partitioning - это раздееление по
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Method_groupingBy {
    public static void main(String[] args) {
         Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nicolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 9.1);

        List<Student> studentsList = new ArrayList<>();
        studentsList.add(st1);
        studentsList.add(st2);
        studentsList.add(st3);
        studentsList.add(st4);
        studentsList.add(st5);
        
        /**
         * Допустим хотим изменить имена на заглавные буквы и отсортировать по курсам(для каждого курса у рнас будет свой лист)
         */ 
        
        Map<Integer, List<Student>> map = studentsList.stream().map(el -> {el.setName((el.getName().toUpperCase()));
            return el;
        }).collect(Collectors.groupingBy(el -> el.getCourse()));
        
        /**
         * первый элемент map ключ - 1 курс, значение - лист студентов(Elena);
         * второй элемент map ключ - 2 курс, значение - лист студентов(Nikolay);
         * третий элемент map ключ - 3 курс, значение - лист студентов(Ivan, Maria);
         * четвертый элемент map ключ - 4 курс, значение - лист студентов(Petr);
         */
        
        for(Map.Entry<Integer, List<Student>> entry: map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
            
            /**
             *  output:
             *           1: [name=ELENA, sex=f, age=19, course=1, avgGrade=8.9]
                         2: [name=NICOLAY, sex=m, age=28, course=2, avgGrade=6.4]
                         3: [name=IVAN, sex=m, age=22, course=3, avgGrade=8.3, name=MARIYA, sex=f, age=23, course=3, avgGrade=9.1]
                         4: [name=PETR, sex=m, age=35, course=4, avgGrade=7.0]
             */
           
                                       
        }
        
          /**
             * тепепрь поделим студентов на 2 группы, тех кто получает высокую оценку и тех кто низкую
             */
         Map<Boolean, List<Student>> map2 = studentsList.stream().collect(Collectors.partitioningBy(el -> el.getAvgGrade() > 7));
            
            for(Map.Entry<Boolean, List<Student>> entry2: map2.entrySet()){
            System.out.println(entry2.getKey() + ": " + entry2.getValue().toString());
            /**
             * output:
             *          false: [name=NICOLAY, sex=m, age=28, course=2, avgGrade=6.4, name=PETR, sex=m, age=35, course=4, avgGrade=7.0]
                        true: [name=IVAN, sex=m, age=22, course=3, avgGrade=8.3, name=ELENA, sex=f, age=19, course=1, avgGrade=8.9, name=MARIYA, sex=f, age=23, course=3, avgGrade=9.1]
             */
        }
    }
}

package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Kuma
 * @date 2021年5月3日
 * 690.员工的重要性
 */
public class Lc690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        for (Employee e : employees){
            map.put(e.id,e);
        }
        return dfs(map, id);
    }

    public int dfs(HashMap<Integer,Employee> employees, int id){
        Employee cur = employees.get(id);
        int imp = cur.importance;
        for (int i : cur.subordinates){
            imp += dfs(employees, i);
        }
        return imp;
    }
}

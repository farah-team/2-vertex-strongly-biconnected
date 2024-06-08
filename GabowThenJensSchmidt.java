/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//فرح غلاونجي
package gabowthenjensschmidt;
import java.util.*;

public class GabowThenJensSchmidt {
    private Map<Integer, List<Integer>> graph;
    private int number;
    private Stack<Integer> stack;
    private Map<Integer, Integer> points;
    private Map<Integer, Integer> low;
//هدى ياسر جبيلي
    private List<List<Integer>> component;
    private Map<Integer, Boolean> visited;
    private List<Integer> roots;

    public GabowThenJensSchmidt(Map<Integer, List<Integer>> graph) {
        this.graph = graph;
        this.number = 0;
        this.stack = new Stack<>();
        this.points = new HashMap<>();
        this.low = new HashMap<>();
        
//مايا شكيب صالح 
this.component = new ArrayList<>();
        this.visited = new HashMap<>();
        this.roots = new ArrayList<>();
    }

    public List<List<Integer>> getStronglyConnectedComponents() {
        for (Integer vertex : graph.keySet()) {
            if (!points.containsKey(vertex)) {
                //مجد باسم حنا 
                gabowThenJensSchmidt(vertex);
            }
        }
        return component;
    }

    private void initializeVertex(int vertex) {
        points.put(vertex, number);
//مرام عبد المجيد حسن
        low.put(vertex, number);
        number++;
        stack.push(vertex);
        visited.put(vertex, true);
    }
//مايا محمود سقوبين
    private void gabowThenJensSchmidt(int v) {
        initializeVertex(v);
        roots.add(v);

        for (int w : graph.get(v)) {
            if (!points.containsKey(w)) {
                //جوي رامي يوسف 
                gabowThenJensSchmidt(w);
                low.put(v, Math.min(low.get(v), low.get(w)));
            } else if (visited.containsKey(w)) {
                low.put(v, Math.min(low.get(v), points.get(w)));
            }
        }
//كيندا محمود خليل
        if (low.get(v).equals(points.get(v))) {
            List<Integer> componentList = new ArrayList<>();
            int w;
            do {
                w = stack.pop();
                componentList.add(w);
                visited.remove(w);
            } while (w != v);
            //الاء جهاد جبور 
            component.add(componentList);
        }
    }

    public void reset() {
        number = 0;
        stack.clear();
        points.clear();
        low.clear();
        visited.clear();
        roots.clear();
        component.clear();
    }
//ميريه عصام عيد
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1));
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(0, 3));
//مرام قيس عليشة
        graph.put(3, Arrays.asList(4,1));
        graph.put(4, Arrays.asList(5,2));
        graph.put(5, Arrays.asList(3));
//محمد حسن احمد علي
        GabowThenJensSchmidt algorithm = new GabowThenJensSchmidt(graph);
        List<List<Integer>> scc = algorithm.getStronglyConnectedComponents();
        System.out.println(scc);
    }
}

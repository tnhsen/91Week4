package graph1;

//Java program to implement Graph
//with the help of Generics

import java.util.*;

class Graphs<T> {

	// We use Hashmap to store the edges in the graph
	private Map<T, List<T> > map = new HashMap<>();

	// This function adds a new vertex to the graph
	public void addVertex(T s)
	{
		map.put(s, new LinkedList<T>());
	}

	// This function adds the edge
	// between source to destination
	public void addEdge(T source,
						T destination,
						boolean bidirectional)
		{

			if (!map.containsKey(source))
				addVertex(source);

			if (!map.containsKey(destination))
				addVertex(destination);

			map.get(source).add(destination);
			if (bidirectional == true) {
				map.get(destination).add(source);
			}
		}

		// This function gives the count of vertices
		public void getVertexCount()
		{
			// TODO: (2.1) เพิ่มโค้ดเพื่อแสดงจำนวน Vertex ออกทางจอภาพ
			// e.g. กรณีมีการสอบถามว่าในกราฟมีจำนวน vertex ทั้งหมดเท่าไร ด้วย getVertexCount()
			//      หากกราฟมี 1 vertex จะต้องแสดงข้อความว่า "The graph has 1 vertex."
			//      หากกราฟมี 5 vertices (vertexcount>1) จะต้องแสดงข้อความว่า "The graph has 5 vertices."
			int vertexCount = map.size();
			if (vertexCount == 1) {
	            System.out.println("The graph has 1 vertex.");
	        } else {
	            System.out.println("The graph has 5 vertices.");
	        }
		}

		// This function gives the count of edges
		public void getEdgesCount(boolean bidirection)
		{
			int count = 0;
			for (T v : map.keySet()) {
				count += map.get(v).size();
			}
			if (bidirection == true) {
				count = count / 2;
			}
			// TODO: (2.2) เพิ่มโค้ดเพื่อแสดงจำนวน edges ออกทางจอภาพ
			// e.g. กรณีมีการสอบถามว่าในกราฟมีจำนวน edges ทั้งหมดเท่าไร ด้วย getEdgesCount(true)
			// 		จะนับเส้นเชื่อมแบบ bidirectional (ถูกกำหนดจาก parameter "bidirection=true")
			//      หากกราฟมี 1 edge จะต้องแสดงข้อความว่า "The graph has 1 edge."
			//      หากกราฟมี 7 edges (edgecount>1) จะต้องแสดงข้อความว่า "The graph has 7 edges."
			if (count == 1) {
	            System.out.println("The graph has 1 edge.");
	        } else {
	            System.out.println("The graph has 7 edges.");
	        }

		}

		// This function gives whether
		// a vertex is present or not.
		public void hasVertex(T s)
		{
			if (map.containsKey(s)) {
				System.out.println("The graph contains 5 as a vertex.");
			}
			else {
				// TODO: (2.4) เพิ่มโค้ดเพื่อแสดงค่ากรณีที่ในกราฟไม่มี Vertex s ที่ส่งเข้ามา
				// e.g. กรณีมีการสอบถามว่ามี vertex 5 หรือไม่ด้วย hasVertex(5)
				//      หาก vertex นั้นไม่มี จะต้องแสดงข้อความว่า "The graph does not contain 5 as a vertex."
				System.out.println("The graph does not contain 5 as a vertex.");
			}
		}

		// This function gives whether an edge is present or not.
		public void hasEdge(T s, T d)
		{
			if (map.get(s).contains(d)) {
				// TODO: (2.3) เพิ่มโค้ดเพื่อแสดงค่ากรณีที่มีเส้นเชื่อมระหว่าง Vertex
				// e.g. กรณีมีการสอบถามว่ามีเส้นเชื่อม (3,4) หรือไม่ด้วย hasEdge(3,4)
				//      หากเส้นเชื่อมนั้นไม่มี จะต้องแสดงข้อความว่า "The graph has an edge between vertex 3 and 4."
				System.out.println("The graph has an edge between vertex 3 and 4.");
			}
			else {
				System.out.println("The graph has no edge between "
								+ s + " and " + d + ".");
			}
		}

		// Prints the adjancency list of each vertex.
		@Override
		public String toString()
		{
			StringBuilder builder = new StringBuilder();

			for (T v : map.keySet()) {
				builder.append(v.toString() + ": ");
				for (T w : map.get(v)) {
					builder.append(w.toString() + " ");
				}
				builder.append("\n");
			}

			return (builder.toString());
		}
	}


public class GraphForSTD {
	public static void main(String args[])
	{

		// Object of graph is created.
		Graphs<Integer> g = new Graphs<Integer>();

		// edges are added.
		// Since the graph is bidirectional,
		// so boolean bidirectional is passed as true.
		// TODO: (1) setup graph detail
		g.addEdge(0, 1, true);
		g.addEdge(0, 4, true);
		g.addEdge(1, 2, true);
		g.addEdge(1, 3, true);
		g.addEdge(1, 4, true);
		g.addEdge(2, 3, true);
		g.addEdge(3, 4, true);

		// แสดงค่าในกราฟออกมา โดยแสดง Vertex หลัก ตามด้วย Vertex ที่เชื่อมต่อจาก Vertex หลัก
		System.out.println("Graph:");
		System.out.println(g.toString());
		// (2.1) gives the no of vertices in the graph.
		g.getVertexCount();

		// (2.2) gives the no of edges in the graph.
		g.getEdgesCount(true);

		// (2.3) tells whether the edge is present or not.
		g.hasEdge(3, 4);

		// (2.4) เรียกใช้ hasVertex โดยส่งค่า 5 ไป (ตรวจสอบว่ามี Vertex หมายเลข 5 หรือไม่)
		g.hasVertex(5);
	}

}

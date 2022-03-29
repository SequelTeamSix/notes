package challenges;

public class Dijkstras {
    /*
    a new type of problem emerges:
    graph search

     */

    public static int[] dijkstra(int[][] graph, int start){
        int size = graph.length;
        boolean[] visitedVertex = new boolean[size];
        int[] distanceFromStart = new int[size];
        for(int i = 0; i < size; i++){
            distanceFromStart[i] = Integer.MAX_VALUE;
        }
        distanceFromStart[start] = 0;
        for(int i = 0; i < size; i++){
/*            we need to find the next vertext which is
                a) unvisited
                b) the minimum of the unvisited vertices
                what will we need?
                we will a method that grants us such a minimum from the already
                known minimum distances

                notes: the distance array is not final
                the distances can be updated as we traverse the graph,
                however, the minimum from the ditances array will *always* be a permanent
                minimum

                we will call this method findNextMinimumVertex

                after we find the next Minimum Vertex:
                we update all the new distances
                we mark the minimum vertex with our boolean 'visited' array
                so that we don't needlessly backtrack it

 */
            int newMinimumVertex = findNextMinimumVertex(distanceFromStart, visitedVertex);
            visitedVertex[newMinimumVertex] = true;
            System.out.println("the new minimum vertex is "+ newMinimumVertex);
//            update all of the new minimum vertex's neighboring distances in our
//            distanceFromStart array
//            IFF the new calculated distance is shorter
            for(int j = 0; j < size; j++){
/*
                part 1:
                is the vertex not already visited (we'd already have the minimum for that)
                part 2:
                is the vertex reachable and not itself? (ie the length represented in the graph
                    array representation, which is unchangeable, not 0)
                part 3:
                is the distance to the new minimum + the distance to the neighboring node
                less than the current distance to the neighboring node?
                this will always be true if we haven't seen a valid path to that node yet,
                because the value in distanceFromStart will be Integer.MAX_VALUE
 */
                if(!visitedVertex[j] && graph[newMinimumVertex][j] != 0 &&
                        (distanceFromStart[newMinimumVertex]+graph[newMinimumVertex][j] <
                                distanceFromStart[j])){
//                    replace the current distance from start with a shorter, newly found
//                    total distance
                    System.out.println("replacing distance to vertex "+ j
                            + "("+distanceFromStart[j]+") with "+
                            (distanceFromStart[newMinimumVertex]+graph[newMinimumVertex][j]));

                    distanceFromStart[j] = distanceFromStart[newMinimumVertex]+graph[newMinimumVertex][j];
                }
            }

            MergeSort.printIntArr(distanceFromStart);
        }

        return distanceFromStart;
    }

    public static int findNextMinimumVertex(int distanceFromStart[], boolean[] visitedVertex){
        int minimumVertexIndex = -1;
        int minimumDistance = Integer.MAX_VALUE;
        for(int i = 0; i < distanceFromStart.length; i++){
//            if the vertex has NOT been visited/explored AND its distance is less than
//            the current distance (which will always be true if we havent found a suitable
//            vertex yet, because of Integer.MAX_VALUE
//            then we say that the new minimum vertex which we may return
//            is vertex i
            if(!visitedVertex[i] && distanceFromStart[i] < minimumDistance){
                minimumVertexIndex = i;
                minimumDistance = distanceFromStart[i];
            }
        }

        return minimumVertexIndex;
    }

    public static void main(String[] args){
//        graph storaqe structure:
//        int[vertex][othervertex] = the distance between vertices
//        if there is no path between vertices, represent with 0
//        (will be ignored)
//        likewise with itself
        int graph[][] = new int[][] {
                {0, 2, 1, 0},
                {2, 0, 5, 3},
                {1, 5, 0, 7},
                {0, 3, 7, 0}

        };
        dijkstra(graph, 0);
    }
}

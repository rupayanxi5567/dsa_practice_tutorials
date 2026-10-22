//package graphs_qns;
//
//import java.util.Arrays;
//import java.util.PriorityQueue;
//
//class Pair{
//    int n;
//    int steps;
//    public Pair(int n,int steps){
//        this.n=n;
//        this.steps=steps;
//    }
//}
//
//class Solution {
//    public int minSteps(int[] a, int start, int end) {
//        // code here
//        if(start==end){
//            return 0;
//        }
//        PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->Integer.compare(x.steps,y.steps));
//        pq.add(new Pair(start,0));
//
//        int []dist=new int[1000];
//        Arrays.fill(dist,Integer.MAX_VALUE);
//        dist[start]=0;
//
//        while (!pq.isEmpty()){
//            Pair cp = pq.poll();
//            int cn = cp.n;
//            int cs = cp.steps;
//
//            if(cn==end){
//                return cs;
//            }
//
//            for(int i=0;i<a.length;i++){
//                int newNumMod = (int)((long) cn * a[i] % 1000);
//                if(dist[newNumMod]>cs+1){
//                    dist[newNumMod]=cs+1;
//                    pq.add(new Pair(newNumMod,cs+1));
//                }
//            }
//
//        }
//        return -1;
//    }
//}

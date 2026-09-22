import java.util.Scanner;

class Main {
    static void main(String[] args) {
        int v,e;
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter no. of vertex: ");
        v = sc.nextInt();
        System.out.println();
        System.out.print("Enter no. of edges: ");
        e = sc.nextInt();

        boolean adj[][] = new boolean[v][v];
        int u,w;

        for(int i=0;i<e;i++){
            u=sc.nextInt();
            w=sc.nextInt();
            adj[u][w]=true;
            adj[w][u]=true;
        }

        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                System.out.print(adj[i][j]+" ");
            }
        }

    }
}
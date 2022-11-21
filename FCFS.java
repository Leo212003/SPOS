import java.util.*;

public class FCFS                           //step 1
{
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        System.out.print("Enter the number of processes :-");

        int n=sc.nextInt();  //Total processes

        int pid[]= new int[n]; //Process ids
        int ar[]= new int[n];
        int bt[]= new int[n];
        int ct[]= new int[n];
        int ta[]= new int[n];
        int wt[]= new int[n];
        int temp;
        float avgwt=0,avgta=0;

        for(int i=0;i<n;i++)                    //step 2
        {
            System.out.print("Enter the process "+(i+1)+"arrival time : ");

            ar[i]=sc.nextInt();

            System.out.print("Enter the process "+(i+1)+"Burst time: ");

            bt[i]=sc.nextInt();

            pid[i]=i+1;
        }


        //sort the process according to Arrival Time            step 3


        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-(i+1);j++)
            {
                if(ar[j]>ar[j+1])
                {
                    temp=ar[j];
                    ar[j]=ar[j+1];
                    ar[j+1]=temp;

                    temp=bt[j];
                    bt[j]=bt[j+1];
                    bt[j+1]=temp;

                    temp=pid[j];
                    pid[j]=pid[j+1];
                    pid[j+1]=temp;

                }

            }
        }
        //find the completion time           step 4

        for(int i=0;i<n;i++)
        {
            if(i==0)
                ct[i]=ar[i]+bt[i];
            else
            {
                if(ar[i]>ct[i-1])
                {
                    ct[i]=ar[i]+bt[i];
                }
                else
                    ct[i]=ct[i-1]+bt[i];
            }

            ta[i]=ct[i]-ar[i];

            wt[i]=ta[i]-bt[i];

            avgwt=avgwt+wt[i];
            avgta=avgta+ta[i];


        }
        System.out.println("\nPID     AT      BT      CT      TAT     WT ");

        for (int i=0; i<n;i++ ) {
            System.out.println(pid[i]+"\t"+ar[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+ta[i]+"\t"+wt[i]);

        }
        sc.close();
    }
}


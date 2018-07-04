package com.example.showgata12.uvideoplayer.Generators;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomSelector {

    public static int[] generatorTen(int noOfItems) {

        Random rn = new Random();
        int[] nos = new int[10];
        boolean flag =false;

        if(noOfItems>=5) {
            for (int i = 1; i <= 10; i++) {
                int no = rn.nextInt(noOfItems);

                for(int j=0;j<nos.length;j++)
                {
                    if(nos[j]==no)
                    {
                        flag =true;
                    }
                }

                if(!flag)
                {
                    nos[i]=no;

                }

                flag =false;
            }

            return nos;
        }else
        {
            nos[0]=-1;
            return nos;
        }


    }
}

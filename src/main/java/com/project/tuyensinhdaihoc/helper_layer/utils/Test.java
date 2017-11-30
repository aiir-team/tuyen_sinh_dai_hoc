package com.project.tuyensinhdaihoc.helper_layer.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        Double d = 8.9;
        String s = String.format("%.2f", d);
        int value = Integer.valueOf(s.split("\\.")[0]);
        int t1 = Integer.valueOf(s.split("\\.")[1]);;

        if(13 <= t1 && t1 <= 37) {
            value += 0.25;
        } else if (38 <= t1 && t1 <= 62) {
            value += 0.50;
        } else if (63 <= t1 && t1 <= 87) {
            value += 0.75;
        } else if (88 <= t1 && t1 <= 99) {
            value += 1.0;
        }

        //tao hai ma tran
        int a[][]={{1,3,4},{3,4,5}};
        int b[][]={{2,11,0},{9,6,7}};

        System.out.println(a[0][0]);
        System.out.println(a[0][1]);
        System.out.println(a[0][2]);
        System.out.println(a[1][0]);
        System.out.println(a[1][1]);

        System.out.println(a[0].length);
        System.out.println(a.length);

        //tao ma tran khac de luu giu ket qua phep cong hai ma tran
        int c[][]=new int[2][3];

        //cong va in tong hai ma tran
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                c[i][j]=a[i][j]+b[i][j];
                System.out.print(c[i][j]+" ");
            }
            System.out.println();//new line
        }


        int[] src  = new int[]{1,2,3,4,5};
        int[] dest = new int[5];

        System.arraycopy( src, 0, dest, 0, src.length );

        for(int i = 0; i< dest.length; i++) {
            System.out.println(dest[i]);
        }

        System.out.println("===================");

        int[] arrId = {21, 25, 27, 22, 29, 28};
        Integer[] arr = {11, 5, 9, 0, 5, 11};

        Integer[] c_star_old = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr, Collections.reverseOrder());

        int outputOrder[] = new int[arrId.length];
        for(int i = 0; i < c_star_old.length; i++) {
            final int t = i;
            int count = (int) Arrays.stream(arr).filter(x -> x == c_star_old[t]).count();

            int index = IntStream.range(0, arr.length).filter(j -> arr[j] == c_star_old[t]).findFirst().orElse(-1);
            System.out.println(index);

            for(int j = 0; j < count; j++) {
                outputOrder[index + j] = arrId[i+j];
            }
        }
        System.out.println(outputOrder);

    }


}

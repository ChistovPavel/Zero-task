package com.chistov.pavel;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args){

        OwnStack list_1 = new OwnStack(Arrays.asList(1,2,3,4,5));
        OwnStack list_2 = new OwnStack(Arrays.asList(7,8,9,10,11,2,56,87,7,7,7,7,7,0));

        try {
            System.out.println("first stack: " + list_1.clone().Pop_all());
            System.out.println("second stack: " + list_2.clone().Pop_all());
            System.out.println("Found value: " + FindCommonNode(list_1.clone(), list_2.clone()));
        }
        catch (CloneNotSupportedException ex) {
            System.out.println("Cloneable not implemented");
        }
    }

    static public Integer FindCommonNode(OwnStack list_1, OwnStack list_2)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        while(list_1.HeadIsNull() == false)
        {
            map.put(list_1.show(), list_1.Pop());
        }

        while (list_2.HeadIsNull() == false)
        {
            if (map.containsKey(list_2.show()))
            {
                return list_2.Pop();
            }
            list_2.Pop();
        }

        return null;
    }
}

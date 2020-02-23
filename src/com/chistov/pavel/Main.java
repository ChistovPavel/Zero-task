package com.chistov.pavel;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args){

        OwnStack list_1 = new OwnStack(Arrays.asList(1,2,3,4,5,6,7));
        try {
            OwnStack list_2 = new OwnStack(list_1.clone(), 4, Arrays.asList(7,8,9,10,11,56,87,7,7,7,7,7,0));

            System.out.println("first stack: " + list_1.clone().Pop_all());
            System.out.println("second stack: " + list_2.clone().Pop_all());
            System.out.println("Found value: " + FindCommonNode(list_1.clone(), list_2.clone()).getData());
        }
        catch (CloneNotSupportedException ex) {
            System.out.println("Cloneable not implemented");
        }
    }

    static public ForwardList FindCommonNode(OwnStack list_1, OwnStack list_2)
    {
        while (list_1.Length() != list_2.Length())
        {
            if (list_1.Length() > list_2.Length())list_1.Pop();
            else list_2.Pop();
        }

        while (!list_1.HeadIsNull() && !list_2.HeadIsNull())
        {
            if (list_1.Head() == list_2.Head())
            {
                return list_1.Head();
            }
            list_1.Pop();
            list_2.Pop();
        }

        return null;
    }
}

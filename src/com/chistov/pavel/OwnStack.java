package com.chistov.pavel;

import java.util.ArrayList;
import java.util.List;

public class OwnStack implements Cloneable{

    private ForwardList head;

    public OwnStack(List<Integer> array)
    {
        head = new ForwardList();
        head.setData(array.get(0));

        for (int i = 1; i < array.size(); i++)
        {
            this.Push(array.get(i));
        }
    }

    public void Push(Integer value){
        if (head == null)
        {
            head = new ForwardList();
            head.setData(value);
        }
        else
        {
            ForwardList new_head = new ForwardList();
            new_head.setData(value);
            new_head.setNextElement(head);
            head = new_head;
        }
    }
    public Integer Pop(){
        if (head == null)
        {
            return null;
        }
        else
        {
            Integer ret = head.getData();
            head = head.next();
            return ret;
        }
    }

    public Integer show()
    {
        return head.getData();
    }

    public List<Integer> Pop_all(){

        List<Integer> ret = new ArrayList<>();

        while (head != null)
        {
            ret.add(head.getData());
            head = head.next();
        }

        return ret;
    }

    public boolean HeadIsNull()
    {
        return (head == null);
    }

    public OwnStack clone() throws CloneNotSupportedException{
        OwnStack new_list = (OwnStack) super.clone();
        return new_list;
    }
}

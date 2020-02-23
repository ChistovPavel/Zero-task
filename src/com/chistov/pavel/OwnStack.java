package com.chistov.pavel;

import java.util.ArrayList;
import java.util.List;

public class OwnStack implements Cloneable{

    private ForwardList head;
    private Integer length;

    public OwnStack(List<Integer> array)
    {
        this.head = new ForwardList();
        this.head.setData(array.get(0));
        this.length = 1;

        for (int i = 1; i < array.size(); i++)
        {
            this.Push(array.get(i));
        }
    }

    public OwnStack(OwnStack stack, Integer commonNode, List<Integer> array)
    {
        int len = stack.Length() - commonNode;
        for (int i = 0; i < len; i++)
        {
            if (stack.head.next() == null) break;
            stack.Pop();
        }
        this.head = stack.head;
        this.length = stack.Length();

        for (int i = 0; i < array.size(); i++)
        {
            this.Push(array.get(i));
        }
    }

    public void Push(Integer value){
        if (head == null)
        {
            head = new ForwardList();
            head.setData(value);
            this.length = 1;
        }
        else
        {
            ForwardList new_head = new ForwardList();
            new_head.setData(value);
            new_head.setNextElement(head);
            head = new_head;
            this.length++;
        }
    }
    public Integer Pop(){
        if (head == null)
        {
            this.length = 0;
            return null;
        }
        else
        {
            Integer ret = head.getData();
            head = head.next();
            this.length--;
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

        this.length = 0;

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

    public Integer Length()
    {
        return this.length;
    }
    public ForwardList Head()
    {
        return this.head;
    }
}

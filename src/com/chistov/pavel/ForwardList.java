package com.chistov.pavel;

public class ForwardList {

    private Integer data;
    private ForwardList nextElement;

    public ForwardList next()
    {
        return this.nextElement;
    }

    public Integer getData()
    {
        return this.data;
    }

    public void setData(Integer otherData)
    {
        this.data = otherData;
    }

    public void setNextElement(ForwardList otherNextElement)
    {
        this.nextElement = otherNextElement;
    }
}

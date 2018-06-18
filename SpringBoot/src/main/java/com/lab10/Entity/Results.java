package com.lab10.Entity;

import java.io.Serializable;

public class Results implements Serializable{
    private boolean showResult;

    public Results() {
    }

    public Results(String result) {
        if(result == "true")
        {
            showResult = true;
        }
        else
        {
            showResult = false;
        }
    }

    public boolean isShowResult() {
        return showResult;
    }

    public void setReslut(boolean res)
    {
       this.showResult = res;
    }

}

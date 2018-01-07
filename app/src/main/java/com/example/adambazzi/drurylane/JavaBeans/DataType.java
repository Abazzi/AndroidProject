package com.example.adambazzi.drurylane.JavaBeans;

import android.widget.Button;

/**
 * Created by web on 2017-12-06.
 */

public class DataType {

    private String name;
    private String definition;
    public DataType(){

    }
    public DataType(String name, String definition){
        this.name = name;
        this.definition = definition;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }
    public void setDefinition(String definition) {
        this.definition = definition;
    }
    public String toString(){
        return this.name;
    }
}

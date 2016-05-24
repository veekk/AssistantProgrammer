package com.onpu.assistantprogrammer;

import java.util.ArrayList;
import java.util.List;

/**
 * Crafted by veek on 23.05.16 with love ♥
 */
public class Item {
    public int id;
    public String text;
    public int[] relations;

    public Item(int id, String text, int[] relations){
        this.id = id;
        this.text = text;
        this.relations = relations;
    }



}

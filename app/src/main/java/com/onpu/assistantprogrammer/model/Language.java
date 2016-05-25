package com.onpu.assistantprogrammer.model;

import com.onpu.assistantprogrammer.R;

import java.util.Map;
import java.util.StringTokenizer;

/**
 * Crafted by veek on 22.05.16 with love ♥
 */

//Модельный класс для языков, опредеялем id, название языка, описание, ссылка на тектовые материалы,
//ссылка на видео-материалы, изображение(лого)
public class Language {
    public int id;
    public String name;
    public String descr;
    public String tUrl;
    public String vUrl;
    public int img;

    public Language(int id, String name, String descr, String tUrl, String vUrl) {
        this.id = id;
        this.name = name;
        this.descr = descr;
        this.tUrl = tUrl;
        this.vUrl = vUrl;
        //Изображение определяется по id через switch
        switch (id){
            case 0:
                img = R.drawable.python;
                break;
            case 1:
                img = R.drawable.js;
                break;
            case 2:
                img = R.drawable.java;
                break;
            case 3:
                img = R.drawable.csharp;
                break;
            case 4:
                img = R.drawable.c;
                break;
            case 5:
                img = R.drawable.ruby;
                break;
            case 6:
                img = R.drawable.php;
                break;
            case 7:
                img = R.drawable.objc;
                break;
            case 8:
                img = R.drawable.cpp;
                break;

        }
    }
}

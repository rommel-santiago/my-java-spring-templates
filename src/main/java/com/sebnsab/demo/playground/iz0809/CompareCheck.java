package com.sebnsab.demo.playground.iz0809;

class CompareCheck {
    int id;
    String name;

    public CompareCheck(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean equals(Object obj) { //line n1
        boolean output = false;
        CompareCheck b = (CompareCheck) obj;
        if (this.name.equals(b.name)) output = true;
        return output;
    }
}



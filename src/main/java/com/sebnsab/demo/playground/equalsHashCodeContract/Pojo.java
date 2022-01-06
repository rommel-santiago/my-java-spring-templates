package com.sebnsab.demo.playground.equalsHashCodeContract;

import com.sebnsab.demo.playground.interview.Interview;

import java.util.Objects;

public class Pojo {
    private String key;
    private String value;

    public Pojo(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pojo pojo = (Pojo) o;

        if (key != null ? !key.equals(pojo.key) : pojo.key != null) return false;
        return value != null ? value.equals(pojo.value) : pojo.value == null;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}

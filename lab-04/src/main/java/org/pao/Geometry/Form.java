package org.pao.Geometry;

import java.util.Objects;

public abstract class Form {
    private String color;

    public Form() {
    }

    public Form(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public float getArea() {
        return 0;
    }

    @Override
    public String toString() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        var form = (Form) o;
        return Objects.equals(color, form.color);
    }
}

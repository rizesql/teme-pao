package org.pao.Geometry;

public class Circle extends Form {
    private float radius;

    public Circle() {}
    public Circle(String color, float radius) {
        super(color);
        this.radius = radius;
    }


    public void printCircleDimensions() {
        System.out.printf("radius: %f%n", radius);
    }

    @Override
    public float getArea() {
        return (float) (radius * radius * Math.PI);
    }

    @Override
    public String toString() {
        return "Cerc: %s %f".formatted(super.toString(), getArea());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        var circle = (Circle) o;
        return Float.compare(circle.radius, radius) == 0 && super.equals(o);
    }
}

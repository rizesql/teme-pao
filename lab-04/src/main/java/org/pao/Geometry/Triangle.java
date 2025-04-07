package org.pao.Geometry;

public class Triangle extends Form {
    private float height;
    private float base;

    public Triangle() {
    }

    public Triangle(String color, float height, float base) {
        super(color);
        this.height = height;
        this.base = base;
    }

    public void printTriangleDimensions() {
        System.out.printf("height: %f, base: %f%n", height, base);
    }

    @Override
    public float getArea() {
        return height * base / 2;
    }

    @Override
    public String toString() {
        return "Triunghi: %s %f".formatted(super.toString(), getArea());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        var triangle = (Triangle) o;
        return Float.compare(height, triangle.height) == 0
                && Float.compare(base, triangle.base) == 0
                && super.equals(triangle);
    }
}

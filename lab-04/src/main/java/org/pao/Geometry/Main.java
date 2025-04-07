package org.pao.Geometry;

public class Main {
    public static void main(String[] args) {
        var forms = new Form[] {
                new Triangle("Rosu", 2.0f, 3.0f),
                new Circle("Galben", 1.0f),
                new Triangle("Albastru", 11.0f, 5.0f),
        };

        for (var form : forms) {
            System.out.println(form.toString());
        }

        for(var form : forms) {
            if(form instanceof Triangle t) {
                t.printTriangleDimensions();
            }
            if(form instanceof Circle c) {
                c.printCircleDimensions();
            }
        }

        for(var form : forms) {
            switch (form) {
                case Triangle t -> t.printTriangleDimensions();
                case Circle c -> c.printCircleDimensions();
                default -> System.out.println(form);
            }
        }
    }
}

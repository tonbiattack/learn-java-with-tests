package dev.learnjavawithtests.shapes.v1;

public record Rectangle(double width, double height) implements Shape {
    @Override
    public double area() {
        return width * height;
    }
}


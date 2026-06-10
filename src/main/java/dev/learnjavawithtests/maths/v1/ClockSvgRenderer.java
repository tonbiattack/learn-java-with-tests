package dev.learnjavawithtests.maths.v1;

import java.time.LocalTime;

public final class ClockSvgRenderer {
    public String render(LocalTime time) {
        Point hour = handEndpoint((time.getHour() % 12 + time.getMinute() / 60.0) * 30, 40);
        Point minute = handEndpoint(time.getMinute() * 6, 60);
        Point second = handEndpoint(time.getSecond() * 6, 75);

        return """
                <svg viewBox="0 0 200 200" xmlns="http://www.w3.org/2000/svg">
                  <circle cx="100" cy="100" r="95" fill="white" stroke="black"/>
                  <line id="hour" x1="100" y1="100" x2="%s" y2="%s" stroke="black" stroke-width="6"/>
                  <line id="minute" x1="100" y1="100" x2="%s" y2="%s" stroke="black" stroke-width="4"/>
                  <line id="second" x1="100" y1="100" x2="%s" y2="%s" stroke="red" stroke-width="2"/>
                </svg>
                """.formatted(hour.x(), hour.y(), minute.x(), minute.y(), second.x(), second.y());
    }

    private Point handEndpoint(double degrees, double length) {
        double radians = Math.toRadians(degrees - 90);
        int x = (int) Math.round(100 + Math.cos(radians) * length);
        int y = (int) Math.round(100 + Math.sin(radians) * length);
        return new Point(x, y);
    }

    private record Point(int x, int y) {
    }
}


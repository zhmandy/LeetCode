class Solution {
    // calculate hour hand, minute hand separatly based on 0 o'clock
    public double angleClock(int hour, int minutes) {
        int oneMinAngle = 6;
        int oneHourAngle = 30;
        
        double minutesAngle = oneMinAngle * minutes;
        double hourAngle = (hour % 12 + minutes / 60.0) * oneHourAngle;
        
        double diff = Math.abs(hourAngle - minutesAngle);
        return Math.min(diff, 360 - diff);
    }
}
/*
Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.

The hour must not contain a leading zero.

For example, "01:00" is not valid. It should be "1:00".
The minute must be consist of two digits and may contain a leading zero.

For example, "10:2" is not valid. It should be "10:02".
Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.

The hour must not contain a leading zero.

For example, "01:00" is not valid. It should be "1:00".
The minute must be consist of two digits and may contain a leading zero.

For example, "10:2" is not valid. It should be "10:02".
*/
class Solution {
    
    public List<String> readBinaryWatch(int num) {
        if (num < 0 || num > 10) {
            return new ArrayList<>();
        }
        
        List<String> result = new ArrayList<>();
      
        for (int hour = 0; hour <= 11; hour++) {
            for (int minute = 0; minute <= 59; minute++) {
				
				// If number of bits in hour + number of bits in minute equals num
				// add to result or else do nothing.
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == num) {
                    
                    result.add(String.format("%d:%02d", hour, minute));
                    
                }
            }
        }      
        
        return result;
    }
}

package leetcode;

/**
 * https://leetcode.com/problems/moving-average-from-data-stream
 */
public final class Problem346MovingAverageFromDataStream {
    public static class MovingAverage {
        private final int[] window;
        private int size;
        private int index;
        private double sum;

        public MovingAverage(int size) {
            window = new int[size];
        }

        public double next(int val) {
            if (size < window.length) {
                size++;
            }

            sum -= window[index];
            sum += val;
            window[index] = val;
            index = (index + 1) % window.length;

            return sum / size;
        }
    }
}

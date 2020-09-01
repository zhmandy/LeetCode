class Solution {
    // calculate the frequency of each task
    // the maximum idle time will be n*(maximumFrequency - 1)
    // sort the frenquency in descending order and deduct the total time greedily
    // cuz we can use the tasks to replace idle
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int[] frequency = new int[26];
        for (char c : tasks) {
            frequency[c - 'A']++;
        }
        
        Arrays.sort(frequency);
        int fMax = frequency[25];
        int fTime = (fMax - 1) * n;
        
        for (int i = 24; i >= 0 && fTime > 0; i--) {
            fTime -= Math.min(fMax - 1, frequency[i]);
        }
        
        return fTime < 0 ? tasks.length : tasks.length + fTime;
    }
}
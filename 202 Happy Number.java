class Solution {
    // case 1: goes down to 1
    // case 2: n ends up in a cycle
    // case 3: n goes up to a large number
    // case 3 is not possible, it will eventually get trapped in a cycle

    // For a number with 33 digits, it's impossible for it to ever go larger than 243243.
    // This means it will have to either get stuck in a cycle below 243243 or go down to 11.
    // Numbers with 44 or more digits will always lose a digit at each step until they are down to 33 digits.
    // So we know that at worst, the algorithm might cycle around all the numbers under 243243 and then go back to one it's already been to (a cycle) or go to 11.
    // But it won't go on indefinitely, allowing us to rule out the 3rd option.
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                n = n / 10;
                sum += digit * digit;
            }
            n = sum;
        }
        
        return n == 1;
    }
}
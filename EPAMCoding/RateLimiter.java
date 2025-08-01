package EPAMCoding;

import java.util.*;

/*Given two positive integers n and t, and a non-decreasing stream of integers representing the timestamps of requests,
implement a data structure that can check if each request is allowed or not.

Implement the RateLimiter class:
RateLimiter(int n, int t) Initializes the RateLimiter object with an empty stream and two integers n and t.
boolean shouldAllow(int timestamp) Returns true if the current request with timestamp timestamp is allowed, otherwise returns false.

Note that while checking if the current request should be allowed, only the timestamps of requests previously allowed are considered.

Example 1: Input ["RateLimiter", "shouldAllow", "shouldAllow", "shouldAllow", "shouldAllow", "shouldAllow"] [[3, 5], [1], [1], [2], [3], [8]]
Output [null, true, true, true, false, true]

Explanation RateLimiter rateLimiter = new RateLimiter(3, 5);
rateLimiter.shouldAllow(1); // returns True // There are no previous requests, so this request is allowed.
rateLimiter.shouldAllow(1); // returns True // We can allow 3 requests every 5 seconds, so this request is allowed. // Timestamps of allowed requests are [1,1].
rateLimiter.shouldAllow(2); // returns True // Timestamps of allowed requests are [1,1,2].
rateLimiter.shouldAllow(3); // returns False // This request is not allowed because // the time range [1,3] already has 3 allowed requests.
rateLimiter.shouldAllow(8); // returns True // This request is allowed because // the time range [4,8] does not have any allowed requests.

Constraints: 1 <= n <= 105 1 <= t, timestamp <= 105 At most 105 calls will be made to shouldAllow.
timestamp values will be non-decreasing over all calls made to shouldAllow.*/
public class RateLimiter {
    private final int maxRequests;
    private final int timeWindow;
    private final Deque<Integer> allowedTimestamps;

    public RateLimiter(int n, int t) {
        this.maxRequests = n;
        this.timeWindow = t;
        this.allowedTimestamps = new ArrayDeque<>();
    }

    public boolean shouldAllow(int timestamp) {
        // Remove outdated timestamps outside the current sliding window
        while (!allowedTimestamps.isEmpty() && allowedTimestamps.peekFirst() <= timestamp - timeWindow) {
            allowedTimestamps.pollFirst();
        }

        if (allowedTimestamps.size() < maxRequests) {
            allowedTimestamps.offerLast(timestamp);
            return true;
        } else {
            return false;
        }
    }

    // Optional: For debugging or visualization
    public void printStatus() {
        System.out.println("Allowed timestamps in window: " + allowedTimestamps);
    }

    public static void main(String[] args) {
        RateLimiter rl = new RateLimiter(3, 5);
        System.out.println(rl.shouldAllow(1)); // true
        System.out.println(rl.shouldAllow(1)); // true
        System.out.println(rl.shouldAllow(2)); // true
        System.out.println(rl.shouldAllow(3)); // false
        System.out.println(rl.shouldAllow(8)); // true
    }
}

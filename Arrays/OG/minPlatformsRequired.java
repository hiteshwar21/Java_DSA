package Arrays.OG;

public class minPlatformsRequired {

    public static void main(String[] args) {
        int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };
        int minPlatforms = getMinPlatforms(arr, dep);
        System.out.println(minPlatforms);
    }

    static int getMinPlatforms(int[] arr, int[] dep){
        int minPlatforms = 1;
        int[] platform = new int[2361];

        for(int i = 0; i < arr.length; i++)
        {
            ++platform[arr[i]];
            --platform[dep[i] + 1];
        }

        for(int i = 1; i < 2361; i++)
        {
            platform[i] = platform[i] + platform[i - 1];
            minPlatforms = Math.max(minPlatforms, platform[i]);
        }
        return minPlatforms;
    }
}

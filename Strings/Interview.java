package Strings;


/*
Our local radio station is running a show where the songs are ordered in a very specific way. 
The last word of the title of one song must match the first word of the title of the next song - for example,
"Silent Running" could be followed by "Running to Stand Still".  No song may be played more than once.

        Given a list of songs and a
        songs1 = [
            "Down By the River",
            "River of Dreams",
            "Take me to the River",
            "Dreams",
            "Blues Hand Me Down",
            "Forever Young",
            "American Dreams",
            "All My Love",
            "Cantaloop",
            "Take it All",
            "Love is Forever",
            "Young American",
            "Every Breath You Take",
        ]

        take -> river -> dreams
        take -> All -> Love -> forever ->young -> american ->dreams
        Node{
            Key
            Name - String
            List<Object> value
        }


        song1_1 = "Every Breath You Take"
*/

import java.util.*;

public class Interview {
    public static void main(String[] args) {
        List<String> songsList = new ArrayList<>();
        songsList.add("Down By the River");
        String startSong = "Every Breath You Take";
        System.out.println(getLongestSongSequence(songsList, startSong));
    }

    static int getLongestSongSequence(List<String> songsList, String startSong){
        int maxCount = 1;
        //base condition
        if(songsList.size() == 1) {
            return maxCount;
        }
        //Main Logic
        char[] startingSong = startSong.toCharArray();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String songList : songsList){
            String[] song = startSong.split("\\s+");
            int songSize = song.length-1;
            map.put(song[0], map.getOrDefault(map.get(song[0]).add(song[songSize]),new ArrayList(Collections.singleton(song[songSize]))));
        }

        for(String key: map.keySet()){
            System.out.println(key);
        }
        return 1;
    }

}

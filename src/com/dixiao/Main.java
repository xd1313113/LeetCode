package com.dixiao;

import com.dixiao.leetcode.LRUCache;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static int friendCircles(String[] friends) {
        int circleCount = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends[i].length(); j++) {
                if (friends[i].charAt(j) == 'Y') {
                    circleCount++;
                    queue.add(i);
                    friends[i] = friends[i].replaceFirst("Y", "V");
                    while (!queue.isEmpty()) {
                        int indexOfFriends = queue.poll();
                        friends[indexOfFriends] = findFriendsInRow(queue, friends[indexOfFriends]);
                    }

                }
            }
        }
        return circleCount;
    }

    static String findFriendsInRow(Queue<Integer> queue, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'Y') {
                queue.add(i);
                s = s.replaceFirst("Y", "V");
            }
        }
        return s;
    }
    private int n = 10;
    private static String name ="Di";

    /**
     *
     @param args
     * @throws IOException
     * @throws ParseException
     */
    public static void main(String[] args) throws IOException, ParseException {

    }


    public List<String> getDirectFriendsForUser(String user) {
        return new LinkedList<>();
    }

    public List<String> getAttendedCoursesForUser(String user) {
        return new LinkedList<>();
    }

    public List<String> getRankedCourses(String user) {

        HashSet<String> attended = new HashSet<>(getAttendedCoursesForUser(user));
        HashSet<String> visitedFriends = new HashSet<>();
        Map<String, Integer> socialCourses = new HashMap<>();
        Queue<String> socialCircle = new LinkedList<>();

        socialCircle.add(user);
        visitedFriends.add(user);
        int deep = 0;
        while (!socialCircle.isEmpty() && deep < 3) {
            int size = socialCircle.size();
            deep++;
            for (int i = 0; i < size; i++) {
                String curUser = socialCircle.poll();
                List<String> friends = getDirectFriendsForUser(curUser);
                for (String friend : friends) {
                    if (!visitedFriends.contains(friend)) {
                        socialCircle.add(friend);
                    }
                }
                if (!visitedFriends.contains(curUser)) {
                    List<String> courses = getAttendedCoursesForUser(curUser);
                    for (String course : courses) {
                        if (!attended.contains(course)) {
                            if (socialCourses.containsKey(course)) {
                                socialCourses.put(course, socialCourses.get(course) + 1);
                            } else {
                                socialCourses.put(course, 1);
                            }
                        }
                    }
                    visitedFriends.add(curUser);
                }
            }
        }

        return sortByComparator(socialCourses);
    }

    private static List<String> sortByComparator(Map<String, Integer> unsortMap) {

        // Convert Map to List
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // Sort list with comparator, to compare the Map values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        List<String> sorted = new LinkedList<>();
        for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext();) {
            Map.Entry<String, Integer> entry = it.next();
            sorted.add(entry.getKey());
        }
        return sorted;
    }

    public static void showNmae(String name){
        System.out.printf(name);
    }
    public static void showNmae(Supplier<String> name){
        System.out.printf(name.get());
    }


}

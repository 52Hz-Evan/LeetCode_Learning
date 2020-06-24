package com.leetcode.editor.cn;

//设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个
//功能： 
//
// 
// postTweet(userId, tweetId): 创建一条新的推文 
// getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
// 
// follow(followerId, followeeId): 关注一个用户 
// unfollow(followerId, followeeId): 取消关注一个用户 
// 
//
// 示例: 
//
// 
//Twitter twitter = new Twitter();
//
//// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//twitter.postTweet(1, 5);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//twitter.getNewsFeed(1);
//
//// 用户1关注了用户2.
//twitter.follow(1, 2);
//
//// 用户2发送了一个新推文 (推文id = 6).
//twitter.postTweet(2, 6);
//
//// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//// 推文id6应当在推文id5之前，因为它是在5之后发送的.
//twitter.getNewsFeed(1);
//
//// 用户1取消关注了用户2.
//twitter.unfollow(1, 2);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//// 因为用户1已经不再关注用户2.
//twitter.getNewsFeed(1);
// 
// Related Topics 堆 设计 哈希表

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T355 {
    @Test
    public void test() {
        T355 t355 = new T355();
        t355.postTweet(1, 5);

        List<Integer> newsFeed = t355.getNewsFeed(1);
        t355.follow(1,2);
        t355.postTweet(2,6);
        List<Integer> newsFeed2 = t355.getNewsFeed(1);
        t355.unfollow(1,2);
        List<Integer> newsFeed1 = t355.getNewsFeed(1);
//        t355.postTweet(1, 3);
//        t355.postTweet(1, 101);
//        t355.postTweet(1, 13);
//        t355.postTweet(1, 10);
//        t355.postTweet(1, 2);
//        t355.postTweet(1, 94);
//        t355.postTweet(1, 505);
//        t355.postTweet(1, 333);
//        t355.postTweet(1, 22);
////
////
//        List<Integer> newsFeed1 = t355.getNewsFeed(1);
//        t355.unfollow(1,2);

    }

    private Map<Integer, List<String>> user2TweetMap;
    private Map<Integer, List<Integer>> followee2FollowerMap;
    private int count;

    /**
     * Initialize your data structure here.
     */
    public T355() {
        user2TweetMap = new HashMap<>();
        followee2FollowerMap = new HashMap<>();
        count = 0;
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        count++;
        String tweet = count + "_" + tweetId;
        List<String> tweetList = user2TweetMap.get(userId);
        if (null == tweetList) {
            tweetList = new ArrayList<>();
        }
        tweetList.add(tweet);
        user2TweetMap.put(userId, tweetList);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<String> list = new ArrayList<>();
        List<Integer> userList = followee2FollowerMap.get(userId);
        if (null == userList) {
            userList = new ArrayList<>();
        }
        for (Integer key : user2TweetMap.keySet()) {
            if (key == userId || userList.contains(key)) {
                List tweets = user2TweetMap.get(key);
                for (int i = 0; i < tweets.size(); i++) {
                    String val = tweets.get(i).toString();
                    list.add(val);
                }
            }
        }
        Map<Integer, Integer> resultMap = new HashMap<>();
        List resultList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String[] vals = list.get(i).toString().split("_");
            resultList.add(Integer.valueOf(vals[0]));
            resultMap.put(Integer.valueOf(vals[0]), Integer.valueOf(vals[1]));
        }
        Collections.sort(resultList);
        List<Integer> result = new ArrayList<>();
        for (int i = resultList.size() - 1; i >= resultList.size() - 10 && i>=0; i--) {
            result.add(Integer.valueOf(resultMap.get(resultList.get(i))));
        }

        return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        List<Integer> followeeList = followee2FollowerMap.get(followerId);
        if (null == followeeList) {
            followeeList = new ArrayList<>();
        }
        followeeList.add(followeeId);
        followee2FollowerMap.put(followerId, followeeList);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        List<Integer> followeeList = followee2FollowerMap.get(followerId);
        if (null != followeeList) {
            for (int i = 0; i < followeeList.size(); i++) {
                if (followeeList.get(i) == followeeId) {
                    followeeList.remove(i);
                }
            }
        }

        followee2FollowerMap.put(followerId, followeeList);
    }
}


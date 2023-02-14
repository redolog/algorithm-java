package com.algorithm.dataStructure.array.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthenticationManagerTest {

    public static void main(String[] args) {
        String ops = "[\"AuthenticationManager\",\"renew\",\"countUnexpiredTokens\",\"countUnexpiredTokens\",\"generate\",\"generate\",\"renew\",\"generate\",\"generate\",\"countUnexpiredTokens\",\"countUnexpiredTokens\",\"countUnexpiredTokens\",\"renew\",\"countUnexpiredTokens\",\"countUnexpiredTokens\",\"countUnexpiredTokens\",\"generate\",\"countUnexpiredTokens\",\"renew\"]";
        String params = "[[13],[\"ajvy\",1],[3],[4],[\"fuzxq\",5],[\"izmry\",7],[\"puv\",12],[\"ybiqb\",13],[\"gm\",14],[15],[18],[19],[\"ybiqb\",21],[23],[25],[26],[\"aqdm\",28],[29],[\"puv\",30]]";
        String rets = "[null,null,0,0,null,null,null,null,null,4,3,3,null,2,2,2,null,2,null]";

        String[] opsArr = ops.split(",");
        String[] paramsArr = params.split("],\\[");
        String[] retsArr = rets.split(",");
        for (int i = 0; i < opsArr.length; i++) {
            System.out.print("-操作：" + opsArr[i]);
            System.out.print("-入参：" + paramsArr[i]);
            System.out.print("-预期：" + retsArr[i]);
            System.out.println();
        }
    }

    @Test
    public void test() {
        // 构造 AuthenticationManager ，设置 timeToLive = 5 秒。
        AuthenticationManager am = new AuthenticationManager(5);
        // 时刻 1 时，没有验证码的 tokenId 为 "aaa" ，没有验证码被更新。
        am.renew("aaa", 1);
        // 时刻 2 时，生成一个 tokenId 为 "aaa" 的新验证码。
        am.generate("aaa", 2);
        // 时刻 6 时，只有 tokenId 为 "aaa" 的验证码未过期，所以返回 1 。
        assertEquals(1, am.countUnexpiredTokens(6));
        // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
        am.generate("bbb", 7);
        // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 7 ，所以时刻 8 的renew 操作被忽略，没有验证码被更新。
        am.renew("aaa", 8);
        // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以 renew 操作会执行，该 token 将在时刻 15 过期。
        am.renew("bbb", 10);
        // tokenId 为 "bbb" 的验证码在时刻 15 过期，tokenId 为 "aaa" 的验证码在时刻 7 过期，所有验证码均已过期，所以返回 0 。
        assertEquals(0, am.countUnexpiredTokens(15));

        am = new AuthenticationManager(13);
        am.renew("ajvy", 1);
        assertEquals(0, am.countUnexpiredTokens(3));
        assertEquals(0, am.countUnexpiredTokens(4));
        am.generate("fuzxq", 5);
        am.generate("izmry", 7);
        am.renew("puv", 12);
        am.generate("ybiqb", 13);
        am.generate("gm", 14);
        assertEquals(4, am.countUnexpiredTokens(15));
        assertEquals(3, am.countUnexpiredTokens(18));
        assertEquals(3, am.countUnexpiredTokens(19));
        am.renew("ybiqb", 21);
        assertEquals(2, am.countUnexpiredTokens(23));
        assertEquals(2, am.countUnexpiredTokens(25));
        assertEquals(2, am.countUnexpiredTokens(26));
        am.generate("aqdm", 28);
        assertEquals(2, am.countUnexpiredTokens(29));
        am.renew("puv", 30);

//
//        ops = ops.replace("[", "")
//                .replace("]", "")
//                .replace("\"", "")
//                ;
//        switch (op) {
//            case "AuthenticationManager":
//                break;
//            case "renew":
//                break;
//            case "countUnexpiredTokens":
//                break;
//            case "generate":
//                break;
//        }

    }
}
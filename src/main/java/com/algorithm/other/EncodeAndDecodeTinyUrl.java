package com.algorithm.other;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 535. TinyURL 的加密与解密
 * TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL 。
 * <p>
 * 加密和解密算法如何设计和运作是没有限制的，你只需要保证一个 URL 可以被加密成一个 TinyURL ，并且这个 TinyURL 可以用解密方法恢复成原本的 URL 。
 * <p>
 * 实现 Solution 类：
 * <p>
 * Solution() 初始化 TinyURL 系统对象。
 * String encode(String longUrl) 返回 longUrl 对应的 TinyURL 。
 * String decode(String shortUrl) 返回 shortUrl 原本的 URL 。题目数据保证给定的 shortUrl 是由同一个系统对象加密的。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：url = "https://leetcode.com/problems/design-tinyurl"
 * 输出："https://leetcode.com/problems/design-tinyurl"
 * <p>
 * 解释：
 * Solution obj = new Solution();
 * string tiny = obj.encode(url); // 返回加密后得到的 TinyURL 。
 * string ans = obj.decode(tiny); // 返回解密后得到的原本的 URL 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= url.length <= 104
 * 题目数据保证 url 是一个有效的 URL
 * <p>
 * https://leetcode.cn/problems/encode-and-decode-tinyurl/
 *
 * @author dragonsong  @date 2022/7/6
 */
public class EncodeAndDecodeTinyUrl {

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(url));

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 73.55%
     * 的用户
     * 内存消耗：
     * 41.5 MB
     * , 在所有 Java 提交中击败了
     * 59.23%
     * 的用户
     * 通过测试用例：
     * 739 / 739
     * <p>
     * 自增id
     */
    class AutoIncrementIdCodec {

        int id;
        Map<String, String> short2Long;
        /**
         * 短链服务域名前缀
         */
        String prefix = "https://dragonsong.tech/";

        public AutoIncrementIdCodec() {
            id = 0;
            short2Long = new HashMap<>();
        }

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            ++id;
            String shortUrl = String.valueOf(id);
            short2Long.put(shortUrl, longUrl);
            return prefix + shortUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return short2Long.get(shortUrl.substring(shortUrl.lastIndexOf("/") + 1));
        }
    }

    /**
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 54.45%
     * 的用户
     * 内存消耗：
     * 41.7 MB
     * , 在所有 Java 提交中击败了
     * 27.36%
     * 的用户
     * 通过测试用例：
     * 739 / 739
     */
    class RandomKeyCodec {
        /**
         * 概率随机
         */
        ThreadLocalRandom random;
        /**
         * 生成素材串
         */
        String baseStr;
        /**
         * 存储映射
         */
        Map<String, String> short2Long;
        /**
         * 短链后缀长度
         */
        int codeLen;
        /**
         * 短链服务域名前缀
         */
        String prefix = "https://dragonsong.tech/";

        public RandomKeyCodec() {
            random = ThreadLocalRandom.current();
            baseStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            short2Long = new HashMap<>();
            codeLen = 8;
        }

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String shortCode;
            do {
                shortCode = gen(longUrl);
            } while (short2Long.containsKey(shortCode));
            short2Long.put(shortCode, longUrl);
            return prefix + shortCode;
        }

        private String gen(String longUrl) {
            char[] codeArr = new char[codeLen];
            for (int i = 0; i < codeLen; i++) {
                codeArr[i] = baseStr.charAt(random.nextInt(baseStr.length()));
            }
            return String.valueOf(codeArr);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return short2Long.get(shortUrl.substring(shortUrl.lastIndexOf("/") + 1));
        }
    }
}

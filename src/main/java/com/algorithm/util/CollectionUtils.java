package com.algorithm.util;

import java.util.*;

public class CollectionUtils {
    private CollectionUtils() {
    }

    /**
     * Returns a {@link Map} mapping each unique element in the given
     * {@link Collection} to an {@link Integer} representing the number
     * of occurrences of that element in the {@link Collection}.
     * <p>
     * Only those elements present in the collection will appear as
     * keys in the map.
     * </p>
     *
     * @param <O>  the type of object in the returned {@link Map}. This is a super type of &lt;I&gt;.
     * @param coll the collection to get the cardinality map for, must not be null
     * @return the populated cardinality map
     */
    public static <O> Map<O, Integer> getCardinalityMap(final Iterable<? extends O> coll) {
        final Map<O, Integer> count = new HashMap<>();
        for (O obj : coll) {
            count.merge(obj, 1, Integer::sum);
        }
        return count;
    }

    public static Map<Object, Integer> getCardinalityMap(final Object[] arr) {
        final Map<Object, Integer> count = new HashMap<>();
        for (Object obj : arr) {
            count.merge(obj, 1, Integer::sum);
        }
        return count;
    }

    public static Map<Integer, Integer> getCardinalityMap(final int[] arr) {
        final Map<Integer, Integer> count = new HashMap<>();
        for (int obj : arr) {
            count.merge(obj, 1, Integer::sum);
        }
        return count;
    }

    public static boolean isEmpty(Collection<?> coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean equals(Collection<?> a, Collection<?> b) {
        if (a.size() != b.size()) {
            return false;
        }
        final CardinalityHelper<Object> helper = new CardinalityHelper<>(a, b);
        if (helper.cardinalityA.size() != helper.cardinalityB.size()) {
            return false;
        }
        for (final Object obj : helper.cardinalityA.keySet()) {
            if (helper.freqA(obj) != helper.freqB(obj)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper class to easily access cardinality properties of two collections.
     *
     * @param <O> the element type
     */
    private static class CardinalityHelper<O> {

        /**
         * Contains the cardinality for each object in collection A.
         */
        final Map<O, Integer> cardinalityA;

        /**
         * Contains the cardinality for each object in collection B.
         */
        final Map<O, Integer> cardinalityB;

        /**
         * Create a new CardinalityHelper for two collections.
         *
         * @param a the first collection
         * @param b the second collection
         */
        public CardinalityHelper(final Iterable<? extends O> a, final Iterable<? extends O> b) {
            cardinalityA = CollectionUtils.<O>getCardinalityMap(a);
            cardinalityB = CollectionUtils.<O>getCardinalityMap(b);
        }

        /**
         * Returns the maximum frequency of an object.
         *
         * @param obj the object
         * @return the maximum frequency of the object
         */
        public final int max(final Object obj) {
            return Math.max(freqA(obj), freqB(obj));
        }

        /**
         * Returns the minimum frequency of an object.
         *
         * @param obj the object
         * @return the minimum frequency of the object
         */
        public final int min(final Object obj) {
            return Math.min(freqA(obj), freqB(obj));
        }

        /**
         * Returns the frequency of this object in collection A.
         *
         * @param obj the object
         * @return the frequency of the object in collection A
         */
        public int freqA(final Object obj) {
            return getFreq(obj, cardinalityA);
        }

        /**
         * Returns the frequency of this object in collection B.
         *
         * @param obj the object
         * @return the frequency of the object in collection B
         */
        public int freqB(final Object obj) {
            return getFreq(obj, cardinalityB);
        }

        private int getFreq(final Object obj, final Map<?, Integer> freqMap) {
            final Integer count = freqMap.get(obj);
            if (count != null) {
                return count;
            }
            return 0;
        }
    }

    public static List<List<String>> matrixArr2List(String[][] arr) {
        if (ArrayUtils.isEmpty(arr)) {
            return new ArrayList<>();
        }
        List<List<String>> list = new ArrayList<>(arr.length);
        for (String[] subArr : arr) {
            list.add(new ArrayList<>(Arrays.asList(subArr)));
        }
        return list;
    }
    public static List<List<Integer>> matrixArr2List(Integer[][] arr) {
        if (ArrayUtils.isEmpty(arr)) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>(arr.length);
        for (Integer[] subInt : arr) {
            list.add(new ArrayList<>(Arrays.asList(subInt)));
        }
        return list;
    }

}

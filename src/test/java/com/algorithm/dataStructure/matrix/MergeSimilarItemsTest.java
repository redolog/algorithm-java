package com.algorithm.dataStructure.matrix;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import static com.algorithm.util.CollectionUtils.matrixArr2List;
import static org.junit.Assert.assertTrue;

public class MergeSimilarItemsTest {

    @Test
    public void mergeSimilarItems() {
        MergeSimilarItems.SortTwoPointer sortTwoPointer = new MergeSimilarItems.SortTwoPointer();
        assertTrue(CollectionUtils.equals(
                        matrixArr2List(new Integer[][]{{1, 6}, {3, 9}, {4, 5}}),
                        sortTwoPointer.mergeSimilarItems(new int[][]{{1, 1}, {4, 5}, {3, 8}}, new int[][]{{3, 1}, {1, 5}})
                )
        );
        assertTrue(CollectionUtils.equals(
                        matrixArr2List(new Integer[][]{{1, 4}, {2, 4}, {3, 4}}),
                        sortTwoPointer.mergeSimilarItems(new int[][]{{1, 1}, {3, 2}, {2, 3}}, new int[][]{{2, 1}, {3, 2}, {1, 3}})
                )
        );
        assertTrue(CollectionUtils.equals(
                        matrixArr2List(new Integer[][]{{1, 7}, {2, 4}, {7, 1}}),
                        sortTwoPointer.mergeSimilarItems(new int[][]{{1, 3}, {2, 2}}, new int[][]{{7, 1}, {2, 2}, {1, 4}})
                )
        );
        assertTrue(CollectionUtils.equals(
                        matrixArr2List(new Integer[][]{{1, 4}, {2, 9}, {3, 3}, {6, 3}, {7, 6}, {9, 5}, {11, 1}, {12, 7}, {16, 3}, {17, 1}, {22, 4}, {23, 8}, {24, 4}, {28, 3}}),
                        sortTwoPointer.mergeSimilarItems(new int[][]{{2, 9}, {24, 4}, {11, 1}, {16, 3}, {1, 4}, {28, 3}, {23, 8}, {3, 3}}, new int[][]{{7, 6}, {12, 7}, {9, 5}, {22, 4}, {6, 3}, {17, 1}})
                )
        );
        MergeSimilarItems.MapSolution mapSolution = new MergeSimilarItems.MapSolution();
        assertTrue(CollectionUtils.equals(
                        matrixArr2List(new Integer[][]{{1, 6}, {3, 9}, {4, 5}}),
                        mapSolution.mergeSimilarItems(new int[][]{{1, 1}, {4, 5}, {3, 8}}, new int[][]{{3, 1}, {1, 5}})
                )
        );
        assertTrue(CollectionUtils.equals(
                        matrixArr2List(new Integer[][]{{1, 4}, {2, 4}, {3, 4}}),
                        mapSolution.mergeSimilarItems(new int[][]{{1, 1}, {3, 2}, {2, 3}}, new int[][]{{2, 1}, {3, 2}, {1, 3}})
                )
        );
        assertTrue(CollectionUtils.equals(
                        matrixArr2List(new Integer[][]{{1, 7}, {2, 4}, {7, 1}}),
                        mapSolution.mergeSimilarItems(new int[][]{{1, 3}, {2, 2}}, new int[][]{{7, 1}, {2, 2}, {1, 4}})
                )
        );
        assertTrue(CollectionUtils.equals(
                        matrixArr2List(new Integer[][]{{1, 4}, {2, 9}, {3, 3}, {6, 3}, {7, 6}, {9, 5}, {11, 1}, {12, 7}, {16, 3}, {17, 1}, {22, 4}, {23, 8}, {24, 4}, {28, 3}}),
                        mapSolution.mergeSimilarItems(new int[][]{{2, 9}, {24, 4}, {11, 1}, {16, 3}, {1, 4}, {28, 3}, {23, 8}, {3, 3}}, new int[][]{{7, 6}, {12, 7}, {9, 5}, {22, 4}, {6, 3}, {17, 1}})
                )
        );
    }
}
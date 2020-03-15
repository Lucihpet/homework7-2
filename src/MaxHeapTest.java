import org.junit.Test;

import static org.junit.Assert.*;

public class MaxHeapTest {

    @Test
    public void nLognTest() {
        Integer[][] testData = {
                {},
                {2},
                {3,6,3,2,6},
                {3,4,6,5,8,2,1,9}
        };

        Integer[][] expected = {
                {},
                {2},
                {6,6,3,2,3},
                {9,8,4,6,5,2,1,3}
        };

        for (int i = 0; i < testData.length; i++) {
            MaxHeap actual = new MaxHeap(testData[i].length);

            actual.MaxHeapLogN(testData[i]);

            assertTrue(actual.equals(expected[i]));
        }
    }

    @Test
    public void nTest() {
        Integer[][] testData = {
                {},
                {2},
                {3,6,3,2,6},
                {3,4,6,5,8,2,1,9}
        };

        Integer[][] expected = {
                {},
                {2},
                {6,6,3,2,3},
                {9,8,6,5,3,2,1,4}
        };

        for (int i = 0; i < testData.length; i++) {
            MaxHeap maxHeap = new MaxHeap(testData[i].length);
            maxHeap.MaxHeapN(testData[i]);

            assertEquals(expected[i], testData[i]);
        }
    }

    @Test
    public void otherTests() {
        Integer[][] testData = {
                {},
                {2},
                {3,6,3,2,6},
                {3,4,6,5,8,2,1,9}
        };

        Integer[] expectedMax = {-1,2,6,9};

        Integer[] expectedSize = {0,0,4,7};

        Integer[][] expected = {
                {},
                {},
                {6,3,2,3},
                {8,4,6,5,2,1,3}
        };

        for (int i = 0; i < testData.length; i++) {
            MaxHeap maxHeap = new MaxHeap(testData[i].length);
            maxHeap.MaxHeapLogN(testData[i]);

            int actualMax = maxHeap.get();
            assertTrue(expectedMax[i] == actualMax);

            actualMax = maxHeap.pop();
            assertTrue(expectedMax[i]==actualMax);

            assertTrue(expectedSize[i] == maxHeap.size);

            assertTrue(maxHeap.equals(expected[i]));
        }
    }
}
import org.junit.Test;

import java.util.Random;

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

    @Test
    public void performanceTests() {
        Random rand = new Random();

        for (int i = 0; i < 1000; i++) {
            Integer[] data = new Integer[i];

            for (int j = 0; j < data.length; j++) {
                data[j] = rand.nextInt(25);
            }

            System.out.print(i + ", ");

            MaxHeap maxHeap = new MaxHeap(i);

            Long start = System.nanoTime();
            maxHeap.MaxHeapLogN(data);
            Long stop = System.nanoTime();

            System.out.print(stop - start + ", ");

            start = System.nanoTime();
            maxHeap.MaxHeapN(data);
            stop = System.nanoTime();

            System.out.println(stop - start);
        }
    }
}
package com.example.unittestscratch.utils;

import com.example.unittestscratch.models.MathUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonServicesTest {
    @Test
    void testAdd() {
        MathUtils mathUtils = new MathUtils();
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual);
    }

    @Test
    void testComputeCircleArea() {
        MathUtils mathUtils = new MathUtils();
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
    }
}
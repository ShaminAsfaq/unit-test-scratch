package com.example.unittestscratch.utils;

import com.example.unittestscratch.models.MathUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MathUtils Test")
class CommonServicesTest {
    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    @DisplayName("Before Each")
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;

        mathUtils = new MathUtils();
        String entry = "Running " + testInfo.getDisplayName() + " with Tags: " + testInfo.getTags();
        testReporter.publishEntry(entry);
    }

    @BeforeAll
    static void testBeforeAll() {
        System.err.println("This is running from before the Big Bang..");
    }

    @AfterEach
    void cleanUp() {
        System.err.println("Picking garbage..");
    }

    @Nested
    @DisplayName("Add Method")
    class AddTest {
        @Test
        @DisplayName("Add Positive")
        void testAddPositive() {
            assertEquals(2, mathUtils.add(1,1), "should return sum");
        }

        @Test
        @DisplayName("Add Negative")
        void testAddNegative() {
            int expected = -2;
            int actual = mathUtils.add(-1,-1);
            assertEquals(expected, actual, () -> "Expected " + expected + " but got " + actual);
        }
    }

    @RepeatedTest(3)
    @DisplayName("CIRCLE AREA")
    void testComputeCircleArea(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo);
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
    }

    @Tag("IMPORTANT")   //  We can put a Tag before a test to (kind of) make an invisible group fo tests. This way, we can
                        //  run only a certain amount of tests by using that Tag. There is a maven dependency/plugin
                        //  to do this. I don't know what is that. Java Brains used it through Eclipse in the following
                        //  video: https://www.youtube.com/watch?v=0m-vtBB66cI&list=PLqq-6Pq4lTTa4ad5JISViSb2FVG8Vwa4o&index=25
    @Test
    @DisplayName("DIVIDE")
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divided by ZERO is unrealistic");
    }

    @Test
    @DisplayName("TDD: Method should not run")
    @Disabled
    void testDisabled() {
        fail("Purposefully failing the test..");
    }

    @Test
    @DisplayName("LINUX")
    @EnabledOnOs(OS.LINUX)
    void testOnLinux() {
        System.err.println("This is Linux");
    }

    @Test
    @DisplayName("WINDOWS")
    @EnabledOnOs(OS.WINDOWS)
    void testOnWindows() {
        System.err.println("This is Windows");
    }

    @Test
    @DisplayName("MAC OS")
    @EnabledOnOs(OS.MAC)
    void testOnMacOS() {
        System.err.println("This is MacOS");
    }

    @Test
    @DisplayName("MULTIPLY")
    void testMultiplyAssertAll() {
//        assertEquals(6, mathUtils.multiply(2,3), "should return the product");
        assertAll(
                () -> assertEquals(6, mathUtils.multiply(2,3)),
                () -> assertEquals(0, mathUtils.multiply(0,3)),
                () -> assertEquals(-4, mathUtils.multiply(-2,2))
        );
    }


}


















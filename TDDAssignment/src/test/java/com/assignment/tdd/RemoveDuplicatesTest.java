package com.assignment.tdd;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class RemoveDuplicatesTest {

    @Test
    public void testRemoveDuplicatesCase1 () {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int [] temporaryArray = {1,1,1,2,2,2,3,3,3};
        int [] passedArray = removeDuplicates.removeDuplicates(temporaryArray);
        int [] resultArray = {1,2,3};
        Assert.assertArrayEquals(resultArray, passedArray);
    }

    @Test
    public void testRemoveDuplicatesCase2 () {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int [] temporaryArray = {1};
        int [] passedArray = removeDuplicates.removeDuplicates(temporaryArray);
        int [] resultArray = {1};
        Assert.assertArrayEquals(resultArray, passedArray);
    }

    @Test
    public void testRemoveDuplicatesCase3 () {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int [] temporaryArray = {};
        int [] passedArray = removeDuplicates.removeDuplicates(temporaryArray);
        int [] resultArray = {};
        Assert.assertArrayEquals(resultArray, passedArray);
    }

    @Test
    public void testRemoveDuplicatesCase4 () {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int [] temporaryArray = {1,2,1,2,1};
        int [] passedArray = removeDuplicates.removeDuplicates(temporaryArray);
        int [] resultArray = {1,2,1,2,1};
        Assert.assertArrayEquals(resultArray, passedArray);
    }
}

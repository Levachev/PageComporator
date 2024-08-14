package org.example.comparator;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DefaultPageComparatorTest {
    private static final DefaultPageComparator comparator = new DefaultPageComparator();
    private static final Map<String, String> yesterdayPages = new HashMap<>();
    private static final Map<String, String> todayPages = new HashMap<>();

    @Before
    public void clearPages(){
        yesterdayPages.clear();
        todayPages.clear();
    }


    @Test
    public void shouldFindDisappearedPages(){
        yesterdayPages.put("url0", "");
        yesterdayPages.put("url1", "");
        var result = comparator.compare(yesterdayPages, todayPages);

        Assert.assertEquals(2, result.disappearedPages().size());
    }

    @Test
    public void shouldFindNewPages(){
        todayPages.put("url0", "");
        todayPages.put("url1", "");
        todayPages.put("url2", "");
        var result = comparator.compare(yesterdayPages, todayPages);

        Assert.assertEquals(3, result.newPages().size());
    }

    @Test
    public void shouldFindUpdatedPages(){
        yesterdayPages.put("url0", "content0");
        yesterdayPages.put("url1", "content1");
        todayPages.put("url0", "content00");
        todayPages.put("url1", "content11");
        var result = comparator.compare(yesterdayPages, todayPages);

        Assert.assertEquals(2, result.updatedPages().size());
    }

    @Test
    public void shouldFindUpdatedPagesAndNewPages(){
        yesterdayPages.put("url0", "content0");
        yesterdayPages.put("url1", "content1");
        todayPages.put("url0", "content00");
        todayPages.put("url1", "content11");

        todayPages.put("url3", "content3");
        todayPages.put("url4", "content4");
        todayPages.put("url5", "content5");
        var result = comparator.compare(yesterdayPages, todayPages);

        Assert.assertEquals(2, result.updatedPages().size());
        Assert.assertEquals(3, result.newPages().size());
    }

    @Test
    public void shouldFindUpdatedPagesAndDisappearedPages(){
        yesterdayPages.put("url3", "content3");
        yesterdayPages.put("url4", "content4");
        yesterdayPages.put("url5", "content5");
        yesterdayPages.put("url6", "content6");

        yesterdayPages.put("url0", "content0");
        yesterdayPages.put("url1", "content1");
        todayPages.put("url0", "content00");
        todayPages.put("url1", "content11");
        var result = comparator.compare(yesterdayPages, todayPages);

        Assert.assertEquals(2, result.updatedPages().size());
        Assert.assertEquals(4, result.disappearedPages().size());
    }

    @Test
    public void shouldFindUNewPagesAndDisappearedPages(){
        yesterdayPages.put("url0", "content0");
        yesterdayPages.put("url1", "content1");

        todayPages.put("url2", "content2");
        var result = comparator.compare(yesterdayPages, todayPages);

        Assert.assertEquals(2, result.disappearedPages().size());
        Assert.assertEquals(1, result.newPages().size());
    }

    @Test
    public void shouldFindUNewPagesAndDisappearedPagesAndUpdatedPages(){
        yesterdayPages.put("url3", "content3");

        todayPages.put("url4", "content4");
        todayPages.put("url2", "content2");

        yesterdayPages.put("url0", "content0");
        yesterdayPages.put("url1", "content1");
        todayPages.put("url0", "content00");
        todayPages.put("url1", "content11");
        var result = comparator.compare(yesterdayPages, todayPages);

        Assert.assertEquals(1, result.disappearedPages().size());
        Assert.assertEquals(2, result.newPages().size());
        Assert.assertEquals(2, result.updatedPages().size());
    }
}
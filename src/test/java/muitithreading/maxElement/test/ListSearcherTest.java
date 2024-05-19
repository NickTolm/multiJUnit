package muitithreading.maxElement.test;

import com.example.multijunit.multithreading.maxElement.Try3.ListSearcher;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListSearcherTest {

    @Test
    public void emptyListShouldRetrurnIntegerMIN() {
        ListSearcher listSearcher = new ListSearcher(1);
        List<Integer> listForTest = new ArrayList<>();
        Assert.assertEquals(Integer.MIN_VALUE, listSearcher.getMaxSingleThread(listForTest), 1e-9 );
    }

}

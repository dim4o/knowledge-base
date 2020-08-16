package interview.data_structures.list.test.integration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interview.data_structures.list.test.util.TestUtil;

public class IntegrationTest extends TestUtil {
    
    private Random rand = new Random();
    
    private List<Integer> myList = null;
    
    private List<Integer> arrList = null;
    
    @Before
    public void doBefore() {
        myList = initListByRange(0, 99);
        arrList = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            arrList.add(i);
    }
    
    @Test
    public void addAndRemoveTest() {        
        for (int i = 0; i < 50; i++) {
            int randInt = Math.abs(rand.nextInt());
            int pos = randInt % arrList.size();
            if (randInt % 2 == 0) {
                arrList.add(randInt);
                myList.add(randInt);
            } else {
                arrList.remove(pos);
                myList.remove(pos);
            }
            
            Assert.assertEquals(arrList, myList);
        }
    }
    
    @Test
    public void setAndRemoveTest() {
        for (int i = 0; i < 100; i++) {
            int randInt = Math.abs(rand.nextInt());
            int pos = randInt % arrList.size();
            if (randInt % 2 == 0) {
                arrList.set(pos, randInt);
                myList.set(pos, randInt);
            } else {
                arrList.remove(pos);
                myList.remove(pos);
            }
            
            Assert.assertEquals(arrList, myList);
        }
    }
    
    @Test
    public void iteratorTest() {
        Iterator<Integer> arrListItr = arrList.iterator();
        Iterator<Integer> myListItr = myList.iterator();
        
        while (arrListItr.hasNext() || myListItr.hasNext()) {
            Assert.assertEquals(arrListItr.next(), myListItr.next());
        }
    }
    
}

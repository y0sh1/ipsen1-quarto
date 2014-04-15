package ipsen1.quarto.util;

import ipsen1.quarto.form.Form;
import ipsen1.quarto.form.Hoofdmenu;
import ipsen1.quarto.form.Instructies;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FormStackTest {
    private FormStack stack;

    private Form hoofdmenu = new Hoofdmenu(),
                 instructies = new Instructies();

    @Before
    public void setUp() throws Exception {
        stack = new FormStack();
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
    }

    @Test
    public void testFirst() throws Exception {
        assertNull(stack.first());

        Form hoofdmenu = new Hoofdmenu(),
             instructies = new Instructies();

        stack.add(hoofdmenu);
        assertSame(hoofdmenu, stack.first());

        stack.add(instructies);
        assertSame(hoofdmenu, stack.first());
        assertNotSame(instructies, stack.first());
    }

    @Test
    public void testLast() throws Exception {
        assertNull(stack.last());

        stack.add(hoofdmenu);
        assertSame(hoofdmenu, stack.last());

        stack.add(instructies);
        assertSame(instructies, stack.last());
        assertNotSame(hoofdmenu, stack.last());
    }

    @Test
    public void testPop() throws Exception {
        assertNull(stack.pop());

        stack.add(hoofdmenu);
        assertSame(hoofdmenu, stack.pop());
        assertEquals(stack.size(), 0);
        assertNull(stack.pop());

        stack.add(hoofdmenu);
        stack.add(instructies);

        assertSame(instructies, stack.pop());
        assertEquals(stack.size(), 1);

        assertSame(hoofdmenu, stack.pop());
        assertEquals(stack.size(), 0);
    }

    @Test
    public void testShift() throws Exception {
        assertNull(stack.shift());

        stack.add(hoofdmenu);
        assertSame(hoofdmenu, stack.shift());
        assertEquals(stack.size(), 0);
        assertNull(stack.shift());

        stack.add(hoofdmenu);
        stack.add(instructies);

        assertSame(hoofdmenu, stack.shift());
        assertEquals(stack.size(), 1);

        assertSame(instructies, stack.shift());
        assertEquals(stack.size(), 0);
    }
}

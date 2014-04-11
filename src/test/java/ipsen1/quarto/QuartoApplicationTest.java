package ipsen1.quarto;

import ipsen1.quarto.form.Form;
import ipsen1.quarto.form.Hoofdmenu;
import ipsen1.quarto.form.Instructies;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuartoApplicationTest {

    private QuartoApplication app;

    @Before
    public void setUp() throws Exception {
        app = new QuartoApplication();
    }

    @Test
    public void testSingleton() throws Exception {
        assertSame(app, QuartoApplication.currentApplication());
    }

    @Test
    public void testPushingAndPoppingForms() throws Exception {
        Form hoofdmenu = new Hoofdmenu(),
             instructies = new Instructies();

        assertNull(app.currentForm());
        assertNull(app.popForm());

        app.presentForm(hoofdmenu);
        assertSame(hoofdmenu, app.currentForm());

        app.presentForm(instructies);
        assertSame(instructies, app.currentForm());

        app.popForm();
        assertSame(hoofdmenu, app.currentForm());

        app.popForm();
        assertNull(app.currentForm());
        assertNull(app.popForm());
    }

    @Test
    public void testCurrentForm() throws Exception {
        Form hoofdmenu = new Hoofdmenu(),
             instructies = new Instructies();

        assertNull(app.currentForm());

        app.presentForm(hoofdmenu);
        assertSame(hoofdmenu, app.currentForm());

        app.presentForm(instructies);
        assertSame(instructies, app.currentForm());
    }

    @After
    public void tearDown() throws Exception {
        app = null;
    }
}

package sprint1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umleditor.sprint1.uml.UMLClass;
import umleditor.sprint1.utilities.Functions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Test suite for checking method creation
 */
public class MethodTests {

    private UMLClass mockClass;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        mockClass = new UMLClass("TestClass");

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void addMethodTest() {
        mockClass.addMethod("Testmethod", "void");
        boolean methodAdded = mockClass.methodExists("Testmethod");
        Assertions.assertTrue(methodAdded);
    }

    @Test
    public void removeMethodTest() {
        mockClass.addMethod("Testmethod", "void");
        mockClass.removeMethod("Testmethod");
        boolean methodRemoved = mockClass.methodExists("Testmethod");
        Assertions.assertFalse(methodRemoved);
    }

    @Test
    public void renameMethodTest() {
        mockClass.addMethod("Testmethod", "void");
        mockClass.renameMethod("Testmethod", "Testmethod2");
        boolean newMethodExists = mockClass.methodExists("Testmethod2");
        boolean oldMethodExists = mockClass.methodExists("Testmethod");
        Assertions.assertTrue(newMethodExists);
        Assertions.assertFalse(oldMethodExists);
    }


    @AfterEach
    public void tearDown() {
        System.setOut(System.out); // Reset to original System.out
    }



}

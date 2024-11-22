package UtilTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umleditor.controller.utilities.Functions;
import umleditor.model.uml.UMLClass;

import static umleditor.controller.utilities.Functions.getClassIfExists;

public class UndoTests {

    private UMLClass testClass;

    @BeforeEach
    public void setUp() {
        Functions.clearProgress();
        Functions.createClass("TestClass");
        testClass = getClassIfExists("TestClass");
    }

    @Test
    public void undoCreateMethod(){
        Functions.addMethod("TestClass", "String", "method");
        Assertions.assertTrue(testClass.methodExists("method"));
        Functions.undo();
        Assertions.assertFalse(testClass.methodExists("method"));
    }

    @Test
    public void undoRemoveMethod(){
        Functions.addMethod("TestClass", "String", "method");
        Assertions.assertTrue(testClass.methodExists("method"));

        Functions.removeMethod("TestClass", "method");
        Assertions.assertFalse(testClass.methodExists("method"));

        Functions.undo();
        Assertions.assertTrue(testClass.methodExists("method"));
    }

    @Test
    public void undoRenameMethod(){
        Functions.addMethod("TestClass", "String", "method");
        Assertions.assertTrue(testClass.methodExists("method"));

        Functions.renameMethod("TestClass", "method", "newMethod");
        Assertions.assertFalse(testClass.methodExists("method"));

        Functions.undo();
        Assertions.assertTrue(testClass.methodExists("method"));
        Assertions.assertFalse(testClass.methodExists("newMethod"));
    }

    @Test
    public void undoCreateField(){
        Functions.addAttribute("TestClass", "String", "field");
        Assertions.assertTrue(testClass.attributeExists("field"));

        Functions.undo();
        Assertions.assertFalse(testClass.attributeExists("field"));
    }

    @Test
    public void undoRemoveField(){
        Functions.addAttribute("TestClass", "String", "field");
        Assertions.assertTrue(testClass.attributeExists("field"));

        Functions.removeAttribute("TestClass", "field");
        Assertions.assertFalse(testClass.attributeExists("field"));

        Functions.undo();
        Assertions.assertTrue(testClass.attributeExists("field"));
    }

    @Test
    public void undoRenameField(){
        Functions.addAttribute("TestClass", "String", "field");
        Assertions.assertTrue(testClass.attributeExists("field"));

        Functions.renameAttribute("TestClass", "field", "newField");
        Assertions.assertFalse(testClass.attributeExists("field"));

        Functions.undo();
        Assertions.assertTrue(testClass.attributeExists("field"));
        Assertions.assertFalse(testClass.attributeExists("newField"));
    }
}

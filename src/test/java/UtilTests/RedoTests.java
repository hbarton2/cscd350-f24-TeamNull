package UtilTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umleditor.controller.utilities.Functions;
import umleditor.model.uml.UMLClass;

import static umleditor.controller.utilities.Functions.getClassIfExists;

public class RedoTests {

    private UMLClass testClass;

    @BeforeEach
    public void setUp() {
        Functions.clearProgress();
        Functions.createClass("TestClass");
        testClass = getClassIfExists("TestClass");
    }

    @Test
    public void redoCreateMethod(){
        Functions.addMethod("TestClass", "String", "method");
        Assertions.assertTrue(testClass.methodExists("method"));
        Functions.undo();
        Assertions.assertFalse(testClass.methodExists("method"));
        Functions.redo();
        Assertions.assertTrue(testClass.methodExists("method"));
    }

    @Test
    public void redoRemoveMethod(){
        Functions.addMethod("TestClass", "String", "method");
        Assertions.assertTrue(testClass.methodExists("method"));

        Functions.removeMethod("TestClass", "method");
        Assertions.assertFalse(testClass.methodExists("method"));

        Functions.undo();
        Assertions.assertTrue(testClass.methodExists("method"));

        Functions.redo();
        Assertions.assertFalse(testClass.methodExists("method"));
    }

    @Test
    public void redoRenameMethod(){
        Functions.addMethod("TestClass", "String", "method");
        Assertions.assertTrue(testClass.methodExists("method"));

        Functions.renameMethod("TestClass", "method", "newMethod");
        Assertions.assertFalse(testClass.methodExists("method"));

        Functions.undo();
        Assertions.assertFalse(testClass.methodExists("method"));
        Assertions.assertTrue(testClass.methodExists("newMethod"));

        Functions.redo();
        Assertions.assertTrue(testClass.methodExists("method"));
        Assertions.assertFalse(testClass.methodExists("newMethod"));
    }

    @Test
    public void redoCreateField(){
        Functions.addAttribute("TestClass", "String", "field");
        Assertions.assertTrue(testClass.attributeExists("field"));

        Functions.undo();
        Assertions.assertFalse(testClass.attributeExists("field"));

        Functions.redo();
        Assertions.assertTrue(testClass.attributeExists("field"));
    }

    @Test
    public void redoRemoveField(){
        Functions.addAttribute("TestClass", "String", "field");
        Assertions.assertTrue(testClass.attributeExists("field"));

        Functions.removeAttribute("TestClass", "field");
        Assertions.assertFalse(testClass.attributeExists("field"));

        Functions.undo();
        Assertions.assertTrue(testClass.attributeExists("field"));

        Functions.redo();
        Assertions.assertFalse(testClass.attributeExists("field"));
    }

    @Test
    public void redoRenameField(){
        Functions.addAttribute("TestClass", "String", "field");
        Assertions.assertTrue(testClass.attributeExists("field"));

        Functions.renameAttribute("TestClass", "field", "newField");
        Assertions.assertFalse(testClass.attributeExists("field"));

        Functions.undo();
        Assertions.assertFalse(testClass.attributeExists("field"));
        Assertions.assertTrue(testClass.attributeExists("newField"));

        Functions.redo();
        Assertions.assertTrue(testClass.attributeExists("field"));
        Assertions.assertFalse(testClass.attributeExists("newField"));
    }
}
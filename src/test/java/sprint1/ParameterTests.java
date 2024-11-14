package sprint1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umleditor.model.uml.MethodSignature;
import umleditor.controller.utilities.Functions;

import static org.junit.Assert.assertTrue;

class ParameterTests {

    private MethodSignature method;

    @BeforeEach
    public void setUp() {
        method = new MethodSignature("exampleMethod", "void");
    }

    @Test
    public void ParameterAdded(){
        method.addParam("Param1", "String");
        boolean paramAdded = method.paramExists("Param1");
        Assertions.assertTrue(paramAdded, "Parameter should be added to the list");
    }

    @Test
    public void ParameterExists(){
        method.addParam("Param1", "String");
        method.addParam("Param2", "Int");
        boolean param1Added = method.paramExists("Param1");
        boolean param2Added = method.paramExists("Param2");
        boolean param3Added = method.paramExists("Param3");
        Assertions.assertTrue(param1Added, "Parameter should be added to the list");
        Assertions.assertTrue(param2Added, "Parameter should be added to the list");
        Assertions.assertFalse(param3Added, "Parameter should not be added to the list");
    }

    @Test
    public void testAddParameterOutput(){
        Functions.createClass("TestClass");
        Functions.addMethod("TestClass", "TestMethod", "void");
        Functions.listClasses("lsa");

        Functions.addParam("TestClass", "TestMethod", "parameter1", "int");
        Functions.listClasses("lsa");

        Functions.addParam("TestClass", "TestMethod", "parameter2", "double");
        Functions.listClasses("lsa");

        Functions.removeParam("TestClass", "TestMethod", "parameter1");
        Functions.listClasses("lsa");
    }

    @Test
    public void parameterRemoved(){
        method.addParam("Param1", "String");
        method.removeParam("Param1");
        boolean paramRemoved = method.paramExists("Param1");
        Assertions.assertFalse(paramRemoved, "Parameter should be removed from the list");
    }
}

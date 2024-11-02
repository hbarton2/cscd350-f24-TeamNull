package sprint1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umleditor.sprint1.uml.MethodSignature;
import umleditor.sprint1.utilities.Functions;

import java.util.List;

import static org.junit.Assert.assertTrue;

class ParameterTests {

    private MethodSignature method;

    @BeforeEach
    public void setUp() {
        method = new MethodSignature("exampleMethod", "initialParam");
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
        Functions.addMethod("TestClass", "TestMethod", "");
        Functions.listClasses("lsa");

        Functions.addParam("TestClass", "TestMethod", "null", "parameter1", "int");
        Functions.listClasses("lsa");

        Functions.addParam("TestClass", "TestMethod", "parameter1", "parameter2", "int");
        Functions.listClasses("lsa");

    }
}

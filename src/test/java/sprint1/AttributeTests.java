package sprint1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umleditor.sprint1.uml.UMLAttribute;
import umleditor.sprint1.uml.UMLClass;
import umleditor.sprint1.utilities.Functions;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AttributeTests {

    private UMLClass mockClass;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        mockClass = new UMLClass("TestClass");

        // Redirecting output to capture printed messages for validation
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testAttributeOutput(){
        Functions.createClass("TestClass");
        Functions.addAttribute("TestClass", "String", "name");
        Functions.listClasses("lsa");

        Functions.addAttribute("TestClass", "int", "age");
        Functions.listClasses("lsa");

        Functions.removeAttribute( "TestMethod", "name");
        Functions.listClasses("lsa");
    }

    @Test
    public void testAddNewAttribute() {
        mockClass.addAttribute("name", "String");

        // Validate that the attribute was added
        assertTrue(mockClass.getAttributes().stream()
                .anyMatch(attr -> attr.getName().equals("name") && attr.getType().equals("String")));
        assertTrue(outputStream.toString().contains("Field name added to class TestClass."));
    }

    @Test
    public void testAddDuplicateAttribute() {
        mockClass.addAttribute("name", "String"); // First addition
        outputStream.reset(); // Clear output stream

        mockClass.addAttribute("name", "String"); // Duplicate addition

        // Validate that the attribute wasn't added again and error message was printed
        assertEquals(1, mockClass.getAttributes().size()); // Attribute should only appear once
        assertTrue(outputStream.toString().contains("Error: Field name already exists in class TestClass."));
    }

    @Test
    public void testRemoveExistingAttribute() {
        mockClass.addAttribute("name", "String");
        outputStream.reset();

        mockClass.removeAttribute("name");

        // Validate that the attribute was removed
        assertFalse(mockClass.getAttributes().stream().anyMatch(attr -> attr.getName().equals("name")));
        assertTrue(outputStream.toString().contains("Field name removed from class TestClass."));
    }

    @Test
    public void testRemoveNonExistentAttribute() {
        mockClass.removeAttribute("name");

        // Validate that the error message is printed for non-existent attribute
        assertTrue(outputStream.toString().contains("Error: Field name does not exist in class TestClass."));
    }

    @Test
    public void testRenameExistingAttribute() {
        mockClass.addAttribute("name", "String");
        outputStream.reset();

        mockClass.renameAttribute("name", "fullName");

        assertTrue(mockClass.getAttributes().stream()
                .anyMatch(attr -> attr.getName().equals("fullName") && attr.getType().equals("String")));
        assertFalse(mockClass.getAttributes().stream().anyMatch(attr -> attr.getName().equals("name")));
        assertTrue(outputStream.toString().contains("Field renamed from name to fullName in class TestClass."));
    }

    @Test
    public void testRenameNonExistentAttribute() {
        mockClass.renameAttribute("name", "fullName");

        assertTrue(outputStream.toString().contains("Error: Field name does not exist in class TestClass."));
    }
}

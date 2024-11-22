package umleditor.model.utilities;

import umleditor.model.uml.UMLClass;

import java.util.Stack;

public class MementoStorage {
    private static MementoStorage instance; // Single instance of the class
    private final Stack<UMLClass.Memento> undoStack;
    private final Stack<UMLClass.Memento> redoStack;

    // Private constructor to prevent instantiation
    private MementoStorage() {
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    // Public method to provide access to the single instance
    public static MementoStorage getInstance() {
        if (instance == null) {
            instance = new MementoStorage();
        }
        return instance;
    }

    public void saveState(UMLClass.Memento memento) {
        this.undoStack.push(memento);
        this.redoStack.clear(); // Clear redo stack as new actions invalidate the redo path
    }

    public UMLClass.Memento undo() {
        if (!undoStack.isEmpty()) {
            UMLClass.Memento currentState = undoStack.pop();
            redoStack.push(currentState);
            return undoStack.isEmpty() ? null : undoStack.peek();// Return the new current state
        }
        return null;
    }

    /**
     * Performs a redo operation by moving a state from the redo stack back to the undo stack.
     * @return The memento to restore the redone state, or null if redo is not possible.
     */
    public UMLClass.Memento redo() {
        if (!redoStack.isEmpty()) {
            UMLClass.Memento redoState = redoStack.pop();
            undoStack.push(redoState);
            return redoState;
        }
        return null; // Nothing to redo
    }

    /**
     * Checks if undo is possible.
     * @return True if the undo stack is not empty; false otherwise.
     */
    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    /**
     * Checks if redo is possible.
     * @return True if the redo stack is not empty; false otherwise.
     */
    public boolean canRedo() {
        return !redoStack.isEmpty();
    }

    /**
     * Clears all undo and redo history.
     */
    public void clearHistory() {
        undoStack.clear();
        redoStack.clear();
    }

}

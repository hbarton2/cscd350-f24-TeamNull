package umleditor.sprint1.uml;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * MethodSignature class holds all parameter specific calls.
 * Contains methodName field and parameters list
 * <p>
 * Constructor instantiates arraylist and adds the first parameter into the list with an empty type
 * TODO Refactor addMethod in UMLClass to take parameter type as well as name
 * Every Method that is created will have an invisible 'null' parameter
 * <p>
 * THIS IS IMPORTANT, if a user wants to access a method that has no parameters, they must type 'null' for the <parameter> field
 *<p>
 * TODO Add check on creating a new parameter to make sure it cant have the same name as another in the method already
 */

public class MethodSignature {

    String methodName;
    String parameter;   //This is only here to satisfy the legacy code, this will need to go eventually
    List<UMLParameter> parameters;

    public MethodSignature(String methodName, String paramName) {
        this.methodName = methodName;
        this.parameter = paramName;
        this.parameters = new ArrayList<UMLParameter>();
        if(paramName.isEmpty())
            paramName = "null";

        this.parameters.add(new UMLParameter(paramName, ""));
    }

    @Override
    public String toString() {
        return methodName + "(" +
                (parameters == null || parameters.isEmpty() ?
                        "no parameters" :
                        parameters.stream()
                                .filter(param -> !"null".equals(param.name))
                                .map(Object::toString)
                                .collect(Collectors.joining(", ")))
                + ")";
    }


    /**
     * UMLParameter, Parameter object has name and type
     */
    public static class UMLParameter{
        String name;
        String type;

        public UMLParameter(String name, String type){
            this.name = name;
            this.type = type;
        }

        @Override
        public String toString() {
            return name + "(" + type + ")";
        }
    }

    public void addParam(String name, String type){
        UMLParameter param = new UMLParameter(name, type);
        this.parameters.add(param);
    }

    public void removeParam(String name){
        for(UMLParameter param : this.parameters){
            if(param.name.equals(name)){
                this.parameters.remove(param);
                System.out.println("Param: " + name + " removed");
            }
        }
        System.out.println("Param not found: " + name);
    }

    //Searches based on name
    public boolean paramExists(String paramName){
        for(UMLParameter param : this.parameters){
            if(param.name.equals(paramName)){
                return true;
            }
        }
        return false;
    }


}
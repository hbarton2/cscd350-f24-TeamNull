package umleditor.sprint1.uml;

import java.util.ArrayList;
import java.util.List;

public class MethodSignature {

    String methodName;
    List<UMLParameter> parameters;

    public MethodSignature(String methodName, String paramName) {
        this.methodName = methodName;
        this.parameters = new ArrayList<UMLParameter>();
        this.parameters.add(new UMLParameter(paramName, null));
    }

    @Override
    public String toString() {
        return methodName + "(" + (parameters == null ? "no parameters" : parameters) + ")";
    }

    public static class UMLParameter{
        String name;
        String type;

        public UMLParameter(String name, String type){
            this.name = name;
            this.type = type;
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

}
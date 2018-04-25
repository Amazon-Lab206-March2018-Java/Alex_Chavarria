public class Project {
    private String name;
    private String description;

    public Project (){
        this("No Name", "No Description");
    }
    public Project(String n) {
        name = n;
        description = "No Description";
    }
    public Project(String n, String d) {
        name = n;
        description = d;
    }
    public String getName (){
        return name;
    }
    public void setName (String n){
        name = n;
    }
    public String getDescription (){
        return description;
    }
    public void setDescription (String d){
        description = d;
    }
    public String elevatorPitch (){
        return name+": "+description;    
    } 
}
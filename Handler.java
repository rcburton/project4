
public class Handler {
    
    public Handler() {
        
    }
    
    public void handleCommands(String[] parsedData) {
        if (parsedData[0].equals("add")) {
            Item newItem = new Item(parsedData);
            
        }
        else if (parsedData[0].equals("delete")) {
            
        }
        else if (parsedData[0].equals("print")) {
            
        }
        else if (parsedData[0].equals("rangeprint")) {
            
        }
        else if (parsedData[0].equals("collisions")) {
            
        }
        else if (parsedData[0].equals("intersect")) {
            
        }
    }
    
}

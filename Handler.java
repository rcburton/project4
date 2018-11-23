
public class Handler {

    // ADD SKIPLIST TO CONSTRUCTOR ONCE YOU HAVE THE CLASS READY
    public Handler() {

    }


    public void handleCommands(String[] parsedData) {
        if (parsedData[0].equals("add")) {
            Item newItem = new Item(parsedData);
            // search for duplicates
            // if no duplicates and is valid, add to SkipList and Bintree

        }
        else if (parsedData[0].equals("delete")) {
            // search for object to be deleted (name is in parsedData[1])
            // delete it

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

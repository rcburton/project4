import java.util.*;
import java.io.*;

public class Parser {

    public Parser() {
        // Empty
    }


    public String[] parseLine(String line) {
        String[] parsedData = new String[12];
        parsedData[0] = "";
        parsedData[1] = "";
        parsedData[2] = "";
        parsedData[3] = "";
        parsedData[4] = "";
        parsedData[5] = "";
        parsedData[6] = "";
        parsedData[7] = "";
        parsedData[8] = "";
        parsedData[9] = "";
        parsedData[10] = "";
        parsedData[11] = "";

        Scanner sc = new Scanner(line);
        String temp, temp2;
        if (sc.hasNext()) {
            temp = sc.next().trim();
            if (temp.equals("add")) {
                // Command name
                parsedData[0] = temp;
                // AirObject type
                temp2 = sc.next().trim();
                parsedData[1] = sc.next().trim();
                // Name
                parsedData[2] = sc.next().trim();
                // X
                parsedData[3] = sc.next().trim();
                // Y
                parsedData[4] = sc.next().trim();
                // Z
                parsedData[5] = sc.next().trim();
                // XWid
                parsedData[6] = sc.next().trim();
                // YWid
                parsedData[7] = sc.next().trim();
                // ZWid
                parsedData[8] = sc.next().trim();

                if (temp2.equals("balloon")) {
                    // Type
                    parsedData[9] = sc.next().trim();
                    // Ascent Rate
                    parsedData[10] = sc.next().trim();
                }
                else if (temp2.equals("airplane")) {
                    // Carrier
                    parsedData[9] = sc.next().trim();
                    // Flight #
                    parsedData[10] = sc.next().trim();
                    // Engine #
                    parsedData[11] = sc.next().trim();
                }
                else if (temp2.equals("rocket")) {
                    // Ascent Rate
                    parsedData[9] = sc.next().trim();
                    // Trajectory
                    parsedData[10] = sc.next().trim();
                }
                else if (temp2.equals("drone")) {
                    // Brand
                    parsedData[9] = sc.next().trim();
                    // Engine #
                    parsedData[10] = sc.next().trim();
                }
                else if (temp2.equals("bird")) {
                    // Type
                    parsedData[9] = sc.next().trim();
                    // Number
                    parsedData[10] = sc.next().trim();
                }

            }
            else if (temp.equals("delete")) {
                // Command name
                parsedData[0] = temp;
                // Name
                parsedData[1] = sc.next().trim();
            }
            else if (temp.equals("print")) {
                // Command name
                parsedData[0] = temp;
                // Print Command
                temp = sc.next().trim();
                parsedData[1] = temp;
                if (temp.equals("object")) {
                    // Name
                    parsedData[2] = sc.next().trim();
                }
            }
            else if (temp.equals("rangeprint")) {
                // Command name
                parsedData[0] = temp;
                // Start
                parsedData[1] = sc.next().trim();
                // End
                parsedData[2] = sc.next().trim();

            }
            else if (temp.equals("collisions")) {
                // Command name
                parsedData[0] = temp;
            }
            else if (temp.equals("intersect")) {
                // Command name
                parsedData[0] = temp;
                // X
                parsedData[1] = sc.next().trim();
                // Y
                parsedData[2] = sc.next().trim();
                // Z
                parsedData[3] = sc.next().trim();
                // XWid
                parsedData[4] = sc.next().trim();
                // YWid
                parsedData[5] = sc.next().trim();
                // ZWid
                parsedData[6] = sc.next().trim();

            }
            else {

            }
        }
        sc.close();
        return parsedData;
    }

}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * {Project Description Here}
 */

/**
 * The class containing the main method.
 *
 * @author {Your Name Here}
 * @version {Put Something Here}
 */

// On my honor:
//
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.

public class GraphProject {
    /**
     * @param args
     *            Command line parameters
     */
    public static void main(String[] args) {
        Parser p = new Parser();
        // String fileName = args[1];
        String fileName = "P4SampleInput.txt";
        String pLine = "";
        Handler handler = new Handler();

        String[] parsedData = new String[12];
        try {

            Scanner scf = new Scanner(new File(fileName));

            while (scf.hasNextLine()) {
                pLine = scf.nextLine();
                parsedData = p.parseLine(pLine);
                handler.handleCommands(parsedData);

            }
            scf.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("no input found");
            e.printStackTrace();
        }
    }
}

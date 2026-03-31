import java.io.*;
import java.util.*;

public class IPLCsvCensor {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("ipl_matches.csv"));
        FileWriter fw = new FileWriter("ipl_matches_censored.csv");

        // Write header
        String header = sc.nextLine();
        fw.write(header + "\n");

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] cols = line.split(",");

            // Columns: match_id,team1,team2,score_team1,score_team2,winner,player_of_match
            cols[1] = maskTeam(cols[1]); // team1
            cols[2] = maskTeam(cols[2]); // team2
            cols[5] = maskTeam(cols[5]); // winner
            cols[6] = "REDACTED";        // player_of_match

            fw.write(String.join(",", cols) + "\n");
        }

        sc.close();
        fw.close();
        System.out.println("✅ Censored CSV written to ipl_matches_censored.csv");
    }

    private static String maskTeam(String team) {
        if (team == null || team.isEmpty()) return "";
        String[] parts = team.split(" ");
        if (parts.length > 1) parts[parts.length - 1] = "***";
        return String.join(" ", parts);
    }
}

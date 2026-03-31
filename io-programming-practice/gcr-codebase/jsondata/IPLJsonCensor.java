import java.io.*;
import java.util.*;

public class IPLJsonCensor {

    public static void main(String[] args) throws Exception {
        File file = new File("ipl_matches.json");
        Scanner sc = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) sb.append(sc.nextLine());
        sc.close();

        String json = sb.toString().trim();

        // Remove array brackets
        json = json.substring(1, json.length() - 1);

        // Split each object carefully
        String[] records = json.split("\\},\\s*\\{");

        List<String> censoredRecords = new ArrayList<>();

        for (String rec : records) {
            rec = rec.trim();
            if (!rec.startsWith("{")) rec = "{" + rec;
            if (!rec.endsWith("}")) rec = rec + "}";

            // Extract fields manually
            Map<String, String> map = new LinkedHashMap<>();
            String scoreContent = "";
            int scoreStart = rec.indexOf("\"score\"");
            if (scoreStart >= 0) {
                int braceOpen = rec.indexOf("{", scoreStart);
                int braceClose = rec.lastIndexOf("}");
                scoreContent = rec.substring(braceOpen, braceClose + 1);
                rec = rec.substring(0, scoreStart - 1); // remove score from main object
            }

            String[] fields = rec.substring(1, rec.length() - 1).split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            for (String f : fields) {
                String[] kv = f.split(":", 2);
                if (kv.length == 2) {
                    map.put(kv[0].trim().replaceAll("\"", ""), kv[1].trim());
                }
            }

            // Apply censorship
            String team1 = removeQuotes(map.get("team1"));
            String team2 = removeQuotes(map.get("team2"));
            map.put("team1", "\"" + maskTeam(team1) + "\"");
            map.put("team2", "\"" + maskTeam(team2) + "\"");
            map.put("winner", "\"" + maskTeam(removeQuotes(map.get("winner"))) + "\"");
            map.put("player_of_match", "\"REDACTED\"");

            // Update score keys
            String maskedScore = scoreContent
                    .replace(team1, maskTeam(team1))
                    .replace(team2, maskTeam(team2));

            // Build JSON object without duplicate keys
            StringBuilder obj = new StringBuilder();
            obj.append("{");

            int i = 0;
            for (String k : map.keySet()) {
                obj.append("\"").append(k).append("\":").append(map.get(k));
                obj.append(", ");
            }

            obj.append("\"score\":").append(maskedScore);
            obj.append("}");
            censoredRecords.add(obj.toString());
        }

        // Write censored JSON
        try (FileWriter fw = new FileWriter("ipl_matches_censored.json")) {
            fw.write("[\n");
            for (int i = 0; i < censoredRecords.size(); i++) {
                fw.write("  " + censoredRecords.get(i));
                if (i < censoredRecords.size() - 1) fw.write(",\n");
            }
            fw.write("\n]");
        }

        System.out.println("✅ Censored JSON written to ipl_matches_censored.json");
    }

    private static String maskTeam(String team) {
        if (team == null || team.isEmpty()) return "";
        String[] parts = team.split(" ");
        if (parts.length > 1) {
            parts[parts.length - 1] = "***";
        } else {
            parts[0] = "***";
        }
        return String.join(" ", parts);
    }

    private static String removeQuotes(String s) {
        if (s == null) return "";
        return s.replaceAll("^\"|\"$", "");
    }
}

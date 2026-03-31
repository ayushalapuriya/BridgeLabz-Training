import java.util.*;

public class StreamBuzz {

    // CreatorStats class
    public static class CreatorStats {
        public String creatorName;
        public double[] weeklyLikes;

        // Static list to store all creators
        public static List<CreatorStats> engagementBoard = new ArrayList<>();

        public CreatorStats(String creatorName, double[] weeklyLikes) {
            this.creatorName = creatorName;
            this.weeklyLikes = weeklyLikes;
        }
    }

    // Program class functionality
    public static class Program {

        // Register creator
        public void registerCreator(CreatorStats record) {
            CreatorStats.engagementBoard.add(record);
            System.out.println("Creator registered successfully");
        }

        // Get top post counts
        public Map<String, Integer> getTopPostCounts(List<CreatorStats> records, double likeThreshold) {
            Map<String, Integer> result = new LinkedHashMap<>();

            for (CreatorStats creator : records) {
                int count = 0;
                for (double likes : creator.weeklyLikes) {
                    if (likes >= likeThreshold) {
                        count++;
                    }
                }
                if (count > 0) {
                    result.put(creator.creatorName, count);
                }
            }

            return result;
        }

        // Calculate average likes
        public double calculateAverageLikes() {
            double totalLikes = 0;
            int totalWeeks = 0;

            for (CreatorStats creator : CreatorStats.engagementBoard) {
                for (double likes : creator.weeklyLikes) {
                    totalLikes += likes;
                    totalWeeks++;
                }
            }

            if (totalWeeks == 0) return 0;
            return totalLikes / totalWeeks;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Program program = new Program();

        while (true) {
            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter Creator Name:");
                    String name = sc.nextLine();
                    double[] likes = new double[4];
                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    for (int i = 0; i < 4; i++) {
                        while (true) {
                            try {
                                likes[i] = Double.parseDouble(sc.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a valid number:");
                            }
                        }
                    }
                    program.registerCreator(new CreatorStats(name, likes));
                    break;

                case 2:
                    System.out.println("Enter like threshold:");
                    double threshold;
                    while (true) {
                        try {
                            threshold = Double.parseDouble(sc.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number:");
                        }
                    }

                    Map<String, Integer> topPosts = program.getTopPostCounts(CreatorStats.engagementBoard, threshold);
                    if (topPosts.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        for (Map.Entry<String, Integer> entry : topPosts.entrySet()) {
                            System.out.println(entry.getKey() + " - " + entry.getValue());
                        }
                    }
                    break;

                case 3:
                    double avg = program.calculateAverageLikes();
                    System.out.println("Overall average weekly likes: " + (int)avg);
                    break;

                case 4:
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    return;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}

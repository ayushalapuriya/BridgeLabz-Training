package online_voting_system;

public class Voter {
    private int voterId;
    private String name;
    private boolean hasVoted;

    Voter(int voterId, String name) {
        this.voterId = voterId;
        this.name = name;
        this.hasVoted = false;
    }

    int getVoterId() {
        return voterId;
    }

    String getName() {
        return name;
    }

    boolean hasVoted() {
        return hasVoted;
    }

    void markVoted() {
        hasVoted = true;
    }
}

package online_voting_system;

public class Candidate {
    private int candidateId;
    private String name;
    private int voteCount;

    Candidate(int candidateId, String name) {
        this.candidateId = candidateId;
        this.name = name;
        this.voteCount = 0;
    }

    int getCandidateId() {
        return candidateId;
    }

    String getName() {
        return name;
    }

    void addVote() {
        voteCount++;
    }

    int getVoteCount() {
        return voteCount;
    }
}

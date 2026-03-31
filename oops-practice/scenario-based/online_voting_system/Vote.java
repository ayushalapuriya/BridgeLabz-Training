package online_voting_system;

public class Vote {
    private Voter voter;
    private Candidate candidate;

    Vote(Voter voter, Candidate candidate) {
        this.voter = voter;
        this.candidate = candidate;
    }

    Voter getVoter() {
        return voter;
    }

    Candidate getCandidate() {
        return candidate;
    }
}

package online_voting_system;

import java.util.ArrayList;
import java.util.List;

public class ElectionServiceImpl implements ElectionService {

    private List<Voter> voters = new ArrayList<>();
    private List<Candidate> candidates = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    public void registerVoter(Voter voter) {
        voters.add(voter);
        System.out.println("Voter registered: " + voter.getName());
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
        System.out.println("Candidate added: " + candidate.getName());
    }

    public void castVote(int voterId, int candidateId) throws DuplicateVoteException {
        Voter voter = null;
        Candidate candidate = null;

        for (Voter v : voters) {
            if (v.getVoterId() == voterId) {
                voter = v;
                break;
            }
        }

        for (Candidate c : candidates) {
            if (c.getCandidateId() == candidateId) {
                candidate = c;
                break;
            }
        }

        if (voter == null || candidate == null) {
            System.out.println("Invalid voter or candidate");
            return;
        }

        if (voter.hasVoted()) {
            throw new DuplicateVoteException("Voter has already cast a vote");
        }

        Vote vote = new Vote(voter, candidate);
        votes.add(vote);

        voter.markVoted();
        candidate.addVote();

        System.out.println(voter.getName() + " voted for " + candidate.getName());
    }

    public void declareResult() {
        System.out.println("\n--- Election Result ---");
        Candidate winner = null;

        for (Candidate c : candidates) {
            System.out.println(c.getName() + " : " + c.getVoteCount() + " votes");
            if (winner == null || c.getVoteCount() > winner.getVoteCount()) {
                winner = c;
            }
        }

        if (winner != null) {
            System.out.println("Winner: " + winner.getName());
        }
    }
}

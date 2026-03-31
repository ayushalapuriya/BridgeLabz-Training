package online_voting_system;

public class ElectionSystem {

    public static void main(String[] args) {

        ElectionService election = new ElectionServiceImpl();

        Voter v1 = new Voter(1, "Ayush");
        Voter v2 = new Voter(2, "Rahul");

        Candidate c1 = new Candidate(101, "Candidate A");
        Candidate c2 = new Candidate(102, "Candidate B");

        election.registerVoter(v1);
        election.registerVoter(v2);

        election.addCandidate(c1);
        election.addCandidate(c2);

        try {
            election.castVote(1, 101);
            election.castVote(2, 102);

            // Duplicate vote attempt
            election.castVote(1, 102);

        } catch (DuplicateVoteException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        election.declareResult();
    }
}

package online_voting_system;

public class DuplicateVoteException extends Exception {
    DuplicateVoteException(String message) {
        super(message);
    }
}

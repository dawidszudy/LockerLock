package pl.pp.LockerLock;

public enum PositionMechanism {

    LOCKED("locked"),
    FAILUREUNLOCKED("failure unlocked"),
    UNLOCKED("unlocked"),
    FAILURE("failure");

    private final String position;

    PositionMechanism(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

}

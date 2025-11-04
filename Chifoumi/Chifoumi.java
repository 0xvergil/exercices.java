public class Chifoumi {
    public static ChifoumiAction getActionBeatenBy(ChifoumiAction action) {
        return switch (action) {
            case PAPER -> ChifoumiAction.ROCK;
            case ROCK -> ChifoumiAction.SCISSOR;
            case SCISSOR -> ChifoumiAction.PAPER;
        };
    }
}
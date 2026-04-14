public class DeadCharacterException extends Exception {
    private final Character character;

    public DeadCharacterException(Character character) {
        this.character = character;
    }

    @Override
    public String getMessage() {
        String type = this.character.getClass().getSimpleName().toLowerCase();
        return "The " + type + " " + this.character.getName() + " is dead.";
    }
}
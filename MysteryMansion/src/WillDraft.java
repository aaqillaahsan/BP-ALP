public class WillDraft extends Item{

    public WillDraft(){
        name = "Altered Will Draft";
        description = """
                    A partially revised draft of Arthur Ravenwood's will.

                    Lucian Ravenwood's name has been deliberately removed from the primary inheritance clause. 
                    In its place are vague annotations about "instability" and "irreversible consequences."

                    Several sections are heavily marked, rewritten, and crossed out, suggesting hesitation rather than impulse.

                    The document is unsigned.

                    A handwritten note in the margin reads:
                    "I cannot allow fear to decide this—yet ignoring it may be worse."
                    """;

        isClue = true;
        isReal = true;
        KeyItem = false;
    }
}

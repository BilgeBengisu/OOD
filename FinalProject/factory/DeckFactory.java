package factory;

/**
 * Purpose of the Simple Factory pattern is to map languages to file paths
 * in order to create Deck instances
 * 
 * implemented as a final class to avoid extending its purpose/funcitonality
 * and protect Singleton pattern
 * 
 * This is the only file that needs to be adapted if the file path changes
 * 
 * @author Bilge Akyol
 */

public final class DeckFactory {
    private DeckFactory() {} // utility class, not meant to be instantiated

    public static Deck createDeck(Language language) {
        if (lang == null) return new Deck();

        return switch (lang) {
            case TURKISH -> CSVLoader.loadDeck("phrases/turkish_phrases.csv", lang);
            case PORTUGUESE -> CSVLoader.loadDeck("phrases/portuguese_phrases.csv", lang);
            case ITALIAN -> CSVLoader.loadDeck("phrases/italian_phrases.csv", lang);
            default -> new Deck();
        };
    }

} 
package exercises.shopping_app;

/**
 * Requirements for ShoppingItem
 * Fields:
 * String aisle; (you may also use int if you prefer numeric aisles)
 * String name;
 * A constructor that sets both fields.
 * getAisle() and getName() accessor methods (and toString() for nice printing).
 * Implement Comparable<ShoppingItem> so that items are ordered by:
 * Aisle (ascending), then
 * Name (alphabetically) when aisles are equal
 */
public class ShoppingItem implements Comparable<ShoppingItem> {
    String aisle;
    String name;

    public ShoppingItem(String aisle, String name) {
        this.aisle = aisle;
        this.name = name;
    }

    public String getAisle() {
        return aisle;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ShoppingItem: " + "aisle- " + this.aisle + " name- " + this.name );
        return sb.toString();
    }
    @Override
    public int compareTo(ShoppingItem other) {
        int aisleComparison = this.aisle.compareTo(other.aisle);
        if (aisleComparison != 0) {
            return aisleComparison;
        }
        return this.name.compareTo(other.name);
    }

}

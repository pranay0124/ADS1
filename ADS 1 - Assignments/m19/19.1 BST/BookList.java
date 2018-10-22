/**.
 * List of books.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BookList<Key extends Comparable<Key>,Value> {
    /**.
     * Book name
     */
    String name;
    /**.
     * Author name
     */
    String author;
    /**.
     * Cost of the book.
     */
    Float cost;
    /**.
     * Constructs the object.
     *
     * @param      name    The name
     * @param      author  The author
     * @param      cost    The cost
     */
    BookList(String name, String author, Float cost) {
        this.name = name;
        this.author = author;
        this.cost = cost;
    }
    /**.
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**.
     * Sets the name.
     *
     * @param      name  The name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**.
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return this.author;
    }
    /**.
     * Sets the author.
     *
     * @param      author  The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**.
     * Gets the cost.
     *
     * @return     The cost.
     */
    public float getCost() {
        return this.cost;
    }
    /**.
     * Sets the cost.
     *
     * @param      cost  The cost
     */
    public void setCost(float cost) {
        this.cost = cost;
    }
    /**.
     * { function_description }
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(1)
     */
    public int compareTo(BookList that) {
        if (this.getName().compareTo(that.getName()) > 0) {
            return 1;
        } else if (this.getName().compareTo(that.getName()) < 0) {
            return -1;
        } else {
            if (this.getAuthor().compareTo(that.getAuthor()) > 0) {
                return 1;
            } else if (this.getAuthor().compareTo(that.getAuthor()) < 0) {
                return -1;
            } else {
                if (this.getCost() > that.getCost()) {
                    return 1;
                } else if (this.getCost() < that.getCost()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return getName() + ", " + getAuthor() + ", " + getCost();
    }
}

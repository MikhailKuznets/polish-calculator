import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReversePolishNotationCalculatorTest {
    ReversePolishNotationCalculator calculator = new ReversePolishNotationCalculator();

    // СЛОЖЕНИЕ
    @Test
    public void shouldCalculatePositiveSumWithPositiveSummands() {
        int sum = calculator.calculatePolishNotation("2 3 +");
        Assertions.assertEquals(5, sum);
    }

    @Test
    public void shouldCalculatePositiveSumWithNegativeSummand() {
        int sum = calculator.calculatePolishNotation("-2 3 +");
        Assertions.assertEquals(1, sum);
    }

    @Test
    public void shouldCalculateNegativeSumWithNegativeSummands() {
        int sum = calculator.calculatePolishNotation("-2 -3 +");
        Assertions.assertEquals(-5, sum);
    }

    //  ВЫЧИТАНИЕ
    @Test
    public void shouldCalculatePositiveDifferenceWithPositiveNumbers() {
        int dif = calculator.calculatePolishNotation("3 2 -");
        Assertions.assertEquals(1, dif);
    }

    @Test
    public void shouldCalculateNegativeDifferenceWithPositiveNumbers() {
        int dif = calculator.calculatePolishNotation("2 3 -");
        Assertions.assertEquals(-1, dif);
    }

    @Test
    public void shouldCalculatePositiveDifferenceWithNegativeSubtrahend() {
        int dif = calculator.calculatePolishNotation("3 -2 -");
        Assertions.assertEquals(5, dif);
    }
    @Test
    public void shouldCalculateNegativeDifferenceWithNegativeNumbers() {
        int dif = calculator.calculatePolishNotation("-3 -2 -");
        Assertions.assertEquals(-1, dif);
    }

    @Test
    public void shouldCalculateNegativeDifferenceWithNegativeMinuend () {
        int dif = calculator.calculatePolishNotation("-3 2 -");
        Assertions.assertEquals(-5, dif);
    }


    //  УМНОЖЕНИЕ
    @Test
    public void shouldCalculatePositiveMultiplicationWithPositiveMultipliers  () {
        int prod = calculator.calculatePolishNotation("2 3 *");
        Assertions.assertEquals(6, prod);
    }

    @Test
    public void shouldCalculateNegativeMultiplicationWithNegativeMultiplier  () {
        int prod = calculator.calculatePolishNotation("2 -3 *");
        Assertions.assertEquals(-6, prod);
    }

    @Test
    public void shouldCalculatePositiveMultiplicationWithNegativeMultipliers  () {
        int prod = calculator.calculatePolishNotation("-2 -3 *");
        Assertions.assertEquals(6, prod);
    }

    // ПРОВЕРКА НА МНОЖЕСТВЕННЫЕ ПРОБЕЛЫ
    @Test
    public void shouldCalculateSumWithMultipleSpaces  () {
        int sum = calculator.calculatePolishNotation("       7        3    +   ");
        Assertions.assertEquals(10, sum);
    }

    @Test
    // Не проходит тест, если в отрицательном числе после минуса стоит пробел
    public void shouldCalculateSumWithSpaceAfterMinus  () {
        int sum = calculator.calculatePolishNotation("7   -  3    +   ");
        Assertions.assertEquals(4, sum);
    }

    @Test
    public void shouldCalculateDifferenceWithMultipleSpaces  () {
        int dif = calculator.calculatePolishNotation("     7    5    -   ");
        Assertions.assertEquals(2, dif);
    }

    @Test
    // Не проходит тест, если в отрицательном числе после минуса стоит пробел
    public void shouldCalculateDifferenceWithSpaceAfterMinus  () {
        int dif = calculator.calculatePolishNotation("     -   7    5    -   ");
        Assertions.assertEquals(-12, dif);
    }

    @Test
    public void shouldCalculateMultiplicationWithMultipleSpaces  () {
        int prod = calculator.calculatePolishNotation("   3    5     *   ");
        Assertions.assertEquals(15, prod);
    }

    @Test
    // Не проходит тест, если в отрицательном числе после минуса стоит пробел
    public void shouldCalculateMultiplicationWithSpaceAfterMinus  () {
        int prod = calculator.calculatePolishNotation("   3    -   5     *   ");
        Assertions.assertEquals(-15, prod);
    }

}
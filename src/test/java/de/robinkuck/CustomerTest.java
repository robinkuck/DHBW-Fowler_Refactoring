package de.robinkuck;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void testGetName() {
        Customer customer = new Customer("Test customer");

        Assert.assertEquals("Test customer", customer.getName());
    }

    @Test
    public void testStatement() {
        Movie movie = new Movie("Test movie", Movie.REGULAR);
        Rental rental = new Rental(movie, 10);

        Customer customer = new Customer("Test customer");
        customer.addRental(rental);

        Assert.assertEquals("Rental Record for Test customer\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tTest movie\t\t10\t14.0\n" +
                "Amount owed is 14.0\n" +
                "You earned 1 frequent renter points", customer.statement());
    }

    @Test
    public void testStatementForAllPriceCodes() {
        Movie movie1 = new Movie("Test movie 1", Movie.REGULAR);
        Rental rental1 = new Rental(movie1, 10);

        Movie movie2 = new Movie("Test movie 2", Movie.NEW_RELEASE);
        Rental rental2 = new Rental(movie2, 11);

        Movie movie3 = new Movie("Test movie 3", Movie.CHILDRENS);
        Rental rental3 = new Rental(movie3, 12);

        Customer customer = new Customer("Test customer");
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        Assert.assertEquals("Rental Record for Test customer\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tTest movie 1\t\t10\t14.0\n" +
                "\tTest movie 2\t\t11\t33.0\n" +
                "\tTest movie 3\t\t12\t15.0\n" +
                "Amount owed is 62.0\n" +
                "You earned 4 frequent renter points", customer.statement());
    }

}
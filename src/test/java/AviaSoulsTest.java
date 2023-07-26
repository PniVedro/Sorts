import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    @Test
    public void secondTicketIsMoreExpensive() {
        Ticket ticket1 = new Ticket("Moscow", "SPB", 1000, 10, 14);
        Ticket ticket2 = new Ticket("Moscow", "SPB", 2000, 10, 14);
        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondTicketIsCheaper() {
        Ticket ticket1 = new Ticket("Moscow", "SPB", 2000, 10, 14);
        Ticket ticket2 = new Ticket("Moscow", "SPB", 1000, 10, 14);
        int expected = 1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ticketCostTheSame() {
        Ticket ticket1 = new Ticket("Moscow", "SPB", 1000, 10, 14);
        Ticket ticket2 = new Ticket("Moscow", "SPB", 1000, 10, 14);
        int expected = 0;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mustFind2Tickets() {
        Ticket ticket1 = new Ticket("Moscow", "SPB", 2000, 10, 14);
        Ticket ticket2 = new Ticket("Moscow", "SPB", 1000, 10, 16);
        Ticket ticket3 = new Ticket("SPB", "Moscow", 11_000, 10, 12);
        Ticket ticket4 = new Ticket("SPB", "Moscow", 111_000, 10, 16);
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        Ticket[] expected = {ticket3, ticket4};
        Ticket[] actual = aviaSouls.search("SPB", "Moscow");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void notMustFindTickets() {
        Ticket ticket1 = new Ticket("Moscow", "SPB", 2000, 10, 14);
        Ticket ticket2 = new Ticket("Moscow", "SPB", 1000, 10, 16);
        Ticket ticket3 = new Ticket("SPB", "Moscow", 11_000, 10, 12);
        Ticket ticket4 = new Ticket("SPB", "Moscow", 111_000, 10, 16);
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("NSK", "Moscow");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void MustFind4Tickets() {
        Ticket ticket1 = new Ticket("SPB", "Moscow", 2000, 10, 14);
        Ticket ticket2 = new Ticket("SPB", "Moscow", 1000, 10, 16);
        Ticket ticket3 = new Ticket("SPB", "Moscow", 11_000, 10, 12);
        Ticket ticket4 = new Ticket("SPB", "Moscow", 111_000, 10, 16);
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        Ticket[] expected = {ticket2, ticket1, ticket3, ticket4};
        Ticket[] actual = aviaSouls.search("SPB", "Moscow");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ifNotTickets() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("SPB", "Moscow");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findTheFastest() {
        Ticket ticket1 = new Ticket("Moscow", "SPB", 1000, 10, 14);
        Ticket ticket2 = new Ticket("Moscow", "SPB", 2000, 10, 16);
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        int expected = -1;
        int actual = ticketTimeComparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findTheSlowest() {
        Ticket ticket1 = new Ticket("Moscow", "SPB", 1000, 10, 14);
        Ticket ticket2 = new Ticket("Moscow", "SPB", 2000, 10, 16);
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        int expected = 1;
        int actual = ticketTimeComparator.compare(ticket2, ticket1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findTheSame() {
        Ticket ticket1 = new Ticket("Moscow", "SPB", 1000, 10, 14);
        Ticket ticket2 = new Ticket("Moscow", "SPB", 2000, 10, 14);
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        int expected = 0;
        int actual = ticketTimeComparator.compare(ticket2, ticket1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void find4Tickets() {
        Ticket ticket1 = new Ticket("SPB", "Moscow", 2000, 10, 14);
        Ticket ticket2 = new Ticket("SPB", "Moscow", 1000, 10, 16);
        Ticket ticket3 = new Ticket("SPB", "Moscow", 11_000, 10, 12);
        Ticket ticket4 = new Ticket("SPB", "Moscow", 111_000, 10, 18);
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        Ticket[] expected = {ticket3, ticket1, ticket2, ticket4};
        Ticket[] actual = aviaSouls.searchAndSortBy("SPB", "Moscow", ticketTimeComparator);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void find2Tickets() {
        Ticket ticket1 = new Ticket("SPB", "Moscow", 2000, 10, 14);
        Ticket ticket2 = new Ticket("SPB", "Moscow", 1000, 10, 16);
        Ticket ticket3 = new Ticket("KGD", "Moscow", 11_000, 10, 12);
        Ticket ticket4 = new Ticket("KGD", "Moscow", 111_000, 10, 18);
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = aviaSouls.searchAndSortBy("SPB", "Moscow", ticketTimeComparator);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findZeroTickets() {
        Ticket ticket1 = new Ticket("KGD", "Moscow", 2000, 10, 14);
        Ticket ticket2 = new Ticket("KGD", "Moscow", 1000, 10, 16);
        Ticket ticket3 = new Ticket("KGD", "Moscow", 11_000, 10, 12);
        Ticket ticket4 = new Ticket("KGD", "Moscow", 111_000, 10, 18);
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("SPB", "Moscow", ticketTimeComparator);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findWithOutTickets() {
        AviaSouls aviaSouls = new AviaSouls();
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("SPB", "Moscow", ticketTimeComparator);
        Assertions.assertArrayEquals(expected, actual);

    }
}

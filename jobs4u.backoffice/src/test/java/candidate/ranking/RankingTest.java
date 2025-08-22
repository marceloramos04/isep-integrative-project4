package candidate.ranking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.domain.ranking.Ranking;

import static org.junit.jupiter.api.Assertions.*;

class RankingTest {

    private Ranking ranking;

    @BeforeEach
    void setUp() {
        ranking = new Ranking(1L, 1L, "1", 5);
    }

    @Test
    void shouldCreateRankingWithValidParameters() {
        assertNotNull(ranking);
        assertEquals(1L, ranking.getCandidateId());
        assertEquals(1L, ranking.getJobOpeningId());
        assertEquals("1", ranking.getRank());
    }

    @Test
    void shouldThrowExceptionWhenCandidateIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Ranking(null, 1L, "1", 5));
    }

    @Test
    void shouldThrowExceptionWhenJobOpeningIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Ranking(1L, null, "1", 5));
    }

    @Test
    void shouldThrowExceptionWhenRankIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Ranking(1L, 1L, null, 5));
    }

    @Test
    void shouldThrowExceptionWhenRankIsNotANumber() {
        assertThrows(IllegalArgumentException.class, () -> new Ranking(1L, 1L, "not a number", 5));
    }

    @Test
    void shouldThrowExceptionWhenRankIsHigherThanNumToBeRanked() {
        assertThrows(IllegalArgumentException.class, () -> new Ranking(1L, 1L, "6", 5));
    }

    @Test
    void shouldCompareToOtherRankingCorrectly() {
        Ranking otherRanking = new Ranking(2L, 2L, "2", 5);
        assertTrue(ranking.compareTo(otherRanking) < 0);
    }

    @Test
    public void testEquals_SameObject() {
        Ranking ranking1 = new Ranking(1L, 1L, "1");
        assertTrue(ranking1.equals(ranking1));
    }

    @Test
    public void testEquals_NullObject() {
        Ranking ranking1 = new Ranking(1L, 1L, "1");
        assertNotEquals(null, ranking1);
    }
}
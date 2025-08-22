package utils.domain.ranking;

import candidate.domain.Candidate;
import jobOpening.domain.JobOpening;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Objects;

@Getter
@Embeddable
public class Ranking implements Comparable<Ranking> {

    @Column(name = "candidate_id",updatable=false)
    private Long candidateId;

    @Column(name = "job_opening_id",insertable=false, updatable=false)
    private Long jobOpeningId;

    private String rank;

    public Ranking() {
    }

    public Ranking(Long candidateId, Long jobOpeningId, String rank, int numToBeRanked) {
        if (candidateId == null) {
            throw new IllegalArgumentException("Candidate ID cannot be null");
        }
        if (jobOpeningId == null) {
            throw new IllegalArgumentException("Job opening ID cannot be null");
        }
        if (rank == null || rank.trim().isEmpty()) {
            throw new IllegalArgumentException("Ranking cannot be empty");
        }
        if (!rank.matches("\\d+")) {
            throw new IllegalArgumentException("Rank must be a number");
        }
        int rankInt = Integer.parseInt(rank);
        if(rankInt > numToBeRanked){
            throw new IllegalArgumentException("Ranking cannot be higher than the number of candidates to be ranked");
        }
        this.candidateId = candidateId;
        this.jobOpeningId = jobOpeningId;
        this.rank = rank;
    }

    // Constructor for non-ranked candidates
    public Ranking(Long candidateId, Long jobOpeningId, String rank) {
        this.candidateId = candidateId;
        this.jobOpeningId = jobOpeningId;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "candidate=" + candidateId +
                ", jobOpening=" + jobOpeningId +
                ", rank=" + rank +
                '}';
    }

    @Override
    public int compareTo(Ranking r) {
        return this.rank.compareTo(r.rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranking ranking = (Ranking) o;
        return Objects.equals(candidateId, ranking.candidateId) &&
                Objects.equals(jobOpeningId, ranking.jobOpeningId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidateId, jobOpeningId);
    }
}
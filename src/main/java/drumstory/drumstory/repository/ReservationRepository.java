package drumstory.drumstory.repository;

import drumstory.drumstory.domain.TImeTable;
import drumstory.drumstory.domain.Reservation;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReservationRepository implements ReservationInterface{
    private final EntityManager em;
    @Override
    public List<TImeTable> getTimeTable() {
        return em.createQuery("Select t from time_table t", TImeTable.class).getResultList();
    }

    @Override
    public List<Reservation> getAllReservations() {
        return em.createQuery("Select r from Reservation r", Reservation.class).getResultList();
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        em.persist(reservation);
        return reservation;
    }
}

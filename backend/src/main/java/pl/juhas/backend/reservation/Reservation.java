package pl.juhas.backend.reservation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.CreatedDate;
import pl.juhas.backend.room.Room;
import pl.juhas.backend.user.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@With
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Column(nullable = false)
    private LocalDateTime checkInDate;

    @Column(nullable = false)
    private LocalDateTime checkOutDate;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @CreatedDate
    @Column(name ="created_at", updatable = false)
    private LocalDateTime createdAt;
}


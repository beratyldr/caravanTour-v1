package com.caravantour.caravan.repository.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caravantour.caravan.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /*@Modifying
    @Transactional
    @Query("SELECT b FROM Room b WHERE b.hotelId=:id AND id NOT IN " +
            "(SELECT roomId FROM Booking WHERE :start BETWEEN checkInDate AND checkOutDate " +
            "OR :end BETWEEN checkInDate " +
            "AND checkOutDate OR :start <= checkInDate AND :end >= checkOutDate)")
    List<Room> getHotelRooms(@Param("start") Date from, @Param("end") Date to, @Param("id") Integer id);*/

    Optional<User> findByEmail(String email);

}
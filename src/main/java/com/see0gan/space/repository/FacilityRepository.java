//package com.see0gan.space.repository;
//
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.see0gan.space.entity.SpaceFacility;
//
//@Repository
//public interface FacilityRepository extends JpaRepository<SpaceFacility, Long> {
//
//
//    @Transactional
//    @Modifying
//    @Query(
//            value = "UPDATE facility " +
//                    "SET has_air_conditioner = ?2, " +
//                    "has_printer = ?3, " +
//                    "has_free_wifi = ?4, " +
//                    "has_parking_lot = ?5 " +
//                    "WHERE facility_id = ?1"
//    , nativeQuery = true)
//    void updateById(Long facility_id,
//                             boolean hasAirConditioner,
//                             boolean hasPrinter,
//                             boolean hasFreeWifi,
//                             boolean hasParkingLot);
//
//
//}

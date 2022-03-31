//package com.see0gan.demo.controller;
//
//
//import java.time.LocalTime;
//import java.util.List;
//
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.see0gan.space.dto.SpaceWithTime;
//import com.see0gan.space.entity.SpaceOpenTime;
//import com.see0gan.space.service.OpenTimeService;
//import com.see0gan.utils.exception.ErrorResponse;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//@Slf4j(topic = "OPEN-TIME_CONTROLLER")
//@RestController
//@RequestMapping(path = "api/v1/spaces/time")
//@AllArgsConstructor
//public class OpenTimeController {
//
//
//    private final OpenTimeService openTimeService;
//
//    @GetMapping
//    public List<SpaceOpenTime> getAllOpenTime() {
//
//        return openTimeService.getAllOpenTime();
//    }
//
//    @GetMapping(path = "q")
//    public List<SpaceWithTime> getSpaceWithTimeLaterThan(@RequestParam("start")
//                                                         @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
//                                                                 LocalTime openTime) {
//
//        return openTimeService.findByOpeningTimeGreaterThanEqual(openTime);
//
//    }
//
//    @PutMapping(path = "{id}")
//    public void updateOpenTime(@PathVariable("id") Long timeId,
//                               @RequestParam("start")
//                               @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
//                                       LocalTime openTime,
//                               @RequestParam("end")
//                               @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
//                                       LocalTime closeTime) {
//
//        openTimeService.updateOpenTime(timeId, openTime, closeTime);
//    }
//
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<?> handleBadTimeParameterException(IllegalArgumentException exception) {
//
//        ErrorResponse errorResponse = new ErrorResponse(
//                                                         HttpStatus.BAD_REQUEST.value(),
//                                                "Parse attempt failed for value, valid time format HH:MM"
//                                                     );
//
//        log.error("catch", exception.getMessage());
//        return ResponseEntity.badRequest().body(errorResponse);
//    }
//
//}
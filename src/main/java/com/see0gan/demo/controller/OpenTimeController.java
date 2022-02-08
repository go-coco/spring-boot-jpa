package com.see0gan.demo.controller;


import com.see0gan.demo.dto.SpaceWithTime;
import com.see0gan.demo.entity.SpaceOpeningHour;
import com.see0gan.demo.exception.ErrorResponse;
import com.see0gan.demo.service.OpenTimeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Slf4j(topic = "OPEN-TIME_CONTROLLER")
@RestController
@RequestMapping(path = "api/v1/spaces/time")
@AllArgsConstructor
public class OpenTimeController {


    private final OpenTimeService openTimeService;

    @GetMapping
    public List<SpaceOpeningHour> getAllOpenTime() {

        return openTimeService.getAllOpenTime();
    }

    @GetMapping(path = "q")
    public List<SpaceWithTime> getSpaceWithTimeLaterThan(@RequestParam("start")
                                                         @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
                                                                 LocalTime openTime) {

        return openTimeService.findByOpeningTimeGreaterThanEqual(openTime);

    }

    @PutMapping(path = "{id}")
    public void updateOpenTime(@PathVariable("id") Long timeId,
                               @RequestParam("start")
                               @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
                                       LocalTime openTime,
                               @RequestParam("end")
                               @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
                                       LocalTime closeTime) {

        openTimeService.updateOpenTime(timeId, openTime, closeTime);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleBadTimeParameterException(IllegalArgumentException exception) {

        ErrorResponse errorResponse = new ErrorResponse(
                                                         HttpStatus.BAD_REQUEST.value(),
                                                "Parse attempt failed for value, valid time format HH:MM"
                                                     );

        log.error("catch", exception.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }

}
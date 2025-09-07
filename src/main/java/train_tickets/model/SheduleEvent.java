package train_tickets.model;

import java.time.DayOfWeek;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SheduleEvent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String startCity;

    @Column(length = 50)
    private String endCity;

    private LocalTime startTime;
    private Integer minutes;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;
    
    public SheduleEvent(){
    }

    public SheduleEvent(String startCity, String endCity, LocalTime startTime, Integer minutes,DayOfWeek dayOfWeek) {
        this.startCity = startCity;
        this.endCity = endCity;
        this.startTime = startTime;
        this.minutes = minutes;
        this.dayOfWeek = dayOfWeek;
    }

    public SheduleEvent(Long id, String startCity, String endCity, LocalTime startTime, Integer minutes,DayOfWeek dayOfWeek) {
        this.id = id;
        this.startCity = startCity;
        this.endCity = endCity;
        this.startTime = startTime;
        this.minutes = minutes;
        this.dayOfWeek = dayOfWeek;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStartCity() {
        return startCity;
    }
    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }
    public String getEndCity() {
        return endCity;
    }
    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public Integer getMinutes() {
        return minutes;
    }
    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "id=" + id + ", startCity=" + startCity + ", endCity=" + endCity + ", startTime="
                + startTime + ", minutes=" + minutes + ", dayOfWeek=" + dayOfWeek;
    }

    

}

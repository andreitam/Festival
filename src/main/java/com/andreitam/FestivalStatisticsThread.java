package com.andreitam;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * FestivalStatisticsThread generates statistics of FestivalGate every 5 seconds.
 * Singelton, in public constructor throw exception
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-10-29
 */
public class FestivalStatisticsThread extends Thread {
    private static FestivalStatisticsThread instance = null;
    private FestivalGate gate;
    private Queue<FestivalAttendeeThread> queue = new PriorityQueue<>();

    private FestivalStatisticsThread() {

    }

    public FestivalStatisticsThread(FestivalGate gate)
    {
        if (instance != null) {
            throw new IllegalArgumentException("Statistics thread is allready instaniated!");
        }
        else {
            instance = new FestivalStatisticsThread();
            this.gate = gate;
        }
    }

    @Override
    public void run() {
       while(true) {
           try {
               Thread.sleep(5000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           generateStatistics();
       }
    }

    private void generateStatistics() {
        Integer countAttendees = 0;
        Integer count_Full = 0;
        Integer count_Full_Vip = 0;
        Integer count_Free_Pass = 0;
        Integer count_One_Day = 0;
        Integer count_One_Day_Vip = 0;
        queue.clear();
        queue = this.gate.transmitQueue();
        if (gate.peekFromGate() != null) {
            for (FestivalAttendeeThread attendee:queue) {
                if(attendee.getTicketType().equals(TicketType.FULL)) {
                    count_Full++;
                }
                if(attendee.getTicketType().equals(TicketType.FULL_VIP)) {
                    count_Full_Vip++;
                }
                if(attendee.getTicketType().equals(TicketType.FREE_PASS)) {
                    count_Free_Pass++;
                }
                if(attendee.getTicketType().equals(TicketType.ONE_DAY)) {
                    count_One_Day++;
                }
                if(attendee.getTicketType().equals(TicketType.ONE_DAY_VIP)) {
                    count_One_Day_Vip++;
                }
            }
            System.out.println(queue.size()+" people entered"+"\n"
                    +count_Full+" people have full tickets"+"\n"
                    +count_Full_Vip+" people have full VIP tickets"+"\n"
                    +count_Free_Pass+" people have free passes"+"\n"
                    +count_One_Day+" have one-day passes"+"\n"
                    +count_One_Day_Vip+" have one-day VIP passes"+"\n"
            );
        }
    }
}

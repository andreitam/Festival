package com.andreitam;
/**
 * Generates a specific number of FestivalAttendeesThreads and starts them for 1 FestivalGate object.
 * It is used for simulation.
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-10-29
 */
class FestivalAttendeeGenerator {
    public static void generateAttendees(FestivalGate gate, Integer attendeesNumber) {
        Thread attendeeThread;
        for (int i=1; i<=attendeesNumber; ++i) {
            attendeeThread = new Thread(new FestivalAttendeeThread(TicketType.generateTicket(),gate));
            attendeeThread.start();
            try {
                attendeeThread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
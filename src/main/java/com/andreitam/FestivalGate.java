package com.andreitam;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * FestivalGate class contains a queue that holds the atendees that pass through gate.
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-10-29
 */
public class FestivalGate<FestivalAttendeeThread> {
    private Queue<FestivalAttendeeThread> gateQueue = new PriorityQueue<>();

    public void addToGate(FestivalAttendeeThread t) {
        this.gateQueue.add(t);
    }

    public FestivalAttendeeThread peekFromGate() {
        return this.gateQueue.peek();
    }

    public Queue<FestivalAttendeeThread> transmitQueue() {
        Queue<FestivalAttendeeThread> transmittedQueue = new PriorityQueue<>();
        for (FestivalAttendeeThread t : this.gateQueue) {
            transmittedQueue.add(t);
        }
        return transmittedQueue;
    }
}

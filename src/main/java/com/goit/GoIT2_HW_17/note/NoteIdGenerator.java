package com.goit.GoIT2_HW_17.note;

import java.util.Random;

public class NoteIdGenerator {
    private static final Random random = new Random();
    public static int generateId() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            result.append(random.nextInt(0,9));
        }
        return Integer.parseInt(result.toString());
    }
}

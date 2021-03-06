package org.drools.planner.examples.ras2012.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import junit.framework.Assert;
import org.drools.planner.examples.ras2012.model.Train.TrainType;
import org.junit.Ignore;
import org.junit.Test;

public class TrainTest {

    @Test
    @Ignore
    public void testConstructor() {
        // FIXME implement me
    }

    @Test
    public void testDirection() {
        final Train east = new Train("EB", BigDecimal.ONE, BigDecimal.ONE, 90, new Node(0),
                new Node(1), 0, 1, 0, Collections.<ScheduleAdherenceRequirement> emptyList(), true,
                false);
        Assert.assertTrue(east.isEastbound());
        Assert.assertFalse(east.isWestbound());
        final Train west = new Train("WB", BigDecimal.ONE, BigDecimal.ONE, 90, new Node(0),
                new Node(1), 0, 1, 0, Collections.<ScheduleAdherenceRequirement> emptyList(), true,
                true);
        Assert.assertTrue(west.isWestbound());
        Assert.assertFalse(west.isEastbound());
    }

    @Test
    @Ignore
    public void testEqualsObject() {
        // FIXME implement me
    }

    @Test
    @Ignore
    public void testGetMaximumSpeed() {
        // FIXME implement me
    }

    @Test
    public void testGetType() {
        final Map<String, TrainType> types = new HashMap<String, TrainType>();
        types.put("A", TrainType.A);
        types.put("B", TrainType.B);
        types.put("C", TrainType.C);
        types.put("D", TrainType.D);
        types.put("E", TrainType.E);
        types.put("F", TrainType.F);
        final Random rand = new Random();
        for (final Map.Entry<String, TrainType> e : types.entrySet()) {
            final String name = e.getKey() + rand.nextInt();
            final Train t = new Train(name, BigDecimal.ONE, BigDecimal.ONE, 90, new Node(0),
                    new Node(1), 0, 1, 0, Collections.<ScheduleAdherenceRequirement> emptyList(),
                    true, false);
            Assert.assertEquals("Train doesn't have the proper type.", e.getValue(), t.getType());
        }
    }

    @Test
    public void testIsHeavy() {
        final Train heavy = new Train("EB", BigDecimal.ONE, BigDecimal.ONE, 110, new Node(0),
                new Node(1), 0, 1, 0, Collections.<ScheduleAdherenceRequirement> emptyList(), true,
                false);
        Assert.assertTrue(heavy.isHeavy());
        final Train light = new Train("EB", BigDecimal.ONE, BigDecimal.ONE, 90, new Node(0),
                new Node(1), 0, 1, 0, Collections.<ScheduleAdherenceRequirement> emptyList(), true,
                true);
        Assert.assertFalse(light.isHeavy());
    }

}
